package com.rawatShweta.Controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") //CORS [This Way is Not Recommendable]
@RestController
@RequestMapping("/api") //Base URL
public class ShwetaController {

    //http://localhost:8080/api/hello
    @GetMapping("/hello")
    public String hello(){
        return "Hello Shweta";
    }

    //http://localhost:8080/api/goodbye
    @GetMapping("/goodbye")
    public String goodbye(){
        return "Goodbye Shweta";
    }


}
