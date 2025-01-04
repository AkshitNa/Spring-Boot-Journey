package nautiDevelopers.RestfulCRUD.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hello APIs", description = "Say Hello!!")
@RequestMapping("/api/hello")
public class HelloController {

    //http://localhost:8080/api/hello/Akshit [GET]
    @Operation(summary = "Write a person name to greet him/her")
    @GetMapping("/{name}")
    public ResponseEntity<String> hello(@PathVariable("name") String myName){
        return ResponseEntity.status(HttpStatus.OK).body("Hello " + myName);
    }
}
