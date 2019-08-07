package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advice for logging
	
	// let's start with an @Before advice
	
	//@Before("execution(public void add*())")
	@Pointcut("execution(* aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n======>>> performing API analytics");
	}
}
