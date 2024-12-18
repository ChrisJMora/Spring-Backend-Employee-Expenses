package com.business.employee.expenses.models.business;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "departments", schema = "business")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name")
    private String name;
    @Column(name = "department_phone")
    private String phone;
    @Column(name = "department_email")
    private String email;
    @Column(name = "department_created_at")
    private LocalDateTime createdAt;
}
