package app.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import app.domain.Person;

//In Hibernate 3.6 the interface Session was in package org.hibernate.classic whereas in Hibernate 4.0 it was moved to the package org.hibernate.
//In Hibernate 3.6 the SessionFactory.openSession no longer returns an org.hibernate.classic.Session, rather it returns an org.hibernate.Session. This is a refactor that breaks client code...

@Repository
public class PersonDaoSupport extends HibernateDaoSupport{

	public Person select(Integer id) {
		Person person = this.getHibernateTemplate().get(Person.class, id);
		return person;
	}
	
}
