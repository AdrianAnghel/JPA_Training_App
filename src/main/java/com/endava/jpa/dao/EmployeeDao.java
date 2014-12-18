package com.endava.jpa.dao;

import com.endava.jpa.model.Employee;

import java.util.List;

public interface EmployeeDao {


    void save(Employee employee);

    List<Employee> findByCityAndDepartment(String city, int dept_id);

    List<Employee> findByProject(String proj_name);
}
