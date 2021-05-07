package io.github.talelin.latticy.service;


import io.github.talelin.latticy.dto.patient.CreateOrUpdatePatientDTO;

import java.util.List;

public interface CommendService {

    int createPatient(CreateOrUpdatePatientDTO patientDTO);

    List<String> listPatientSymptom();

    String  listPatientSymptom( Integer id);

    String commendPython(String symptom);
}
