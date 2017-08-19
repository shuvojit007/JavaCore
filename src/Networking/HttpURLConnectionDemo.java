package Networking;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by SHOBOJIT on 6/19/2017.
 */
public class HttpURLConnectionDemo {
    public static void main(String[] args){
        try{
            URL url=new URL("http://siu.edu.bd/category/notice/");
            HttpURLConnection huc=(HttpURLConnection)url.openConnection();
            for(int i=1;i<=8;i++){
                System.out.println(huc.getHeaderFieldKey(i)+" = "+huc.getHeaderField(i));
            }

            huc.disconnect();
        }catch(Exception e){System.out.println(e);}
    }
}
