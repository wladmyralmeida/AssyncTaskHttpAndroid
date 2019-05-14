package com.meusprojetos.wlad.project.web;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.meusprojetos.wlad.project.activity.ListarImoveisActivity;
import com.meusprojetos.wlad.project.activity.MainActivity;
import com.meusprojetos.wlad.project.model.Imovel;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class ExecuteTaskGet extends AsyncTask<Imovel, Void, Imovel> {

    private ListarImoveisActivity activity;
    private ProgressDialog progress;

    String URL = "http://192.168.0.200:8080/WebServiceProject/rest/imobilit/imovel";

    public ExecuteTaskGet(ListarImoveisActivity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(activity, "Aguarde.",
                "Processando..!", true);
        progress.show();
    }

    protected Imovel doInBackground(Imovel... imoveis) {

        try {

            String[] respostaGet = Requisicoes.get(URL);

            Log.e("Teste", respostaGet[1]);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

            return gson.fromJson(respostaGet[1], Imovel.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void onPostExecute(Imovel feed) {
        progress.dismiss();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
