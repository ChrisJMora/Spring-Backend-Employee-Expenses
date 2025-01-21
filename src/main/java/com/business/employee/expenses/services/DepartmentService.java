package com.business.employee.expenses.services;

import com.business.employee.expenses.dto.DepartmentExpenses;
import com.business.employee.expenses.models.business.Department;

import java.time.LocalDate;
import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    List<DepartmentExpenses> getAllDepartmentExpensesByTimeSpan(LocalDate startDate, LocalDate endDate);
    double getDepartmentExpensesByTimeSpan(Long id, LocalDate startDate, LocalDate endDate);
}
