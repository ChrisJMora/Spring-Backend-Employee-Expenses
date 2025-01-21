package com.business.employee.expenses.utils.mappers.imp;

import com.business.employee.expenses.dto.DepartmentDTO;
import com.business.employee.expenses.models.business.Department;
import com.business.employee.expenses.utils.mappers.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentMapperImp implements DepartmentMapper {

    @Override
    public DepartmentDTO toDTO(Department department) {
        if (department == null) return null;

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(department.getName());
        departmentDTO.setPhone(department.getPhone());
        departmentDTO.setEmail(department.getEmail());

        return departmentDTO;
    }

    @Override
    public List<DepartmentDTO> toDTOList(List<Department> departments) {
        if (departments == null || departments.isEmpty()) return null;

        List<DepartmentDTO> dtos = new ArrayList<>( departments.size() );
        for(Department department : departments) {
            dtos.add(toDTO(department));
        }

        return dtos;
    }
}
