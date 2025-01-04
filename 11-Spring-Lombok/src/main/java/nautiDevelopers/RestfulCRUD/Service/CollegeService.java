package nautiDevelopers.RestfulCRUD.Service;
import nautiDevelopers.RestfulCRUD.Model.College;
import java.util.List;

public interface CollegeService {
    List<College> findAll();
    College findById(int id);
    College save(College college);
    void deleteById(int id);
    List <College> findByCollegeName(String collegeName);//New
}



