package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginView , View.OnClickListener {
    private LoginView loginView;
    private EditText edtUsername;
    private EditText edtPassword;
    private LoginPresenter loginPresenter;

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(this);
        edtUsername = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        initView();
        initAction();

    }


    public void checkLogin(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void Dangki1(View view) {
        Intent intent = new Intent(LoginActivity.this, DangKyActivity.class);
        startActivity(intent);
    }

    public void initView() {
        edtUsername = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    // set sự kiện click cho nút Login
    public void initAction() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void LoginFail() {
        Toast.makeText(this, "Login Fail!!",
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void LoginSuccessful() {
        Toast.makeText(this, "Login Thanh Cong!!",
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setErrorUsername() {
        edtUsername.setError("Vui long nhap Username");

    }

    @Override
    public void setErrorPasswword() {
        edtPassword.setError("Vui long nhap Password");

    }

    @Override
    public void navigate() {
        startActivity(new Intent(this, MainActivity.class));

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin) {
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();
            loginPresenter.login(username, password);

        }
    }
}



