package com.mm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientSelect {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.configure();
		
		cfg.addAnnotatedClass(Candidate.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Candidate obj = session.load(Candidate.class, 1);
		System.out.println(obj);
		
		
	}

}
