package Networking;

import android.util.Log;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHOBOJIT on 6/22/2017.
 */
public class Okhttp03 implements FakeDataSource.Datainterface
{
    private static List<DataItem> listOfData;
    public static void main(String[] args) {
    Okhttp03 ok = new Okhttp03();

    FakeDataSource fake = new FakeDataSource(ok);
    }

    @Override
    public void getListofData(List<DataItem>data) {
        listOfData = data;
        for (DataItem dataonj:listOfData){
            System.out.println("Name : "+ dataonj.getName());
            System.out.println("Designation : "+ dataonj.getDesignation());
            System.out.println("Phone : "+ dataonj.getPhone());
            System.out.println("ImageURL: "+ dataonj.getImgUrl());
            System.out.println("--------------");
        }
    }
}





class FakeDataSource{
    public interface Datainterface{
        void getListofData(List<DataItem>data) throws JSONException;

    }
    public static String Url ="http://javaloverbd.000webhostapp.com/teacher_detail.txt";
    private static OkHttpClient client;
    List<DataItem>datasource;
    Datainterface datainterface;
        public FakeDataSource(Okhttp03 ok){
            client = new OkHttpClient();
            datainterface = ok;
            datasource = new ArrayList<>();
            GetData();
    }
    void GetData(){
        Request re = new Request.Builder().url(Url).build();
        client.newCall(re).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();

                try {
                    JSONObject json  = new JSONObject(s);
                    JSONArray jsr = json.getJSONArray("ece");
                    for (int i = 0 ;i<jsr.length();i++){
                        DataItem dataItem = new DataItem(jsr.getJSONObject(i).getString("name").toString(),
                                jsr.getJSONObject(i).getString("designation").toString(),
                                jsr.getJSONObject(i).getString("mob").toString(),
                                jsr.getJSONObject(i).getString("image").toString());
                        datasource.add(dataItem);

                    }

                    /*for (DataItem dataonj:datasource){
                        System.out.println("Name : "+ dataonj.getName());
                    }*/
                    System.out.println("");
                    datainterface.getListofData(datasource);

                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        });
    }

}

class DataItem{
    String name;
    String Designation;
    String phone;
    String ImgUrl;

    public DataItem(String name, String designation, String phone, String imgUrl) {
        this.name = name;
        Designation = designation;
        this.phone = phone;
        ImgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return Designation;
    }

    public String getPhone() {
        return phone;
    }

    public String getImgUrl() {
        return ImgUrl;
    }
}
