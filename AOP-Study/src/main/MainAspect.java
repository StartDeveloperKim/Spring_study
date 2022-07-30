package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter7.Calculator;
import config.AppCtx;

public class MainAspect {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new
				AnnotationConfigApplicationContext(AppCtx.class);
		
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		cal.factorial(7);
		cal.factorial(7);
		cal.factorial(5);
		cal.factorial(5);
		ctx.close();

	}

}
