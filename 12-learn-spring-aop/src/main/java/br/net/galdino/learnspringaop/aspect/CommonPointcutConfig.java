package br.net.galdino.learnspringaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class CommonPointcutConfig {
	
	@Pointcut("execution(* br.net.galdino.learnspringaop.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("bean(*Service*)")
	public void allClassesWithServiceInName() {}
	
	@Pointcut("@annotation(br.net.galdino.learnspringaop.annotations.TrackTime)")
	public void trackTimeAnnotation() {}

}
