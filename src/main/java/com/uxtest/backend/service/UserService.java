package com.uxtest.backend.service;

import com.uxtest.backend.model.user.User;
import com.uxtest.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public Long getIdByEmailRole(String email, User.Role role){
        return userRepository.findByEmailAndRole(email,role).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")).getId();
    }

    public Long createUser(User user) {
        return userRepository.save(user).getId();
    }

    public void updateUser(User user, Long id) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
