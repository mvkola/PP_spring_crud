package web.dao;
import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User findById(long id);

    void saveNewUser(User user);

    void updateUserInfo(long id, User updatedUser);

    void deleteUser(long id);
}
