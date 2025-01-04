package nautiDevelopers.RestfulCRUD.Service;

import lombok.AllArgsConstructor;
import nautiDevelopers.RestfulCRUD.Model.Course;
import nautiDevelopers.RestfulCRUD.Model.Student;
import nautiDevelopers.RestfulCRUD.Repository.CourseRepository;
import nautiDevelopers.RestfulCRUD.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //Save Student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    //Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //Get all students by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    //Get students by names
    public List<Student> findStudentsContainingByName(String name){
        return studentRepository.findByNameContaining(name);
    }

    //Delete a student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
