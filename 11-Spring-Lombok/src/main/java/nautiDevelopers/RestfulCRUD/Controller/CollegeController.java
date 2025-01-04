package nautiDevelopers.RestfulCRUD.Controller;

import nautiDevelopers.RestfulCRUD.Model.College;
import nautiDevelopers.RestfulCRUD.Exception.CollegeNotFoundException;
import nautiDevelopers.RestfulCRUD.Service.CollegeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/college") // Base URL
public class CollegeController {

    @Autowired
    private final CollegeServiceImpl collegeService;

    // Constructor-Based Injection
    public CollegeController(CollegeServiceImpl collegeService) {
        this.collegeService = collegeService;
    }

    // http://localhost:8080/api/college/receive [GET]
    @GetMapping("/receive")
    public ResponseEntity<List<College>> findAll() {
        List<College> colleges = collegeService.findAll();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

    // http://localhost:8080/api/college/{id} [GET]
    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeData(@PathVariable int id) {

        College college = collegeService.findById(id);

        if (college == null) {
            throw new CollegeNotFoundException("College not found with - " + id);
        }
        return new ResponseEntity<>(college, HttpStatus.OK);
    }

    // http://localhost:8080/api/college/name/{collegeName} [GET]
    @GetMapping("/name/{collegeName}")
    public ResponseEntity<List<College>> findByCollegeName(@PathVariable String collegeName) {
        List<College> collegeData = collegeService.findByCollegeName(collegeName);

        if (collegeData == null || collegeData.isEmpty()) {
            throw new CollegeNotFoundException("College not found - " + collegeName);
        }

        return new ResponseEntity<>(collegeData, HttpStatus.OK);
    }

    // http://localhost:8080/api/college/create [POST]
    @PostMapping("/create")
    public ResponseEntity<College> addCollege(@RequestBody College college) {
        College savedCollege = collegeService.save(college);
        return new ResponseEntity<>(savedCollege, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/college/update [PUT]
    @PutMapping("/update")
    public ResponseEntity<College> updateCollege(@RequestBody College college) {
        College updatedCollege = collegeService.save(college);
        return new ResponseEntity<>(updatedCollege, HttpStatus.OK);
    }

    // http://localhost:8080/api/college/delete/{id} [DELETE]
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCollegeData(@PathVariable int id) {
        College college = collegeService.findById(id);

        if (college == null) {
            throw new CollegeNotFoundException("Id not found: " + id);
        }

        collegeService.deleteById(id);
        return new ResponseEntity<>("The id " + id + " is successfully DELETED.", HttpStatus.OK);
    }
}
