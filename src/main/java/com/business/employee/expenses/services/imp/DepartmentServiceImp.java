package com.business.employee.expenses.services.imp;

import com.business.employee.expenses.dto.DepartmentExpenses;
import com.business.employee.expenses.exceptions.EmptyRecordException;
import com.business.employee.expenses.exceptions.EmptyTableException;
import com.business.employee.expenses.models.business.Department;
import com.business.employee.expenses.models.humanResources.Expense;
import com.business.employee.expenses.persistence.DepartmentRepository;
import com.business.employee.expenses.services.DepartmentService;
import com.business.employee.expenses.utils.mappers.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private DepartmentMapper mapper;

    public List<Department> getAllDepartments() {
        List<Department> departments = repository.findAll();
        if (departments.isEmpty()) throw new EmptyTableException(Department.class);
        return departments;
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> department = repository.findById((id));
        if (department.isEmpty()) throw new EmptyRecordException(Department.class);
        return department.get();
    }

    public double getDepartmentExpensesByTimeSpan(Long id, LocalDate startDate, LocalDate endDate) {
        Department department = getDepartmentById(id);

        if (department.getEmployees() == null) {
            return 0;
        }

        return department.getEmployees().stream()
                .filter(employee -> employee.getExpenses() != null)
                .flatMap(employee
                        -> employee.getExpenses().stream())
                .filter(expense
                        -> !expense.getDate().isBefore(startDate) && !expense.getDate().isAfter(endDate))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public List<DepartmentExpenses> getAllDepartmentExpensesByTimeSpan(LocalDate startDate, LocalDate endDate) {
        List<Department> departments = getAllDepartments();
        List<DepartmentExpenses> departmentsExpenses = new ArrayList<>();
        for(Department department : departments) {
            double expenses = getDepartmentExpensesByTimeSpan(department.getId(), startDate, endDate);
            departmentsExpenses.add(new DepartmentExpenses(
                    mapper.toDTO(department),
                    expenses));
        }
        return departmentsExpenses;
    }
}
