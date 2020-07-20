package com.sooriya.databaseoperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sooriya.Entity.Student;

public class QueryingObject {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			System.out.println("Displaying all students");
			List<Student> student = session.createQuery("from Student").getResultList();
			displayStudent(student);
		
			System.out.println("\nDisplay all students whose firstname=Sooriya or lastName=Furhana");
		    student = session.createQuery("from Student s where s.firstName='Sooriya' or s.lastName='Furhana'").getResultList();
            displayStudent(student);		    
            System.out.println("\nDisplay all students whose firstname like 'Soor%'");
            student = session.createQuery("from Student s where s.firstName like 'Soor%'").getResultList();
            displayStudent(student);
            
			session.getTransaction().commit();
		}
		finally
		{
		     	factory.close();
		}
	}

	private static void displayStudent(List<Student> student) {
		for(Student tempStudent:student)
		{
			System.out.println(tempStudent);
		}
	}

}
