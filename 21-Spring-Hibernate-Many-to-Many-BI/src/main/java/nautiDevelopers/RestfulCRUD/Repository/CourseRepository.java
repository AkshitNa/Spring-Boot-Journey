package nautiDevelopers.RestfulCRUD.Repository;

import nautiDevelopers.RestfulCRUD.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Custom queries if needed

    List<Course> findByFeesLessThan(double fees);
}

