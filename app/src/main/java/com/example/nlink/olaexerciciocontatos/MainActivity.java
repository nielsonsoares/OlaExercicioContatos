package com.example.nlink.olaexerciciocontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listContatos);
        listView.setAdapter(new ContatosListAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), ContatoDetalheActivity.class);
                intent.putExtra("contato", Contatos.getContatos().get(position));
                startActivity(intent);
            }
        });

    }

    public void addNovoContato(View view){
        Intent intent = new Intent(getBaseContext(), ContatoAdicionarActivity.class);
        startActivity(intent);
    }
}
