package com.uprr.app.tng.spring.diagnosis.service;

import com.uprr.app.tng.spring.diagnosis.pojo.MedicalHistory;
import com.uprr.app.tng.spring.diagnosis.pojo.PatientDetails;

import java.util.Arrays;
import java.util.List;

public class InferenceEngine {
    private final String serviceUrl;
    private final int    maxNumRecordsReturned;

    public InferenceEngine(final String serviceUrl,
                           final int maxNumRecordsReturned) {
        this.serviceUrl = serviceUrl;
        this.maxNumRecordsReturned = maxNumRecordsReturned;
    }

    // Pretend calculations to compute possible diagnoses
    public List<String> getPossibleDiagnoses(final MedicalHistory medicalHistory,
                                             final PatientDetails patientDetails,
                                             final List<String> symptoms) {
        return Arrays.asList("cold", "flu", "allergy");
    }
}
