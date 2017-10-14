package br.com.fiap.appjobcomb;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o xml do Slash Screeen Activity
        setContentView(R.layout.activity_splash_screen);

        // Executa o Splash e chama a tela de login apos o delay de 1200
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {

                chamarLogin();
            }
        }, 1200);
    }

    private void chamarLogin() {

        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
        finish();
    }
}
