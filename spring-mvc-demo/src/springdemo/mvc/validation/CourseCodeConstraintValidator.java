package springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefix;
	
	@Override 
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}
	
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		
		boolean result = false;;
		
		if (theCode != null) {
			
			// iterate the prefixes and check if any prefix matches
			for (String prefix: coursePrefix) {
				if (theCode.startsWith(prefix)) {
					result = true;
					break;
				}
			}
			
		} else {
			result = true;
		}
		
		return result;
	}

}
