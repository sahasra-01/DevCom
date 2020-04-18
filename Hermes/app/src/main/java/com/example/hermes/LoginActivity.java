package com.example.hermes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseUser currentUser;
    private TextView NeedNewAccountLink;

    public LoginActivity(FirebaseUser currentUser) {
        this.currentUser = currentUser;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
//        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      InitializeFields();

      NeedNewAccountLink.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

          }
      });
    }

    private void InitializeFields() {
        Button loginButton = findViewById(R.id.login_button);
        Button phoneLoginButton = findViewById(R.id.phone_login_button);
        EditText userEmail = findViewById(R.id.login_email);
        EditText userPassword = findViewById(R.id.login_password);
        NeedNewAccountLink = findViewById(R.id.new_here);
        TextView forgotPasswordLink = findViewById(R.id.forgot_password_link);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(currentUser == null){
            SendUserToMainActivity();
        }
    }

    private void SendUserToMainActivity() {
        Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(loginIntent);
    }

    private void SendUserToRegisterActivity() {
        Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
    }
}
