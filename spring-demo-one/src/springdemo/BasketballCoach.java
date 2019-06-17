package springdemo;

public class BasketballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BasketballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override 
	public String getDailyWorkout() {
		return "Shoot 500 balls";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
