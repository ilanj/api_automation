package com.auxolabs.run;

import com.auxolabs.configs.ResponseModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.lang.reflect.Type;

public class ParseGet {
    private static final Type resType = new TypeToken<ResponseModel>() {
    }.getType();

    public static void main(String[] args) {
        try
        {
            ResponseModel rm;
            CloseableHttpClient httpClient=HttpClients.createDefault();
            //CloseableHttpClient httpClient = HttpClients.createDefault();
            String endpoint1 = "http://localhost:8443/hi";
           // HttpGet httpGet = new HttpPost(endpoint1);
            HttpGet httpGet=new HttpGet(endpoint1);
            //httpGet.addHeader("Content-type", "application/json");

            HttpResponse httpResponse;
            int currRetryCount = 0;
            httpResponse = httpClient.execute(httpGet);

            System.out.println("httpresponse="+httpResponse);
            HttpEntity httpEntity = httpResponse.getEntity();
            System.out.println("HTTP Entity="+httpEntity);
            String entityOutput = EntityUtils.toString(httpEntity);
            System.out.println("entity output"+entityOutput);
            Gson gson = new Gson();
            ResponseModel rm1 = gson.fromJson(entityOutput,resType);
            System.out.println("response model rm1="+rm1);//important which brings all json
            String n1=rm1.getN1();
            String check=rm1.getCheck();
            String id1=rm1.getId1();
            String n2=rm1.getN2();//not in original api
            System.out.println("\nid1="+id1+"\nn1="+n1+"\ncheck="+check+"\nn2="+n2);
            System.out.println(rm1.getA());
            System.out.println(rm1.getHm());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
