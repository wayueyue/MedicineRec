package io.github.talelin.latticy.web.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * @author Zhang Xilong 81840
 * @date 2021/3/5
 */
public class EnumValidator implements ConstraintValidator<Enum, Object> {

	private Enum annotation;

	@Override
	public void initialize(Enum constraintAnnotation) {
		this.annotation = constraintAnnotation;
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value == null) {
			return annotation.allowNull();
		}

		Object[] objects = annotation.clazz().getEnumConstants();
		try {
			Method method = annotation.clazz().getMethod(annotation.method());
			for (Object o : objects) {
				if (value.equals(method.invoke(o))) {
					return true;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return false;
	}
}