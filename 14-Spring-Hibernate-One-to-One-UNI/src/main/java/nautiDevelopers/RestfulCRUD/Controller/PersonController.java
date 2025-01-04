package nautiDevelopers.RestfulCRUD.Controller;

import lombok.AllArgsConstructor;
import nautiDevelopers.RestfulCRUD.Model.Person;
import nautiDevelopers.RestfulCRUD.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    //http://localhost:8080/api/persons/getAll
    @GetMapping("/getAll")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    //http://localhost:8080/api/persons/1
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personService.getPersonById(id);
        return person.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    //http://localhost:8080/api/persons
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createOrUpdatePerson(person));
    }

    //http://localhost:8080/api/persons/1
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        if (!personService.getPersonById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        person.setId(id);
        return ResponseEntity.ok(personService.createOrUpdatePerson(person));
    }

    //http://localhost:8080/api/persons/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if (!personService.getPersonById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}