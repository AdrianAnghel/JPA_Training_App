package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.DepartmentDao;
import com.endava.jpa.model.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@PersistenceContext
	private EntityManager entityManager;

	private String QUERY_FIND_DEPARTMENT_BY_NAME = "Select d from Department d where d.name = :dep_name";
    private String QUERY_UPDATE_DEPARTMENT = "Update Department set :dep_column = :new_value";
	@Override
	public Department find(int id) {
		return entityManager.find(Department.class, id);
	}

	public List<Department> find(String departmentName) {
		return entityManager.createQuery(QUERY_FIND_DEPARTMENT_BY_NAME)
				.setParameter("dep_name", departmentName)
				.getResultList();
	}

	@Override
	public void save(Department toBeSaved) {
		// To be implemented
        entityManager.persist(toBeSaved);
	}

	@Override
	public void update(Department toBeUpdated) {
        int id=toBeUpdated.getId();
        Department dept = entityManager.find(Department.class,id);
        dept.setName(toBeUpdated.getName());
	}

	@Override
	public void remove(Department toBeRemoved) {
        int id = toBeRemoved.getId();
        Department dept = entityManager.find(Department.class,id);
        entityManager.remove(dept);
	}

}
