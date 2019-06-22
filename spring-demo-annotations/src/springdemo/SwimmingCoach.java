package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	public FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Practice breaststroke for 1000 metres";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	
}
