package com.example.nlink.olaexerciciocontatos;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class SplashScreenActivity extends AppCompatActivity {

    private TextView txtPergunta;
    private Button btnNao, btnSim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if(verificaPrimeiroAcesso()){
            txtPergunta = findViewById(R.id.txtPergunta);
            txtPergunta.setVisibility(View.VISIBLE);
            btnSim = findViewById(R.id.btnSim);
            btnSim.setVisibility(View.VISIBLE);
            btnNao = findViewById(R.id.btnNao);
            btnNao.setVisibility(View.VISIBLE);
        }else {
            irPaginaPrincipal();
        }
    }

    private boolean verificaPrimeiroAcesso() {

        return true;
    }

    public void carregaContatos(View view){
        btnSim.setVisibility(View.GONE);
        btnNao.setVisibility(View.GONE);
        TarefaCarregaContatos carregaContatos = new TarefaCarregaContatos(this, txtPergunta);
        try {
            carregaContatos.execute(new URL("http://10.0.2.2:80/conecta.php"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void irPaginaPrincipal(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void irPaginaPrincipal(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
