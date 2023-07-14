package com.example.assignment2_spring.service.impl;

import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.repository.UserRepository;
import com.example.assignment2_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        MemberEntity user = userRepository.findByUserName(username);
        if (user != null) {
            String encodedPassword = user.getPassword();
            return passwordEncoder.matches(password, encodedPassword);
        }
        return false;
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        MemberEntity user = userRepository.findByUserName(username);
        return user == null;
    }

    @Override
    public void registerUser(String username, String password) {
        MemberEntity user = new MemberEntity();
        user.setUserName(username);
        user.setPassword(passwordEncoder.encode(password));
        // Set other user properties as needed
        userRepository.save(user);
    }
}
