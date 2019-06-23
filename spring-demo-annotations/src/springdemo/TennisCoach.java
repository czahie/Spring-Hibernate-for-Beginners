package springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside doMyStartupStuff method");
	}
	
	// destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside doMyCleanupStuff method");
	}
	
//	@Autowired
//	public TennisCoach(FortuneService thefortuneService) {
//		this.fortuneService = thefortuneService;
//	}
	
//	// define a setter method
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService theFortuneService) {
//		System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
//		fortuneService = theFortuneService;
//	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
