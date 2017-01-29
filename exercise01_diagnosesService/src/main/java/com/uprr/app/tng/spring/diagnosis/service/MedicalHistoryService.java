package com.uprr.app.tng.spring.diagnosis.service;

import com.uprr.app.tng.spring.diagnosis.pojo.MedicalHistory;

/**
 * Created by Katie on 2/6/2017.
 */
public class MedicalHistoryService {
    private final FamilyHistoryService  familyHistoryService;
    private final PatientHistoryService patientHistoryService;

    public MedicalHistoryService(final FamilyHistoryService familyHistoryService,
                                 final PatientHistoryService patientHistoryService) {
        this.familyHistoryService = familyHistoryService;
        this.patientHistoryService = patientHistoryService;
    }

    public MedicalHistory getMedicalHistory(final Long patientId) {
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setFamilyHistory(
            this.familyHistoryService.getFamilyHistory(patientId));
        medicalHistory.setPatientHistory(
            this.patientHistoryService.getPatientHistory(patientId)
        );
        return medicalHistory;
    }
}
