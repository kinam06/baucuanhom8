package com.example.baucua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    CheckBox nmk;
    TextView tdk,tdn,tt;
    EditText eus,epw,ecpw;
    Button bdn,bdk;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhXa();
        sharedPreferences = getSharedPreferences("us", MODE_PRIVATE);
        sEditor = sharedPreferences.edit();
        eus.setText(sharedPreferences.getString("user",""));
        epw.setText(sharedPreferences.getString("pass",""));
        nmk.setChecked(sharedPreferences.getBoolean("checked",false));
        events();
    }
    private void anhXa(){
        tt = findViewById(R.id.tv1);
        tdk = findViewById(R.id.tdk);
        tdn = findViewById(R.id.tdn);
        eus = findViewById(R.id.etk);
        epw = findViewById(R.id.emk);
        ecpw = findViewById(R.id.ecmk);
        bdn = findViewById(R.id.bdn);
        bdk = findViewById(R.id.bdk);
        nmk = findViewById(R.id.nmk);
    }
    private void events(){
        tdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ecpw.setVisibility(View.VISIBLE);
                        bdn.setVisibility(View.INVISIBLE);
                        tdk.setVisibility(View.INVISIBLE);
                        bdk.setVisibility(View.VISIBLE);
                        tdn.setVisibility(View.VISIBLE);
                        nmk.setVisibility(View.INVISIBLE);
                        tt.setText("Đăng ký");
                    }
                },200);
            }
        });
        tdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ecpw.setVisibility(View.INVISIBLE);
                        tdk.setVisibility(View.VISIBLE);
                        bdk.setVisibility(View.INVISIBLE);
                        bdn.setVisibility(View.VISIBLE);
                        tdn.setVisibility(View.INVISIBLE);
                        nmk.setVisibility(View.VISIBLE);
                        tt.setText("Đăng nhập");
                    }
                },200);
            }
        });
        bdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (epw.getText().length()==0||eus.getText().length()==0||ecpw.getText().length()==0)
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập đầy đủ thông tin!",Toast.LENGTH_SHORT).show();
                else if (!epw.getText().toString().equals(ecpw.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Xác nhận mật khẩu không đúng!",Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(getApplicationContext(),"Đăng ký thành công!",Toast.LENGTH_SHORT).show();
                    ecpw.setText("");
                    ecpw.setVisibility(View.INVISIBLE);
                    tdk.setVisibility(View.VISIBLE);
                    bdk.setVisibility(View.INVISIBLE);
                    bdn.setVisibility(View.VISIBLE);
                    tdn.setVisibility(View.INVISIBLE);
                    nmk.setVisibility(View.VISIBLE);
                    tt.setText("Đăng nhập");
                }
            }
        });
        bdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                if (nmk.isChecked()==true) {
                    sEditor.putString("user", eus.getText().toString());
                    sEditor.putString("pass", epw.getText().toString());
                    sEditor.putBoolean("checked",true);
                    sEditor.commit();
                }
                else{
                    sEditor.putString("user", eus.getText().toString());
                    sEditor.remove("pass");
                    sEditor.putBoolean("checked",false);
                    sEditor.commit();
                }
                intent.putExtra("username",eus.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}