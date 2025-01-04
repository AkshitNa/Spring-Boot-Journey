package nautiDevelopers.RestfulCRUD.Service;

import nautiDevelopers.RestfulCRUD.Exception.UserNotFoundException;
import nautiDevelopers.RestfulCRUD.Model.User;
import nautiDevelopers.RestfulCRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        // Directly save the user into the database
        userRepository.save(user);
    }

    @Override
    public boolean loginUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser == null) {
            throw new UserNotFoundException("Username not found");
        }
        // Compare plaintext passwords
        if (!user.getPassword().equals(existingUser.getPassword())) {
            throw new UserNotFoundException("Invalid password");
        }
        return true;
    }
}