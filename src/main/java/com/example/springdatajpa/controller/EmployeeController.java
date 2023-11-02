package com.example.springdatajpa.controller;

import com.example.springdatajpa.domain.Employee;
import com.example.springdatajpa.domain.EmployeeUpdateDTO;
import com.example.springdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    C
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    //    R
//    전체 다 가져오기
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployeess();
    }

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable String empId) {
        return employeeService.getEmployee(empId).get();
    }

    //    U
    @PutMapping("/{empId}")
    public String updateEmployee(@PathVariable String empId,
                                 @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        return employeeService.updateEmployee(employeeUpdateDTO);
    }

//    D
    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable String empId) {
        return employeeService.deleteEmployee(empId);
    }
}
