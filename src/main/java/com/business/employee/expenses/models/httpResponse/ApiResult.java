package com.business.employee.expenses.models.httpResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResult {
    private ResponseStatus status;
}

