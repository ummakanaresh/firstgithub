package com.hyber.welcome;

import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  

public class WelocomeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("employee.cfg.xml").build();  
           Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
         
       SessionFactory factory = meta.getSessionFactoryBuilder().build();  
       Session session = factory.openSession();  
       Transaction t = session.beginTransaction();  
         
       EmployeePersistClass e1=new EmployeePersistClass();    
           e1.setId(1);    
           e1.setName("Gaurav");    
           e1.setAge("22");    
        
      session.save(e1);  
      t.commit();  
      System.out.println("successfully saved");    
       factory.close();  
       session.close();     
   }  
}  