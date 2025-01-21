package com.business.employee.expenses.dto;

import com.business.employee.expenses.models.business.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class DepartmentExpenses {
    private DepartmentDTO department;
    private double expenses;
}
