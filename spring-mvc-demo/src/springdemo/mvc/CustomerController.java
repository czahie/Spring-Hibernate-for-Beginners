package springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// add an initBinder to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		// register a editor that will trim all the leading and trailing whitespace
		// if no other characters other than whitespace, trim it to null
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// add an attribute
		theModel.addAttribute("customer", new Customer());
		
		// return the view
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
		
		// for debug
		System.out.println("last name: |" + theCustomer.getLastName() + "|");
		
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}
	
}
