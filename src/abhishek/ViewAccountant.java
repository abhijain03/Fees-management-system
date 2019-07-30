package abhishek;

import java.awt.EventQueue;
import java.util.List;
import abhishek.AccountantData;

import javax.swing.*;

public class ViewAccountant extends JFrame{
static ViewAccountant curr;	
	
	ViewAccountant(){
		setSize(600,450);
		setVisible(true);
		
		String tablecol[]={"name","Password","email","contact"};
		List<AccountantData> list=AccountantData.main(new String[]{});
		int size=list.size();
		String finalarr[][]=new String[size][4];
		for(int i=0;i<size;i++){
			finalarr[i][0]=list.get(i).name;
			finalarr[i][1]=list.get(i).password;
			finalarr[i][2]=list.get(i).email;
			finalarr[i][3]=list.get(i).contact;
		}
		JTable table=new JTable(finalarr,tablecol);
		JScrollPane sp=new JScrollPane(table);
		add(sp);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				curr=new ViewAccountant();
			}
		});
	}

}
