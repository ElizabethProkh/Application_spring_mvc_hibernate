package web.Dao;

import web.Model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void updateUser (int id, User updatedUser);

    void deleteUser(int id);
}
