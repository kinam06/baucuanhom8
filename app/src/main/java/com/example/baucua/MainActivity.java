package com.example.baucua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baucua.Object.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.baucua.LoginActivity.logedInUser;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    FrameLayout frameLayout;
    TextView tbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        tbl.setText(logedInUser.getUsername()+": "+(int)logedInUser.getBalance());
    }
    private void anhXa(){
        tbl = findViewById(R.id.txtuserbalance);
        linearLayout = findViewById(R.id.main);
        frameLayout = findViewById(R.id.fmain);
    }

    public void xidach(View view) {
        Toast.makeText(getApplicationContext(),"Đang phát triển...",Toast.LENGTH_SHORT).show();
    }

    public void baucua(View view) {
    }

    public void taixiu(View view) {
    }

    public void logout(View view) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor sEditor;
        sharedPreferences = getSharedPreferences("us",0);
        sEditor = sharedPreferences.edit();
        sEditor.remove("pass");
        sEditor.remove("checked");
        sEditor.commit();
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
        finish();
    }
}