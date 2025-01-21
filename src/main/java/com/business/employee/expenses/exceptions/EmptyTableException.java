package com.business.employee.expenses.exceptions;

import jakarta.persistence.Table;

public class EmptyTableException extends RuntimeException {
    public EmptyTableException(Class<?> entityClass) {
        super("No " + entityClass.getAnnotation(Table.class).name() + " found in the database");
    }
}
