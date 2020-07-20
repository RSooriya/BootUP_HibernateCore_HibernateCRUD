package com.sooriya.databaseoperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sooriya.Entity.Student;

public class DeletingObject {

	public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().
        		addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try
        {
        	System.out.println("Deleting single student..");
        	session.beginTransaction();
        	Student myStudent = session.get(Student.class, 1);
        	session.delete(myStudent);
        	session.getTransaction().commit();
        	System.out.println("Deleting multiple Student...");
        	
        	
        	session = factory.getCurrentSession();
        	session.beginTransaction();
        	session.createQuery("delete from Student").executeUpdate();
        	session.getTransaction().commit();
        }
        finally
        {
        	factory.close();
        	
        }
	}

}
