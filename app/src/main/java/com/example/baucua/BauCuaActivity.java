package com.example.baucua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.baucua.LoginActivity.logedInUser;

public class BauCuaActivity extends AppCompatActivity {

    Spinner spinner1;
    Integer[] dsQuan = {R.drawable.conca,
            R.drawable.concua,
            R.drawable.bau,
            R.drawable.nai,
            R.drawable.contom,
            R.drawable.conga};
    Integer[] giatricuoc={1000,10000,100000};
    AnimationDrawable xs1, xs2, xs3;
    ImageView xucsac1, xucsac2, xucsac3;
    Button btnxucsac;
    int giatri1, giatri2, giatri3;
    Random randomxs1, randomxs2, randomxs3;
    TextView tiendatbau, tiendatcua, tiendatca, tiendathuou, tiendatga, tiendattom;
    TextView txttienhienthi, tienketqua, us;
    int tienga = 0, tienca = 0, tienbau = 0, tientom = 0, tienhuou = 0, tiencua = 0;
    int tienthuong, tienhienthi;
    Animation anim, animmat;
    TextView animtxt, thuacuoc1;
    LinearLayout themtien, thuacuoctxt, thuacuocmain;
    ImageView imgdau;
    int tienthuongtxt = 0;
    String TongTien = "tongtien";
    String AmThanh = "amthanh";
    SharedPreferences save_Data;
    SharedPreferences.Editor editor;
    int tiencongtong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bau_cua);
        anhXa();
        ArrayAdapter<Integer> adapterBC = new ArrayAdapter<Integer>(this,R.layout.spinner,giatricuoc);
        spinner1.setAdapter(adapterBC);
        txttienhienthi.setText(getIntent().getStringExtra("balance"));
        us.setText(logedInUser.getUsername());
    }
    private void anhXa()
    {
        xucsac1 = findViewById(R.id.xucsac1);
        xucsac2 = findViewById(R.id.xucsac2);
        xucsac3 = findViewById(R.id.xucsac3);
        xucsac1.setImageResource(R.drawable.concua);
        xucsac2.setImageResource(R.drawable.concua);
        xucsac3.setImageResource(R.drawable.concua);
        btnxucsac = findViewById(R.id.btnxucsac);
        txttienhienthi = findViewById(R.id.txtbalancebc);
        tiendatbau = findViewById(R.id.tiendatbau);
        tiendatga = findViewById(R.id.tiendatga);
        tiendatca = findViewById(R.id.tiendatca);
        tiendatcua = findViewById(R.id.tiendatcua);
        tiendattom = findViewById(R.id.tiendattom);
        tiendathuou = findViewById(R.id.tiendathuou);
        tienketqua = findViewById(R.id.tienkqbc);
        spinner1 = findViewById(R.id.spn1);
        us = findViewById(R.id.bcuser);
    }

    public void backtomain(View view) {
        Intent intent = new Intent();
        intent.putExtra("balancebc", txttienhienthi.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }

    public void lacBauCua(View view) {
        int tiendat = Integer.parseInt(tiendatbau.getText().toString())+Integer.parseInt(tiendatga.getText().toString())
                +Integer.parseInt(tiendatca.getText().toString())+Integer.parseInt(tiendatcua.getText().toString())
                +Integer.parseInt(tiendattom.getText().toString())+Integer.parseInt(tiendathuou.getText().toString());
        if (tiendat>Integer.parseInt(txttienhienthi.getText().toString()))
            Toast.makeText(getApplicationContext(),"Không đủ số dư!",Toast.LENGTH_SHORT).show();
        else{
            xucsac1.setImageResource(R.drawable.animation_item);
            xucsac2.setImageResource(R.drawable.animation_item_1);
            xucsac3.setImageResource(R.drawable.animation_item_2);
            xs1 = (AnimationDrawable) xucsac1.getDrawable();
            xs2 = (AnimationDrawable) xucsac2.getDrawable();
            xs3 = (AnimationDrawable) xucsac3.getDrawable();
            xs1.start();
            xs2.start();
            xs3.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Randomgt1();
                    Randomgt2();
                    Randomgt3();
                    xuLyThuong();
                }
            }, 2000);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    tienketqua.setText("");
                }
            }, 6000);
        }
    }
    private void Randomgt1() {
        randomxs1 = new Random();
        int rd1 = randomxs1.nextInt(6);
        switch (rd1) {
            case 0:
                xucsac1.setImageResource(dsQuan[0]);
                giatri1 = rd1;
                break;
            case 1:
                xucsac1.setImageResource(dsQuan[1]);
                giatri1 = rd1;
                break;
            case 2:
                xucsac1.setImageResource(dsQuan[2]);
                giatri1 = rd1;
                break;
            case 3:
                xucsac1.setImageResource(dsQuan[3]);
                giatri1 = rd1;
                break;
            case 4:
                xucsac1.setImageResource(dsQuan[4]);
                giatri1 = rd1;
                break;
            case 5:
                xucsac1.setImageResource(dsQuan[5]);
                giatri1 = rd1;
                break;
        }
    }

    private void Randomgt2() {
        randomxs2 = new Random();
        int rd2 = randomxs2.nextInt(6);
        switch (rd2) {
            case 0:
                xucsac2.setImageResource(dsQuan[0]);
                giatri2 = rd2;
                break;
            case 1:
                xucsac2.setImageResource(dsQuan[1]);
                giatri2 = rd2;
                break;
            case 2:
                xucsac2.setImageResource(dsQuan[2]);
                giatri2 = rd2;
                break;
            case 3:
                xucsac2.setImageResource(dsQuan[3]);
                giatri2 = rd2;
                break;
            case 4:
                xucsac2.setImageResource(dsQuan[4]);
                giatri2 = rd2;
                break;
            case 5:
                xucsac2.setImageResource(dsQuan[5]);
                giatri2 = rd2;
                break;
        }
    }

    private void Randomgt3() {
        randomxs3 = new Random();
        int rd3 = randomxs3.nextInt(6);
        switch (rd3) {
            case 0:
                xucsac3.setImageResource(dsQuan[0]);
                giatri3 = rd3;
                break;
            case 1:
                xucsac3.setImageResource(dsQuan[1]);
                giatri3 = rd3;
                break;
            case 2:
                xucsac3.setImageResource(dsQuan[2]);
                giatri3 = rd3;
                break;
            case 3:
                xucsac3.setImageResource(dsQuan[3]);
                giatri3 = rd3;
                break;
            case 4:
                xucsac3.setImageResource(dsQuan[4]);
                giatri3 = rd3;
                break;
            case 5:
                xucsac3.setImageResource(dsQuan[5]);
                giatri3 = rd3;
                break;
        }
    }
    private void xuLyBau(){
        if (giatri1 == 2) {
            tienthuong += Integer.parseInt(tiendatbau.getText().toString());
        }
        if (giatri2 == 2) {
            tienthuong += Integer.parseInt(tiendatbau.getText().toString());
        }
        if (giatri3 == 2) {
            tienthuong += Integer.parseInt(tiendatbau.getText().toString());
        }
        if (giatri1 != 2 && giatri2 != 2 && giatri3 != 2) {
            tienthuong -= Integer.parseInt(tiendatbau.getText().toString());
        }
    }
    private void xuLyCa(){
        if (giatri1 == 0) {
            tienthuong += Integer.parseInt(tiendatca.getText().toString());
        }
        if (giatri2 == 0) {
            tienthuong += Integer.parseInt(tiendatca.getText().toString());
        }
        if (giatri3 == 0) {
            tienthuong += Integer.parseInt(tiendatca.getText().toString());
        }
        if (giatri1 != 0 && giatri2 != 0 && giatri3 != 0) {
            tienthuong -= Integer.parseInt(tiendatca.getText().toString());
        }
    }
    private void xuLyCua(){
        if (giatri1 == 1) {
            tienthuong += Integer.parseInt(tiendatcua.getText().toString());
        }
        if (giatri2 == 1) {
            tienthuong += Integer.parseInt(tiendatcua.getText().toString());
        }
        if (giatri3 == 1) {
            tienthuong += Integer.parseInt(tiendatcua.getText().toString());
        }
        if (giatri1 != 1 && giatri2 != 1 && giatri3 != 1) {
            tienthuong -= Integer.parseInt(tiendatcua.getText().toString());
        }
    }
    private void xuLyHuou(){
        if (giatri1 == 3) {
            tienthuong += Integer.parseInt(tiendathuou.getText().toString());
        }
        if (giatri2 == 3) {
            tienthuong += Integer.parseInt(tiendathuou.getText().toString());
        }
        if (giatri3 == 3) {
            tienthuong += Integer.parseInt(tiendathuou.getText().toString());
        }
        if (giatri1 != 3 && giatri2 != 3 && giatri3 != 3) {
            tienthuong -= Integer.parseInt(tiendathuou.getText().toString());
        }
    }
    private void xuLyTom(){
        if (giatri1 == 4) {
            tienthuong += Integer.parseInt(tiendattom.getText().toString());
        }
        if (giatri2 == 4) {
            tienthuong += Integer.parseInt(tiendattom.getText().toString());
        }
        if (giatri3 == 4) {
            tienthuong += Integer.parseInt(tiendattom.getText().toString());
        }
        if (giatri1 != 4 && giatri2 != 4 && giatri3 != 4) {
            tienthuong -= Integer.parseInt(tiendattom.getText().toString());
        }
    }
    private void xuLyGa(){
        if (giatri1 == 5) {
            tienthuong += Integer.parseInt(tiendatga.getText().toString());
        }
        if (giatri2 == 5) {
            tienthuong += Integer.parseInt(tiendatga.getText().toString());
        }
        if (giatri3 == 5) {
            tienthuong += Integer.parseInt(tiendatga.getText().toString());
        }
        if (giatri1 != 5 && giatri2 != 5 && giatri3 != 5) {
            tienthuong -= Integer.parseInt(tiendatga.getText().toString());
        }
    }
    private void xuLyThuong(){
        xuLyBau();xuLyCa();xuLyCua();xuLyGa();xuLyHuou();xuLyTom();
        if (tienthuong>0) {
            tienketqua.setText("+" + tienthuong);
            tienketqua.setTextColor(Color.parseColor("#24fc03"));
        }
        else if(tienthuong<0){
            tienketqua.setText(""+tienthuong);
            tienketqua.setTextColor(Color.parseColor("#f70008"));
        }
        else{
            tienketqua.setTextColor(Color.parseColor("#ebe4e4"));
            tienketqua.setText(""+tienthuong);
        }
        tienhienthi = Integer.parseInt(txttienhienthi.getText().toString())+tienthuong;
        txttienhienthi.setText(""+tienhienthi);
        tienthuong=0;
        tiendatbau.setText("0");
        tiendatcua.setText("0");
        tiendattom.setText("0");
        tiendatca.setText("0");
        tiendathuou.setText("0");
        tiendatga.setText("0");
        tienbau=tienca=tiencua=tientom=tienhuou=tienca=0;
    }

    public void clickBau(View view) {
        tienbau = Integer.parseInt(tiendatbau.getText().toString()) + Integer.parseInt(spinner1.getSelectedItem().toString());
        tiendatbau.setText(""+tienbau);
    }

    public void clickCa(View view) {
        tienca = Integer.parseInt(tiendatca.getText().toString()) + Integer.parseInt(spinner1.getSelectedItem().toString());
        tiendatca.setText(""+tienca);
    }

    public void clickCua(View view) {
        tiencua = Integer.parseInt(tiendatcua.getText().toString()) + Integer.parseInt(spinner1.getSelectedItem().toString());
        tiendatcua.setText(""+tiencua);
    }

    public void clickTom(View view) {
        tientom = Integer.parseInt(tiendattom.getText().toString()) + Integer.parseInt(spinner1.getSelectedItem().toString());
        tiendattom.setText(""+tientom);
    }

    public void clickGa(View view) {
        tienga = Integer.parseInt(tiendatga.getText().toString()) + Integer.parseInt(spinner1.getSelectedItem().toString());
        tiendatga.setText(""+tienga);
    }

    public void clickHuou(View view) {
        tienhuou = Integer.parseInt(tiendathuou.getText().toString()) + Integer.parseInt(spinner1.getSelectedItem().toString());
        tiendathuou.setText(""+tienhuou);
    }

    public void xoaCuocBC(View view) {
        tiendathuou.setText("0");
        tiendatca.setText("0");
        tiendatga.setText("0");
        tiendatbau.setText("0");
        tiendattom.setText("0");
        tiendatcua.setText("0");
    }
}