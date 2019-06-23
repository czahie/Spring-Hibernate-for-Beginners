package springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeConfig {
	
	// define a bean for my practice fortune service
	@Bean
	public FortuneService practiceFortuneService() {
		return new PracticeFortuneService();
	}
	
	// define a bean for my soccer coach
	@Bean
	public Coach soccerCoach() {
		return new SoccerCoach(practiceFortuneService());
	}
}
