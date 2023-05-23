package com.example.asstkgd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asstkgd.Adapter.TaiKhoanDatabaseHelper;
import com.example.asstkgd.Entity.TaiKhoan;

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
        setContentView(R.layout.activity_dangky);

        edtUser = (EditText) findViewById(R.id.editTextTK);
        edtPass = (EditText) findViewById(R.id.editTextMK);
        edtPass2 = (EditText) findViewById(R.id.editTextXNMK);
        edtTen = (EditText) findViewById(R.id.editTextTenChuTK);
        edtDiaChi = (EditText) findViewById(R.id.editTextDiaChi);
        edtSDT = (EditText) findViewById(R.id.editTextSDT);
        btnDangKy = (Button) findViewById(R.id.buttonDangKy);
        TaiKhoanDatabaseHelper helper = new TaiKhoanDatabaseHelper(this);
        helper.open();
        btnDangKy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(edtPass.getText().toString().equals(edtPass2.getText().toString())){
                    TaiKhoan kh = new TaiKhoan();
                    kh.setM_TK(edtUser.getText().toString());
                    kh.setM_Matkhau(edtPass.getText().toString());
                    kh.setM_Ten(edtTen.getText().toString());
                    kh.setM_Diachi(edtDiaChi.getText().toString());
                    kh.setM_Sdt(edtSDT.getText().toString());
                    helper.insertTK(kh);
                    Toast.makeText(getApplicationContext(),"Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    Intent mh2 = new Intent(DangKyActivity.this, Ass.class);
                    startActivity(mh2);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Mật khẩu không khớp nhau", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
//    public void InsertTK(){
//        if(edtPass.getText().toString().equals(edtPass2.getText().toString())){
//            TaiKhoan kh = new TaiKhoan();
//                    kh.setM_TK(edtUser.getText().toString());
//                    kh.setM_Matkhau(edtPass.getText().toString());
//                    kh.setM_Ten(edtTen.getText().toString());
//                    kh.setM_Diachi(edtDiaChi.getText().toString());
//                    kh.setM_Sdt(edtSDT.getText().toString());
//                    helper.insertTK(kh);
//            Toast.makeText(getApplicationContext(),"Đăng ký thành công", Toast.LENGTH_SHORT).show();
//            Intent mh2 = new Intent(DangKyActivity.this, MainActivity.class);
//            startActivity(mh2);
//            finish();
//        }else{
//            Toast.makeText(getApplicationContext(),"Mật khẩu không khớp nhau", Toast.LENGTH_LONG).show();
//        }
//
//    }
}
