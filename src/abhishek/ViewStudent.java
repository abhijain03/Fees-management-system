package abhishek;

import java.awt.Event;
import java.awt.EventQueue;
import java.util.List;




import javax.swing.*;

public class ViewStudent extends JFrame{

static ViewStudent curr;
	
	ViewStudent(){
	setSize(1100,500);
	setVisible(true);
	List<StudentData> list=StudentData.main(new String[]{});
	String[] contents={"Roll no.","Name","Email","Fee","Paid","Due","Contact","Course","Address","State","Country"};
	int size=list.size();
	String [][]arr=new String[size][11];
	for(int i=0;i<size;i++){
		arr[i][0]=list.get(i).rollno;
		arr[i][1]=list.get(i).name;
		arr[i][2]=list.get(i).email;
		arr[i][3]=list.get(i).fees;
		arr[i][4]=list.get(i).paid;
		arr[i][5]=list.get(i).due;
		arr[i][6]=list.get(i).contact;
		arr[i][7]=list.get(i).course;
		arr[i][8]=list.get(i).address;
		arr[i][9]=list.get(i).state;
		arr[i][10]=list.get(i).course;
		
		
	}
	JTable table=new JTable(arr,contents);
	JScrollPane sp=new JScrollPane(table);
	add(sp);
	}
	public static void main(String []args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				curr=new ViewStudent();
			}
		});
	}
}
