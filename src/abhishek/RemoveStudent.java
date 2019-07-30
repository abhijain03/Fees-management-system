package abhishek;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class RemoveStudent extends JFrame{
static RemoveStudent curr;
JLabel heading=new JLabel("Remove Student");
JLabel namel=new JLabel("Name:");
JLabel lblroll=new JLabel("Roll No:");
JTextField namet=new JTextField();
JTextField rollt=new JTextField();
JButton b1=new JButton("Remove");
JButton b2=new JButton("Back");

String name,roll;


	RemoveStudent(){
		setSize(500,350);
		setVisible(true);
		setLayout(null);
		JPanel top=new JPanel();
		JPanel center=new JPanel();
		
		//top panel
		top.add(heading);
		top.setBounds(160,30,100,50);
		
		//center panel
		GroupLayout layout=new GroupLayout(center);
		center.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		GroupLayout.SequentialGroup hgrp=layout.createSequentialGroup();
		GroupLayout.SequentialGroup vgrp=layout.createSequentialGroup();
		
		hgrp.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(namel).addGap(30).addComponent(lblroll)
						.addGroup(layout.createSequentialGroup().addGap(90).addComponent(b1)));
		hgrp.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(namet,layout.PREFERRED_SIZE,160,layout.PREFERRED_SIZE)
						.addGap(30).addComponent(rollt,layout.PREFERRED_SIZE,160,layout.PREFERRED_SIZE));
		hgrp.addComponent(b2);
		layout.setHorizontalGroup(hgrp);
		
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(namel).addGap(40).addComponent(namet));
		vgrp.addGap(20);
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(lblroll).addGap(40).addComponent(rollt));
		vgrp.addGap(40);
		vgrp.addGroup(layout.createParallelGroup().addComponent(b1,layout.PREFERRED_SIZE,37,layout.PREFERRED_SIZE).addGap(40).addComponent(b2));
		layout.setVerticalGroup(vgrp);
		center.setBounds(60,70,450,300);
		
		rollt.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char p=e.getKeyChar();
				if(!((p>='0'&&p<='9')||(p==KeyEvent.VK_BACK_SPACE)||(p==KeyEvent.VK_DELETE))){
					e.consume();
				}
			}
		});
		
		//remove funtion
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				name=namet.getText();
				roll=rollt.getText();
				System.out.println(name+" "+roll);
				String query="delete from studentinfo where name='"+name+"' and id="+roll+";";
				try {
					Sql_connection.main(new String[]{});
					PreparedStatement smt=Sql_connection.con.prepareStatement(query);
					if(smt.executeUpdate()>0){
						JOptionPane.showMessageDialog(null, "Record Deleted","",JOptionPane.INFORMATION_MESSAGE);
						namet.setText("");
						rollt.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null, "Record Not Found","",JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				curr.dispose();
				AccountantSection.main(new String[]{});
				
			}
		});
		
		
		
		add(top);
		add(center);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				curr=new RemoveStudent();
			}
		});
	}

}
