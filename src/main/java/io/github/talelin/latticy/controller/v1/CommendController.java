package io.github.talelin.latticy.controller.v1;


import io.github.talelin.latticy.dto.patient.CreateOrUpdatePatientDTO;
import io.github.talelin.latticy.mapper.PatientMapper;
import io.github.talelin.latticy.model.PatientDO;
import io.github.talelin.latticy.service.CommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/commend")
public class CommendController {

    @Autowired
    public CommendService commendService;


    @PostMapping("")
    public PatientDO getPrescription(@RequestBody PatientDO patientDTO) {
        return commendService.getPrescription(patientDTO);
    }

    @GetMapping("/{name}")
    public List<PatientDO> getPatient(@PathVariable(value = "name") @Positive(message = "{name.positive}") String name) {
        List<PatientDO> patient = commendService.getByName(name);
        return patient;
    }





}
