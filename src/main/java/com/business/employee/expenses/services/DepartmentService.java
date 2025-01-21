package com.business.employee.expenses.services;

import com.business.employee.expenses.dto.DepartmentExpenses;
import com.business.employee.expenses.models.business.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    List<DepartmentExpenses> getAllDepartmentExpenses();
    double getDepartmentExpenses(Long id);
}
