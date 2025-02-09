package com.business.employee.expenses.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
public class TimeSpan {
    private LocalDate startDate;
    private LocalDate endDate;
}
