package com.business.employee.expenses.services.imp;

import com.business.employee.expenses.models.business.Department;
import com.business.employee.expenses.models.humanResources.Expense;
import com.business.employee.expenses.persistence.DepartmentRepository;
import com.business.employee.expenses.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public double getDepartmentExpenses(Department department) {
        if (department == null || department.getEmployees() == null) {
            return 0;
        }

        return department.getEmployees().stream()
                .filter(employee -> employee.getExpenses() != null)
                .flatMap(employee -> employee.getExpenses().stream())
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}
