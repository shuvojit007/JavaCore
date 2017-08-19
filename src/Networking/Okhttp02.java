package Networking;
import okhttp3.*;
import java.io.IOException;
/**
 * Created by SHOBOJIT on 6/19/2017.
 */
public class Okhttp02 {
    private static String url = "https://api.github.com/users/Shuvojit007";
    public static void main(String[] args) throws IOException {
    Okhttp02 ok2 = new Okhttp02();
    String s =ok2.GithubUserInformation(url);
    System.out.println(s);
    }

  public  String GithubUserInformation(String s) throws IOException {
        OkHttpClient ok = OkHttpClientSIngerlton.GetOkhttpInstance();
            Request re = new Request.
                    Builder()
                    .url(s)
                    .build();
            /*
            To make a synchronous network call,
            use the Client to create a Call object and use the execute method.
             */
            Response response = ok.newCall(re).execute();
            System.out.println("Meassage : "+ response.message());
            System.out.println("Header : "+ response.headers());
            return response.body().toString();
    }
}

class OkHttpClientSIngerlton {
  static OkHttpClient client;
  static OkHttpClient GetOkhttpInstance(){
       if (client ==null){
           client = new OkHttpClient();
       }
       return client;
   }
}
