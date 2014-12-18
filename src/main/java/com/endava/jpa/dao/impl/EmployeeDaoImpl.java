package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private String QUERY_FIND_EMPLOYEE_BY_CITY_AND_DEPARTMENT = "SELECT e from Employee e join e.department d where e.city = :city_name and d.id=:dept_id";
    private String QUERY_FIND_EMPLOYEE_BY_PROJECT = "SELECT e from Employee e,Project p where e.name=p.project_manager and p.name = :proj_name";

	@PersistenceContext
	private EntityManager entityManager;

    @PersistenceContext
    private EntityManager em;



    @Override
    public void save(Employee employee){
        em.persist(employee);
    }


    @Override
    public List<Employee> findByCityAndDepartment(String city, int dept_id) {
        return em.createQuery( QUERY_FIND_EMPLOYEE_BY_CITY_AND_DEPARTMENT )
                .setParameter( "city_name" , city )
                .setParameter( "dept_id" , dept_id )
                .getResultList();
    }

    @Override
    public List<Employee> findByProject(String proj_name){
        return em.createQuery( QUERY_FIND_EMPLOYEE_BY_PROJECT)
                .setParameter("proj_name",proj_name)
                .getResultList();

    }
}
