package Compiler.Compiler02;

/**
 * Created by SHOBOJIT on 8/9/2017.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LeftRecursion {
    //storing each line in its corresponding Arraylist
    static ArrayList<String> leftRules = new ArrayList<>();
    static ArrayList<String> rightRules = new ArrayList<>();
    static Scanner scan = new Scanner (System.in);

    public static void read_file() throws IOException {
        String line;
        line = scan.nextLine();
        leftRules.add(line);
        rightRules.add(scan.nextLine());

        scan.close();
    }

    public static void ss() {

        for (int i = 0; i < leftRules.size(); i++) {
            for (int j = 1; j <= i - 1; j++) {
                //splitting inputs on bars "|" to iterate through them
                for (String x : rightRules.get(i).split("\\|")) {
                    if (x.contains(leftRules.get(j))) {
                        String f = "";
                        String ff = "";
                        for (int k=0; k<rightRules.get(k).split("\\|").length;k++) {

                            f = x;
                            f = f.replaceAll(leftRules.get(i), rightRules.get(k).split("\\|")[k]);

                            ff += f;

                        }
                        rightRules.remove(i);
                        rightRules.add(i, ff);
                    }
                }
            }

            //Recursive or Not boolean
            boolean isRec = false;

            for (String z : rightRules.get(i).split("\\|")) {
                if (z.startsWith(leftRules.get(i))) {
                    isRec = true;
                    break;
                }
            }

            if (isRec) {
                String a = "";
                String b = "";
                for (String s : rightRules.get(i).split("\\|")) {

                    if (s.startsWith(leftRules.get(i))) {
                        b += s.replaceAll(leftRules.get(i), "") + leftRules.get(i) + "'|";
                    } else {
                        a += s + leftRules.get(i) + "'";
                    }
                }

                b += "δ";

                if(a.length()>=1)
                    a.substring(1, a.length() - 1);
                rightRules.add(i, a);
                rightRules.add(i + 1, b);
                leftRules.add(leftRules.get(i) + "'");
            }

        }
    }

    public static void main(String[] args) throws IOException {
        read_file();
        ss();
        for (int i=0;i<leftRules.size();i++)
        {
            System.out.print(leftRules.get(i)+"->");
            System.out.println("["+rightRules.get(i)+"]");
        }

    }


}