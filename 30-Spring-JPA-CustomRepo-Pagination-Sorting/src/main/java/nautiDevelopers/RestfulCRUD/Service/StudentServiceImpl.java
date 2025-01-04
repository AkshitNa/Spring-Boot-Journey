package nautiDevelopers.RestfulCRUD.Service;

import lombok.AllArgsConstructor;
import nautiDevelopers.RestfulCRUD.Entity.Student;
import nautiDevelopers.RestfulCRUD.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository; // It has all CRUD Functions provided by Repository

    //Basic CRUD Methods

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    /*
    @Override
    public Student findById(int id) {

        Optional<Student> result = studentRepository.findById(id);

        if(result.isPresent()){
            return result.get();
        }else {
            throw new RuntimeException("Error" + id);
        }
    }
     */

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found" + id));
    }

    // @Transactional JPARepository provides it automatically.
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // @Transactional JPARepository provides it automatically.
    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    //Custom Methods

    @Override
    public List<Student> findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Student findByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public List<Student> findByFirstNameOrLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public List<Student> findByFirstNameIn(List<String> names) {
        return studentRepository.findByFirstNameIn(names);
    }

    //Pagination
    @Override
    public List<Student> getAllStudentsWithPagination(int pageNo, int PageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, PageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    //Sorting 1
    @Override
    public List<Student> getAllStudentsWithSorting() {
       Sort sort = Sort.by(Sort.Direction.ASC, "age"); //age is as same as Entity Class Column
       return studentRepository.findAll(sort);
    }

    //Sorting 2
    @Override
    public List<Student> getStudentsSortedByFirstName() {
        return studentRepository.findAll(Sort.by("firstName")); // Ascending order by default
    }

    //Sorting 3
    public List<Student> getStudentsSortedByFirstNameAndLastName() {
        return studentRepository.findAll(Sort.by("lastName").ascending().and(Sort.by("firstName").descending()));
    }

    //Sorting with Pagination
    @Override
    public List<Student> getStudentsWithSortingAndPagination(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        return studentRepository.findAll(pageable).getContent();
    }
}
