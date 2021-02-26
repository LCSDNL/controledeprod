package com.LCSDNL.controledeproducao.main;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.LCSDNL.controledeproducao.R;
import com.LCSDNL.controledeproducao.database.dataOpenHelper;
import com.LCSDNL.controledeproducao.lista_funcionario.activity_Lista_Funcionarios;
import com.LCSDNL.controledeproducao.rep_modelos.activity_Lista_Modelos;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TITLLE_APPBAR = "Inicio";

    private SQLiteDatabase conexao;
    private dataOpenHelper dataOH;
    private ConstraintLayout layoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(TITLLE_APPBAR);

        abreListaModelos();
        abreListaFuncionarios();

        layoutMain = findViewById(R.id.layout_main_activity);
        criarConexao();
    }

    private void criarConexao(){
        try {

            dataOH = new dataOpenHelper(this);
            conexao = dataOH.getWritableDatabase();

            Snackbar.make(layoutMain,"Conexão criada!", Snackbar.LENGTH_LONG)
            .setAction("ok", null).show();

        }catch (SQLException exe){
            AlertDialog.Builder dlg= new AlertDialog.Builder(this);
            dlg.setTitle("erro");
            dlg.setMessage(exe.getMessage());
            dlg.setNeutralButton("ok", null);
        }
    }

    //    botoes da listas

    private void abreListaFuncionarios() {
        Button buttonFunc= findViewById(R.id.button_Funcionario);
        buttonFunc.setOnClickListener(v ->{
            listaFuncionarios();
        });
    }

    private void listaFuncionarios() {
        startActivity(new Intent(this,
                activity_Lista_Funcionarios.class));
    }


    private void abreListaModelos(){
        Button buttonModelos = findViewById(R.id.button_modelo);
        buttonModelos.setOnClickListener(v -> {
            listaModelos();
//
        });
    }
    private void listaModelos() {
        startActivity(new Intent(this,
                activity_Lista_Modelos.class));
    }

}