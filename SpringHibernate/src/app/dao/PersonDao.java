package app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.springframework.stereotype.Repository;

import app.domain.Person;

@Repository
public class PersonDao{

	@Resource
	SessionFactory sessionFactory;
	
	public Person select(Integer id) {
		Session session = sessionFactory.openSession();
		Person person = (Person)session.get(Person.class, id);
		session.close();
		return person;
	}
	
	public int save(Person person){
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(person);
		tran.commit();
		session.close();
		return 1;
	}
	
	public List<Person> find(){
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Person.class);
		crit.add(Expression.gt("age", 10));
		List<Person> listPerson = crit.list();
		session.close();
		return listPerson;
	}

	public int update(Person person) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(person);
		tran.commit();
		session.close();
		return 1;
	}
	
}
