package nautiDevelopers.RestfulCRUD.Service;

import nautiDevelopers.RestfulCRUD.Entity.College;
import nautiDevelopers.RestfulCRUD.Repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeServiceImpl implements CollegeService{

    CollegeRepo collegeRepo; // It has all CRUD Functions provided by Repository

    @Autowired
    public CollegeServiceImpl(CollegeRepo collegeRepo){
        this.collegeRepo = collegeRepo;
    }

    @Override
    public List<College> findAll() {
        return collegeRepo.findAll();
    }

    @Override
    public College findById(int id) {

        Optional<College> result = collegeRepo.findById(id); //Optional is a class.
        College college = null; //setting reference null

        if(result.isPresent()){
            college = result.get();
        } else {
            throw new RuntimeException("Could not find the id " + id);
        }
        return college;
    }

    // @Transactional JPARepository provides it automatically.
    @Override
    public College save(College college) {
        return collegeRepo.save(college);
    }

    // @Transactional JPARepository provides it automatically.
    @Override
    public void deleteById(int id) {
        collegeRepo.deleteById(id);
    }

    @Override
    public List<College> findByCollegeName(String firstName) {
        return collegeRepo.findByCollegeName(firstName);
    }
}


