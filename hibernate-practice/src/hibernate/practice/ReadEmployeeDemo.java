package hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.practice.entity.Employee;

public class ReadEmployeeDemo {

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
			Employee emp1 = new Employee("Kevin", "Durant", "Nets");
			
			// start transaction
			session.beginTransaction();
			
			// save the employee object
			System.out.println("Saving employee objects...");
			session.save(emp1);
			
			// commit transaction
			session.getTransaction().commit();
			
			// retrieve the employee object
			
			// find the employee id
			System.out.println("The employee's id is " + emp1.getId());
			
			// get a new session and begin a new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// get the employee based on his id
			System.out.println("\nGetting the employee based on his id...");
			Employee emp2 = session.get(Employee.class, 1);
			System.out.println("Get completed: " + emp2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
