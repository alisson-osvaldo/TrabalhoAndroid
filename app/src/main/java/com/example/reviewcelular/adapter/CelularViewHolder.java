package com.example.reviewcelular.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reviewcelular.R;

public class CelularViewHolder extends RecyclerView.ViewHolder {

    TextView tvModelo;
    ImageButton ibEditar;
    ImageButton ibExcluir;

    public CelularViewHolder(@NonNull View itemView){
        super(itemView);

        tvModelo = itemView.findViewById(R.id.tvModelo);
        ibEditar  = itemView.findViewById(R.id.ibEditar);
        ibExcluir = itemView.findViewById(R.id.ibExcluir);
    }

}
