package todoapp.service;

import todoapp.model.User;

public interface IAuthenticationService {
    User signUp(String username, String password);
    User logIn(String username, String password);
}
