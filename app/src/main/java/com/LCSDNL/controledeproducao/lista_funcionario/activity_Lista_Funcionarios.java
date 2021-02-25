package com.LCSDNL.controledeproducao.lista_funcionario;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.LCSDNL.controledeproducao.R;

public class activity_Lista_Funcionarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__lista__funcionarios);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.titulo_lista_funcionarios_activity));

        fabAddFuncionario();


    }



// FAB start
    private void fabAddFuncionario() {
        FloatingActionButton fab = findViewById(R.id.fab_add_funcionario);
        fab.setOnClickListener(v -> {
            addFuncionario();
        });
    }

    private void addFuncionario() {
        startActivity(new Intent(this, activity_Cadastro_Funcionario.class));
    }
}
// FAB end

