package com.LCSDNL.controledeproducao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dataOpenHelper extends SQLiteOpenHelper {

    public dataOpenHelper(@Nullable Context context) {
        super(context, "dados", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptDLL.getCreateTableFuncionario());
        db.execSQL(ScriptDLL.getCreateTableModelos());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
