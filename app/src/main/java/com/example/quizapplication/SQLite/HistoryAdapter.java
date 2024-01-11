package com.example.quizapplication.SQLite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapplication.Activities.QuestionActivity;
import com.example.quizapplication.Models.Dethi;
import com.example.quizapplication.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HisViewHolder> {
    Context context;
    ArrayList<Dethi> dethis;
    public HistoryAdapter(Context context , ArrayList<Dethi> dethis){
        this.dethis = dethis;
        this.context = context;
    }
    @NonNull
    @Override
    public HisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.item_his,parent,false);
        return new HisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HisViewHolder holder, int position) {
        Dethi dethi = dethis.get(position);
        holder.textmade.setText(String.valueOf(dethi.getMade()));
        holder.textscore.setText(String.valueOf(dethi.getScore()));
    }

    @Override
    public int getItemCount() {
        return dethis.size();
    }

    class HisViewHolder extends RecyclerView.ViewHolder{
        TextView setName ,textmade ,textscore ;
        ImageView imgXoa;
        public HisViewHolder(@NonNull View itemView) {
            super(itemView);
            setName =itemView.findViewById(R.id.setName);
            imgXoa = itemView.findViewById(R.id.imageViewXoa);
            textmade = itemView.findViewById(R.id.textmade);
            textscore = itemView.findViewById(R.id.textscore);
            imgXoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean rs = HistoryData.delete(context, String.valueOf(dethis.get(getAdapterPosition()).getMade()));
                    if (rs) {
                        Toast.makeText(context, "Xóa thành công", Toast.LENGTH_LONG).show();
                        resetData();
                    } else {
                        Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_LONG).show();
                    }
                    notifyDataSetChanged();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, QuestionActivity.class);
                    int idmade = dethis.get(getPosition()).getMade();
                    intent.putExtra("idDethi",idmade) ;
                    context.startActivity(intent);
                }
            });

        }
    }
    void resetData() {
        dethis.clear();
        dethis.addAll(HistoryData.getDe(context));
    }
}
