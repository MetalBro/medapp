package ru.hostapp.service;

import ru.hostapp.model.UserCredential;

public interface AuthenticationService {

    /**login with account and password**/
    public boolean login(String account, String password);

    /**logout current user**/
    public void logout();

    /**get current user credential**/
    public UserCredential getUserCredential();

}
