package com.endava.jpa.service;

import com.endava.jpa.model.Employee;

import java.util.List;

public interface EmployeeService {

	void save( Employee employee );

	List<Employee> findByCityAndDepartment( String city, int department_id );

    List<Employee> findByProject(String proj_name);
}
