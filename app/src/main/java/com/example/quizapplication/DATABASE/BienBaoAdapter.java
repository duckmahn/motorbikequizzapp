package com.example.quizapplication.DATABASE;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quizapplication.Activities.ChitietActivity;
import com.example.quizapplication.Models.BienBao;
import com.example.quizapplication.R;

import java.util.List;

public class BienBaoAdapter extends RecyclerView.Adapter<BienBaoAdapter.BienBaoVH>{
    List<BienBao> bienBaos;

    public BienBaoAdapter(List<BienBao> bienBaos) {
        this.bienBaos = bienBaos;
    }

    @NonNull
    @Override
    public BienBaoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bienbao,parent,false);

        return new BienBaoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BienBaoVH holder, int position) {
        BienBao bienBao = bienBaos.get(position);
        holder.tvName.setText(bienBao.getName());
        
        Glide.with(holder.img.getContext()).load(bienBao.getImage()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChitietActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("bienbao", bienBao);
                intent.putExtra("chitiet",bundle);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bienBaos.size();
    }

    public void setList(List<BienBao> list) {
        bienBaos.clear();
        bienBaos.addAll(list);
        notifyDataSetChanged();
    }

    class BienBaoVH extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tvName;
        public BienBaoVH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ivBienBao1);
            tvName = itemView.findViewById(R.id.tvBienBao);
        }
    }
}
