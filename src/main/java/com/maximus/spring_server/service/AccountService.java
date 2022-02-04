package com.maximus.spring_server.service;

import com.maximus.spring_server.domain.User;
import com.maximus.spring_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    private final UserRepository userRepository;

    @Autowired
    public AccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User signup(User user) throws IllegalArgumentException {
        List<User> userList = userRepository.findAll();
        try {
            user.ExitUser(userList);
            return userRepository.save(user);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
