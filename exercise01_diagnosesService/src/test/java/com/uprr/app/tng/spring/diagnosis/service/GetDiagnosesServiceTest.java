package com.uprr.app.tng.spring.diagnosis.service;

import com.uprr.app.tng.spring.diagnosis.config.GetDiagnosisServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GetDiagnosisServiceConfig.class)
public class GetDiagnosesServiceTest {
    @Autowired
    private GetDiagnosesService getDiagnosesService;

    @Test
    public void testGetDiagnoses() throws Exception {
        final List<String> possibleDiagnoses =
            this.getDiagnosesService.getPossibleDiagnoses(
            15L, Arrays.asList("sneezing", "dry throat", "headache"));
        assertTrue(possibleDiagnoses.contains("cold"));
        assertTrue(possibleDiagnoses.contains("flu"));
        assertTrue(possibleDiagnoses.contains("allergy"));
    }
}
