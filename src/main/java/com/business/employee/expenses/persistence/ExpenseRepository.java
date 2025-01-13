package com.business.employee.expenses.persistence;

import com.business.employee.expenses.models.humanResources.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
