package cn.edu.service.impl;

import java.io.Serializable;
import java.util.Collection;

import cn.edu.dao.DepartmentDao;
import cn.edu.domain.Department;
import cn.edu.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public void saveDepartment(Department department) {
//		departmentDao.saveDepartment(department);  重构前的代码
		departmentDao.saveEntry(department);
	}

	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
	}

	public void deleteDepartmentById(Serializable id, String deleteModel) {
		departmentDao.deleteDepartmentById(id, deleteModel);
	}

	public Collection<Department> getAllDepartment() {
		return departmentDao.getAllDepartment();
	}

	public Department getDepartmentById(Serializable id) {
		return departmentDao.getDepartmentById(id);
	}

}
