package com.LCSDNL.controledeproducao.cadastroActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.LCSDNL.controledeproducao.R;

public class Cadastro_Funcionario_Activity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText telefone;
    private EditText valor;
    private EditText cargo;
    private boolean notValido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_funcionario);
        setTitle(getString(R.string.titulo_cadastro_de_funcionarios_activity));

        preencheCampos();
        botaoSalvar();
        botaoCancelar();

    }

    private void botaoSalvar() {
        Button buttonSalvar = findViewById(R.id.buttonSalvarFuncionario);
        buttonSalvar.setOnClickListener(v -> {
            validarCampos();
            if (!notValido){
                salvar();}
        });
    }

    private void salvar() {

        Toast.makeText(this, "salvo", Toast.LENGTH_LONG).show();
        finish();
    }


    private void botaoCancelar() {
        Button buttonCancelar= findViewById(R.id.buttonCancelarFuncionario);
        buttonCancelar.setOnClickListener(v ->{
            Toast.makeText(this, "Cancelado!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void preencheCampos() {
        nome     = findViewById(R.id.editTextFuncionarioNome);
        cpf      = findViewById(R.id.editTextFuncionarioCPF);
        telefone = findViewById(R.id.editTextFuncionarioTelefone);
        valor    = findViewById(R.id.editTextFuncionarioValor);
        cargo    = findViewById(R.id.editTextFuncionarioCargo);

    }

    private void validarCampos(){
        notValido= false;
        String vNome = nome.getText().toString() ;
        String vCPF = cpf.getText().toString();
        String vTelefone= telefone.getText().toString();
        String vValor= valor.getText().toString();
        String vCargo= cargo.getText().toString();


        if (isVazio(vNome)){
            nome.requestFocus();
            notValido =true;
        }else
            if(isVazio(vCPF)){
                cpf.requestFocus();
                notValido =true;
            }else
                if(isVazio(vTelefone)){
                    telefone.requestFocus();
                    notValido =true;
                }else
                    if (isVazio(vValor)){
                        valor.requestFocus();
                        notValido =true;
                    }else
                        if (isVazio(vCargo)) {
                            cargo.requestFocus();
                            notValido = true;
                        }

        if (notValido){
            AlertDialog.Builder dlg= new AlertDialog.Builder(this);
            dlg.setTitle(R.string.titulo_Aviso);
            dlg.setMessage(R.string.aviso_EmptyField);
            dlg.setNeutralButton(R.string.OK, null);
            dlg.show();
        }
    }

    private boolean isVazio (String campo){
        boolean resul = (TextUtils.isEmpty(campo) || campo.trim().isEmpty());
        return  resul;
    }

}