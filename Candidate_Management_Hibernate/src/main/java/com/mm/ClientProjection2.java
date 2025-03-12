package com.mm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;

public class ClientProjection2 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.configure();
		
		cfg.addAnnotatedClass(Candidate.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		// Select * From Candidate
		Criteria criteria = session.createCriteria(Candidate.class);
		
		PropertyProjection projection1 = Projections.property("name");
		
		// Select name from Candidate
		criteria.setProjection(projection1);
		
		// Where age > 60
		criteria.add(Restrictions.gt("age", 30));
		
		List<String> namesofcandidate = criteria.list();
		
		for (String name : namesofcandidate) {
			System.out.println(name);
			System.out.println("------------");
		}
		
		
		
		
	}

}
