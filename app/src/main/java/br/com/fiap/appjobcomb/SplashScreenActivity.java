package br.com.fiap.appjobcomb;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {

                chamarLogin();
            }
        }, 1200);
    }

    private void chamarLogin() {

        Intent intent = new Intent(this, ListaUsuariosActivity.class);
        //Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
