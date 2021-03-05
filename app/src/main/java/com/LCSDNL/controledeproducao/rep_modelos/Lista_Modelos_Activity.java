package com.LCSDNL.controledeproducao.rep_modelos;

import android.content.Intent;
import android.os.Bundle;

import com.LCSDNL.controledeproducao.cadastroActivity.Cadastro_Modelo_Activity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.LCSDNL.controledeproducao.R;

public class Lista_Modelos_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__lista__modelos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.titulo_lista_de_modelos_activity));

        fabAddModelo();
    }




//      FAB start
    private void fabAddModelo() {
        FloatingActionButton fab = findViewById(R.id.fab_add_modelo);
        fab.setOnClickListener(v -> {
            addModelo();
        });
    }

    private void addModelo() {
        startActivity(new Intent(this, Cadastro_Modelo_Activity.class));
    }
}
//      FAB end