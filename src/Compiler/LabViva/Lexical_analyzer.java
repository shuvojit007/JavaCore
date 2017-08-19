package Compiler.LabViva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by SHOBOJIT on 8/19/2017.
 */
public class Lexical_analyzer {
    static Character c;
    static String[] keyword={"int","float","double","char","string","main","return","stdio.h","printf","scanf","while","for","do","include","void","long","short","if","else","break","continue","void","public","static","private","void"};
    static List validkeyword= Arrays.asList(keyword);
    static String get_word=new String();
    static String get_line=new String();


    public static void main(String[] args) {
        String allfile = new String();
        String temp1,temp2;
        Lexical_analyzer la=new Lexical_analyzer();
        boolean commentStart=false,commentEnd=false;
        ArrayList<String> list=new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("lexicalanalyzer"));
            while((allfile=br.readLine())!=null){
                for(int i=0;i<allfile.length();i++){
                    if(commentStart==true){
                        while(allfile.charAt(i)!='*'){
                            i++;
                            if(i==allfile.length()-1){
                                break;
                            }

                        }
                        if(i<allfile.length()-1){
                            if(allfile.charAt(i)!='/'){
                                temp2=allfile.substring(i+1, allfile.length()-1);
                                commentStart=false;
                                allfile=temp2;
                            }
                        }

                    }
                    else if(allfile.charAt(i)=='/'){
                        i+=1;
                        if(allfile.charAt(i)=='/'){
                            allfile=allfile.substring(0,allfile.lastIndexOf('/')-1);
                            break;
                        }
                        else if(allfile.charAt(i)=='*'){
                            temp1=allfile.substring(0, i-1);

                            commentStart=true;
                            i+=1;
                            while(allfile.charAt(i)!='*'){
                                i++;
                                if(i==allfile.length()-1)
                                    break;
                            }
                            if(i<allfile.length()-1){
                                i++;
                                if(allfile.charAt(i)!='/'){
                                    temp2=allfile.substring(i, allfile.length()-1);
                                    commentStart=false;
                                    allfile=temp1+temp2;
                                }
                            }
                            allfile=temp1;
                        }

                    }
                    //else list.add(allfile);
                }
                list.add(allfile);

            }
            split(list);
        }
        catch(IOException Ex){
            System.out.println("Exception");
        }
    }

    static   void split(ArrayList<String> whole_file) {
        for(int i=0;i<whole_file.size();i++){
            get_line=whole_file.get(i);
            StringTokenizer tokenizer=new StringTokenizer(get_line," \t\n(){}[];,!%#<>^&|+-*/=",true);
            while(tokenizer.hasMoreTokens()){
                get_word=(String) tokenizer.nextElement();
                if(!checkDigit(get_word)){
                    //as the string is not digit check if it contains alphabet or not
                    if(checkAlphabet(get_word)){
                        // the string contains alphabets then check if it is in the keyword list
                        if(validkeyword.contains(get_word)){
                            // the string is a keyword
                            System.out.println(get_word+"\tKEYWORD");
                         //   write.write_file(get_word+"\tKEYWORD");
                        }

                        else{
                            //the string is not in keyword list .
                            // it is an identifier
                            if(checkLiteral(get_word)){
                                //if the string is inside a double cottation it is a literal
                              //  write.write_file(get_word+"\tLITERAL");
                                System.out.println(get_word+"\tKEYWORD");
                            }
                            else{
                                //else it is an identifier
                              //  write.write_file(get_word+"\tIDENTIFIER");
                                System.out.println(get_word+"\tIDENTIFIER");
                            }
                        }
                    }

                    //string is not alphabet
                    else if(checkPunctuations(get_word)){
                       // write.write_file(get_word+"\tPUNCTUATION");
                        System.out.println(get_word+"\tPUNCTUATION");
                    }
                    else if(checkParanthesis(get_word)){
                       // write.write_file(get_word+"\tPARANTHESIS");
                        System.out.println(get_word+"\tPARANTHESIS");
                    }
                    else if(checkOperators(get_word)){
                      //  write.write_file(get_word+"\tOPERATOR");
                        System.out.println(get_word+"\tOPERATOR");
                    }
                    else if(checkSymbols(get_word)){
                      //  write.write_file(get_word+"\tSYMBOL");
                        System.out.println(get_word+"\tSYMBOL");
                    }


                }
                else if(checkDigit(get_word)){
                   // write.write_file(get_word+"\tNUMBER");
                    System.out.println(get_word+"\tNUMBER");
                }


            }
        }
    }

    private static boolean checkDigit(String get_word) {
        boolean decimalFlag = false;
        for (int i = 0; i < get_word.length(); i++) {
            char ch = get_word.charAt(i);
            if (ch>= '0'  && ch <= '9') {
                return true;
            }
            else if (ch == '.' && decimalFlag == false) {
                decimalFlag = true;
            }
            else {
                return false;
            }
        }
        return true;
    }
    private static boolean checkAlphabet(String get_word) {

        for (int i = 0; i < get_word.length(); i++) {
            char ch = get_word.charAt(i);
            if ((ch>= 'a'  && ch <= 'z') || (ch>='A' && ch <= 'Z') || (ch>='0'  && ch <= '9') || ch == '_' || ch=='\"') {
            } else {
                return false;
            }
        }
        return true;
    }
    private static boolean checkLiteral(String get_word){
        if (get_word.charAt(0)=='\"' && get_word.charAt(get_word.length()-1)=='\"' ){
            //System.out.print(get_word.charAt(0));
            return true;
        }
        else
            return false;
    }
    private static  boolean checkPunctuations(String get_word){
        char ch;
        ch=get_word.charAt(0);
        if(ch==',' || ch== ';'){
            return true;
        }
        else
            return false;
    }
    private static boolean checkParanthesis(String get_word){
        char ch;
        ch=get_word.charAt(0);
        if(ch=='(' || ch==')' || ch=='{' || ch=='}' || ch=='[' || ch==']')
            return true;
        else return false;
    }
    private static boolean checkOperators(String get_word) {
        char ch;
        ch=get_word.charAt(0);
        switch(ch){
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
            case '<':
            case '>':
            case '=':
                return true;
            default:
                return false;
            //!%#<>^&|=
        }

    }
    private static  boolean checkSymbols(String get_word){
        char ch;
        ch=get_word.charAt(0);
        switch(ch){
            case '&':
            case '|':
            case '!':
            case '#':
            case '@':
            case '$':
            case '?':
                return true;
            default :
                return false;
        }
    }

}
