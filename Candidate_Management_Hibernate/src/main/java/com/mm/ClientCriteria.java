package com.mm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class ClientCriteria {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();

		cfg.configure();

		cfg.addAnnotatedClass(Candidate.class);

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		// Select from Candidate
		Criteria criteria = session.createCriteria(Candidate.class);

		// Where age > 60
		criteria.add(Restrictions.gt("age", 30));

		List<Candidate> listofcandidates = criteria.list();

		for (Candidate candidate : listofcandidates) {
			System.out.println(candidate);

		}
	}

}
