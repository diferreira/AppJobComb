package br.com.fiap.appjobcomb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void logar(View v){
        Intent intentHome = new Intent(this, PrincipalActivity.class);
        startActivity(intentHome);

    }

    public void primeiroAcesso(View v){
        Intent intentPrimeiroAcesso = new Intent(this, FormularioActivity.class);
        startActivity(intentPrimeiroAcesso);


    }

}
