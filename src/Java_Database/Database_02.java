package Java_Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database_02 {
	private Connection connection;
	public Database_02(){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/simple_database","root","");
			System.out.println("Connection Successfull");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		private List<String> getallData(){
			
			List<String> aList =new ArrayList<String>();
			Statement st=null;
			ResultSet resultSet = null;
			try {
				st = connection.createStatement();
				 resultSet = st.executeQuery("SELECT * FROM `info`" );
					while (resultSet.next()) {
						aList.add("\n "+resultSet.getInt("id")+" "+resultSet.getString("name")+" " +resultSet.getString("city")+
								" "+ resultSet.getInt("phone_no")); } 
			}
					catch (Exception ex) {
				ex.printStackTrace();
			}
			

			return aList;
		
	}
		public void selectrow(int id) {
			Statement st= null;
			ResultSet resultSet = null;
			try {
				st= connection.createStatement();
				resultSet=st.executeQuery("Select * from info where id="+id);
				if(resultSet.isBeforeFirst()){
				while (resultSet.next()) {
					System.out.println(+resultSet.getInt("id")+" "+resultSet.getString("name")+" " +resultSet.getString("city")+
							" "+ resultSet.getInt("phone_no"));;
				}}
				else{
					System.out.println("Not Data Found");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		private void Insertdata (String name,String city,int phone_no){
			Statement st = null;
			int i ;
			
			try {
				st=connection.createStatement();
				
				 i=st.executeUpdate("insert into info(name,city,phone_no) values('"+name+"'"
						+",'"+city+"','"+phone_no+"') ");
				if(i==1){
					System.out.println("Insertion Successful");
				}else {
					System.out.println("Insertion Fail");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void update (){
			Statement st ;
			try {
				st=connection.createStatement();
				st.executeUpdate("UPDATE `info` SET name='Shopnil',`city`='Sylhet',`phone_no`='01762233559' WHERE id='11' ");
				System.out.println("Update Succesfull");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			
		}
		private void delete (String name){
			Statement st = null;
			try {
				st=connection.createStatement();
				st.executeUpdate("DELETE FROM `info` WHERE name ="+"'"+ name +"'");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
			private static Scanner in  = new Scanner(System.in);
	public static void main(String[] args) {
		Database_02 js =new Database_02();
		
		System.out.println(js.getallData());
		while(in.hasNext()){
			String s = in.next();
			js.delete(s);
			System.out.println(js.getallData());
		}
		
//		while (in.hasNext()) {
//			int i = in.nextInt();
//			js.selectrow(i);}
		//js.update();
//js.Insertdata("Gulok", "Moulobibajar", 223355);
		
//		}int i = in.nextInt();
//		js.selectrow(i);
	}
	/* Statement:-Use for general-purpose access to your database.
	Useful when you are using static SQL statements at runtime. 
	The Statement interface cannot accept parameters.

	PreparedStatement:-Use when you plan to use the SQL statements many times. 
	The PreparedStatement interface accepts input parameters at runtime. */
}

