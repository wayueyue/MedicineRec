package io.github.talelin.latticy.web.response;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 返回值统一处理类自动装配
 *
 * @author alita
 * @date 2020/10/30
 */
@Configuration
public class ResponseAdviceAutoConfiguration {
	@Bean
	public ResponseAdvice responseAdvice() {
		return new ResponseAdvice();
	}
}
