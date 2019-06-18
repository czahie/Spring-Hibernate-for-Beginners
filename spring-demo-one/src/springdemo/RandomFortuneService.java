package springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	public String[] fortunes;
	
	public Random random = new Random(); 
	
	public RandomFortuneService() {
		fortunes = new String[3];
		fortunes[0] = "The early bird gets the worm, but the second mouse gets the cheese.";
		fortunes[1] = "Be on the alert to recognize your prime at whatever time of your life it may occur.";
		fortunes[2] = "Your road to glory will be rocky, but fulfilling.";
	}
	
	@Override
	public String getFortune() {
		return fortunes[random.nextInt(fortunes.length)];
	}

}
