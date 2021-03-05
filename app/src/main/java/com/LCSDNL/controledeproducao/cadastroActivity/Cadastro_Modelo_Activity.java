package com.LCSDNL.controledeproducao.cadastroActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.LCSDNL.controledeproducao.R;

public class Cadastro_Modelo_Activity extends AppCompatActivity {

    private EditText modelo;
    private EditText tipo;
    private EditText valor;
    private boolean notValido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__cadastro__modelo);
        setTitle(getString(R.string.titulo_cadastro_de_modelos_activity));

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
        Toast.makeText(this, "salvo", Toast.LENGTH_LONG).show();
        finish();
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
        notValido= false;
        String vModelo= modelo.getText().toString();
        String vTipo= tipo.getText().toString();
        String vValor=valor.getText().toString();

        if (isVazio(vModelo)){
            modelo.requestFocus();
            notValido= true;
            }else
                if (isVazio(vTipo)){
                    tipo.requestFocus();
                    notValido=true;
                } else
                    if (isVazio(vValor)){
                        valor.requestFocus();
                        notValido=true;
                    }


        if (notValido){
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

}