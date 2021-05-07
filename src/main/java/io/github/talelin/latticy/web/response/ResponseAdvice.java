package io.github.talelin.latticy.web.response;

import io.github.talelin.latticy.web.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回值统一处理类
 *
 * @author alita
 * @date 2020/10/30
 */
@Slf4j
@RestControllerAdvice(annotations = ResponseResult.class)
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		Class<?> type = returnType.getParameterType();
		log.info("return type is :{}", type);
		return !ApiResponse.class.isAssignableFrom(type) && !ModelAndView.class.isAssignableFrom(type)
				&& !CharSequence.class.isAssignableFrom(type) && !ResponseEntity.class.isAssignableFrom(type);
	}

	@Override
	public Object beforeBodyWrite(
			Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response
	) {
		log.info("going to convert response body to ApiResponse");
		return ApiResponse.newInstance(body);
	}
}
