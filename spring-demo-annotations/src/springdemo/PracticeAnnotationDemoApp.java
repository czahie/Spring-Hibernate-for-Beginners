package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeAnnotationDemoApp {

	public static void main(String[] args) {
		
		// read the spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from the spring container
		Coach theCoach = context.getBean("swimmingCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close the context;
		context.close();

	}

}
