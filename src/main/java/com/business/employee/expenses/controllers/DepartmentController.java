package com.business.employee.expenses.controllers;

import com.business.employee.expenses.exceptions.EmptyRecordException;
import com.business.employee.expenses.exceptions.EmptyTableException;
import com.business.employee.expenses.models.httpResponse.ApiResult;
import com.business.employee.expenses.models.httpResponse.Error;
import com.business.employee.expenses.models.httpResponse.WrappedEntity;
import com.business.employee.expenses.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/expenses")
    ResponseEntity<ApiResult> getDepartmentExpenses()
    {
        try {
            return  ResponseEntity.ok(new WrappedEntity<>(service.getAllDepartmentExpenses()));
        } catch (EmptyTableException | EmptyRecordException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Error(ex.getMessage()));
        } catch (Exception ex) {
            log.error("An error occurred while retrieving department expenses: ", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Error("An unexpected error occurred."));
        }
    }
}
