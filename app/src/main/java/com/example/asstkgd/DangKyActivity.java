package com.example.asstkgd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangKyActivity extends AppCompatActivity {
    private EditText edtUser;
    private EditText edtPass;
    private EditText edtPass2;
    private EditText edtTen;
    private EditText edtDiaChi;
    private  EditText edtSDT;
    Button btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_DangKy);

        edtUser = (EditText) findViewById(R.id.editTextTK);
        edtPass = (EditText) findViewById(R.id.editTextMK);
        edtPass2 = (EditText) findViewById(R.id.editTextXNMK);
        edtTen = (EditText) findViewById(R.id.editTextTenChuTK);
        edtDiaChi = (EditText) findViewById(R.id.editTextDiaChi);
        edtSDT = (EditText) findViewById(R.id.editTextSDT);
        btnDangKy = (Button) findViewById(R.id.buttonDangKy);

        //kiem tra dang nhap sau khi click button dang nhap
        btnDangKy.setOnClickListener(this::onClick);

    }

    private void onClick(View view) {
        String username = "admin";
        String password = "admin";
        if (edtUser.getText().toString().equals(username) && edtPass.getText().toString().equals(password)) {
            Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_LONG).show();
            startActivity(new Intent(DangKyActivity.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
        }

    }
}
