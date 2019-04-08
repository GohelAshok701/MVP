package com.mvp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mvp.R;
import com.mvp.databinding.ActivityLoginBinding;
import com.mvp.model.LoginInteractor;
import com.mvp.presenter.LoginPresenter;
import com.mvp.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private ActivityLoginBinding binding;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginPresenter = new LoginPresenter(this, new LoginInteractor());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.validCredencial(binding.edtUsername.getText().toString(), binding.edtPassword.getText().toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter = null;
    }

    @Override
    public void showProgress() {
        binding.progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.progress.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        hideProgress();
        Toast.makeText(this, R.string.please_enter_username, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        hideProgress();
        Toast.makeText(this, R.string.please_enter_password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        hideProgress();
        Toast.makeText(this, R.string.login_successfully, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, UsersActivity.class);
        startActivity(intent);
    }
}
