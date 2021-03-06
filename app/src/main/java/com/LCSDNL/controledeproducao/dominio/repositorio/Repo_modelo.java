package com.LCSDNL.controledeproducao.dominio.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.LCSDNL.controledeproducao.dominio.entidades.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Repo_modelo {

    private SQLiteDatabase conexao;

    public Repo_modelo(SQLiteDatabase conexao){
        this.conexao=conexao;
    }

    public void inserir(Modelo modelo){
        ContentValues contentValues= new ContentValues();
        contentValues.put("modelo", modelo.modelo);
        contentValues.put("tipo", modelo.tipo);
        contentValues.put("valor", modelo.valor);

        conexao.insertOrThrow("modelos", null, contentValues);

    }

    public void excluir(int id){
        String[] parameters= new String[1];
        parameters[0]= String.valueOf(id);

        conexao.delete("modelos", "ID= ?", parameters);

    }

    public void editar(Modelo modelo){
        ContentValues contentValues= new ContentValues();
        contentValues.put("modelo", modelo.modelo);
        contentValues.put("tipo", modelo.tipo);
        contentValues.put("valor", modelo.valor);

        String[] parameters= new String[1];
        parameters[0]= String.valueOf(modelo.id);

        conexao.update("modelos", contentValues, "ID= ?", parameters);
    }

    public List<Modelo> buscarTodos(){

        List<Modelo> modelos= new ArrayList<Modelo>();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT id, modelo, tipo, valor");
            sql.append("FROM modelos");


        Cursor resultado= conexao.rawQuery(sql.toString(), null);

        if (resultado.getCount()>0) {
            resultado.moveToFirst();

            do {
                Modelo mod =new Modelo();
                mod.id=resultado.getInt( resultado.getColumnIndexOrThrow("id"));
                mod.modelo=resultado.getString( resultado.getColumnIndexOrThrow("modelo"));
                mod.tipo=resultado.getString( resultado.getColumnIndexOrThrow("tipo"));
                mod.valor=resultado.getDouble(resultado.getColumnIndexOrThrow("valor"));
                modelos.add(mod);

            }while (resultado.moveToNext());
        }

        return modelos;
    }

    public  Modelo bucarModelo(int id){

        Modelo modelos = new Modelo();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, modelo, tipo, valor");
        sql.append("FROM modelos");
        sql.append("WHERE ID = ?");

        String[] parameters= new String[1];
        parameters[0]= String.valueOf(id);

        Cursor resultado = conexao.rawQuery(sql.toString(), parameters);

            if (resultado.getCount()>0) {
                resultado.moveToFirst();

                Modelo mod = new Modelo();
                modelos.id = resultado.getInt(resultado.getColumnIndexOrThrow("id"));
                modelos.modelo = resultado.getString(resultado.getColumnIndexOrThrow("modelo"));
                modelos.tipo = resultado.getString(resultado.getColumnIndexOrThrow("tipo"));
                modelos.valor = resultado.getDouble(resultado.getColumnIndexOrThrow("valor"));
            }
        return null;
    }

}
