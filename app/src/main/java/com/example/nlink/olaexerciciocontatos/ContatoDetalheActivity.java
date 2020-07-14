package com.example.nlink.olaexerciciocontatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContatoDetalheActivity extends AppCompatActivity {

    private Contatos contato;
    private Button btnDeletar, btnAlterarSalvar;
    private TextView txtContatoNome, txtContatoID, txtContatoEmail, txtContatoEndereco, txtContatoSexo, txtContatoTelCel, txtContatoTelRes, txtContatoTelCom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_detalhe);

        btnAlterarSalvar = findViewById(R.id.btnAlterarSalvar);
        btnDeletar = findViewById(R.id.btnDeletar);

        txtContatoNome = findViewById(R.id.txtContatoNome);
        txtContatoID = findViewById(R.id.txtContatoID);
        txtContatoEmail = findViewById(R.id.txtContatoEmail);
        txtContatoEndereco = findViewById(R.id.txtContatoEndereco);
        txtContatoSexo = findViewById(R.id.txtContatoSexo);
        txtContatoTelCel = findViewById(R.id.txtContatoTelCel);
        txtContatoTelRes = findViewById(R.id.txtContatoTelRes);
        txtContatoTelCom = findViewById(R.id.txtContatoTelCom);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        contato = (Contatos) getIntent().getSerializableExtra("contato");

        txtContatoNome.setText(contato.getNome());
        txtContatoID.setText(contato.getId());
        txtContatoEmail.setText(contato.getEmail());
        txtContatoEndereco.setText(contato.getEndereco());
        txtContatoSexo.setText(contato.getSexo());
        txtContatoTelCel.setText(contato.getTelCel());
        txtContatoTelRes.setText(contato.getTelRes());
        txtContatoTelCom.setText(contato.getTelCom());
    }

    public void alterarSalvar(View view){
        Log.i("Contato", btnAlterarSalvar.getText().toString());
        if (btnAlterarSalvar.getText().toString().equals("alterar")){
            txtContatoEmail.setEnabled(true);
            txtContatoEndereco.setEnabled(true);
            txtContatoSexo.setEnabled(true);
            txtContatoTelCel.setEnabled(true);
            txtContatoTelRes.setEnabled(true);
            txtContatoTelCom.setEnabled(true);
            btnAlterarSalvar.setText("salvar");
        }else{
            Toast.makeText(this, "Contato alterado!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void deletar(View view){
        Toast.makeText(this, "Contato deletado!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
