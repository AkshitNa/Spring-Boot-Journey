package nautiDevelopers.RestfulCRUD.Service;
import nautiDevelopers.RestfulCRUD.Model.User;

public interface UserService {
    void registerUser(User user);
    boolean loginUser(User user);
}
