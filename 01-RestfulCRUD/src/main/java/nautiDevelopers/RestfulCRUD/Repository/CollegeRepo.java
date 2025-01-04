package nautiDevelopers.RestfulCRUD.Repository;

import nautiDevelopers.RestfulCRUD.Entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeRepo extends JpaRepository<College, Integer> {
    //this is all
    List<College> findByCollegeName(String collegeName);
    //New Method which is not in Repository
}


