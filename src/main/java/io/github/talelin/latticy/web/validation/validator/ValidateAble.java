package io.github.talelin.latticy.web.validation.validator;

import cn.hutool.core.exceptions.ValidateException;

/**
 * @author Zhang Xilong 81840
 * @date 2021/3/5
 */
public interface ValidateAble {

	/**
	 * 验证对象各属性是否合法
	 *
	 * @throws ValidateException 数据验证失败异常
	 */
	void validate() throws ValidateException;

}
