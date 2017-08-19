package Networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by SHOBOJIT on 6/19/2017.
 * The java.net package contains two interesting classes: The URL class and the URLConnection class.
 * These classes can be used to create client connections to web servers (HTTP servers).
 */
public class URl_Connection {
    private static Scanner in= new Scanner(System.in);
    public static void main(String[] args) throws IOException {
    URl_Connection uRl_connection = new URl_Connection();

    uRl_connection.URL_Connection();
    uRl_connection.URLs_to_Local_Files();

    uRl_connection.used_methods_of_Java_URL_class();
    }

    public void used_methods_of_Java_URL_class(){
        URL url = null;
        try {
            url = new URL("file:/G:/routine/cl.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("Protocol: "+url.getProtocol());
        System.out.println("Host Name: "+url.getHost());
        System.out.println("Port Number: "+url.getPort());
        System.out.println("File Name: "+url.getFile());
    }

    public void URL_Connection() throws IOException{
        URL url = new URL("http://jenkov.com");
        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();

        int data = input.read();
        while(data != -1){
            System.out.print((char) data);
            data = input.read();
        }
        input.close();
    }


    /*
    URLs to Local Files
    The URL class can also be used to access files in the local file system.
    Thus the URL class can be a handy way to open a file, if you need your
    code to not know whether the file came from the network or local file system.
     */


    public void URLs_to_Local_Files () throws IOException{
        URL url = new URL("file:/G:/routine/cl.txt");
        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();

        int data = input.read();
        while(data != -1){
            System.out.print((char) data);
            data = input.read();
        }
        input.close();
    }


}
