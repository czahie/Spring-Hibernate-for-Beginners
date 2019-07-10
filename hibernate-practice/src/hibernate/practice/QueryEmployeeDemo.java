package hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.practice.entity.Employee;

public class QueryEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			// get employee list where company="Rockets"
			System.out.println("Getting employees whose company are Rockets...");
			List<Employee> employees = session.createQuery("from Employee where company='Rockets'").getResultList();
			
			// display employees
			displayEmployees(employees);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

	private static void displayEmployees(List<Employee> employees) {
		for (Employee e: employees) {
			System.out.println(e);
		}
		
	}

}
