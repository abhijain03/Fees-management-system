package abhishek;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


public class FeeReport extends JFrame{
	static FeeReport curr;
	JLabel feereport=new JLabel("Fee Report");
	JButton b1=new JButton("Admin Login");
	JButton b2=new JButton("Accountant Login");
	public FeeReport() {
		setSize(450,280);
		setVisible(true);
		setLayout(null);
		
		JPanel center=new JPanel();
		JPanel top=new JPanel();
		//top panel
		top.add(feereport);
		top.setBounds(176,10,100,50);
		
		//center panel
		GroupLayout layout=new GroupLayout(center);
		center.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		GroupLayout.SequentialGroup hgrp=layout.createSequentialGroup();
		hgrp.addGroup(layout.createParallelGroup(Alignment.CENTER).addComponent(b1,GroupLayout.PREFERRED_SIZE,150,GroupLayout.PREFERRED_SIZE).addComponent(b2,GroupLayout.PREFERRED_SIZE,150,GroupLayout.PREFERRED_SIZE));
		layout.setHorizontalGroup(hgrp);
		
		GroupLayout.SequentialGroup vgrp=layout.createSequentialGroup();
		vgrp.addComponent(b1);
		vgrp.addGap(20);
		vgrp.addComponent(b2);
		
		layout.setVerticalGroup(vgrp);
		center.setBounds(140,50,300,200);
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				curr.dispose();
				AdminLogin.main(new String[]{});
			}
		});
		
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				curr.dispose();
				AccountantLogin.main(new String[]{});
			}
		});
		
		
		add(top);
		add(center);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				curr=new FeeReport();
				
			}
		});

	}

}
