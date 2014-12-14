package com.endava.jpa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Adi on 11/19/2014.
 */

@Entity
@Table(name="employee")
public class Employee {


    @ManyToOne
    @JoinColumn(name="dept_id")
    Department department;

    @Id
    private int id;
    private String name;
    private Long salary;
    private String street;
    private String city;
    private String state;
    private String zip_code;
    private String birthday;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String Name){
        this.name=Name;
    }

    public Long getSalary(){
        return salary;
    }

    public void setSalary(Long salary){
        this.salary=salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street=street;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city=city;
    }
    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state=state;
    }
    public String getZip_code(){
        return zip_code;
    }

    public void setZip_code(String zip_code){
        this.zip_code=zip_code;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday=birthday;
    }

    public String toString(){
        return "Employee{" +
                "id = " + id +
                ", name = " + name +
                ", salary = " + salary +
                ", dept_id = " + department.getId() +
                ", street = " + street +
                ", city = " + city +
                ", state = " + state +
                ", zip_code = " + zip_code +
                ", birthday = " + birthday +
                "}";
    }
}
