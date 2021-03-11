package com.LCSDNL.controledeproducao.lista_funcionario;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.LCSDNL.controledeproducao.cadastroActivity.Cadastro_Funcionario_Activity;
import com.LCSDNL.controledeproducao.database.dataOpenHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.LCSDNL.controledeproducao.R;
import com.google.android.material.snackbar.Snackbar;

public class Lista_Funcionarios_Activity extends AppCompatActivity {

    private SQLiteDatabase conexao;
    private dataOpenHelper dataOH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__lista__funcionarios);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.titulo_lista_funcionarios_activity));

        criarConexao();

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
        startActivity(new Intent(this, Cadastro_Funcionario_Activity.class));
    }

// FAB end

    private void criarConexao() {
        try {

            dataOH = new dataOpenHelper(this);
            conexao = dataOH.getWritableDatabase();


        } catch (SQLException exe) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("erro");
            dlg.setMessage(exe.getMessage());
            dlg.setNeutralButton("ok", null);

        }
    }


}

