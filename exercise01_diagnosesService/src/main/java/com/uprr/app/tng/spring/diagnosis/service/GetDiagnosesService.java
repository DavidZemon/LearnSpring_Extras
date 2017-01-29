package com.uprr.app.tng.spring.diagnosis.service;

import com.uprr.app.tng.spring.diagnosis.pojo.MedicalHistory;
import com.uprr.app.tng.spring.diagnosis.pojo.PatientDetails;

import java.util.List;

public class GetDiagnosesService {
    private final MedicalHistoryService medicalHistoryService;
    private final PatientDetailsService patientDetailsService;
    private final InferenceEngine       inferenceEngine;

    public GetDiagnosesService(final MedicalHistoryService medicalHistoryService,
                               final PatientDetailsService patientDetailsService,
                               final InferenceEngine inferenceEngine) {
        this.medicalHistoryService = medicalHistoryService;
        this.patientDetailsService = patientDetailsService;
        this.inferenceEngine = inferenceEngine;
    }

    public List<String> getPossibleDiagnoses(final Long patientId,
                                             final List<String> symptoms) {
        final MedicalHistory medicalHistory = this.medicalHistoryService.getMedicalHistory(patientId);
        final PatientDetails patientDetails = this.patientDetailsService.getPatientDetails(patientId);
        return this.inferenceEngine.getPossibleDiagnoses(medicalHistory, patientDetails, symptoms);
    }
}
