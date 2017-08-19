package Java_Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by SHOBOJIT on 7/1/2017.
 */
public class CreateStatementandExcuteStatement {
       public static void main(String []args) throws SQLException {
           Connection cn = Java_Connection_Class.buildConnection("simple_database","root","");
            //Here I Pass the Simple_database name which i created for storing my friends name and their contact number

           //Step 3 : create the statement object
           Statement stmt = cn.createStatement();

           //Step 4 : execute query
           ResultSet res = stmt.executeQuery("select * from info");
           while (res.next()) {
               System.out.println("Name : " + res.getString(2));
               System.out.println("City : " + res.getString(3));
               System.out.println("Phnoe No : " + res.getString(4));
               System.out.println("");

           }

           //Step 5 : close the connection object
           stmt.close();
           cn.close();

       }
}
