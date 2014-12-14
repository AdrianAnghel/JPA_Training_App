package com.endava.jpa.service.impl;

import com.endava.jpa.dao.DepartmentDao;
import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;



	@Override
	public void save(Employee employee){
        employeeDao.save(employee);
	}

	@Override
	public List<Employee> findByCityAndDepartment( String city, int dept_id ) {
		return employeeDao.findByCityAndDepartment(city, dept_id);
	}

    @Override
    public List<Employee> findByProject(String proj_name){
        return employeeDao.findByProject(proj_name);
    }


}
