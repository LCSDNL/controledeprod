package com.LCSDNL.controledeproducao.dominio.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.LCSDNL.controledeproducao.dominio.entidades.Funcionario;
import com.LCSDNL.controledeproducao.dominio.entidades.Modelo;

import java.util.ArrayList;
import java.util.List;

    public class Repo_funcionario {

    private SQLiteDatabase conexao;

    public Repo_funcionario(SQLiteDatabase conexao){
        this.conexao= conexao;
    }

    public void inserir(Funcionario funcionario){
        ContentValues contentValues= new ContentValues();
        contentValues.put("nome", funcionario.nome);
        contentValues.put("cpf", funcionario.cpf);
        contentValues.put("telefone", funcionario.telefone);
        contentValues.put("valor", funcionario.valor);
        contentValues.put("cargo", funcionario.cargo);

        conexao.insertOrThrow("PESSOAS", null, contentValues);

    }

    public void excluir(int id){

        String[] parameters=new String[1];
        parameters[0]= String.valueOf(id);

        conexao.delete("PESSOAS", "ID = ?",parameters);
    }

    public void editar(Funcionario funcionario){
        ContentValues contentValues= new ContentValues();
        contentValues.put("nome", funcionario.nome);
        contentValues.put("cpf", funcionario.cpf);
        contentValues.put("telefone", funcionario.telefone);
        contentValues.put("valor", funcionario.valor);
        contentValues.put("cargo", funcionario.cargo);

        String[] parameters=new String[1];
        parameters[0]= String.valueOf(funcionario.id);

        conexao.update("PESSOAS", contentValues, "ID = ?",parameters);

    }

    public List<Funcionario> buscarTodos(){
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, nome, cpf, telefone, valor, cargo");
        sql.append("FROM PESSOAS");

        Cursor resultado= conexao.rawQuery(sql.toString(),null);
            if (resultado.getCount()>0){
                resultado.moveToFirst();
                do {
                    Funcionario func =new Funcionario();
                    func.id=resultado.getInt(resultado.getColumnIndexOrThrow("id"));
                    func.nome= resultado.getString(resultado.getColumnIndexOrThrow("nome"));
                    func.cpf= resultado.getString(resultado.getColumnIndexOrThrow("cpf"));
                    func.telefone=resultado.getString(resultado.getColumnIndexOrThrow("telefone"));
                    func.valor=resultado.getDouble(resultado.getColumnIndexOrThrow("valor"));
                    func.cargo=resultado.getString(resultado.getColumnIndexOrThrow("cargo"));
                    funcionarios.add(func);

                }while(resultado.moveToNext());

            }



        return funcionarios;
    }

    public Funcionario buscarFuncionario(int id){
        return  null;
    }
}
