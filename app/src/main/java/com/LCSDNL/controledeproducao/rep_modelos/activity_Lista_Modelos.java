package com.LCSDNL.controledeproducao.rep_modelos;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.LCSDNL.controledeproducao.R;

public class activity_Lista_Modelos extends AppCompatActivity {

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
        startActivity(new Intent(this, activity_Cadastro_Modelo.class));
    }
}
//      FAB end