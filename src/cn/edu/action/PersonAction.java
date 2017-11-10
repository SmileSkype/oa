package cn.edu.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.domain.Person;
import cn.edu.service.PersonService;

public class PersonAction extends ActionSupport{
	private PersonService personService;
	public PersonService getPersonService() {
		return personService;
	}
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public String savePerson(){
		Person person = new Person();
		person.setPname("小赵");
		personService.savePerson(person);
		return null;
	}
	
	public String getPerson(){
		Person person = personService.getPersonById(3L);
		ServletActionContext.getRequest().setAttribute("person", person);;
		return "index";
	}
}
