package abhishek;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


public class AccountantSection extends JFrame{
static AccountantSection curr;
JLabel accsec=new JLabel("Accountant Section");
JButton addstudent=new JButton("Add Student");
JButton viewstudent=new JButton("View Student");
JButton editstudent=new JButton("Edit Student");
JButton duefees=new JButton("Due Fees");
JButton removestudent=new JButton("Remove Student");
JButton logout=new JButton("Logout");

	AccountantSection(){
		setSize(500,500);
		setVisible(true);
		setLayout(null);
		
		JPanel top=new JPanel();
		JPanel center=new JPanel();
		
		//top panel
		top.add(accsec);
		top.setBounds(170,30,150,40);
		
		//center panel
		GroupLayout layout=new GroupLayout(center);
		center.setLayout(layout);
		GroupLayout.SequentialGroup hgrp=layout.createSequentialGroup();
		GroupLayout.SequentialGroup vgrp=layout.createSequentialGroup();
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		
		hgrp.addGroup(layout.createParallelGroup().addComponent(addstudent,layout.PREFERRED_SIZE,150,layout.PREFERRED_SIZE)
				.addGap(60).addComponent(editstudent,layout.PREFERRED_SIZE,150,layout.PREFERRED_SIZE).addGap(60)
				      .addComponent(removestudent,layout.PREFERRED_SIZE,150,layout.PREFERRED_SIZE));
		hgrp.addGap(40);
		hgrp.addGroup(layout.createParallelGroup().addComponent(viewstudent,layout.PREFERRED_SIZE,150,layout.PREFERRED_SIZE)
				.addGap(60).addComponent(duefees,layout.PREFERRED_SIZE,150,layout.PREFERRED_SIZE).addGap(60)
						.addComponent(logout,layout.PREFERRED_SIZE,150,layout.PREFERRED_SIZE));
		layout.setHorizontalGroup(hgrp);
		
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(addstudent,layout.PREFERRED_SIZE,50,layout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(viewstudent,layout.PREFERRED_SIZE,50,layout.PREFERRED_SIZE));
		vgrp.addGap(50);
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(editstudent,layout.PREFERRED_SIZE,50,layout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(duefees,layout.PREFERRED_SIZE,50,layout.PREFERRED_SIZE));
		vgrp.addGap(50);
		vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(removestudent,layout.PREFERRED_SIZE,50,layout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(logout,layout.PREFERRED_SIZE,50,layout.PREFERRED_SIZE));
		layout.setVerticalGroup(vgrp);
		
		center.setBounds(60,100,400,400);
		
		//due fees button
		duefees.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				
				DueFees.main(new String[]{});
			}
		});
		
		//view student button
				viewstudent.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						
						ViewStudent.main(new String[]{});
					}
				});
		
		//logout button
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				curr.dispose();
				
				AccountantLogin.main(new String[]{});
			}
		});
		
		//add student
		addstudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				curr.dispose();
				AddStudent.main(new String[]{});
			}
		});
		
		//remove student
				removestudent.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						curr.dispose();
						RemoveStudent.main(new String[]{});
					}
		});
		//add student
		editstudent.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		curr.dispose();
		EditStudent.main(new String[]{});
			}
		});
				
		
	
		
		add(center);
		add(top);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				curr=new AccountantSection();
			}
		});

	}

}
