package app.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})  
// handle session.load ERROR FAIL_ON_EMPTY_BEANS
public class Person{
	
	Integer id;
	String name;
	Integer age;
	Date birth;

	public Person(){}
	public Person(String _name, int _age) {
//		this.id = new Random().nextInt(5000);
		this.name = _name;
		this.age = _age;
		this.birth = new Date();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	
}
