package com.uprr.app.tng.spring.person.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {
    private String name;
    private String attribute;
    private Integer attributeLevel;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(final String attribute) {
        this.attribute = attribute;
    }

    public Integer getAttributeLevel() {
        return this.attributeLevel;
    }

    public void setAttributeLevel(final Integer attributeLevel) {
        this.attributeLevel = attributeLevel;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final Person person = (Person) o;

        return new EqualsBuilder()
            .append(this.name, person.name)
            .append(this.attribute, person.attribute)
            .append(this.attributeLevel, person.attributeLevel)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(this.name)
            .append(this.attribute)
            .append(this.attributeLevel)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("name", this.name)
            .append("attribute", this.attribute)
            .append("attributeLevel", this.attributeLevel)
            .toString();
    }
}
