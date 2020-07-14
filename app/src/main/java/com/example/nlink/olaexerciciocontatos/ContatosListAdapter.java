package com.example.nlink.olaexerciciocontatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ContatosListAdapter extends BaseAdapter {

    private List<Contatos> contatosList;
    private Context context;

    public ContatosListAdapter(Context context){
        this.context = context;
        ContatoDBHelper dbHelper = new ContatoDBHelper(context);
        this.contatosList = dbHelper.lerContatos();
    }

    @Override
    public int getCount() {
        return contatosList.size();
    }

    @Override
    public Object getItem(int position) {
        return contatosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contatos contato = contatosList.get(position);

        View view = LayoutInflater.from(context).inflate(R.layout.contato_lista_adapter, parent, false);

        TextView t = view.findViewById(R.id.txtListContato);
        t.setText(contato.toString());

        return view;
    }
}
