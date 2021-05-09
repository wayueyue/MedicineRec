package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.patient.CreateOrUpdatePatientDTO;
import io.github.talelin.latticy.mapper.PatientMapper;
import io.github.talelin.latticy.mapper.SymptomMapper;
import io.github.talelin.latticy.model.PatientDO;
import io.github.talelin.latticy.model.SymptomDO;
import io.github.talelin.latticy.service.CommendService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CommendServiceImpl implements CommendService {
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private SymptomMapper symptomMapper;

    private final String DELIMITER = ",";


    /**
     * Set Symptom
     * TODO zhangxilong 对于症状,的处理 待定 2021.0508 [2021.0515]
     * @param patient       patient
     * @param patientSelect 已存在的patient
     */
    private void setSymptom(CreateOrUpdatePatientDTO patient, PatientDO patientSelect) {
        if (StringUtils.isNotBlank(patientSelect.getSymptom())) {
            patientSelect.setSymptom(patientSelect.getSymptom() + DELIMITER + patient.getSymptom());
        } else {
            patientSelect.setSymptom(patient.getSymptom());
        }
    }


    @Override
    public PatientDO getPrescription(PatientDO patientDTO) {
        //1.此处已经为,分隔的症状列表 前端处理
        String symptom = patientDTO.getSymptom();
        //2.调用Python获取处方 Python是否可以正常调用未知
        String prescription= getPrescriptionByPython(symptom);
        patientDTO.setPrescription(prescription);
        //3.存储
        patientMapper.insert(patientDTO);
        return patientDTO;
    }

    @Override
    public List<SymptomDO> getSymptoms() {
        List<SymptomDO> symptom = symptomMapper.getSymptoms();
        return symptom;
    }



    /**
     * 通过Python获得处方
     * @param symptom 症状信息
     * @return 处方prescription
     */
    private String getPrescriptionByPython(String symptom) {
        try {
            String[] args = new String[]{"python", "E:\\Destop\\medicine\\he_20210425(3).py", symptom};
            Process proc = Runtime.getRuntime().exec(args);
            InputStream inputStream = proc.getInputStream();
            InputStreamReader outputReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(outputReader);
            String output = bufferedReader.readLine();
            bufferedReader.close();
            proc.waitFor();
            return output;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
