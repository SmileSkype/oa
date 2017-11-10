package cn.edu.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.edu.dao.PersonDao;
import cn.edu.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	public void savePerson(Person person) {
		this.getHibernateTemplate().save(person);
	}

	public Person getPersonById(Serializable id) {
		Person person = this.getHibernateTemplate().load(Person.class, id);
//		System.out.println(person.getPname());
		return person;
	}

}
