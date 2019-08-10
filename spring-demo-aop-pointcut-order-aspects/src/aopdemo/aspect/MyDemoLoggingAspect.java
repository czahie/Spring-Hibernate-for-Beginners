package aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advice for logging
	
	// let's start with an @Before advice
		
	@Before("aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display the method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object arg: args) {
			System.out.println(arg);
			
			if (arg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) arg;
				
				System.out.println("Account Name: " + theAccount.getName());
				System.out.println("Account Level: " + theAccount.getLevel());
			}
		}
		
		
	}
	
}
