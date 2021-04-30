package com.novakova.project.service;

import com.novakova.project.model.User;
import com.novakova.project.model.security.UserRole;

import java.util.Set;

public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
    boolean checkUserExists(String username, String email);
    boolean checkUsernameExists(String username);
    boolean checkEmailExists(String email);
    User saveUser (User user);
    void save(User user);
    User createUser(User user, Set<UserRole> userRoles);
}
