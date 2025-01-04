package nautiDevelopers.RestfulCRUD.Service;

import lombok.AllArgsConstructor;
import nautiDevelopers.RestfulCRUD.Model.Course;
import nautiDevelopers.RestfulCRUD.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //Save Course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    //Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    //Get all courses by ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    //Get courses less than given fee
    public List<Course> findCoursesLessThanFeesPrice(double fees){
        return courseRepository.findByFeesLessThan(fees);
    }

    //Delete a course by ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

