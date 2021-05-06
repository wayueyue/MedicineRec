package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.patient.CreateOrUpdatePatientDTO;
import io.github.talelin.latticy.mapper.BookMapper;
import io.github.talelin.latticy.mapper.PatientMapper;
import io.github.talelin.latticy.model.PatientDO;
import io.github.talelin.latticy.service.CommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class CommendServiceImpl implements CommendService {
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public boolean createPatient(CreateOrUpdatePatientDTO patientDTO) {
        PatientDO patient = new PatientDO();
        patient.setName(patientDTO.getName());
        patient.setAge(patientDTO.getAge());
        patient.setSex(patientDTO.getSex());
        patient.setSymptom(patientDTO.getSymptom());
        return patientMapper.insert(patient) > 0;
    }
    @Override
    public String commendPython(String symptom )
    {
        try {
            String[] args  = new String[] { "python", "E:\\Destop\\medicine\\he_20210425(3).py", symptom };
            Process proc = Runtime.getRuntime().exec(args);
            InputStream inputStream = proc.getInputStream();
            InputStreamReader outputReader= new InputStreamReader(inputStream,"utf-8");
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
