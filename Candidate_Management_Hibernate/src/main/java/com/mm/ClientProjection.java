package com.mm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;

public class ClientProjection {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.configure();
		
		cfg.addAnnotatedClass(Candidate.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		// Select from Candidate
		Criteria criteria = session.createCriteria(Candidate.class);
		
		PropertyProjection projection1 = Projections.property("name");
		
		PropertyProjection projection2 = Projections.property("partyname");
		
		//Used For at a time operation on two columns
		ProjectionList projectionList = Projections.projectionList();
		
		projectionList.add(projection1);
		projectionList.add(projection2);
		
		
		// Select from Candidate
		criteria.setProjection(projectionList);
		
		// where age > 30
		criteria.add(Restrictions.gt("age", 30));
		
		List<Candidate> listofcandidate = criteria.list();
		
		for (Candidate candidate : listofcandidate) {
			System.out.println(candidate);
		}

		
	}

}
