package app.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

//In Hibernate 3.6 the interface Session was in package org.hibernate.classic whereas in Hibernate 4.0 it was moved to the package org.hibernate.
//In Hibernate 3.6 the SessionFactory.openSession no longer returns an org.hibernate.classic.Session, rather it returns an org.hibernate.Session. This is a refactor that breaks client code...


@Repository
public class PersonDaoTemplate extends HibernateTemplate{
	
	
}
