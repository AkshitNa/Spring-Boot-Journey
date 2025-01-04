package nautiDevelopers.RestfulCRUD.Repository;

import nautiDevelopers.RestfulCRUD.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //New Custom Methods

    List<Student> findByFirstName(String firstName); //firstName matches the Entity Column

    Student findByFirstNameAndLastName(String firstName, String LastName);//Order matters

    List<Student> findByFirstNameOrLastName(String firstName, String LastName);//Order matters

    List<Student> findByFirstNameIn(@Param("names") List<String> names);

    //Pagination Method Will Not Be Defined here as it comes from "Pageable Interface"
}


