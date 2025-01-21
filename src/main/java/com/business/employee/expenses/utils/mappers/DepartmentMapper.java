package com.business.employee.expenses.utils.mappers;

import com.business.employee.expenses.dto.DepartmentDTO;
import com.business.employee.expenses.models.business.Department;

import java.util.List;

public interface DepartmentMapper {
    DepartmentDTO toDTO(Department department);
    List<DepartmentDTO> toDTOList(List<Department> departments);
}
