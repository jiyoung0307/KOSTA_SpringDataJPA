package com.example.springdatajpa.domain;


public class EmployeeUpdateDTO {
    private String empId;
    private int deptId;
    private int salary;


    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }


    public int getDeptId() {
        return deptId;
    }


    public int getSalary() {
        return salary;
    }


    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }
}
