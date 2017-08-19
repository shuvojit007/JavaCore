package Compiler.LabViva;
import java.util.Scanner;

class Left_Recurtion {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        for(;;){
            String input = in .nextLine();
            String inputtemp= "";

            //Step 1 remove the space
            for(String element: input.split(" "))
                inputtemp+= element;
            CheckTheString(inputtemp);
        }
    }

    static void  CheckTheString(String input){

        //step 2 : spilt the string
        String[] input2 = input.split(">");

        /*for (String s :input2){
            System.out.println(s);
        }*/
        String[] input3 = input2[1].split("[|]");
        /*for (String s :input3){
            System.out.print(s + " ");
        }*/
        //System.out.println("");
        String temp = input3[0].substring(0, input2[0].length());
        System.out.println(temp);
        if (input2[0].equals(temp)) {

            String lhs1 = input2[0];
            String rhshelp1 = lhs1 + "'";
            String rhs1 = input3[1] + rhshelp1;
            System.out.println(lhs1 + "->" + rhs1);
            String lhs2 = rhshelp1;
            String rhshelp2 = input3[0].substring(input2[0].length());

            System.out.println(lhs2 + "->" + rhshelp2 + lhs2 + "|δ");

        } else
            System.out.println("Not Left recusrive");


    }
}