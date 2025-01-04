package nautiDevelopers.RestfulCRUD.Controller;

import lombok.AllArgsConstructor;
import nautiDevelopers.RestfulCRUD.Model.Student;
import nautiDevelopers.RestfulCRUD.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //http://localhost:8080/api/students
    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return  studentService.saveStudent(student);
    }

    //http://localhost:8080/api/students/getAll
    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    //http://localhost:8080/api/students/1
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    //http://localhost:8080/api/students/Akshit
    @GetMapping("/student-name")
    public List<Student> findStudentsContainingByName(@PathVariable("student-name") String name){
        return studentService.findStudentsContainingByName(name);
    }

    //http://localhost:8080/api/students/1
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.saveStudent(student);
    }

    //http://localhost:8080/api/students/1
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }


}

