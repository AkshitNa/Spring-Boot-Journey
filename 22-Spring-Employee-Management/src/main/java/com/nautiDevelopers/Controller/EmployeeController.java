package com.nautiDevelopers.Controller;

import com.nautiDevelopers.DTO.EmployeeDTO;
import com.nautiDevelopers.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api") //Base URl
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //http://localhost:8080/api/addEmployee
    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/employees
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        List<EmployeeDTO> emp = employeeService.getAllEmployee();
        return ResponseEntity.ok((emp));
    }

    //http://localhost:8080/api/employees/1
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmpByID(@PathVariable long id){
        EmployeeDTO empDTO = employeeService.getEmpById(id);
        return ResponseEntity.ok(empDTO);
        //ResponseEntity can generate a list.
    }

    //http://localhost:8080/api/updateEmployee/1
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO empDTO = employeeService.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok(empDTO);
    }

    //http://localhost:8080/api/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Successfully Deleted!!");
    }
}


