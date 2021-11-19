package ru.infinic.springbootadmin.service;

import ru.infinic.springbootadmin.model.User;

import java.util.List;

/**
 * @author Oleg Kadochnikov
 */

public interface UserService {
    void createUser(User user);
    void updateUser(User user);
    void updateUserById(Long id, User user);
    void deleteUser(User user);
    void deleteUserById(Long id);
    User getUserById(Long id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
