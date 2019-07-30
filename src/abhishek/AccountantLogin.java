package abhishek;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;



public class AccountantLogin extends JFrame{
static AccountantLogin curr;
JLabel acclogin=new JLabel("Accountant Login");
JLabel namel=new JLabel("Name:");
JLabel passl=new JLabel("Password:");
JTextField t1=new JTextField(20);
JPasswordField t2=new JPasswordField(20);
JButton b1=new JButton("Login");
JButton b2=new JButton("Back");
String name;
String password;

	AccountantLogin(){
		setSize(500,300);
		setVisible(true);
		setLayout(null);
		
		JPanel top=new JPanel();
		JPanel center=new JPanel();
		
		//top panel
		top.add(acclogin);
		top.setBounds(160,30,100,50);
		
		//center panel
		GroupLayout layout=new GroupLayout(center);
		center.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		GroupLayout.SequentialGroup hgrp=layout.createSequentialGroup();
		GroupLayout.SequentialGroup vgrp=layout.createSequentialGroup();
		
		hgrp.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(namel).addGap(30).addComponent(passl)
						.addGroup(layout.createSequentialGroup().addGap(90).addComponent(b1)));
		hgrp.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(t1,layout.PREFERRED_SIZE,160,layout.PREFERRED_SIZE)
						.addGap(30).addComponent(t2,layout.PREFERRED_SIZE,160,layout.PREFERRED_SIZE));
		hgrp.addComponent(b2);
		layout.setHorizontalGroup(hgrp);
		
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(namel).addGap(40).addComponent(t1));
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(passl).addGap(40).addComponent(t2));
		vgrp.addGroup(layout.createParallelGroup().addComponent(b1,layout.PREFERRED_SIZE,37,layout.PREFERRED_SIZE).addGap(40).addComponent(b2));
		layout.setVerticalGroup(vgrp);
		center.setBounds(60,70,400,300);
		
		
		//login funtion
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				name=t1.getText();
				password=t2.getText();
			
				try {
					Sql_connection.main(new String[]{});
				
				String query="select * from AccountantInfo where name='"+name+"' and password='"+password+"';";
				
				Statement smt=Sql_connection.con.createStatement();
				ResultSet rs=smt.executeQuery(query);
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "Login Successful", "", JOptionPane.INFORMATION_MESSAGE);
					curr.dispose();
					AccountantSection.main(new String[]{});
					}
					else{
						JOptionPane.showMessageDialog(null, "Invalid Name/Password", "", JOptionPane.INFORMATION_MESSAGE);
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
				FeeReport.main(new String[]{});
				
			}
		});
		
		
		
		add(top);
		add(center);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				curr=new AccountantLogin();
				
			}
		
			
		});

	}

}
