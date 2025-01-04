package com.nautiDevelopers.Mapper;

import com.nautiDevelopers.DTO.DepartmentDTO;
import com.nautiDevelopers.Entity.Department;

public class DepartmentMapper {


    //Mapping Department Entity to Department-DTO
    public static DepartmentDTO mapToDepartmentDto(Department department){
        return new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    //Mapping Department-DTO to Department Entity
    public static Department mapToDepartment(DepartmentDTO departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
