package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        // ok username valid chars a-z
        // ok username min 3 chars
        // ok username not yet in use
        // ok password min 8 chars
        // ok password must not be only letters
        if (!(username.length() >= 3)) {
            return true;
        }
        if (!checkAlphabet(username)) {
            return true;
        }
        if (checkAlphabet(password)) {
            return true;
        }
        if (!(password.length() >= 8)) {
            return true;
        }
        return false;
    }
    
    private boolean checkAlphabet(String text) { //checks string chars if it contains letters only
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }
}
