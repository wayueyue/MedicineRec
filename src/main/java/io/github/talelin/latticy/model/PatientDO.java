package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 */
@Data
@TableName("t_patient")
@Builder
@EqualsAndHashCode(callSuper = true)
public class PatientDO extends BaseModel implements Serializable {

    @Tolerate
    public PatientDO(){}

    private static final long serialVersionUID = 3531805912578317266L;

    private String name;

    private int age;

    private String sex;

    private String symptom;


    private String prescription;

}
