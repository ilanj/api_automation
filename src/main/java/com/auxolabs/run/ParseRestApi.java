package com.auxolabs.run;

import com.auxolabs.configs.ResponseModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class ParseRestApi {
    private static final Type resType = new TypeToken<ResponseModel>() {
    }.getType();
    public static void main(String[] args) {

        try {
            ResponseModel rm;
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String endpoint1 = "http://localhost:8085/CaptureAutomationResource/run";
            HttpPost httpPost = new HttpPost(endpoint1);
            JSONObject json = new JSONObject();
            json.put("recipients", "ilanchezhianj.qa@auxolabs.in");
            json.put("version", "v456");
            json.put("environment", "Stage");
            StringEntity params = new StringEntity(json.toString());
                httpPost.addHeader("Content-type", "application/json");
            httpPost.setEntity(params);
            //httpPost.setEntity(new StringEntity(JsonFormat.printer().print(taskRequestModel)));

            HttpResponse httpResponse;
            int currRetryCount = 0;
            httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            String entityOutput = EntityUtils.toString(httpEntity);
            Gson gson = new Gson();
            ResponseModel rm1 = gson.fromJson(entityOutput,resType);
            System.out.println(rm1);// this will print all the json data
            String id1=rm1.getId1();
            String n1=rm1.getN1();
            String check=rm1.getCheck();
            System.out.println("id1="+id1+"\nn1="+n1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
