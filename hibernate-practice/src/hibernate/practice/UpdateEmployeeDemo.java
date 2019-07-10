package hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.practice.entity.Employee;

public class UpdateEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int employeeId = 3;
			
			// start transaction
			session.beginTransaction();
			
			// get the employee object
			System.out.println("Getting the employee object...");
			Employee emp = session.get(Employee.class, employeeId);
			
			// update the info of the employee
			System.out.println("Updating the employee object...");
			emp.setFisrtName("Kwahi");
			emp.setLastName("Leonard");
			emp.setCompany("Clippers");
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
