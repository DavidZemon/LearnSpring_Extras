package com.uprr.app.tng.spring.diagnosis.pojo;

public class MedicalHistory {
    private FamilyHistory  familyHistory;
    private PatientHistory patientHistory;

    public void setFamilyHistory(final FamilyHistory familyHistory) {
        this.familyHistory = familyHistory;
    }

    public void setPatientHistory(final PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    public FamilyHistory getFamilyHistory() {
        return this.familyHistory;
    }

    public PatientHistory getPatientHistory() {
        return this.patientHistory;
    }
}

