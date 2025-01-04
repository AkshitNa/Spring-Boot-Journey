package nautiDevelopers.RestfulCRUD.Repository;

import nautiDevelopers.RestfulCRUD.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom queries if needed

    List<Student> findByNameContaining(String name);
}

