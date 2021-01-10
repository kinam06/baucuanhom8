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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baucua.Object.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    LinearLayout ldn, ldk;
    ScrollView scrollView;
    CheckBox nmk;
    TextView tdk,tdn,tt;
    EditText eus,epw,erus,erpw,ecpw,efn,eemail,esdt;
    Button bdn,bdk;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sEditor;
    public static User logedInUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhXa();
        sharedPreferences = getSharedPreferences("us", 0);
        sEditor = sharedPreferences.edit();
        eus.setText(sharedPreferences.getString("user",""));
        epw.setText(sharedPreferences.getString("pass",""));
        nmk.setChecked(sharedPreferences.getBoolean("checked",false));
        events();
    }
    private void anhXa(){
        tdk = findViewById(R.id.tdk);
        tdn = findViewById(R.id.tdn);
        eus = findViewById(R.id.edntk);
        epw = findViewById(R.id.ednmk);
        erus = findViewById(R.id.edktk);
        erpw = findViewById(R.id.edkmk);
        ecpw = findViewById(R.id.exnmk);
        efn = findViewById(R.id.efullname);
        eemail = findViewById(R.id.eemail);
        esdt = findViewById(R.id.esdt);
        bdn = findViewById(R.id.bdn);
        bdk = findViewById(R.id.bdk);
        nmk = findViewById(R.id.nmk);
        ldn = findViewById(R.id.lndn);
        ldk = findViewById(R.id.lndk);
        scrollView =findViewById(R.id.slndk);
    }
    private void events(){
        tdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ldn.setVisibility(View.INVISIBLE);
                        scrollView.setVisibility(View.VISIBLE);
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
                        scrollView.setVisibility(View.INVISIBLE);
                        ldn.setVisibility(View.VISIBLE);
                    }
                },200);
            }
        });
        bdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdk.setEnabled(false);
                if (erpw.getText().toString().trim().length() == 0 || erus.getText().toString().trim().length() == 0
                        || ecpw.getText().toString().trim().length() == 0 || efn.getText().toString().trim().length() == 0
                        || eemail.getText().toString().trim().length() == 0 || esdt.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                    bdk.setEnabled(true);
                }
                else if (!erpw.getText().toString().equals(ecpw.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Xác nhận mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                    bdk.setEnabled(true);
                }
                else {
                    User user = new User(erus.getText().toString().toLowerCase().trim(), erpw.getText().toString(),
                            efn.getText().toString().trim(), esdt.getText().toString(), eemail.getText().toString().trim());
                    ApiClient.getApiService().reg(user).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            eus.setText(erus.getText().toString());
                            epw.setText(erpw.getText().toString());
                            erus.setText("");
                            erpw.setText("");
                            ecpw.setText("");
                            efn.setText("");
                            eemail.setText("");
                            esdt.setText("");
                            scrollView.setVisibility(View.INVISIBLE);
                            ldn.setVisibility(View.VISIBLE);
                            bdk.setEnabled(true);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                            bdk.setEnabled(true);
                        }
                    });
                }
            }
        });
        bdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (eus.getText().toString().length()==0||epw.getText().toString().length()==0)
                //    Toast.makeText(getApplicationContext(),"Vui lòng nhập tên tài khoản và mật khẩu",Toast.LENGTH_SHORT).show();
                bdn.setEnabled(false);
                User user = new User(eus.getText().toString().toLowerCase().trim(),epw.getText().toString());
                ApiClient.getApiService().login(user).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                       try {
                           bdn.setEnabled(true);
                           if (response.body().getMessage().equals("LOGIN SUCCESSFULLY")){
                               Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_SHORT).show();
                               logedInUser = new User(eus.getText().toString(),
                                       epw.getText().toString(),
                                       response.body().getBalance(),
                                       response.body().getEmail(),
                                       response.body().getFullname(),
                                       response.body().getPhone(),
                                       response.body().getUser_type());
                               if (response.body().getUser_type().equals("admin"))
                                   startActivity(new Intent(getApplicationContext(),AdminActivity.class));
                               else
                                   startActivity(new Intent(LoginActivity.this,MainActivity.class));
                               finish();
                           }
                       }catch (Exception e){
                           Toast.makeText(getApplicationContext(),"Sai tên đăng nhập hoặc mật khẩu!",Toast.LENGTH_SHORT).show();
                           bdn.setEnabled(true);
                       };
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                        bdn.setEnabled(true);
                    }
                });
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
            }
        });
    }
}