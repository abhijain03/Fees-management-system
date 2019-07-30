package abhishek;

import java.awt.EventQueue;
import java.util.List;

import abhishek.DueStudents;

import javax.swing.*;

public class DueFees extends JFrame{
static DueFees curr;
	
	DueFees(){
	setSize(700,500);
	setVisible(true);
	List<DueStudents> list=DueStudents.main(new String[]{});
	String[] contents={"Roll no.","Name","Email","Fee","Paid","Due","Contact","Course"};
	int size=list.size();
	String [][]arr=new String[size][8];
	for(int i=0;i<size;i++){
		arr[i][0]=list.get(i).rollno;
		arr[i][1]=list.get(i).name;
		arr[i][2]=list.get(i).email;
		arr[i][3]=list.get(i).fee;
		arr[i][4]=list.get(i).paid;
		arr[i][5]=list.get(i).due;
		arr[i][6]=list.get(i).contact;
		arr[i][7]=list.get(i).course;
		
	}
	JTable table=new JTable(arr,contents);
	JScrollPane sp=new JScrollPane(table);
	add(sp);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				curr=new DueFees();
			}
		});
	}

}
