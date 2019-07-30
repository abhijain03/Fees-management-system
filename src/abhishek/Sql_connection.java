package abhishek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Sql_connection {
public static Connection con;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost/FeeReport","root","");

	}

}
