package nautiDevelopers.RestfulCRUD.Service;
import nautiDevelopers.RestfulCRUD.Entity.Student;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    Student save(Student college);
    void deleteById(int id);

    //Custom Methods
    List<Student> findByFirstName(String firstName); //firstName matches the Entity Column
    Student findByFirstNameAndLastName(String firstName, String LastName);
    List<Student> findByFirstNameOrLastName(String firstName, String LastName);
    List<Student> findByFirstNameIn(@Param("names") List<String> names);

    //Pagination
    List<Student> getAllStudentsWithPagination(int pageNo, int PageSize);

    //Sorting 1
    List<Student> getAllStudentsWithSorting();
    //Sorting 2
    List<Student> getStudentsSortedByFirstName();
    //Sorting 3
    List<Student> getStudentsSortedByFirstNameAndLastName();

    //Sorting with Pagination
    List<Student> getStudentsWithSortingAndPagination(int pageNo, int pageSize, String sortBy);

    //JPQL
    Student getStudentByFirstNameAndAge(String firstName, @Param("givenAge") int age);

    //JPQL
    List<Student> findStudentsOlderThan(@Param("givenAge") int age);

    //JPQL Update
    Integer updateFirstName(int id, String firstName);

    //JPQL Delete
    Integer deleteByFirstName(String firstName);
}



