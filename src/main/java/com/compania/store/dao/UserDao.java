package main.java.com.compania.store.dao;

import main.java.com.compania.store.model.User;

import java.util.List;

/**
 * Created by Владислав on 31.01.2018.
 */
public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    List<User> getAllUsers();

}
