package com.example.baucua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.baucua.Object.Transact;
import com.example.baucua.Object.User;
import com.example.baucua.Object.UserName;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.baucua.LoginActivity.logedInUser;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdminAdapter2 adminAdapter2;
    ArrayList<Transact> listT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView = findViewById(R.id.rls);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        getT();
    }

    private void getT() {
        ApiClient.getApiService().getTransaction(new UserName(logedInUser.getUsername())).enqueue(new Callback<ArrayList<Transact>>() {
            @Override
            public void onResponse(Call<ArrayList<Transact>> call, Response<ArrayList<Transact>> response) {
                listT=response.body();
                adminAdapter2 = new AdminAdapter2(getApplicationContext(),listT);
                recyclerView.setAdapter(adminAdapter2);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onFailure(Call<ArrayList<Transact>> call, Throwable t) {

            }
        });
    }
}