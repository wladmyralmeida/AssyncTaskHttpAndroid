package com.meusprojetos.wlad.project.activity;

import android.os.Bundle;
import android.view.View;

import com.meusprojetos.wlad.project.R;

public class MenuActivity extends DefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void abrirFormulario(View view) {
       iniciarActivity( MainActivity.class );
    }

    public void abrirListagem(View view) {
        iniciarActivity( ListarImoveisActivity.class );
    }
}
