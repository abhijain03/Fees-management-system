package abhishek;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;




public class AdminSection extends JFrame{
static AdminSection curr;
JLabel admin=new JLabel("Admin Section");
JButton b1=new JButton("Add Accountant");
JButton b2=new JButton("View Accountant");
JButton b3=new JButton("Logout");

	AdminSection(){
		setSize(430,300);
		setLayout(null);
		setVisible(true);
		JPanel center=new JPanel();
		JPanel top=new JPanel();
		//top panel
		top.add(admin);
		top.setBounds(160,10,100,50);
		
		//center panel
		GroupLayout layout=new GroupLayout(center);
		center.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		GroupLayout.SequentialGroup hgrp=layout.createSequentialGroup();
		hgrp.addGroup(layout.createParallelGroup(Alignment.CENTER).addComponent(b1,GroupLayout.PREFERRED_SIZE,130,GroupLayout.PREFERRED_SIZE).addComponent(b2).addComponent(b3,GroupLayout.PREFERRED_SIZE,130,GroupLayout.PREFERRED_SIZE));
		layout.setHorizontalGroup(hgrp);
		
		GroupLayout.SequentialGroup vgrp=layout.createSequentialGroup();
		vgrp.addComponent(b1);
		vgrp.addGap(20);
		vgrp.addComponent(b2);
		vgrp.addGap(20);
		vgrp.addComponent(b3);
		layout.setVerticalGroup(vgrp);
		center.setBounds(140,50,300,200);
		
		//add accountant function
		
		b1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String []args={};
				AddAccountant.main(args);
				curr.dispose();
				
			}
			
		});
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				curr.dispose();
				AdminLogin.main(new String[]{});
			}
		});
		
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				ViewAccountant.main(new String[]{});
			}
		});
		
		
		add(top);
		add(center);
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 EventQueue.invokeLater(new Runnable(){
		    	public void run(){
		    		try{
		    		curr=new AdminSection();
		    		}
		    		catch (Exception e) {
						e.printStackTrace();
					}
		    	}
		    });
			}
	}


