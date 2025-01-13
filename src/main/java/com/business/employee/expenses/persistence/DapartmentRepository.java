package com.business.employee.expenses.persistence;

import com.business.employee.expenses.models.business.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DapartmentRepository extends JpaRepository<Department, Long> {
}
