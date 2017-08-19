package Java_Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by SHOBOJIT on 7/1/2017.
 * Database Name --> jdbc_tutorial
 * Table Name --> shuvojitcontact
 */
public class Database_01 {

    void GetAllDataUsingStatement(Connection cn) throws SQLException {
        Statement st = cn.createStatement();
        ResultSet res = st.executeQuery("select * from shuvojitcontact");
        while(res.next()){
            System.out.println("------------------");
            System.out.println("| ID : "+res.getInt(1));
            System.out.println("| Name : " +res.getString(2));
            System.out.println("| Phone : 0" +res.getString(3));
            System.out.println("| Address : " +res.getString(4));
            System.out.println("------------------");
        }
    }

    void GetAllDataSelectingRow(Connection cn,int id) throws SQLException {
        Statement st = cn.createStatement();
        ResultSet res = st.executeQuery("select * from shuvojitcontact where id="+id);
        if (res.next()){
            System.out.println("------------------");
            System.out.println("| ID : "+res.getInt(1));
            System.out.println("| Name : " +res.getString(2));
            System.out.println("| Phone : 0" +res.getString(3));
            System.out.println("| Address : " +res.getString(4));
            System.out.println("------------------");
        }else {
            System.out.println("No Data found on this particular row\n");
        }

    }

    void InsertData(Connection cn,String name,int phone,String Address) throws SQLException {
        Statement st = cn.createStatement();
        int res = st.executeUpdate("insert into shuvojitcontact (name,phone,address) values('"+name+"'"
                +",'"+phone+"','"+Address+"') ");
        if(res==1){
            System.out.println("Data inserted Successfully");
        }else{
            System.out.println("Data insert Fail");
        }

    }


    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        Connection cn = Java_Connection_Class.buildConnection("jdbc_tutorial","root","");
        Database_01 db = new Database_01();

        //Get All Data Using Statement
        //db.GetAllDataUsingStatement(cn);

        while(true){
            System.out.println("Please Select your operation ");
            System.out.println("------------------");
            System.out.println("1 : GET All DATA FROM DATABASE USING STATEMENT");
            System.out.println("2 : GET DATA FROM DATABASE BY SELECTING ROW");
            System.out.println("3 : INSERT DATA INTO TABLE");
            System.out.println("------------------");
            System.out.print("YOUR ANSWER IS : ");
            int i=in.nextInt();
            switch (i){
                case 1:
                    db.GetAllDataUsingStatement(cn);
                case 2 :
                    System.out.println("Enter your row number");
                    db.GetAllDataSelectingRow(cn,in.nextInt());
                case 3 :
                    //db.InsertData(cn,));
            }
        }
    }
}
