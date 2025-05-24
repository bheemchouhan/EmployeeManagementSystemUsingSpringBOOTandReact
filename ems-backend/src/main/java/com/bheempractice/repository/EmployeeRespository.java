package com.bheempractice.repository;

import com.bheempractice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee,Long> {
}
