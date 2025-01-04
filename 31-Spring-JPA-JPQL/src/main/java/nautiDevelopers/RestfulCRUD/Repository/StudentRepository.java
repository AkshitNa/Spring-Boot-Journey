package nautiDevelopers.RestfulCRUD.Repository;

import nautiDevelopers.RestfulCRUD.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //New Custom Methods

    List<Student> findByFirstName(String firstName); //firstName matches the Entity Column

    Student findByFirstNameAndLastName(String firstName, String LastName);//Order matters

    List<Student> findByFirstNameOrLastName(String firstName, String LastName);//Order matters

    List<Student> findByFirstNameIn(@Param("names") List<String> names);

    //Pagination Method Will Not Be Defined here as it comes from "Pageable Interface"

    //JPQL
    @Query("From Student where firstName = :firstName and age = :givenAge") //You can remove "Select"
    Student getStudentByFirstNameAndAge(String firstName, @Param("givenAge") int age);

    //JPQL
    @Query("FROM Student WHERE age > :givenAge")
    List<Student> findStudentsOlderThan(@Param("givenAge") int age);

    //JPQL Update Query
    @Modifying
    @Transactional //Transaction.annotation
    @Query("UPDATE Student SET firstName = :firstName WHERE id = :id")
    Integer updateFirstName(int id, String firstName);

    //JPQL Delete Query
    @Modifying
    @Transactional //Transaction.annotation
    @Query("DELETE from Student WHERE firstName = :firstName")
    Integer deleteByFirstName(String firstName);
}


