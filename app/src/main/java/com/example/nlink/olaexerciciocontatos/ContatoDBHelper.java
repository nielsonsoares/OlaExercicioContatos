package com.example.nlink.olaexerciciocontatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ContatoDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contato_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table "
            + ContratoContato.ContatoEntry.TABLE_NAME
            + "(" + ContratoContato.ContatoEntry.ID + " text primary key,"
            + ContratoContato.ContatoEntry.NOME + " text,"
            + ContratoContato.ContatoEntry.EMAIL + " text,"
            + ContratoContato.ContatoEntry.ENDERECO + " text,"
            + ContratoContato.ContatoEntry.SEXO + " text,"
            + ContratoContato.ContatoEntry.TEL_CEL + " text,"
            + ContratoContato.ContatoEntry.TEL_RES + " text,"
            + ContratoContato.ContatoEntry.TEL_COM + " text);";

    public static final String DROP_TABLE = "drop table if exists " + ContratoContato.ContatoEntry.TABLE_NAME;

    public ContatoDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i("Operações BD", "Banco de Dados criado...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.i("Operações BD", "Tabela criada...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addContato(Contatos contatos){
        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();

        values.put(ContratoContato.ContatoEntry.ID, contatos.getId());
        values.put(ContratoContato.ContatoEntry.NOME, contatos.getNome());
        values.put(ContratoContato.ContatoEntry.EMAIL, contatos.getEmail());
        values.put(ContratoContato.ContatoEntry.ENDERECO, contatos.getEndereco());
        values.put(ContratoContato.ContatoEntry.SEXO, contatos.getSexo());
        values.put(ContratoContato.ContatoEntry.TEL_CEL, contatos.getTelCel());
        values.put(ContratoContato.ContatoEntry.TEL_RES, contatos.getTelRes());
        values.put(ContratoContato.ContatoEntry.TEL_COM, contatos.getTelCom());

        db.insert(ContratoContato.ContatoEntry.TABLE_NAME, null, values);
        db.close();

        Log.i("Operações BD", "Um registro inserido...");
    }

    public List<Contatos> lerContatos(){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projections = {
                ContratoContato.ContatoEntry.ID,
                ContratoContato.ContatoEntry.NOME,
                ContratoContato.ContatoEntry.EMAIL,
                ContratoContato.ContatoEntry.ENDERECO,
                ContratoContato.ContatoEntry.SEXO,
                ContratoContato.ContatoEntry.TEL_CEL,
                ContratoContato.ContatoEntry.TEL_RES,
                ContratoContato.ContatoEntry.TEL_COM
        };

        Cursor cursor = db.query(ContratoContato.ContatoEntry.TABLE_NAME,
                projections, null, null, null,null, null);

        List<Contatos> contatos = new ArrayList();

        while (cursor.moveToNext()){
            Contatos contato = new Contatos();
            contato.setId(cursor.getString(cursor.getColumnIndex(ContratoContato.ContatoEntry.ID)));
            contato.setNome(cursor.getString(cursor.getColumnIndex(ContratoContato.ContatoEntry.NOME)));
            contato.setEmail(cursor.getString(cursor.getColumnIndex(ContratoContato.ContatoEntry.EMAIL)));
            contato.setEndereco(cursor.getString(cursor.getColumnIndex(ContratoContato.ContatoEntry.ENDERECO)));
            contato.setSexo(cursor.getString(cursor.getColumnIndex(ContratoContato.ContatoEntry.SEXO)));
            contato.setTelCel(cursor.getString(cursor.getColumnIndex(ContratoContato.ContatoEntry.TEL_CEL)));
            contato.setTelRes(cursor.getString(cursor.getColumnIndex(ContratoContato.ContatoEntry.TEL_RES)));
            contato.setTelCom(cursor.getString(cursor.getColumnIndex(ContratoContato.ContatoEntry.TEL_COM)));
            contatos.add(contato);
        }
        Contatos.setContatos(contatos);
        db.close();
        return contatos;
    }
}
