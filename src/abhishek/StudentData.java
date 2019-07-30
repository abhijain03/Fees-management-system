package abhishek;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentData {
String rollno,name,email,course,fees,paid,due,contact,address,state,country;
	
	public static List<StudentData> main(String[] args) {
		// TODO Auto-generated method stub
		String query="select * from studentinfo ;";
		List<StudentData> list=new ArrayList<StudentData>();
		try {
			Sql_connection.main(new String[]{});
			Statement smt=Sql_connection.con.createStatement();
			ResultSet rs=smt.executeQuery(query);
			while(rs.next()){
				StudentData temp=new StudentData();
				temp.rollno=rs.getString(1);
				temp.name=rs.getString(2);
				temp.email=rs.getString(3);
				temp.fees=rs.getString(5);
				temp.paid=rs.getString(6);
				temp.due=rs.getString(7);
				temp.address=rs.getString(8);
				temp.country=rs.getString(12);
				temp.state=rs.getString(10);
				
				temp.contact=rs.getString(11);
				temp.course=rs.getString(4);
				list.add(temp);
				
			}
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

	

	}

}
