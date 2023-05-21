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

import com.example.asstkgd.Adapter.TaiKhoanDatabaseHelper;
import com.example.asstkgd.Entity.TaiKhoan;

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
    TaiKhoanDatabaseHelper helper;

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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = edUser.getText().toString();
                if (helper.searkTK(tk) == true) {
                    if (edPass.getText().toString().equals(helper.searchPass(tk))) {
                        Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                        Intent mh2 = new Intent(Ass.this, MainActivity.class);
                        startActivity(mh2);
                    } else {
                        Toast.makeText(getApplicationContext(), "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        }
}