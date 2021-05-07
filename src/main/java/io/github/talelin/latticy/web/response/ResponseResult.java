package io.github.talelin.latticy.web.response;

import java.lang.annotation.*;

/**
 * 此注解用于返回值包装，将返回值包装成ApiResponse
 *
 * @author alita
 * @date 2020/11/3
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {
}
