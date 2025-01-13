package com.business.employee.expenses.persistence;

import com.business.employee.expenses.models.business.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
