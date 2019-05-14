package com.meusprojetos.wlad.project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class DefaultActivity extends AppCompatActivity {

    protected void imprimirMensagem(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void iniciarActivity(Class activity){
        Intent intent = new Intent( this, activity);
        startActivity( intent );
    }
}
