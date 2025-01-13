package com.business.employee.expenses.services;

import com.business.employee.expenses.models.business.Department;

public interface DepartmentService {
    Department getDepartmentById(Long id);
    double getDepartmentExpenses(Long id);
}
