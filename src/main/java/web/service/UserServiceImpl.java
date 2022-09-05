package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.getAllUsers();
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.saveNewUser(user);
    }

    @Override
    @Transactional
    public void update(long id, User updatedUser) {
        userDao.updateUserInfo(id, updatedUser);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.deleteUser(id);
    }

}
