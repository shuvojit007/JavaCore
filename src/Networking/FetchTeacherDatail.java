package Networking;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by SHOBOJIT on 6/19/2017.
 */
public class FetchTeacherDatail {
    private static Scanner in = new Scanner(System.in);
    private static String link = "http://javaloverbd.000webhostapp.com/teacher_detail.txt";
    private static String result ;
    public static void main(String[] args) throws IOException, JSONException {
        FetchTeacherDatail teacherDatail = new FetchTeacherDatail();
        teacherDatail.URL_Connection(link);

        if (!result.isEmpty()){
         /*   teacherDatail.GetDataFromJSONFILE(result,"cse");
            teacherDatail.GetDptLIStFromJSONFILE(result);*/
            for (; ; ){
                System.out.println("Your Dpt List ");
                teacherDatail.GetDptLIStFromJSONFILE(result);
                System.out.print("Please Choose your dpt : " );
                String dpt  = in.next();
                teacherDatail.GetDataFromJSONFILE(result,dpt);
            }
        }else {
            System.out.println("No Data Found");
        }
    }

    public void URL_Connection(String u) throws IOException, JSONException {
        URL url = new URL(u);
        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();
        StringBuilder sb = new StringBuilder();
        int data = input.read();
        while(data != -1){
            sb.append((char)data);
            //System.out.print((char) data);
            data = input.read();
        }
         result = sb.toString();
        input.close();
        //System.out.println(result);
    }

    public void GetDataFromJSONFILE(String s,String dpt) throws JSONException {
        JSONObject jsb = new JSONObject(result);
        // JSONObject jsb2 = jsb.getJSONObject("cse");
        JSONArray jsr =jsb.getJSONArray(dpt);
        for (int i = 0 ;i<jsr.length();i++){
            System.out.println("Name : "+jsr.getJSONObject(i).getString("name") );
            System.out.println("Designation: "+jsr.getJSONObject(i).getString("designation") );
            System.out.println("Mobile : "+jsr.getJSONObject(i).getString("mob") );
            System.out.println("Image : "+jsr.getJSONObject(i).getString("image") );
            System.out.println("------------");
        }
    }



    public void GetDptLIStFromJSONFILE(String s) throws JSONException {
        JSONObject jsb = new JSONObject(result);
        System.out.println(jsb.names());

    }

}
