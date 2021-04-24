package com.novakova.project.service.impl;

import com.novakova.project.model.User;
import com.novakova.project.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserSecurityService implements UserDetailsService {
    
    private static final Logger LOG = Logger.getLogger(UserSecurityService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            LOG.warning(String.format("Username {} not found", username));
        }
        return user;
    }
}
