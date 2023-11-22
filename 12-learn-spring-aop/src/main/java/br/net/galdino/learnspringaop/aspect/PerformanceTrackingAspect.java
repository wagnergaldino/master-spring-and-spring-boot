package br.net.galdino.learnspringaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//Configure
@Configuration
//AOP
@Aspect
public class PerformanceTrackingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//@Around("execution(* br.net.galdino.learnspringaop.*.*.*(..))") DEFAULT USE
	@Around("br.net.galdino.learnspringaop.aspect.CommonPointcutConfig.trackTimeAnnotation()")//USING TimeTrack CUSTOM ANNOTATION
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTimeMillis = System.currentTimeMillis();
		
		Object returnValue = proceedingJoinPoint.proceed();
		
		long stopTimeMillis = System.currentTimeMillis();
		long executionDuration = stopTimeMillis - startTimeMillis;
		logger.info("{} method executed in {} milliseconds", proceedingJoinPoint, executionDuration);
		
		return returnValue;
	}

}
