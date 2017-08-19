package Networking;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHOBOJIT on 6/19/2017.
 *
 * Jsoup Tutorial : https://www.javatpoint.com/jsoup-examples
 */
public class Jsoup_For_Siu_Notice {
    public static List<String>notice= new ArrayList<>();
    public static List<String>dateandtime = new ArrayList<>();
    public  static List<String>link = new ArrayList<>();
    public static String url = "http://siu.edu.bd/category/notice/";
    public static void main(String[] args) {
      Jsoup_For_Siu_Notice notice =new Jsoup_For_Siu_Notice();
        new Runnable() {
            @Override
            public void run() {
                try {
                    notice.GetNOtice();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.run();
    }


    void GetNOtice() throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements date = doc.select(".single_notice .noticeboard_date");
        Elements noticename = doc.select(".single_notice .notice_title");
        Elements address = doc.select(".single_notice .notice_title a");

        for(Element t : date){
            dateandtime.add(t.text());
        }

        for(Element t : noticename){
            notice.add(t.text());
        }
        //For Notice Address
        for(Element t : address){
            link.add(t.attr("href"));
        }


        for (int i = 0; i<dateandtime.size()&&i<notice.size()&& i<link.size();i++){
            System.out.println("Notice no : "+i);
            System.out.println("NOTICE : "+notice.get(i));
            System.out.println("DATE AND TIME : "+dateandtime.get(i));
            System.out.println("LINK : "+link.get(i));
            System.out.println("");
        }
    }
}
