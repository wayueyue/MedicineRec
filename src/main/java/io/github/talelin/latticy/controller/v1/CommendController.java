package io.github.talelin.latticy.controller.v1;
import io.github.talelin.latticy.dto.patient.CreateOrUpdatePatientDTO;
import io.github.talelin.latticy.service.CommendService;
import io.github.talelin.latticy.web.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/commend/")
@ResponseResult
public class CommendController {

    @Autowired
    public CommendService commendService;


    @PostMapping("")
    public int createPatient(@RequestBody CreateOrUpdatePatientDTO patientDTO) {
        return commendService.createPatient(patientDTO);
    }


    @PostMapping("list")
    public List<String> listPatientSymptom() {
        return commendService.listPatientSymptom();
    }


    @PostMapping("/{symptom}")
    public String commend(@RequestParam String symptom) {
        return commendService.commendPython(symptom);
    }


}
