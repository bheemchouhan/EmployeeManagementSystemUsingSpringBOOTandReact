package com.bheempractice.service.impl;

import com.bheempractice.dto.EmployeeDto;
import com.bheempractice.entity.Employee;
import com.bheempractice.exception.ResourceNotFoundException;
import com.bheempractice.mapper.EmployeeMapper;
import com.bheempractice.repository.EmployeeRespository;
import com.bheempractice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRespository employeeRespository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =  employeeRespository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRespository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does noty exist with given ID"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRespository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee existingEmployee = employeeRespository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee with the given ID does not exists" +employeeId));

        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());

        Employee savedEmployee = employeeRespository.save(existingEmployee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRespository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("The emplyee does not exists with ID "+employeeId));
        employeeRespository.delete(employee);

    }
}
