package com.mvp.presenter;

import com.mvp.model.LoginInteractor;
import com.mvp.view.LoginView;

/**
 * Created by Ashok on 4/7/2019.
 */

public class LoginPresenter extends LoginInteractor {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void validCredencial(String username,String password)
    {
        loginView.showProgress();
        loginInteractor.login(username,password,loginView);
    }

}

