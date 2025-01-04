package nautiDevelopers.RestfulCRUD.Controller;

import nautiDevelopers.RestfulCRUD.DTO.CollegeInfoDTO;
import nautiDevelopers.RestfulCRUD.Service.CollegeInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/college") // Base URL
public class CollegeController {

    @Autowired
    private final CollegeInfoServiceImpl collegeInfoService;

    // Constructor-Based Injection
    public CollegeController(CollegeInfoServiceImpl collegeInfoService) {
        this.collegeInfoService = collegeInfoService;
    }

    // http://localhost:8080/api/college/receive [GET]
    @GetMapping("/receive")
    public ResponseEntity<List<CollegeInfoDTO>> getAllColleges() {
        List<CollegeInfoDTO> collegeDTOs = collegeInfoService.findAllColleges();
        return ResponseEntity.ok(collegeDTOs);
    }
}
