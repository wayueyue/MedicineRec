package io.github.talelin.latticy.service;
import io.github.talelin.latticy.model.PatientDO;


public interface CommendService {

    PatientDO getPrescription(PatientDO patientDTO);
}
