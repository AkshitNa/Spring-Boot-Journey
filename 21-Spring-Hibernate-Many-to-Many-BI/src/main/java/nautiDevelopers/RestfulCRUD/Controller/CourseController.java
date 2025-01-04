package nautiDevelopers.RestfulCRUD.Controller;

import lombok.AllArgsConstructor;
import nautiDevelopers.RestfulCRUD.Model.Course;
import nautiDevelopers.RestfulCRUD.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //http://localhost:8080/api/courses
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    //http://localhost:8080/api/courses/getAll
    @GetMapping("/getAll")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    //http://localhost:8080/api/courses/101
    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    //http://localhost:8080/api/courses/500
    @GetMapping("/fees")
    public List<Course> getCoursesLessThanFees(@PathVariable("fees") double fees){
        return courseService.findCoursesLessThanFeesPrice(fees);
    }

    //http://localhost:8080/api/courses/101
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        return courseService.saveCourse(course);
    }

    //http://localhost:8080/api/courses/101
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}

