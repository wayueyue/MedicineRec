package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.talelin.latticy.common.LocalUser;
import io.github.talelin.latticy.dto.patient.CreateOrUpdatePatientDTO;
import io.github.talelin.latticy.mapper.PatientMapper;
import io.github.talelin.latticy.model.PatientDO;
import io.github.talelin.latticy.service.CommendService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@Service
public class CommendServiceImpl implements CommendService {
    @Autowired
    private PatientMapper patientMapper;

    private final String DELIMITER = ",";

    @Override
    public int createPatient(CreateOrUpdatePatientDTO patient) {
        PatientDO patientSelect = getPatientDO();
        PatientDO patientDO;
        if (patientSelect == null) {
            patientDO = PatientDO.builder().name(patient.getName())
                    .age(patient.getAge())
                    .sex(patient.getSex())
                    .symptom(patient.getSymptom()).build();
            return patientMapper.insert(patientDO);
        } else {
            patientSelect.setName(patient.getName());
            patientSelect.setAge(patient.getAge());
            patientSelect.setSex(patient.getSex());
            setSymptom(patient, patientSelect);
            return patientMapper.updateById(patientSelect);
        }

    }

    /**
     * Set Symptom
     * @param patient patient
     * @param patientSelect 已存在的patient
     */
    private void setSymptom(CreateOrUpdatePatientDTO patient, PatientDO patientSelect) {
        if (StringUtils.isNotBlank(patientSelect.getSymptom())) {
            patientSelect.setSymptom(patientSelect.getSymptom() + DELIMITER + patient.getSymptom());
        } else {
            patientSelect.setSymptom(patient.getSymptom());
        }
    }

    /**
     * 获得PatientDo
     * @return PatientDo
     */
    private PatientDO getPatientDO() {
        Integer userId = LocalUser.getLocalUser().getId();
        LambdaQueryWrapper<PatientDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PatientDO::getUserId, userId);
        return patientMapper.selectOne(queryWrapper);
    }

    @Override
    public List<String> listPatientSymptom() {
        PatientDO patientSelect = getPatientDO();
        String symptom = patientSelect.getSymptom();
        return Arrays.asList(symptom.split(DELIMITER));
    }

    @Override
    public String listPatientSymptom(Integer id) {
        return null;
    }

    @Override
    public String commendPython(String symptom) {
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
