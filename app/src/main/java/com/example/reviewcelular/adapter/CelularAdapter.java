package com.example.reviewcelular.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reviewcelular.R;
import com.example.reviewcelular.database.CelularesDB;
import com.example.reviewcelular.database.dao.CelularDAO;
import com.example.reviewcelular.entity.Celular;
import com.example.reviewcelular.ui.FormActivity;

import java.util.List;

public class CelularAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Celular> listaCelulares;
    private CelularDAO dao;

    public CelularAdapter(Context context) {
        this.context = context;
        dao = CelularesDB.getInstance(context).getCelularDAO();
        listaCelulares = dao.getCelulares();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(context).inflate(R.layout.celular_layout, parent, false);

        CelularViewHolder cvh = new CelularViewHolder(itemView);

        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){

        Celular c = listaCelulares.get(position);

        CelularViewHolder cvh = (CelularViewHolder) holder;

        cvh.tvModelo.setText(c.getModelo());

        //Aqui falta

        cvh.ibEditar.setOnClickListener(v -> {
            Intent editarIntent = new Intent(context, FormActivity.class);
            editarIntent.putExtra("celular", c);
            context.startActivity(editarIntent);
        });

        cvh.ibExcluir.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                .setTitle("Excluir Celular")
                .setMessage("Deseja excluir este Celular?")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim!", (dialogInterface, i) -> {
                    dao.excluirCelular(c);
                    updateDataSet();
                })
                    .show();
        });

    }

    @Override
    public int getItemCount(){

        return listaCelulares.size();
    }

    public void updateDataSet() {
        listaCelulares.clear();
        listaCelulares = dao.getCelulares();
        notifyDataSetChanged();
    }

}


