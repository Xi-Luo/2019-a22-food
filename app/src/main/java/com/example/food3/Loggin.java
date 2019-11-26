package com.example.food3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;

public class Loggin extends AppCompatActivity {
    private EditText account;
    private EditText password;
    private Button login;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);
        Slide slide = new Slide(Gravity.RIGHT);
        slide.setDuration(500);
        getWindow().setEnterTransition(slide);
        getWindow().setExitTransition(new Fade());
        login =  findViewById(R.id.login);
        logout =  findViewById(R.id.logout);
        account =  findViewById(R.id.account);
        password =  findViewById(R.id.pwd);
    }
}
