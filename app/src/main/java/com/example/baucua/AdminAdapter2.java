package com.example.baucua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baucua.Object.Transact;
import com.example.baucua.Object.User;

import java.util.ArrayList;

import static com.example.baucua.LoginActivity.logedInUser;

public class AdminAdapter2 extends RecyclerView.Adapter<AdminAdapter2.ViewHolder> {
    Context context;
    ArrayList<Transact> listT;

    public AdminAdapter2(Context context, ArrayList<Transact> listT) {
        this.context = context;
        this.listT = listT;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemview2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Transact transact = listT.get(position);
        holder.t1.setText(logedInUser.getUsername());
        if (transact.getTransaction_type().equals("Withdraw"))
            holder.t2.setText("-"+transact.getAmount());
        else
            holder.t2.setText("+"+transact.getAmount());
        holder.t3.setText(transact.getDatetime());

        holder.setItemClick(new ItemOnClick() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Toast.makeText(context,"Đang phát triển...",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listT.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView t1,t2,t3;
        Button btn;
        ItemOnClick itemOnClick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.txtuserh);
            t2 = itemView.findViewById(R.id.txtuserbalanceh);
            t3 = itemView.findViewById(R.id.t3);
            itemView.setOnClickListener(this);
        }
        public void setItemClick(ItemOnClick itemOnClick){
            this.itemOnClick = itemOnClick;
        }

        @Override
        public void onClick(View v) {
            itemOnClick.onClick(v,getAdapterPosition(),false);
        }
    }
    public void addT(ArrayList<Transact> transacts){
        for (Transact transact : transacts)
        {

        }
    }
}
