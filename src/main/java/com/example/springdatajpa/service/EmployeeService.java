package com.example.springdatajpa.service;

import com.example.springdatajpa.domain.Employee;
import com.example.springdatajpa.domain.EmployeeUpdateDTO;
import com.example.springdatajpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //    C
//    @Transactional
//    기본적으로 commit을 지원
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //    R
    @Transactional(readOnly = true)
    public Optional<Employee> getEmployee(String empId) {  // optional test 추가
//        Optional은 null처리를 위한 아이 (nullPointerException)
        return employeeRepository.findById(empId);
    }

    //    R
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeess(){
        return employeeRepository.findAll();
    }

    //    U
//    @Transactional
    public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
        Optional<Employee> findEmployee = employeeRepository.findById(employeeUpdateDTO.getEmpId());    // 원래 사원 정보
//        Optional이므로 get으로 먼저 처리
        Employee employee = findEmployee.get();
        employee.setDeptId(employeeUpdateDTO.getDeptId());
        employee.setSalary(employeeUpdateDTO.getSalary());
//        save는 null을 절대 던지지 않고 Exception 처리함
        Employee save = employeeRepository.save(employee);
        return "수정 완료";
    }

//    D
    public String deleteEmployee(String empId) {
        employeeRepository.deleteById(empId);
        return "삭제 완료";
    }
}

