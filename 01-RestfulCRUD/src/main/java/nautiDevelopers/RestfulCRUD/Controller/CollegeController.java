package nautiDevelopers.RestfulCRUD.Controller;

import nautiDevelopers.RestfulCRUD.Entity.College;
import nautiDevelopers.RestfulCRUD.Service.CollegeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") //Base URL
public class CollegeController {

    private final CollegeServiceImpl collegeService;

    //Now I have all CollegeService Methods
    @Autowired
    public CollegeController(CollegeServiceImpl collegeService){
        this.collegeService = collegeService;
    }

    // http://localhost:8080/api/college [Get]
    @GetMapping("/college")
    public List<College> findAll(){
        return collegeService.findAll();
    }

    // http://localhost:8080/api/college/2 [Get]
    @GetMapping("/college/{id}")
    public College getCollegeData(@PathVariable int id){

        College college = collegeService.findById(id);

        if(college==null){
            throw new RuntimeException("Id not found" + id);
        }else {
            return college;
        }
    }

    // http://localhost:8080/api/college/name/Graphic Era [Get]
    //Get College Data By Using collegeName as PathVariable
    @GetMapping("/college/name/{collegeName}")
    public List <College> findByFirst(@PathVariable String collegeName) {

        List<College> empData = collegeService.findByCollegeName(collegeName);

        if(empData==null){throw new RuntimeException("Data Not found of the College" + collegeName);
        } else {
            return empData;
        }
    }

    // http://localhost:8080/api/college [Post]
    @PostMapping("/college")
    public College addCollege(@RequestBody College college){
        return collegeService.save(college);
        //NOTE: USE Postman and change the method to POST.
    }

    // http://localhost:8080/api/college [Put i.e. Update]
    @PutMapping("/college")
    public College updateCollege(@RequestBody College college) {
        return collegeService.save(college);
        //NOTE: USE Postman and change the method to PUT.
    }

    // http://localhost:8080/api/college/3 [Delete]
    @DeleteMapping("/college/{id}")
    public String deleteCollegeData(@PathVariable int id){
        College college = collegeService.findById(id);

        if(college==null){
            throw new RuntimeException("Id not found" + id);
        } else {
            collegeService.deleteById(id);
        }
        return "The id" + id + " is successfully DELETED.";
    }
    //NOTE: USE Postman and change the method to DELETE.
}

