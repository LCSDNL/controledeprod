package com.LCSDNL.controledeproducao.cadastroActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.LCSDNL.controledeproducao.R;

public class cadastro_Modelo_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__cadastro__modelo);
        setTitle(getString(R.string.titulo_cadastro_de_modelos_activity));
    }
}