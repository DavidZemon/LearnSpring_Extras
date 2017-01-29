package com.uprr.app.tng.spring.diagnosis.service;

import com.uprr.app.tng.spring.diagnosis.pojo.PatientDetails;

public class PatientDetailsService {
    public PatientDetails getPatientDetails(final Long patientId) {
        return new PatientDetails();
    }
}
