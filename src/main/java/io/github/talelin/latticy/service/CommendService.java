package io.github.talelin.latticy.service;
import io.github.talelin.latticy.model.PatientDO;


import io.github.talelin.latticy.dto.patient.CreateOrUpdatePatientDTO;
import io.github.talelin.latticy.model.PatientDO;
import java.util.List;

public interface CommendService {

    PatientDO getPrescription(PatientDO patientDTO);
    List<PatientDO> getByName(String name);
}
