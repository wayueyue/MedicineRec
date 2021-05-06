package io.github.talelin.latticy.controller.v1;


import io.github.talelin.latticy.dto.patient.CreateOrUpdatePatientDTO;
import io.github.talelin.latticy.mapper.PatientMapper;
import io.github.talelin.latticy.model.PatientDO;
import io.github.talelin.latticy.service.CommendService;
import io.github.talelin.latticy.vo.CreatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/commend")
public class CommendController {

    @Autowired
    public CommendService commendService;



    @PostMapping("")
    public boolean  createPatient(@RequestBody  CreateOrUpdatePatientDTO patientDTO) {
      return   commendService.createPatient(patientDTO);
    }

    @PostMapping("/{symptom}")
    public String commend(@RequestParam String symptom) {
        return commendService.commendPython(symptom);
    }




}
