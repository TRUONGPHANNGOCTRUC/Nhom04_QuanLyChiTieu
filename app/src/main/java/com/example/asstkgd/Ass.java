package com.example.asstkgd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ass extends AppCompatActivity {
    private TextView txtReforpass;
    private TextView textView6;
    private EditText edUser;
    private EditText edPass;
    private Button btnLogin;
    private TextView create;
    private TextView txtOr;
    private View view;
    private View view2;
    private ImageView btnFb;
    private ImageView btnGg;
    private ImageView btnTw;
    private ImageView btnSc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ass);

        txtReforpass = (TextView) findViewById(R.id.txt_reforpass);
        textView6 = (TextView) findViewById(R.id.textView6);
        edUser = (EditText) findViewById(R.id.ed_user);
        edPass = (EditText) findViewById(R.id.ed_pass);
        btnLogin = (Button) findViewById(R.id.btn_login);
        create = (TextView) findViewById(R.id.create);
        txtOr = (TextView) findViewById(R.id.txt_or);
        view = (View) findViewById(R.id.view);
        view2 = (View) findViewById(R.id.view2);
        btnFb = (ImageView) findViewById(R.id.btn_fb);
        btnGg = (ImageView) findViewById(R.id.btn_gg);
        btnTw = (ImageView) findViewById(R.id.btn_tw);
        btnSc = (ImageView) findViewById(R.id.btn_sc);

        btnLogin.setOnClickListener(view -> {
            String username = "admin";
            String password = "admin";
            if (edUser.getText().toString().equals(username) && edPass.getText().toString().equals(password)) {
                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Ass.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
            }
        });
    }
}