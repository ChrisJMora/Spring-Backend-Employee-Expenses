package com.business.employee.expenses.services.imp;

import com.business.employee.expenses.exceptions.EmptyRecordException;
import com.business.employee.expenses.models.business.Department;
import com.business.employee.expenses.models.humanResources.Expense;
import com.business.employee.expenses.persistence.DepartmentRepository;
import com.business.employee.expenses.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department getDepartmentById(Long id) {
        Optional<Department> department = repository.findById((id));
        if (department.isEmpty()) throw new EmptyRecordException(Department.class);
        return department.get();
    }

    public double getDepartmentExpenses(Long id) {
        Department department = getDepartmentById(id);

        if (department.getEmployees() == null) {
            return 0;
        }

        return department.getEmployees().stream()
                .filter(employee -> employee.getExpenses() != null)
                .flatMap(employee -> employee.getExpenses().stream())
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}
