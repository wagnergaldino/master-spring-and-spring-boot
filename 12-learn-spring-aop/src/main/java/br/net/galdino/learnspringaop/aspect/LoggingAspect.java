package br.net.galdino.learnspringaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//Configure
@Configuration
//AOP
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//When
	//execution(* PACKAGE.*.*(..)) USING PACKAGE POINTCUT FROM COMMONPOINTCUTCONFIG CLASS
	//@Before("execution(* br.net.galdino.learnspringaop.data.*.*(..)) || execution(* br.net.galdino.learnspringaop.business.*.*(..))")
	@Before("br.net.galdino.learnspringaop.aspect.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logBeforeMethodCall(JoinPoint joinpoint) {
		//What
		logger.info("Método: {} - Argumentos: {} - INICIO", joinpoint, joinpoint.getArgs());
	}
	
	//@After goes for Success or Failure - USING BEAN POINTCUT FROM COMMONPOINTCUTCONFIG CLASS
//	@After("br.net.galdino.learnspringaop.aspect.CommonPointcutConfig.allClassesWithServiceInName()") //for everything since root package
//	public void logAfterMethodCall(JoinPoint joinpoint) {
//		//What
//		logger.info("Método: {} - Argumentos: {} - FINAL", joinpoint, joinpoint.getArgs());
//	}
	
	//@AfterReturning just in case of success
	@AfterReturning(pointcut = "execution(* br.net.galdino.learnspringaop.*.*.*(..))", returning = "resultValue")
	public void logAfterReturningMethodCall(JoinPoint joinpoint, Object resultValue) {
		//What
		logger.info("Método: {} - HAS RETURNED: {} - FINAL", joinpoint, resultValue);
	}
	
	//@AfterThrowing just in case of throwing exception
	@AfterThrowing(pointcut = "execution(* br.net.galdino.learnspringaop.*.*.*(..))", throwing = "exception")
	public void logAfterThrowingMethodCall(JoinPoint joinpoint, Exception exception) {
		//What
		logger.info("Método: {} - HAS THROWN EXCEPTION: {}", joinpoint, exception.getMessage());
	}

}
