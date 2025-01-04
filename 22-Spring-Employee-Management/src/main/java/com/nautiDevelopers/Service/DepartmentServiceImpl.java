package com.nautiDevelopers.Service;

import com.nautiDevelopers.DTO.DepartmentDTO;
import com.nautiDevelopers.Entity.Department;
import com.nautiDevelopers.Exception.NotFoundException;
import com.nautiDevelopers.Mapper.DepartmentMapper;
import com.nautiDevelopers.Repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /* No need of the below code as @AllArgsConstructor.

 Public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }
 */

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDto) {
        //Mapping departmentDTO with Department
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        //Saving an department object
        Department savedDepartment = departmentRepository.save(department);
        //Mapping Department with DepartmentDTO and returning it.
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new NotFoundException("Department is not exists with a given id: " + departmentId)
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(DepartmentMapper::mapToDepartmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO updatedDepartmentDTO) {

        //Finding ID and if not found throwing exception.
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new NotFoundException("Department is not exists with a given id:"+ departmentId)
        );

        //Setting the data we will get from RequestBody of DepartmentDTO to an employee class object
        department.setDepartmentName(updatedDepartmentDTO.getDepartmentName());
        department.setDepartmentDescription(updatedDepartmentDTO.getDepartmentDescription());

        //Saving our department Object.
        Department savedDepartment = departmentRepository.save(department);

        //Returning our DTO.
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        //Finding ID and if not found throwing exception.
        departmentRepository.findById(departmentId)
                .orElseThrow(() -> new NotFoundException("Department is not exists with a given id: " + departmentId)
        );
        departmentRepository.deleteById(departmentId);
    }
}
