package com.nautiDevelopers.Repository;

import com.nautiDevelopers.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //it provides CRUD Operation + @Transactional annotation.
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
