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
    public PatientDO getPrescription(@RequestBody PatientDO patientDTO) {
        return commendService.getPrescription(patientDTO);
    }

    @GetMapping("")
    public List<SymptomDO> getSymptoms() {
        List<SymptomDO> symptoms = commendService.getSymptoms();
        return symptoms;
    }
}
