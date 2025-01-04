package com.nautiDevelopers.Service;

import com.nautiDevelopers.DTO.EmployeeDTO;
import com.nautiDevelopers.Entity.Employee;
import com.nautiDevelopers.Exception.NotFoundException;
import com.nautiDevelopers.Mapper.EmployeeMapper;
import com.nautiDevelopers.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

/* No need of the below code as @AllArgsConstructor.

 Public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
 */

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        //Mapping employeeDTO with Employee
        Employee employee = EmployeeMapper.maptoEmployee(employeeDTO);
        //Saving an employee object
        Employee savedEmployee = employeeRepository.save(employee);
        //Mapping Employee with employeeDTO and returning it.
        EmployeeMapper.maptoEmployeeDTO(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees =  employeeRepository.findAll();
        return   employees.stream().map(EmployeeMapper::maptoEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmpById(long id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
        return EmployeeMapper.maptoEmployeeDTO(emp);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {

        //Finding ID and if not found throwing exception.
       Employee emp =  employeeRepository.findById(id).orElseThrow(
               () -> new NotFoundException("Employee not found with id: " + id));

       //Setting the data we will get from RequestBody of EmployeeDTO to an employee class object
       emp.setFirstName(employeeDTO.getFirstName());
       emp.setLastName(employeeDTO.getLastName());
       emp.setEmail(employeeDTO.getEmail());

       //Saving our employee Object.
       Employee employee = employeeRepository.save(emp);

       //Returning our DTO.
       return EmployeeMapper.maptoEmployeeDTO(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        //Finding ID and if not found throwing exception.
        Employee emp =  employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Employee not found with id: " + id));

        employeeRepository.delete(emp);
    }
}
