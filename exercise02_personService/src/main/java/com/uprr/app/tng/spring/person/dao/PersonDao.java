package com.uprr.app.tng.spring.person.dao;

import com.uprr.app.tng.spring.person.pojo.Person;

import javax.annotation.Nonnull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Objects;

public class PersonDao {
    @Nonnull private final String directory;
    @Nonnull private final String database;

    public PersonDao(@Nonnull final String database, @Nonnull final String directory) {
        this.directory = directory;
        this.database = database;
    }

    @SuppressWarnings({"resource", "IOResourceOpenedButNotSafelyClosed"})
    public Person get(@Nonnull final String name) throws IOException {
        final InputStream dbStream = this.getClass().getClassLoader()
                                         .getResourceAsStream(Paths.get(this.directory, this.database + ".csv")
                                                                   .toString());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(dbStream))) {
            return reader.lines().map(line -> {
                final String[] parts     = line.split(",");
                final Person   candidate = new Person();
                candidate.setName(parts[0]);
                candidate.setAttribute(parts[1]);
                candidate.setAttributeLevel(Integer.valueOf(parts[2]));
                return candidate;
            }).filter(person -> Objects.equals(name, person.getName()))
                         .findFirst()
                         .orElse(null);
        }
    }
}
