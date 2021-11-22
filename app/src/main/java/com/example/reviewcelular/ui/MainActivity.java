package com.example.reviewcelular.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.reviewcelular.R;
import com.example.reviewcelular.adapter.CelularAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCelulares;
    FloatingActionButton fabAdd;
    CelularAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCelulares = findViewById(R.id.rvCelulares);
        fabAdd      = findViewById(R.id.fabAdd);

        LinearLayoutManager layout = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        adapter = new CelularAdapter(this);

        rvCelulares.setLayoutManager(layout);
        rvCelulares.setAdapter(adapter);

        fabAdd.setOnClickListener(v -> {
            startActivity(new Intent(this,FormActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateDataSet();
    }
}