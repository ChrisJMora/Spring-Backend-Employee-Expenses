package com.business.employee.expenses.models.humanResources;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExpenseType {
    MEALS("Alimentación"),
    ACCOMMODATION("Alojamiento"),
    SUPPLIES("Suministros");

    private final String description;

    public static ExpenseType fromDescription(String description) {
        for(ExpenseType type : ExpenseType.values()) {
            if (type.getDescription().equals(description)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant for description: " + description);
    }
}
