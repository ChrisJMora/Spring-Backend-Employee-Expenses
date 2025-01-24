package com.business.employee.expenses.models.humanResources;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.nio.charset.StandardCharsets;

@Getter
@AllArgsConstructor
public enum ExpenseType {
    MEALS("Alimentacion"),
    ACCOMMODATION("Alojamiento"),
    SUPPLIES("Suministros");

    private final String description;

    public static ExpenseType fromDescription(String description) {
        String fixedDescription = new String(description.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        for(ExpenseType type : ExpenseType.values()) {
            if (type.getDescription().equals(fixedDescription)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant for description: " + description);
    }

}
