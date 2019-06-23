package springdemo;

import org.springframework.stereotype.Component;

@Component
public class PracticeFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Fake it till you make it.";
	}

}
