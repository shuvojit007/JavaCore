package ACM.CF;

import java.util.Scanner;

public class Masha_and_Bears {
    public static Scanner in= new Scanner(System.in);
    public static void main(String []args){
               int fth,mth,son,masha;
               while (in.hasNext()){
                   fth=in.nextInt();
                   mth=in.nextInt();
                   son=in.nextInt();
                   masha=in.nextInt();
                   if (son==masha){
                        Print(fth*2,mth*2,son,masha);
                   }else if(son<masha){
                       if(mth>masha){
                           if ((son*2)>masha){
                               Print(fth*2,mth*2,masha,son);
                           }else{
                               System.out.println("-1");
                           }
                       }else{
                           System.out.println("-1");
                       }

                   }else if(son>masha){
                       if ((masha*2)>son){
                           Print(fth*2,mth*2,son,masha);
                       }else{
                           System.out.println("-1");
                       }
                   }else {
                       System.out.println("-1");
                   }
               }
           }

    private static void Print(int fth, int mth, int son, int masha) {
        System.out.println(fth);
        System.out.println(mth);
        System.out.println(son);
    }
}
