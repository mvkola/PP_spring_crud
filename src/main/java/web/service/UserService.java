package web.service;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {

    @Transactional
    List<User> findAll();

    @Transactional
    User findById(long id);

    @Transactional
    void save(User user);

    @Transactional
    void update(long id, User updatedUser);

    @Transactional
    void delete(long id);

}
