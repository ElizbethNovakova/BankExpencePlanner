package com.novakova.project.service.impl;

import com.novakova.project.model.User;
import com.novakova.project.model.security.UserRole;
import com.novakova.project.repository.RoleRepository;
import com.novakova.project.repository.UserRepository;
import com.novakova.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;
import java.util.logging.Logger;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean checkUserExists(String username, String email) {
        return checkUsernameExists(username) || checkEmailExists(email);
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return findByUsername(username) != null;
    }

    @Override
    public boolean checkEmailExists(String email) {
        return findByEmail(email) != null;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    public User createUser(User user, Set<UserRole> userRoles){
        User localUser = userRepository.findByUsername(user.getUsername());
        if(localUser != null){
            LOG.info(String.format("User with {} username already exists", user.getUsername()));
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for(UserRole userRole : userRoles){
                roleRepository.save(userRole.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            //TODO add savings and primary account
            localUser = userRepository.save(user);
        }
        return localUser;
    }
}
