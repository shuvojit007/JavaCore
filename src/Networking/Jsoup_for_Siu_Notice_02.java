package Networking;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHOBOJIT on 7/5/2017.
 */
public class Jsoup_for_Siu_Notice_02 {
    public static List<String> NoticeDate = new ArrayList<>();
    public static List<String> Notice = new ArrayList<>();
   public static String url = "http://siu.edu.bd";
    public static void main(String[] args) throws IOException {
        GetNoticeAndDate();
    }

     public static void GetNoticeAndDate() throws IOException {
         Document doc = Jsoup.connect(url).get();
         Elements date = doc.select(".notice_section_area .bxslider .notice_date");
         Elements noticdate = doc.select(".bxslider .notice_date");
         Elements address = doc.select(".single_notice .notice_title a");


         for(Element t : date){
             NoticeDate.add(t.text());
         }

         for (String s : NoticeDate)
             System.out.println(s);
     }


}
