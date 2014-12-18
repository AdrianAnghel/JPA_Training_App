package com.endava.jpa.service.impl;

import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.DepartmentService;
import com.endava.jpa.service.EmployeeService;
import com.endava.jpa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.Date;
import java.util.List;

@Service
public class JPAMainService {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;

	//-------------------------------------- Department -----------------------------/

	public void findDepartment() {
		Department department = departmentService.find(1);
		System.out.println(department);
	}

    public Department findDepartment(int id) {
        Department department = departmentService.find(id);
        return department;
    }

	public void findDepartmentByName() {
		List<Department> departments = departmentService.find("PRE-SALES");
		for(Department department : departments) {
			System.out.println(department);
		}
	}
	/**
	 *   Define a new department entity and insert it into the corresponding table
	 */
	 public void insertDepartment() {
         Department newDepartment = new Department();
         newDepartment.setId(8);
         newDepartment.setName("APP-SECURITY");
         departmentService.save(newDepartment);
         System.out.println("New department inserted!");
     }

	 /**
	 * Search for an existing department, update its name and save it using the new name
	 */
	public void updateDepartment() {
        Department newDepartment = findDepartment(3);
        newDepartment.setName("ITServices");
        departmentService.update(newDepartment);
        System.out.println("Department updated! \n " + newDepartment);
    }

	/**
	 * Delete an existing department from the database
	 */
	public void deleteDepartment() {
        Department newDepartment = new Department();
        newDepartment.setId(8);
        newDepartment.setName("APP-SECURITY");
        departmentService.remove(newDepartment);
        System.out.println("Department deleted");
    }

	//-------------------------------------- Employee -----------------------------/
	/**
	 * Create a new employee entity and save it into the corresponding table
	 */
	public void insertEmployee() {
		Employee employee = new Employee();

        SimpleDateFormat dateFormat = new SimpleDateFormat("1992-08-27");
        Date date = new Date();

		employee.setName( "Mos Craciun" );
		employee.setCity("Bucharest");
		employee.setDepartment(departmentService.find(1));
		employee.setZip_code("089898");
		employee.setSalary(40L);
		employee.setState("Romania");
		employee.setBirthday((dateFormat.format(date)));
		employee.setStreet("Soseaua Laponia");
		employee.setId( 10 );
		employeeService.save(employee);
        System.out.println("Employee inserted ! \n " + employee);
	}

	/**
	 * Print to stdout all the employees from 'Bucharest', which belong to the department with id = 1.
	 * Make sure that there are more than two employees in Bucharest which belong to the department with id=1 when populating the DB.
	 * ! Use a join query.
	 */
	public void getEmployeesFromBucharest(){
		List<Employee> employeeList;
		employeeList=employeeService.findByCityAndDepartment("Bucharest",1);

		for(Employee emp : employeeList){
			System.out.println(emp);
		}


	}

	/**
	 * Give a salary raise(+10%) for all employees that work in the 'Endava' project (project name = 'Endava').
	 * ! Use a join query.
	 */
	public void giveSalaryRaise(){
        List<Employee> employeeList=employeeService.findByProject("Endava");



	}


	//-------------------------------------- Project -----------------------------/

	/**
	 * Add a new employee to the 'Endava' project. (project name = 'Endava')
	 */
	public void addEmployee(){}

	/**
	 * Remove an employee from a project which has 'John Doe' as project manager.
	 */
	public void removeEmployee(){}

}
