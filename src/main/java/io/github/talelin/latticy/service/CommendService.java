package io.github.talelin.latticy.service;


import io.github.talelin.latticy.dto.patient.CreateOrUpdatePatientDTO;

public interface CommendService {

    boolean createPatient(CreateOrUpdatePatientDTO patientDTO);
    String commendPython(String symptom);
}
