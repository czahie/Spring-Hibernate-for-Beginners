package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			

			/*
			// create the objects
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"http://www.luv2code.com/youtube",
					"Luv 2 code!!");
			*/
			
			// create the objects
			Instructor tempInstructor = new Instructor("James", "Harden", "jharden@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"http://www.luv2code.com/youtube",
					"Basketball");
			
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			// this will also save the tempInstructorDetail 
			// because of CascadeType.ALL
			System.out.println("Savint Instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





