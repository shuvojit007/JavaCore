package Compiler.LabViva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by SHOBOJIT on 8/19/2017.
 */
public class Left_Factoring {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[ ] args) {
        /*String data = in.nextLine();
        common(data);*/

        read();
    }

    public static void read(){
        String line=new String();
        try {
            BufferedReader br = new BufferedReader(new FileReader("leftfactoring"));
            while((line=br.readLine())!=null){
              common(line);
            }
        }
        catch(IOException Ex){
            System.out.println("Exception");
        }
    }

    public  static void common(String line){
        System.out.println("Input : "+line);
        System.out.println("LEFT FACTORING : ");
        StringTokenizer tokenizer=new StringTokenizer(line,"=|");
      //  System.out.println(tokenizer.toString());
        String first=tokenizer.nextToken();
       // System.out.println(first);
        String common="";
        ArrayList<String> tokens=new ArrayList<String>();
        tokens.clear();
        while(tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
   /*     for(String s:tokens){
            System.out.print(s+" ");
        }*/

        int max=0;

        for(int i=0;i<tokens.size()-1;i++){
            for(int j=i+1;j<tokens.size();j++){
                //return the lenght of common string
                int max2=LongestCommon(tokens.get(i),tokens.get(j));
             //   System.out.println(max2);
                if(max2>max){
                    max=max2;
                    common=tokens.get(i).substring(0, max);
                }
              //  System.out.println("common ="+common);
            }
        }
        factor(first,common, tokens);
    }

    public static int LongestCommon(String str1, String str2){
        if (str1==null || str2==null)
            return 0;
        int len=0;
        int loopcount;
        if(str1.length()<str2.length())
            loopcount=str1.length();
        else
            loopcount=str2.length();
        for(int i=0;i<loopcount;i++){
            if(str1.charAt(i)==str2.charAt(i))
                len++;
            else
                return len;
        }

        return len;
    }


    public static void factor(String first,String common,ArrayList<String> tokens){
        // Left Factring
        String next=new String();
        ArrayList<String> suffix=new ArrayList<String>();
        ArrayList<String> prefix=new ArrayList<String>();

        int tokensize;
        for(tokensize=0;tokensize<tokens.size();tokensize++){
            next=tokens.get(tokensize);
            if(next.equals(common)){
                suffix.add("ε");
                prefix.add(common);
               // System.out.println("common  " + common);
               // System.out.println("next " + next);

            }
            else if(next.startsWith(common)){
               // System.out.println("common  " + common);
               // System.out.println("next " + next);
                prefix.add(common);
                char[] charArray = next.toCharArray();
                String x = new String(charArray,common.length(),next.length()-common.length());
                suffix.add(x);
            }
            else{
               // System.out.println(next);
                prefix.add(next);
            }
        }

//        for(int i=0;i<prefix.size();i++)
//            System.out.println("prefix= "+prefix.get(i));
//
        int i;
       // System.out.println("first "+first);
        String firstoutput=first+"="+common+first+"`|";
        System.out.println(firstoutput);
        for(i=0;i<prefix.size();i++){
            if(i==prefix.size()-1)
                break;
            if(prefix.get(i)!=common){
                firstoutput+=prefix.get(i);
                firstoutput+="|";
            }
        }
        firstoutput+=prefix.get(i);
        System.out.println(firstoutput);

        String secondoutput=first+"`=";
        i=0;
        for(i=0;i<suffix.size()-1;i++){
            secondoutput+=suffix.get(i);
            secondoutput+="|";
        }
        secondoutput+=suffix.get(i);
        System.out.println(secondoutput);
        System.out.println("\n");

    }
}
