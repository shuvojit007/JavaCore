package Networking;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by SHOBOJIT on 6/19/2017.
 */
public class OkHttp01 {
    private static String url = "http://javaloverbd.000webhostapp.com/teacher_detail.txt";
    public static void main(String[] args) throws IOException {
    OkHttp01 ok = new OkHttp01();
    String result = ok.GetDATA(url);
    System.out.println(result);
    }
    public String GetDATA(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        }
    }

