package com.example.quizapplication.DATABASE;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapplication.Models.Dethi;
import com.example.quizapplication.Models.Question;
import com.example.quizapplication.R;

import java.util.ArrayList;

public class SetAdapter extends RecyclerView.Adapter<SetAdapter.DethiVH>{

    ArrayList<Dethi> dethis;
    //ArrayList<Question> questions;
    Listener listener;

    public SetAdapter(ArrayList<Dethi> dethis, Listener listener) {
        this.listener = listener;
        this.dethis = dethis;
    }

    public SetAdapter(ArrayList<Dethi> questions) {
        this.dethis = questions;
    }

    @NonNull
    //tạo viewholdersd
    @Override
    public DethiVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview,parent,false );
        return new DethiVH(view);
    }

    //đổ dữ liệu vào DethiVH
    @Override
    public void onBindViewHolder(@NonNull DethiVH holder, int position) {
        Dethi dethi = dethis.get(position);
        holder.textmade.setText(String.valueOf(dethi.getMade()));
        holder.itemView.setOnClickListener(view ->
                listener.onItemListener(dethi)
                );
        //holder.textname.setText(dethi.getCauhoi());


    }
    //đếm có bao nhiêu dữ liệu
    @Override
    public int getItemCount() {
        return dethis.size();
    }

    class DethiVH extends RecyclerView.ViewHolder{
        TextView textmade, textname;

        public DethiVH(@NonNull View view){
            super(view) ;
            textmade = view.findViewById(R.id.textmade);
            //textname = view.findViewById(R.id.txtName);
        }
    }
    public interface Listener{
        void onItemListener(Dethi dethi);
    }
}