package springdemo;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice breaststroke for 1000 metres";
	}
}
