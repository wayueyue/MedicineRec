package io.github.talelin.latticy.service;
import io.github.talelin.latticy.model.PatientDO;
import io.github.talelin.latticy.model.SymptomDO;

import java.util.List;

public interface CommendService {

    PatientDO getPrescription(PatientDO patientDTO);
    List<SymptomDO> getSymptoms();
    PatientDO getByName(String name);
}
