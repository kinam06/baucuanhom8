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

import com.example.baucua.Object.User;

import java.util.ArrayList;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.ViewHolder> {
    Context context;
    ArrayList<User> listUser;

    public AdminAdapter(Context context, ArrayList<User> listUser) {
        this.context = context;
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = listUser.get(position);
        holder.t1.setText(user.getUsername());
        holder.t2.setText(""+Utils.formatMoney(user.getBalance()));
        //holder.btn.setText("Xoá");
        holder.setItemClick(new ItemOnClick() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Toast.makeText(context,"Đang phát triển...",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView t1,t2,t3;
        Button btn;
        ItemOnClick itemOnClick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.txtusera);
            t2 = itemView.findViewById(R.id.txtuserbalancea);
            btn = itemView.findViewById(R.id.rbtn);
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
    public void addUser(ArrayList<User> users){
        //for (User user : users)
    }
}
