package com.LCSDNL.controledeproducao.main;

import android.content.Intent;
import android.os.Bundle;

import com.LCSDNL.controledeproducao.R;
import com.LCSDNL.controledeproducao.lista_funcionario.activity_Lista_Funcionarios;
import com.LCSDNL.controledeproducao.rep_modelos.activity_Lista_Modelos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TITLLE_APPBAR = "Inicio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(TITLLE_APPBAR);

        abreListaModelos();
        abreListaFuncionarios();
    }

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









//    ===============================================================================================
//    depois eu vejo se precisa ou nao
//    ===============================================================================================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}