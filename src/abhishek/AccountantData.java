package abhishek;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abhishek.Sql_connection;





public class AccountantData {
String name,email,password,contact;
	
	
	public static List<AccountantData> main(String []args){
	List<AccountantData> list=new ArrayList<AccountantData>();
	ResultSet rs;
	
		
		try {
		Sql_connection.main(new String[]{});
		Statement smt=Sql_connection.con.createStatement();
		rs=smt.executeQuery("select * from accountantinfo");
		while(rs.next()){
			AccountantData d=new AccountantData();
			d.name=rs.getString(1);
			d.password=rs.getString(2);
			d.email=rs.getString(3);
			d.contact=rs.getString(4);
			list.add(d);
			
			
		}
		
		return list;
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
	

}
