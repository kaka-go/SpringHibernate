package app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import app.dao.PersonDao;
import app.dao.PersonDaoSupport;
import app.dao.PersonDaoTemplate;
import app.domain.Person;
import app.service.PersonService;


@Controller
public class TestController {
	
	@Resource
	PersonService personService;
	
	@Resource
	SessionFactory sessionFactory;
	@Resource
	PersonDao personDao;
	
	@Resource
	PersonDaoTemplate personDaoTemplate;
	@Resource
	PersonDaoSupport personDaoSupport;
	
	@RequestMapping("/person/find")
	@ResponseBody
	public List<Person> findPerson(){
		return personDao.find();
	}
	
	@RequestMapping("/person/update")
	@ResponseBody
	public Person updatePerson(Person person){
		personDao.update(person);
		return person;
	}
	
	@RequestMapping("/person/save")
	@ResponseBody
	public Person savePerson(Person person){
		personDao.save(person);
		return person;
	}
	
	@RequestMapping("/personByDao")
	@ResponseBody
	public Person getPersonByDao(Integer id){
		Person person = personDao.select(id);
		return person;
	}
	
	@RequestMapping("/personByDaoTemplate")
	@ResponseBody
	public Person getPersonByDaoTemplate(Integer id){
		Person person = personDaoTemplate.get(Person.class, id);
		return person;
	}
	
	@RequestMapping("/personByDaoSupport")
	@ResponseBody
	public Person getPersonByDaoSupport(Integer id){
		Person person = personDaoSupport.select(id);
		return person;
	}
	
	@RequestMapping("/person")
	@ResponseBody
	public Person person(Integer id){
		if(id == null)
			return new Person("Edward", 23);
		Session session = sessionFactory.openSession();
		Person person = (Person)session.get(Person.class, id);
		session.close();
		return person;
	}
	
	@RequestMapping("/getPerson")
	@ResponseBody
	public Person getPerson(Integer id){
		Session session = sessionFactory.openSession();
		Person person = (Person)session.get(Person.class, id);
		session.close();
		return person;
	}
	
	@RequestMapping("/loadPerson")
	@ResponseBody
	public Person loadPerson(Integer id){
		Session session = sessionFactory.openSession();
		Person person = (Person)session.load(Person.class, id);
		session.close();
		return person;
	}
	
	@RequestMapping("/createPerson")
	@ResponseBody
	public Person createPerson(String name, Integer age){
		Person person = new Person(name, age);
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(person);
		tran.commit();
		session.close();
		return new Person(name, age);
	}
		
}
