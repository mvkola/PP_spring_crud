package web.dao;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager
                .createNativeQuery("SELECT t.* FROM crud_db.users t", User.class)
                .getResultList();
    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveNewUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUserInfo(long id, User updatedUser) {
        User user = findById(id);
        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(findById(id));
    }

}
