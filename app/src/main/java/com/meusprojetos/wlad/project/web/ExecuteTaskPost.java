package com.meusprojetos.wlad.project.web;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.meusprojetos.wlad.project.activity.MainActivity;
import com.meusprojetos.wlad.project.model.Imovel;

import java.util.HashMap;
import java.util.Map;

public class ExecuteTaskPost extends AsyncTask<Imovel, Void, Imovel> {

    private MainActivity activity;
    private ProgressDialog progress;

    String URL = "http://192.168.0.200:8080/WebServiceProject/rest/imobilit/imovel";

    public ExecuteTaskPost(MainActivity activity) {
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
            Thread.sleep(500);
            Map<String, String> parametros = new HashMap<>();

            Imovel imovel = imoveis[0];
            parametros.put("obs", imovel.getObs());
            parametros.put("tipoImovel", imovel.getTipoImovel());
            parametros.put("tipoNegociacao", imovel.getTipoNegociacao());
            parametros.put("valor", String.valueOf(imovel.getValor()));
            parametros.put("proprietario", imovel.getProprietario());
            parametros.put("cidade", String.valueOf(imovel.getCidade()));
            parametros.put("ocupacao", imovel.getOcupacao());
            parametros.put("qtdBanheiro", String.valueOf(imovel.getQtdBanheiro()));
            parametros.put("qtdSuite", String.valueOf(imovel.getQtdSuite()));
            parametros.put("qtdQuartos", String.valueOf(imovel.getQtdQuartos()));
            parametros.put("area", String.valueOf(imovel.getArea()));

            String[] repostaPost = Requisicoes.post(URL, parametros);
            Log.e("Teste", repostaPost[1]);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

            return gson.fromJson(repostaPost[1], Imovel.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void onPostExecute(Imovel feed) {
        progress.dismiss();
        activity.adicionarImovel(feed);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
