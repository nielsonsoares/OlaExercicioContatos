package com.example.nlink.olaexerciciocontatos;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TarefaCarregaContatos extends AsyncTask <URL, Void, String> {

    private TextView textView;
    private SplashScreenActivity context;

    public TarefaCarregaContatos(SplashScreenActivity context, TextView textView){
        this.textView = textView;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("Carregando Contatos...");
        Log.i("TESTE1", "teste");
    }

    @Override
    protected String doInBackground(URL... urls) {
        HttpURLConnection con = null;
        try {

            con = (HttpURLConnection) urls[0].openConnection();
            int status = con.getResponseCode();

            if (status == 200){

                InputStream stream =
                        new BufferedInputStream(con.getInputStream());
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(stream)
                );

                String contatoJSON = "";
                String inputString;
                while ((inputString = reader.readLine()) != null) {
                    contatoJSON += inputString;
                }

                Log.i("TESTE", contatoJSON);

                //List<Contatos> contatos = new ArrayList();
                ContatoDBHelper dbHelper = new ContatoDBHelper(context);

                /*JSONObject jsonObject = new JSONObject(contatoJSON);
                JSONArray contatosArray = jsonObject.getJSONArray("contacts");
                for (int i = 0; i < contatosArray.length(); i++){
                    JSONObject c = contatosArray.getJSONObject(i);
                    Contatos contato = new Contatos();
                    contato.setId(c.getString("id"));
                    contato.setNome(c.getString("name"));
                    contato.setEmail(c.getString("email"));
                    contato.setEndereco(c.getString("address"));
                    contato.setSexo(c.getString("gender"));
                    JSONObject telefones = c.getJSONObject("phone");
                    contato.setTelCel(telefones.getString("mobile"));
                    contato.setTelRes(telefones.getString("home"));
                    contato.setTelCom(telefones.getString("office"));
                    //contatos.add(contato);
                    dbHelper.addContato(contato);
                }*/
                dbHelper.close();
                //Contatos.setContatos(contatos);

                //Log.i("JSON", ""+contatos.size());

            }
            else{
                Log.i("JSON", "Falha...");
                return "Falha ao acessar os contatos!";
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (con!=null)
                con.disconnect();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //textView.setText("Ok!");
        //context.irPaginaPrincipal();
    }
}
