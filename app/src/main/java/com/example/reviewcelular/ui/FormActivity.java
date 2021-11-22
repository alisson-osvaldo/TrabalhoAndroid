package com.example.reviewcelular.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reviewcelular.R;
import com.example.reviewcelular.database.CelularesDB;
import com.example.reviewcelular.database.dao.CelularDAO;
import com.example.reviewcelular.entity.Celular;

public class FormActivity extends AppCompatActivity {

    EditText etModelo;
    EditText etMarca;
    EditText etSistema;
    EditText etRam;
    Button   bSalvar;

    CelularDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etModelo = findViewById(R.id.etModelo);
        etMarca  = findViewById(R.id.etMarca);
        etSistema = findViewById(R.id.etSistema);
        etRam     = findViewById(R.id.etRam);
        bSalvar   = findViewById(R.id.bSalvar);

        dao = CelularesDB.getInstance(this).getCelularDAO();

        //receber  intent
        Intent intent = getIntent();

        //verificar se há o extra 'celular' dentro da intent recebida
        Celular edtCelular;

        if(intent.hasExtra("celular"))
        {
            edtCelular = (Celular) intent.getSerializableExtra("celular");
            etModelo.setText(edtCelular.getModelo());
            etMarca.setText(edtCelular.getMarca());
            etSistema.setText(edtCelular.getSistema());
            etRam.setText(edtCelular.getRam() + "");
        }
        else
        {
            edtCelular = null;
        }

        bSalvar.setOnClickListener(v->{

            if (etModelo.getText().toString().isEmpty() ||
            etMarca.getText().toString().isEmpty() ||
            etSistema.getText().toString().isEmpty() ||
            etRam.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                Celular c = new Celular(
                        0,
                        etModelo.getText().toString(),
                        etMarca.getText().toString(),
                        etSistema.getText().toString(),
                        Integer.parseInt(etRam.getText().toString())
                );

                if(edtCelular == null) {
                    dao.salvarCelular(c);
                } else {
                    c.setId(edtCelular.getId());
                    dao.editarCelular(c);
                }


                Toast.makeText(this, "Celular salvo!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}