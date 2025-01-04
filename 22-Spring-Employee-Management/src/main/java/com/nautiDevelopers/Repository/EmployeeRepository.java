package com.nautiDevelopers.Repository;

import com.nautiDevelopers.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //it provides CRUD Operation + @Transactional annotation.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
