package com.mm;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Session;

public class ClientInsert {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();

		cfg.configure();

		cfg.addAnnotatedClass(Candidate.class);

		SessionFactory factory = cfg.buildSessionFactory();

		org.hibernate.Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		Candidate candidate = new Candidate(2, "Anup", "BJP", "Dhule", "MH", "Male", 55);

		session.save(candidate);
		
		tx.commit();
		
		session.close();
		
	}

}
