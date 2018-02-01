package main.java.com.compania.store.sevice;

import main.java.com.compania.store.model.User;

import java.util.List;

/**
 * Created by Владислав on 01.02.2018.
 */
public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    List<User> getAllUsers();
}
