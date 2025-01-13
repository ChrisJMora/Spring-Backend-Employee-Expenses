package com.business.employee.expenses.persistence;

import com.business.employee.expenses.models.humanResources.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
