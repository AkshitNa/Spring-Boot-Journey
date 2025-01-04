package com.nautiDevelopers.Mapper;

import com.nautiDevelopers.DTO.EmployeeDTO;
import com.nautiDevelopers.Entity.Employee;

public class EmployeeMapper {

    //Mapping Employee Entity to Employee-DTO
    public static EmployeeDTO maptoEmployeeDTO(Employee employee){
        return new EmployeeDTO(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail());
    }

    //Mapping Employee-DTO to Employee Entity
    public static Employee maptoEmployee(EmployeeDTO employeedto){
        return new Employee(employeedto.getId(),employeedto.getFirstName(),employeedto.getLastName(),employeedto.getEmail());
    }
}
