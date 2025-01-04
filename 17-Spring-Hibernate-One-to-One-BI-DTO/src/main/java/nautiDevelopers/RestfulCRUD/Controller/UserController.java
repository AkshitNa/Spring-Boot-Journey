package nautiDevelopers.RestfulCRUD.Controller;

import lombok.NoArgsConstructor;
import nautiDevelopers.RestfulCRUD.DTO.UserDTO;
import nautiDevelopers.RestfulCRUD.Model.User;
import nautiDevelopers.RestfulCRUD.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;  // Inject ModelMapper

    // Get all users
    //http://localhost:8080/api/users/getAll
    @GetMapping("/getAll")
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))  // Convert User to UserDTO
                .collect(Collectors.toList());
    }

    // Get user by ID
    //http://localhost:8080/api/users/1
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(u -> ResponseEntity.ok(modelMapper.map(u, UserDTO.class))) // Convert User to UserDTO
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new user
    //http://localhost:8080/api/users
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        User createdUser = userService.createOrUpdateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(createdUser, UserDTO.class)); // Convert to UserDTO
    }

    // Update user
    //http://localhost:8080/api/users/1
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (!userService.getUserById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        user.setId(id);
        User updatedUser = userService.createOrUpdateUser(user);
        return ResponseEntity.ok(modelMapper.map(updatedUser, UserDTO.class)); // Convert to UserDTO
    }

    // Delete user
    //http://localhost:8080/api/users/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (!userService.getUserById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
