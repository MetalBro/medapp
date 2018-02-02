package ru.hostapp.service;

import ru.hostapp.model.User;

public interface UserService {

    /** find user by email **/
    public User findUser(String email);

    /** update user **/
    public User updateUser(User user);
}
