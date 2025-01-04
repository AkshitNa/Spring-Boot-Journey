package com.nautiDevelopers.Service;

import com.nautiDevelopers.DTO.DepartmentDTO;
import java.util.List;

public interface DepartmentService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDto);

    DepartmentDTO getDepartmentById(Long departmentId);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO updatedDepartment);

    void deleteDepartment(Long departmentId);
}
