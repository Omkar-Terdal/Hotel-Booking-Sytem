package com.example.hotelmanagementsy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hotelmanagementsy.model.Employee;

@Repository
public interface EmployeeRepository {
    void save(Employee employee);

    Employee findById(Long employeeId);
}