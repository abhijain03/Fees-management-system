package abhishek;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


public class AdminLogin extends JFrame {
static AdminLogin curr;
JLabel l1=new JLabel("Admin Login");
JLabel namel=new JLabel("Name:");
JLabel passl=new JLabel("Password:");
JButton login=new JButton("Login");
JTextField t1=new JTextField(20);
JPasswordField t2=new JPasswordField(20);
JButton back=new JButton("Back");

	AdminLogin(){
		setSize(450,300);
		setLayout(null);
		setVisible(true);
				
		//top panel
		JPanel top=new JPanel();
		top.add(l1);
		top.setBounds(160,20,100,50);
		
		//center panel
		JPanel center=new JPanel();
		center.setBounds(60,80,330,400);
		GroupLayout layout=new GroupLayout(center);
		center.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		GroupLayout.SequentialGroup hgrp=layout.createSequentialGroup();
		hgrp.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(namel).addComponent(passl).addGroup(layout.createSequentialGroup().addGap(85).addComponent(login)));
		hgrp.addGap(20);
		hgrp.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(t1).addComponent(t2).addGroup(layout.createSequentialGroup().addGap(25).addComponent(back)));
		layout.setHorizontalGroup(hgrp);
		
		GroupLayout.SequentialGroup vgrp=layout.createSequentialGroup();
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(namel).addComponent(t1));
		vgrp.addGap(20);
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(passl).addComponent(t2));
		vgrp.addGap(20);
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(login).addComponent(back));
		layout.setVerticalGroup(vgrp);
		
		//login button
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String name=t1.getText();
				String pass=t2.getText();
				if((name.equals("abhi"))&&(pass.equals("jain"))){
					String []args={};
					JOptionPane.showMessageDialog(null, "Login Successful!","",JOptionPane.ERROR_MESSAGE);
					AdminSection.main(args);
					curr.dispose();
					
					
					
			}else{
				JOptionPane.showMessageDialog(null, "Invalid Name/Password","",JOptionPane.ERROR_MESSAGE);
				}}
			
		});
		back.addActionListener(new ActionListener(){
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
			public void run(){
				curr=new AdminLogin();
				
			
			}
		});
		
	}

}
