package hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.practice.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a employee object 
			System.out.println("Creating employee objects...");
			Employee emp1 = new Employee("James", "Harden", "Rockets");
			Employee emp2 = new Employee("Russel", "Westbrook", "Thunders");
			
			// start transaction
			session.beginTransaction();
			
			// save the employee object
			System.out.println("Saving employee objects...");
			session.save(emp1);
			session.save(emp2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
