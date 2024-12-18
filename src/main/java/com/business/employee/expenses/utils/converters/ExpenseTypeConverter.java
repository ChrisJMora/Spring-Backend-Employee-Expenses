package com.business.employee.expenses.utils.converters;

import com.business.employee.expenses.models.humanResources.ExpenseType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ExpenseTypeConverter implements AttributeConverter<ExpenseType,
        String> {

    @Override
    public String convertToDatabaseColumn(ExpenseType type) {
        return type.getDescription();
    }

    @Override
    public ExpenseType convertToEntityAttribute(String dbData) {
        return ExpenseType.fromDescription(dbData);
    }
}
