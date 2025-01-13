package com.business.employee.expenses.models.humanResources;
import com.business.employee.expenses.utils.converters.ExpenseTypeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "expenses", schema = "human_resources")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Long id;

    @Column(name = "expense_amount")
    private double amount;
    @Convert(converter = ExpenseTypeConverter.class)
    @Column(name = "expense_type")
    private ExpenseType type;
    @Column(name = "expense_date")
    private LocalDate date;
    @Column(name = "expense_created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
