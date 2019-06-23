package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file 
		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(PracticeConfig.class);
		
		// get the bean from the container
		Coach theCoach = context.getBean("soccerCoach", Coach.class);
		
		// call our method
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();

	}

}
