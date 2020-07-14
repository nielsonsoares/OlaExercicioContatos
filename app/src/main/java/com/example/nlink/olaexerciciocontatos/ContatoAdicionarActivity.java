package com.example.nlink.olaexerciciocontatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ContatoAdicionarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_adicionar);
    }

    public void addNovoContato(View view){
        Toast.makeText(this, "Contato adicionado!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
