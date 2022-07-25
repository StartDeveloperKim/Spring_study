package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.ExeTimeAspect;
import chapter7.Calculator;
import chapter7.RecCalculator;

@Configuration
@EnableAspectJAutoProxy
// @Aspect 어노테이션을 붙인 클래스를 공통 기능으로 적용하려면 해당 어노테이션을 붙여야함
public class AppCtx {
	
	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}
	
	@Bean
	public Calculator calculator() {
		return new RecCalculator();
	}
}
