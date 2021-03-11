package com.LCSDNL.controledeproducao.cadastroActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.LCSDNL.controledeproducao.R;
import com.LCSDNL.controledeproducao.database.dataOpenHelper;
import com.LCSDNL.controledeproducao.dominio.entidades.Modelo;
import com.LCSDNL.controledeproducao.dominio.repositorio.Repo_modelo;

public class Cadastro_Modelo_Activity extends AppCompatActivity {

    private EditText modelo;
    private EditText tipo;
    private EditText valor;
    private boolean notValido;

    private Repo_modelo repo_modelo;
    private Modelo mod;


    private SQLiteDatabase conexao;
    private dataOpenHelper dataOH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__cadastro__modelo);
        setTitle(getString(R.string.titulo_cadastro_de_modelos_activity));
        criarConexao();
        preencheCampos();
        botaoSalvar();
        botaoCancelar();


    }

    private void botaoSalvar() {
        Button buttonSalvar = findViewById(R.id.buttonSalvarModelo);
        buttonSalvar.setOnClickListener(v->{
            validarCampos();
            if (!notValido){
                salvar();
            }
        });
    }

    private void salvar() {
        try {
            repo_modelo.inserir(mod);
            Toast.makeText(this, "salvo", Toast.LENGTH_LONG).show();
            finish();
        }catch (SQLException e){
            android.app.AlertDialog.Builder dlg= new android.app.AlertDialog.Builder(this);
            dlg.setTitle("erro");
            dlg.setMessage(e.getMessage());
            dlg.setNeutralButton("ok", null);
            dlg.show();
        }

    }


    private void botaoCancelar() {
        Button buttonCancelar=findViewById(R.id.buttonCancelarModelo);
        buttonCancelar.setOnClickListener(v ->{
            Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void preencheCampos() {
        modelo= findViewById(R.id.editTextModeloReferencia);
        tipo= findViewById(R.id.editTextModeloTipo);
        valor= findViewById(R.id.editTextModeloValor);
    }

    private void validarCampos(){
        this.mod= new Modelo();
        this.notValido= false;
        String vModelo  = modelo.getText().toString();
        String vTipo    = tipo.getText().toString();
        String vValor   =valor.getText().toString();


        if (isVazio(vModelo)){
            modelo.requestFocus();
            this.notValido= true;
            }else
                if (isVazio(vTipo)){
                    tipo.requestFocus();
                    this.notValido=true;
                } else
                    if (isVazio(vValor)){
                        valor.requestFocus();
                        this.notValido=true;
                    }else {
                        this.mod.modelo=vModelo;
                        this.mod.tipo=vTipo;
                        this.mod.valor=Double.parseDouble(vValor);
                    }


        if (this.notValido){
             AlertDialog.Builder dlg= new AlertDialog.Builder(this);
             dlg.setTitle(R.string.titulo_Aviso);
             dlg.setMessage(R.string.aviso_EmptyField);
             dlg.setNeutralButton(R.string.OK, null);
             dlg.show();
         }
    }

    public boolean isVazio(String campo){
        boolean resul= (TextUtils.isEmpty(campo) || campo.trim().isEmpty());
        return resul;
    }


    private void criarConexao() {
        try {

            dataOH = new dataOpenHelper(this);
            conexao = dataOH.getWritableDatabase();

            repo_modelo = new Repo_modelo(conexao);

        } catch (SQLException exe) {
            android.app.AlertDialog.Builder dlg = new android.app.AlertDialog.Builder(this);
            dlg.setTitle("erro");
            dlg.setMessage(exe.getMessage());
            dlg.setNeutralButton("ok", null);

        }
    }

}
