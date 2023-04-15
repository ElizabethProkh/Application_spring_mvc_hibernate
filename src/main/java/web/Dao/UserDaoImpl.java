package web.Dao;

import org.springframework.stereotype.Repository;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        User userToBeUpdate = getUser(id);

        userToBeUpdate.setName(updatedUser.getName());
        userToBeUpdate.setSurname(updatedUser.getSurname());
        userToBeUpdate.setDepartment(updatedUser.getDepartment());
    }

    @Override
    public void deleteUser(int id) {
        User userToDelete = getUser(id);
        entityManager.remove(userToDelete);
    }

}
