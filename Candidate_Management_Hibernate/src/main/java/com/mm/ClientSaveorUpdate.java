package com.mm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientSaveorUpdate {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.configure();
		
		cfg.addAnnotatedClass(Candidate.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Candidate candidate = new Candidate(3,"Mali","BJP","MH","Dhule","Male",24);
		
		session.saveOrUpdate(candidate);
		
		tx.commit();
		
		session.close();
		
		}

}
