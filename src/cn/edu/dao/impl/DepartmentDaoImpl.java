package cn.edu.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.edu.dao.DepartmentDao;
import cn.edu.dao.base.BaseDaoImpl;
import cn.edu.domain.Department;
import cn.edu.domain.User;

public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao<Department> {
//	public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao { 重构前的代码

	public void saveDepartment(Department department) {
//		this.getHibernateTemplate().save(department);  //重构前的代码
		this.saveEntry(department);
	}

	public void updateDepartment(Department department) {
		this.getHibernateTemplate().update(department);
	}

	public void deleteDepartmentById(Serializable id, String deleteModel) {
		Department department = this.getDepartmentById(id);
		if("del".equals(deleteModel)){  //单表的删除
			
		}else if("del_pre_release".equals(deleteModel)){  //先解除关系，再进行删除操作
			Set<User> users = department.getUsers();
			for(User user:users){
				user.setDepartment(null);
			}
		}else{
			//级联删除
		}
		this.getHibernateTemplate().delete(department);
	}

	public Collection<Department> getAllDepartment() {
		return (Collection<Department>) this.getHibernateTemplate().find("from Department");
	}

	public Department getDepartmentById(Serializable id) {
		return this.getHibernateTemplate().get(Department.class, id);
	}

}
