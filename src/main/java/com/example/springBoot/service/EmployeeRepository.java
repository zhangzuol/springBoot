package com.example.springBoot.service;

import com.example.springBoot.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByName(String name);

    List<Employee> findByNameOrAddress(String name, String address);
}
