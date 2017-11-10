package cn.edu.dao;

import java.io.Serializable;

import cn.edu.domain.Person;

public interface PersonDao {
	public void savePerson(Person person);
	public Person getPersonById(Serializable id);
}
