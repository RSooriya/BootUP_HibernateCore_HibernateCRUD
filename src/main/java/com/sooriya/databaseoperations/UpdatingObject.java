package com.sooriya.databaseoperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sooriya.Entity.Student;

public class UpdatingObject {

	public static void main(String[] args) {
       SessionFactory factory = new Configuration().configure().
    		   addAnnotatedClass(Student.class).buildSessionFactory();
       Session session = factory.getCurrentSession();
       try
       {
    	    session.beginTransaction();
    	    System.out.println("Updating using primary key");
    	    Student myStudent = session.get(Student.class, 1);
    	    myStudent.setEmail("luv2code@gmail.com");
    	    session.getTransaction().commit();
    	    System.out.println("/Updating using hibernate query language");
    	    session = factory.getCurrentSession();
    	    session.beginTransaction();
    	    session.createQuery("update Student set email='luv2code@gmail.com'").executeUpdate();
    	    session.getTransaction().commit();
    	    
       }
       finally
       {
    	   factory.close();
       }
	}

}
