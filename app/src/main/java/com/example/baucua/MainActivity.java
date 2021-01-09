package com.example.baucua;

import androidx.annotation.Nullable;
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
    TextView tbl,tus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        tbl.setText(""+(int)logedInUser.getBalance());
        tus.setText(logedInUser.getUsername());
    }
    private void anhXa(){
        tbl = findViewById(R.id.txtbalancemain);
        tus = findViewById(R.id.mainuser);
        linearLayout = findViewById(R.id.main);
    }

    public void xidach(View view) {
        Toast.makeText(getApplicationContext(),"Đang phát triển...",Toast.LENGTH_SHORT).show();
    }

    public void baucua(View view) {
        Intent intent = new Intent(MainActivity.this,BauCuaActivity.class);
        intent.putExtra("balance",tbl.getText().toString());
        startActivityForResult(intent,1);
    }

    public void taixiu(View view) {
        Toast.makeText(getApplicationContext(),"Đang phát triển...",Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK)
            tbl.setText(data.getStringExtra("balancebc"));
    }

    public void clickBaiCao(View view) {
        Toast.makeText(getApplicationContext(),"Đang phát triển...",Toast.LENGTH_SHORT).show();
    }
}