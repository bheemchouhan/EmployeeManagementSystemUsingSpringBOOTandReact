package com.bheempractice.controller;

import com.bheempractice.dto.EmployeeDto;
import com.bheempractice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;



    //Build Add Employee REST API
    @PostMapping


    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee REST API

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeByID(@PathVariable("id") Long employeeID){
       EmployeeDto employeeDto=  employeeService.getEmployeeById(employeeID);
       return ResponseEntity.ok(employeeDto);
    }

    //Build Get All REST API
    @GetMapping

    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build Update Employee REST API

    @PutMapping("{id}")

    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
       EmployeeDto employeeDto=  employeeService.updateEmployee(employeeId,updatedEmployee);
       return ResponseEntity.ok(employeeDto);
    }


    //Delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){

        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok("Employee deleted successfully");
    }
}

