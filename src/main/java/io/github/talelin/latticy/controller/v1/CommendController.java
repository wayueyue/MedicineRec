package io.github.talelin.latticy.controller.v1;


import io.github.talelin.latticy.model.PatientDO;
import io.github.talelin.latticy.model.SymptomDO;
import io.github.talelin.latticy.service.CommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/commend")
public class CommendController {

    @Autowired
    public CommendService commendService;


    @PostMapping("")
    public void getPrescription(@RequestBody PatientDO patientDTO) {
        commendService.getPrescription(patientDTO);
    }

    @GetMapping("")
    public List<SymptomDO> getSymptoms() {
        List<SymptomDO> symptoms = commendService.getSymptoms();
        return symptoms;
    }

    @GetMapping("/list")
    public PatientDO getPatient(@RequestParam(value = "name") String name) {
        PatientDO patient = commendService.getByName(name);
        System.out.println(patient);
        return patient;
    }
}
