package abhishek;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abhishek.Sql_connection;

public class DueStudents {
String name,email,fee,paid,due,contact,course,rollno;

	public static List<DueStudents> main(String[] args) {
		// TODO Auto-generated method stub
		String query="select * from studentinfo where due!=0;";
		List<DueStudents> list=new ArrayList<DueStudents>();
		try {
			Sql_connection.main(new String[]{});
			Statement smt=Sql_connection.con.createStatement();
			ResultSet rs=smt.executeQuery(query);
			while(rs.next()){
				DueStudents temp=new DueStudents();
				temp.rollno=rs.getString(1);
				temp.name=rs.getString(2);
				temp.email=rs.getString(3);
				temp.fee=rs.getString(5);
				temp.paid=rs.getString(6);
				temp.due=rs.getString(7);
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
