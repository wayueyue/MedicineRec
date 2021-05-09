package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 */
@Data
@TableName("t_symptom")
@Builder
@EqualsAndHashCode(callSuper = true)
public class SymptomDO extends BaseModel implements Serializable {

    @Tolerate
    public SymptomDO(){}

    private static final long serialVersionUID = 3531805912578317266L;

    private String symptom;

}
