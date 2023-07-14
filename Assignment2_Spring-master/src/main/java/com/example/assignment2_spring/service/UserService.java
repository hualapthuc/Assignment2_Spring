package com.example.assignment2_spring.service;

public interface UserService {

    boolean authenticateUser(String username, String password);

    boolean isUsernameAvailable(String username);

    void registerUser(String username, String password);
}
