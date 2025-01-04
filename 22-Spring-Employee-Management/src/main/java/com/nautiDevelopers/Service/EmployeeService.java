package com.nautiDevelopers.Service;

import com.nautiDevelopers.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    void createEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO getEmpById(long id);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);
}
