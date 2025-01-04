package nautiDevelopers.RestfulCRUD.Repository;


import nautiDevelopers.RestfulCRUD.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}