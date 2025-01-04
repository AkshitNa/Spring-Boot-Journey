package nautiDevelopers.RestfulCRUD.Service;

import lombok.NoArgsConstructor;
import nautiDevelopers.RestfulCRUD.Model.Profile;
import nautiDevelopers.RestfulCRUD.Model.User;
import nautiDevelopers.RestfulCRUD.Repository.ProfileRepository;
import nautiDevelopers.RestfulCRUD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createOrUpdateUser(User user) {
        // Save profile first, as it's cascade-related
        Profile profile = user.getProfile();
        if (profile != null) {
            profileRepository.save(profile);
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

