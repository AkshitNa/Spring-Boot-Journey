package nautiDevelopers.RestfulCRUD.Controller;

import lombok.AllArgsConstructor;
import nautiDevelopers.RestfulCRUD.Model.Company;
import nautiDevelopers.RestfulCRUD.Model.Employee;
import nautiDevelopers.RestfulCRUD.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // CRUD for Company

    //http://localhost:8080/api/companies
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company createdCompany = companyService.createCompany(company);
        return ResponseEntity.ok(createdCompany);
    }

    //http://localhost:8080/api/companies/getAll
    @GetMapping("/getAll")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    //http://localhost:8080/api/companies/101
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Optional<Company> company = companyService.getCompanyById(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //http://localhost:8080/api/companies/101
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
        Company updatedCompany = companyService.updateCompany(id, companyDetails);
        return ResponseEntity.ok(updatedCompany);
    }

    //http://localhost:8080/api/companies/101
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    // CRUD for Employee
    //http://localhost:8080/api/companies/101/create-employees
    @PostMapping("/{companyId}/create-employees")
    public ResponseEntity<Employee> createEmployee(@PathVariable Long companyId, @RequestBody Employee employee) {
        Employee createdEmployee = companyService.createEmployee(employee, companyId);
        return ResponseEntity.ok(createdEmployee);
    }

    //http://localhost:8080/api/companies/employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return companyService.getAllEmployees();
    }

    //http://localhost:8080/api/companies/employees/1
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = companyService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //http://localhost:8080/api/companies/employees/1
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        companyService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}

