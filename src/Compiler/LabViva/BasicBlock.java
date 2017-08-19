package Compiler.LabViva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class BasicBlock {
    public static void main(String[] args) {
        String line=new String();
        ArrayList<String> wholefile=new ArrayList<String>();
        try {BufferedReader br = new BufferedReader(new FileReader("tt.txt"));
            while((line=br.readLine())!=null){
                wholefile.add(line);
            }
        }
        catch(IOException Ex){
            System.out.println("Exception");
        }
        partition(wholefile);

    }

    public  static  void partition(ArrayList<String> file){
        ArrayList<Integer> leader= new ArrayList<>();
        leader.add(0);
        for(int i=1;i<file.size();i++){
            if(file.get(i).contains("if")){
                String temp=file.get(i);
                String jump="";
                for(int j=temp.length()-1;j>=2;j--){
                    if(temp.charAt(j)=='o')
                        break;
                    else
                        jump=temp.charAt(j)+jump;
                }
                int jumpTo= Integer.parseInt(jump)-1;
                leader.add(jumpTo);
                if(i+1<file.size())
                    leader.add(i+1);
            }
        }
        Collections.sort(leader);
        leader.add(file.size());
        for(int i=0;i<leader.size()-1;i++){
            System.out.println("BLOCK "+(i+1)+" :");
            for(int j=leader.get(i);j<leader.get(i+1);j++){
                System.out.println("\t"+file.get(j));
            }
        }
    }
}
