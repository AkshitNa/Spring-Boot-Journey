package nautiDevelopers.RestfulCRUD.Controller;

import lombok.AllArgsConstructor;
import nautiDevelopers.RestfulCRUD.Entity.Student;
import nautiDevelopers.RestfulCRUD.Exception.StudentNotFoundException;
import nautiDevelopers.RestfulCRUD.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/student") // Base URL
public class StudentController {

    @Autowired
    private final StudentServiceImpl studentService;

    // http://localhost:8080/api/student/create [POST]
    @PostMapping("/create")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    // http://localhost:8080/api/student/receive [GET]
    @GetMapping("/receive")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> studentsList = studentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(studentsList);
    }

    // http://localhost:8080/api/student/{id} [GET]
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentData(@PathVariable int id) {

        Student student = studentService.findById(id);

        if (student == null) {
            throw new StudentNotFoundException("Student not found with - " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    // http://localhost:8080/api/student/update [PUT]
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.save(student);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }

    // http://localhost:8080/api/student/delete/{id} [DELETE]
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentData(@PathVariable int id) {
        Student student = studentService.findById(id);

        if (student == null) {
            throw new StudentNotFoundException("Id not found: " + id);
        }
        studentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("The id " + id + " is successfully DELETED");
    }

    //Custom Methods

    //http://localhost:8080/api/student/getByFirstName/Rohit [GET]
    @GetMapping("/getByFirstName/{firstName}")
    public ResponseEntity<List<Student>> getByFirstName(@PathVariable("firstName") String firstName) {
        List<Student> studentsList = studentService.findByFirstName(firstName);
        return ResponseEntity.status(HttpStatus.OK).body(studentsList);
    }

    //http://localhost:8080/api/student/getByFirstNameAndLastName/Akshit/Nautiyal [GET]
    @GetMapping("/getByFirstNameAndLastName/{firstName}/{LastName}")
    public ResponseEntity<Student> getByFirstNameAndLastName(@PathVariable("firstName") String firstName,
    @PathVariable("LastName") String lastName) {
        Student students = studentService.findByFirstNameAndLastName(firstName, lastName);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    //http://localhost:8080/api/student/getByFirstNameOrLastName/Rohit/Negi [GET]
    @GetMapping("/getByFirstNameOrLastName/{firstName}/{LastName}")
    public ResponseEntity<List<Student>> getByFirstNameOrLastName(@PathVariable("firstName") String firstName,
                                                             @PathVariable("LastName") String lastName) {
        List<Student> studentsList = studentService.findByFirstNameOrLastName(firstName, lastName);
        return ResponseEntity.status(HttpStatus.OK).body(studentsList);
    }

    //http://localhost:8080/api/student/getByFirstNameIn?names=Akshit,Saurab,Plakchha
    //SELECT * from Student where firstName IN ("Akshit", "Saurab", "Plackhha")
    @GetMapping("/getByFirstNameIn")
    public ResponseEntity<List<Student>> getStudentsByFirstNames(@RequestParam List<String> names) {
        List<Student> studentsList = studentService.findByFirstNameIn(names);
        return ResponseEntity.status(HttpStatus.OK).body(studentsList);
    }

    //Pagination
    //http://localhost:8080/api/student/getAllPagination?pageNo=1&pageSize=10
    @GetMapping("/getAllPagination")
    public ResponseEntity<List<Student>> getAllStudentsWithPagination(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        List<Student> studentsPageList = studentService.getAllStudentsWithPagination(pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(studentsPageList);
    }

    //Sorting 1
    //http://localhost:8080/api/student/getAllSorting
    @GetMapping("/getAllSorting")
    public ResponseEntity<List<Student>> getAllStudentsWithSorting() {
        List<Student> studentsSortList = studentService.getAllStudentsWithSorting();
        return ResponseEntity.status(HttpStatus.OK).body(studentsSortList);
    }

    //Sorting 2
    //http://localhost:8080/api/student/getAllSortingFirstName
    @GetMapping("/getAllSortingFirstName")
    public ResponseEntity<List<Student>> getAllStudentsWithFirstNameSorting() {
        List<Student> studentsSortListByFirstName = studentService.getStudentsSortedByFirstName();
        return ResponseEntity.status(HttpStatus.OK).body(studentsSortListByFirstName);
    }

    //Sorting 2
    //http://localhost:8080/api/student/getAllSortingFirstNameAndLastName
    @GetMapping("/getAllSortingFirstNameAndLastName")
    public ResponseEntity<List<Student>> getAllStudentsWithFirstNameAndLastNameSorting() {
        List<Student> studentsSortListByFirstNameAndLastName = studentService.getStudentsSortedByFirstNameAndLastName();
        return ResponseEntity.status(HttpStatus.OK).body(studentsSortListByFirstNameAndLastName);
    }

    //http://localhost:8080/api/student/getAllPaginationSorted?pageNo=2&pageSize=10&sortBy=age
    @GetMapping("/getAllPaginationSorted")
    public ResponseEntity<List<Student>> getAllStudentsWithPagination(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "firstName") String sortBy) {
        List<Student> studentsPageListSorted = studentService.getStudentsWithSortingAndPagination(pageNo,pageSize,sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(studentsPageListSorted);
    }

    //JPQL
    //http://localhost:8080/api/student/getStudentByFirstNameAndAge/Akshit/21 [GET]
    @GetMapping("/getStudentByFirstNameAndAge/{firstName}/{age}")
    public ResponseEntity<Student> getStudentByFirstNameAndAge(@PathVariable("firstName") String firstName,
                                                             @PathVariable("age") int age) {
        Student students = studentService.getStudentByFirstNameAndAge(firstName,age);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    //JPQL
    //http://localhost:8080/api/student/findStudentsOlderThan/30
    @GetMapping("/findStudentsOlderThan/{age}")
    public ResponseEntity<List<Student>> findStudentsOlderThan(
            @PathVariable("age") int age) {
        List<Student> studentsOlderThan = studentService.findStudentsOlderThan(age);
        return ResponseEntity.status(HttpStatus.OK).body(studentsOlderThan);
    }

    //JPQL
    //http://localhost:8080/api/student/updateFirstName/16/Mohini
    @PutMapping("/updateFirstName/{id}/{firstName}")
    public ResponseEntity<String> updateFirstName(@PathVariable("id") int id,@PathVariable("firstName") String firstName){
       Integer num =  studentService.updateFirstName(id,firstName);
       return ResponseEntity.status(HttpStatus.OK).body(num + " row(s) Updated!!");
    }
    //Always use Postman for PUT

    //JPQL
    //http://localhost:8080/api/student/deleteByFirstName/Divya
    @DeleteMapping("/deleteByFirstName/{firstName}")
    public ResponseEntity<String> deleteByFirstName(@PathVariable("firstName") String firstName){
        Integer num =  studentService.deleteByFirstName(firstName);
        return ResponseEntity.status(HttpStatus.OK).body(num + " row(s) deleted!!");
    }
    //Always use Postman for DELETE
}
