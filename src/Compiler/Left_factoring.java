package Compiler;

import java.util.Scanner;
public class Left_factoring {


    /*
    Simple Test Case :  A-> abB | aB | cdg | cdeB | cdfB
                        S-> iEtS | iEtSeS | a |c
     */

    public static String prefixCommon ="";
    public static String fline = "";
    public static String cfg_Left_factored="";
    public static String cfg;
    public static String Not_LF="";

    public static boolean left_factor=false;
    public static int f_count =0;
    public static Scanner scan = new Scanner (System.in);
    public static void main(String[] args) {
        for (; ;){
            cfg = scan.nextLine();
            check_factor(cfg);
            System.out.println("Left factoring ---> \n"  ); // productions that don't need to be left factored out.
            System.out.println(Not_LF);
            System.out.println("");
        }

    }

    public static void check_factor(String cfg) {
        String lines [] = cfg.split("\\\n");
        for (String line: lines) {
            line= line.replaceAll("\\s+", "");
            String productions [] = line.split("->",0);
            String lhs = productions [0];
            String rhs = productions[1];
            String [] rhs_productions = rhs.split("\\|") ;
            left_factor=false;
            for (int i=0;i<rhs_productions.length-1;i++) {
                for(int j=i+1;j<rhs_productions.length;j++) {
                    if (rhs_productions[i].charAt(0)==rhs_productions[j].charAt(0) && (!rhs_productions[i].equals("epsilon")) ) {
                        left_factor=true;
                    }
                }
            }

            if(left_factor) {
               String common_prefix="";
               common_prefix=find_common_prefix(rhs_productions);
               left_factor_out (lhs , common_prefix,  rhs_productions );
            }
            else {
                String st [] = line.split("");
                int l = st.length;
                String s = st[l-2];
                if(s == "0") {
                    for(int i=0; i<l-2;i++) {
                        fline += st[i];
                    }
                }
                Not_LF+=line +"\n";
            }
        }
    }
    private static void left_factor_out(String lhs,  String common_prefix, String[] rhs_productions) {
        cfg_Left_factored=lhs+"-->"; // rewrite the productions without left factoring
        for(String pro:rhs_productions) {
            if(!pro.startsWith(common_prefix) ) {
                cfg_Left_factored+=pro+"|";
            }
        }
        cfg_Left_factored+=common_prefix + "X"+ f_count + "\n";
        cfg_Left_factored+="X"+ f_count + "--> ";
        for(String pro:rhs_productions) {
            if(pro.startsWith(common_prefix) ) {
                if( pro.substring(1 , pro.length()).length() ==0) {
                    cfg_Left_factored+="$"+"|";
                }
                else {
                    cfg_Left_factored+=pro.substring(1 , pro.length() )+"|";
                }
            }
        }
        cfg_Left_factored=cfg_Left_factored.substring(0, cfg_Left_factored.length()-1); // to remove last | symbol at the end
        if(left_factor){
            f_count++;
            check_factor(cfg_Left_factored);
        }
    }

    public static String find_common_prefix(String[] rhs_productions) {
        String common_prefix = "";
        for (int i=0;i<rhs_productions.length-1;i++) {

            for(int j=i+1;j<rhs_productions.length;j++) {
                if (rhs_productions[i].charAt(0) == rhs_productions[j].charAt(0) ) {
                    common_prefix=rhs_productions[i].charAt(0)+"";
                    break;
                }

            }
            if(common_prefix.length()>0) // initially length of common_prefix is 0 , once the a common prefix is found , we don't need the first for to keep looping
                break;	 // this break correspond to stop first loop for(int =i.....)
        }
        prefixCommon += common_prefix;
        return common_prefix;
    }


}