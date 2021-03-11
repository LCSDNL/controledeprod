package com.LCSDNL.controledeproducao.cadastroActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.LCSDNL.controledeproducao.R;
import com.LCSDNL.controledeproducao.database.dataOpenHelper;
import com.LCSDNL.controledeproducao.dominio.entidades.Funcionario;
import com.LCSDNL.controledeproducao.dominio.repositorio.Repo_funcionario;

public class Cadastro_Funcionario_Activity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText telefone;
    private EditText valor;
    private EditText cargo;

    private boolean notValido;
    private Repo_funcionario repo_funcionario;
    private Funcionario funcionario;

    private SQLiteDatabase conexao;
    private dataOpenHelper dataOH;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_funcionario);
        setTitle(getString(R.string.titulo_cadastro_de_funcionarios_activity));
        criarConexao();
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
        try{
            repo_funcionario.inserir(funcionario);

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
        this.funcionario = new Funcionario();
        this.notValido = false;
        String vNome    = nome.getText().toString() ;
        String vCPF     = cpf.getText().toString();
        String vTelefone= telefone.getText().toString();
        String vValor   = valor.getText().toString();
        String vCargo   = cargo.getText().toString();


        if (isVazio(vNome)){
            nome.requestFocus();
            this.notValido =true;
        }else
            if(isVazio(vCPF)){
                cpf.requestFocus();
                this.notValido =true;
            }else
                if(isVazio(vTelefone)){
                    telefone.requestFocus();
                    this.notValido =true;
                }else
                    if (isVazio(vValor)){
                        valor.requestFocus();
                        this.notValido =true;
                    }else
                        if (isVazio(vCargo)) {
                            cargo.requestFocus();
                            this.notValido = true;
                        }else{
                            funcionario.nome      = vNome;
                            funcionario.cpf       = vCPF;
                            funcionario.telefone  = vTelefone;
                            funcionario.valor     = Double.parseDouble(vValor);
                            funcionario.cargo     = vCargo;
                        }

        if (this.notValido){
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


    private void criarConexao() {
        try {

            dataOH = new dataOpenHelper(this);
            conexao = dataOH.getWritableDatabase();
            repo_funcionario = new Repo_funcionario(conexao);

        } catch (SQLException exe) {
            android.app.AlertDialog.Builder dlg = new android.app.AlertDialog.Builder(this);
            dlg.setTitle("erro");
            dlg.setMessage(exe.getMessage());
            dlg.setNeutralButton("ok", null);

        }
    }


}