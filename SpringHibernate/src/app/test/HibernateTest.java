package app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.domain.Person;

public class HibernateTest {  
	  
    private SessionFactory sessionFactory;  
    private ApplicationContext ctx;  
  
    @Before
    public void init() {  
        String[] configLocations = new String[] {"classpath:spring-config.xml"};  
        ctx = new ClassPathXmlApplicationContext(configLocations);  
        sessionFactory = ctx.getBean("sessionFactory", SessionFactory.class);  
    }  
      
    @Test
    public void testSessionFactory(){  
        System.out.println(sessionFactory);  
        System.out.println(ctx.getBean("dataSource"));  
        Session session = sessionFactory.openSession();   
        Person person = new Person("Edward", 23);
        session.save(person);
        session.flush();
        session.close();
    }  
}  
