package cn.edu.service.impl;

import java.io.Serializable;

import cn.edu.dao.PersonDao;
import cn.edu.domain.Person;
import cn.edu.service.PersonService;

public class PersonServiceImpl implements PersonService{
	
	private PersonDao personDao;
	public PersonDao getPersonDao() {
		return personDao;
	}
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void savePerson(Person person) {
		personDao.savePerson(person);
	}
	public Person getPersonById(Serializable id) {
		Person person = personDao.getPersonById(id);
		return person;
	}

}
