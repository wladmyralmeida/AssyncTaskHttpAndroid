package com.meusprojetos.wlad.project.web;

import android.util.Log;

import com.meusprojetos.wlad.project.model.Imovel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ch.boye.httpclientandroidlib.HttpEntity;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.NameValuePair;
import ch.boye.httpclientandroidlib.client.entity.UrlEncodedFormEntity;
import ch.boye.httpclientandroidlib.client.methods.HttpDelete;
import ch.boye.httpclientandroidlib.client.methods.HttpGet;
import ch.boye.httpclientandroidlib.client.methods.HttpPost;
import ch.boye.httpclientandroidlib.client.methods.HttpPut;
import ch.boye.httpclientandroidlib.impl.client.HttpClientBuilder;
import ch.boye.httpclientandroidlib.message.BasicNameValuePair;

/**
 * @author wladm
 */
public class Requisicoes {

    public static String[] get(String url) {
        String[] resposta = new String[2];
        try {
            //Tipo de requisicao
            HttpGet get = new HttpGet(url);
            //Faz requisicao e armazena a resposta
            HttpResponse response = HttpClientBuilder.create().build().execute(get);
            //Recebe o corpo da resposta
            HttpEntity entity = response.getEntity();
            //Le o conteudo da resposta
            InputStream is = entity.getContent();
            //Código da resposta
            resposta[0] = String.valueOf(response.getStatusLine().getStatusCode());
            //Le o conteudo da resposta
            resposta[1] = toString(is);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resposta;
    }

    //177.70.1.254/lib.rar
    public static String[] post(String url, Map<String, String> parametros) {
        String[] resposta = new String[2];
        try {
            HttpPost post = new HttpPost(url);
            //Armazena no corpo da requisicao
            List<NameValuePair> valores = new ArrayList<>();
            for (String key : parametros.keySet()) {
                valores.add(new BasicNameValuePair(key, parametros.get(key)));
            }
            //No formato URL ENCODED FORM
            post.setEntity(new UrlEncodedFormEntity(valores));
            HttpResponse response = HttpClientBuilder.create().build().execute(post);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            resposta[0] = String.valueOf(response.getStatusLine().getStatusCode());
            resposta[1] = toString(is);
        } catch (Exception ex) {
            Log.e("Teste", Log.getStackTraceString(ex));
        }
        return resposta;
    }

    public static String toString(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int lidos;
        while ((lidos = inputStream.read(bytes)) > 0) {
            baos.write(bytes, 0, lidos);
        }
        return new String(baos.toByteArray());
    }

    public static String delete(String url) {
        try {
            String[] resposta = new String[2];
            HttpDelete request = new HttpDelete(url);
            HttpResponse res = HttpClientBuilder.create().build().execute(request);
            HttpEntity entity = res.getEntity();

            String content = res.getEntity().toString();

            InputStream is = entity.getContent();
            resposta[0] = String.valueOf(res.getStatusLine().getStatusCode());
            resposta[1] = toString(is);

            return content;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //177.70.1.254/lib.rar
    public static String[] put(String url, Map<String, String> parametros) {
        String[] resposta = new String[2];
        try {
            HttpPut put = new HttpPut(url + "?idImovel=" + parametros.get(Imovel.class.hashCode()));
            //Armazena no corpo da requisicao
            List<NameValuePair> valores = new ArrayList<>();
            for (String key : parametros.keySet()) {
                valores.add(new BasicNameValuePair(key, parametros.get(key)));
            }
            //No formato URL ENCODED FORM
            put.setEntity(new UrlEncodedFormEntity(valores));
            HttpResponse response = HttpClientBuilder.create().build().execute(put);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            resposta[0] = String.valueOf(response.getStatusLine().getStatusCode());
            resposta[1] = toString(is);
        } catch (Exception ex) {
            Log.e("Teste", Log.getStackTraceString(ex));
        }
        return resposta;
    }

}
