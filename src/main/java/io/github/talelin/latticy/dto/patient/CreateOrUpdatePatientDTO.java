package io.github.talelin.latticy.dto.patient;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 */
@Data
@NoArgsConstructor
public class CreateOrUpdatePatientDTO {

    @Length(max = 255, message = "{patient.name.length}")
    private String name;

    @NotNull(message = "{patient.age.not-empty}")
    private int age;

    @Length(max = 255, message = "{patient.sex.length}")
    private String sex;

    @Length(max = 100, message = "{patient.symptom.length}")
    private String symptom;
}
