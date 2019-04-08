package com.mvp.model;

import com.mvp.view.LoginView;

/**
 * Created by Ashok on 4/7/2019.
 */

public class LoginInteractor {

    public void login(String username, String password, LoginView loginView) {
        if (username.isEmpty()) {
            loginView.setUsernameError();
        } else if (password.isEmpty()) {
            loginView.setPasswordError();
        } else {
            loginView.navigateToHome();
        }
    }
}
