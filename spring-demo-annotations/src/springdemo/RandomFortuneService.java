package springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of strings
	private String[] data = {
			"Beware of the wolf in the sheep's clothing", 
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	// create a random number generator
	Random random = new Random();
	
	@Override
	public String getFortune() {
		
		// pick a random string
		int idx = random.nextInt(data.length);
		return data[idx];
	}

}
