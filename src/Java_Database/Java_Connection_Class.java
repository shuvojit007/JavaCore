package Java_Database;

import javax.annotation.Nonnull;
import java.sql.*;

/**
 * Created by SHOBOJIT on 7/1/2017.
 */
public class Java_Connection_Class {
    public static Connection connection;
    public static  Connection buildConnection (@Nonnull String DatabaseName,String user,String pass){
         if (connection == null){
             try {
             /*  1. jdbc:mysql://localhost/yourDatabaseName
                 2. user name
                 3. password  */

                 //Step 2 : create  the connection object
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/"+DatabaseName,user,pass);
                 System.out.println(" Database Connection Successful");
             } catch (SQLException e) {
                 System.out.println("Connection Establish Failed");
             }
         }
        return  connection;
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //Step 1 : load the driver class
        Class.forName("com.mysql.jdbc.Driver");
     //   Connection cn =buildConnection("simple_database","root","");
      //  Connection cn =buildConnection("jdbc_tutorial","root","");
    }
}
