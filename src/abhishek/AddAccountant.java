package abhishek;

import java.awt.EventQueue;

import abhishek.Sql_connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


public class AddAccountant extends JFrame{
static AddAccountant curr;
String name,email,contact,password;
JLabel addacc=new JLabel("Add Accountant");
JLabel namel=new JLabel("Name:");
JLabel passl=new JLabel("Password:");
JLabel emaill=new JLabel("Email:");
JLabel contacl=new JLabel("Contact no.");
JTextField t1=new JTextField(30);
JPasswordField t2=new JPasswordField(30);
JTextField t3=new JTextField(30);
JTextField t4=new JTextField(10);
JButton b1=new JButton("Add Accountant");
JButton b2=new JButton("Back");
	public AddAccountant() {
		// TODO Auto-generated constructor stub
		setSize(500,350);
		setVisible(true);
		setLayout(null);
		
		JPanel top=new JPanel();
		JPanel center=new JPanel();
		//top panel
		top.add(addacc);
		top.setBounds(180,30,100,50);
		
		//center panel
		GroupLayout layout=new GroupLayout(center);
		center.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		GroupLayout.SequentialGroup hgrp=layout.createSequentialGroup();
		GroupLayout.SequentialGroup vgrp=layout.createSequentialGroup();
		hgrp.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(namel).addComponent(passl).addComponent(emaill).addComponent(contacl).
				addGroup(layout.createSequentialGroup().addGap(70).addComponent(b1)));
		
		hgrp.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(t1,layout.PREFERRED_SIZE,150,layout.PREFERRED_SIZE).addComponent(t2,layout.PREFERRED_SIZE,150,layout.PREFERRED_SIZE)
				.addComponent(t3,layout.PREFERRED_SIZE,150,layout.PREFERRED_SIZE).addComponent(t4,layout.PREFERRED_SIZE,150,layout.PREFERRED_SIZE));
		layout.setHorizontalGroup(hgrp);
		hgrp.addComponent(b2);
		
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(namel).addGap(15).addComponent(t1));
		vgrp.addGap(10);
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(passl).addGap(15).addComponent(t2));
		vgrp.addGap(10);
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(emaill).addGap(15).addComponent(t3));
		vgrp.addGap(10);
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(contacl).addGap(15).addComponent(t4));
		vgrp.addGap(30);
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(b1).addGap(15).addComponent(b2));
		b1.setSize(100, 100);;
		layout.setVerticalGroup(vgrp);
		
		center.setBounds(50,70,420,400);
		
		
		//add button
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				name=t1.getText();
				if(name.isEmpty()){
					JOptionPane.showMessageDialog(null, "Empty Name Field", "", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				
				password=t2.getText();
				if(password.isEmpty()){
					JOptionPane.showMessageDialog(null, "Empty Password Field", "", JOptionPane.ERROR_MESSAGE);
					return;
				}
				email=t3.getText();
				if(!((email.contains("@"))&&(email.contains(".")))||(email.isEmpty())){
						JOptionPane.showMessageDialog(null, "Invalid email id", "", JOptionPane.ERROR_MESSAGE);
						return;
					
				}
				contact=t4.getText();
				if(contact.length()!=10){
					JOptionPane.showMessageDialog(null, "Invalid Conatact no", "", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String query="insert into AccountantInfo values ('"+name+"','"+password+"','"+email+"','"+contact+"');";
				System.out.println(query);
				try {
					Sql_connection.main(new String[]{});
					PreparedStatement stm=Sql_connection.con.prepareStatement(query);
					if(stm.executeUpdate()>0){
						System.out.println("updated");
						JOptionPane.showMessageDialog(null, "Accountant Added", "", JOptionPane.INFORMATION_MESSAGE);
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Failed", "", JOptionPane.ERROR_MESSAGE);
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Failed", "", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		
		t4.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char p=e.getKeyChar();
				if(!((p>='0'&&p<='9')||(p==KeyEvent.VK_BACK_SPACE)||(p==KeyEvent.VK_DELETE))){
					e.consume();
				}
			}
		});
		
		//back Button
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String[] args={};
				AdminSection.main(args);
				curr.dispose();
			}
		});
		
		add(center);
		add(top);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    EventQueue.invokeLater(new Runnable(){
    	public void run(){
    		try{
    		curr=new AddAccountant();
    		}
    		catch (Exception e) {
				e.printStackTrace();
			}
    	}
    });
	}

}
