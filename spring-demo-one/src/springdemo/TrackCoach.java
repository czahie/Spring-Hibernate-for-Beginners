package springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}
	
	// add an init method 
	public void doMyStartupMethod() {
		System.out.println("TrackCoach: inside method doMyStartupMethod");
	}
	
	// add a destroy method
	public void doMyCleanupMethod() {
		System.out.println("TrackCoach: inside method doMyCleanupMethod");
	}
	

}
