package com.mvp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.mvp.R;
import com.mvp.databinding.ActivityUsersBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class UsersActivity extends AppCompatActivity {

    private ActivityUsersBinding activityUsersBinding;
    private ArrayList<String> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        activityUsersBinding= DataBindingUtil.setContentView(this,R.layout.activity_users);
        activityUsersBinding.rvUsers.setLayoutManager(new LinearLayoutManager(this));

        usersList=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.users)));
        
    }
}
