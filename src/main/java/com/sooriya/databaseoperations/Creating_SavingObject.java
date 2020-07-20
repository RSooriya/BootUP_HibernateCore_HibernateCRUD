
package com.sooriya.databaseoperations;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sooriya.Date.DateUtils;
import com.sooriya.Entity.Student;

public class Creating_SavingObject {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				                       addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{
			System.out.println("Creating new object...");
			String dateOfBirthStr = "29/06/1997";
			Date dateOfBirth = DateUtils.parseDate(dateOfBirthStr);
		    Student student = new Student("Shama","Furhana","shama04@gmail.com",dateOfBirth);
		   
		    session.beginTransaction();
		    System.out.println("Saving into the database");
		    session.save(student);
		    session.getTransaction().commit();
		    System.out.println(student);
		    System.out.println("Done!!!");
		    System.out.println();
		    System.out.println("Retrieving using primary key " +student.getId());
		    session = factory.getCurrentSession();
		    session.beginTransaction();
		    Student theStudent = session.get(Student.class, student.getId());
		    session.getTransaction().commit();
		    System.out.println(theStudent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		       factory.close();	
		}
	}

}
