package abhishek;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public class EditStudent extends JFrame {

	static EditStudent curr;	
	String name,email,state,course,address,city,contact,country;
	int fee,paid,due,id;
	JLabel rollnol=new JLabel("Roll No:");
	JTextField rollt=new JTextField(25);
	JButton load=new JButton("Load");
	JLabel namel=new JLabel("Name:");
	JLabel emaill=new JLabel("Emaill:");
	JLabel coursel=new JLabel("Course:");
	JLabel feel=new JLabel("Fee:");
	JLabel paidl=new JLabel("Paid:");
	JLabel duel=new JLabel("Due:");
	JLabel addressl=new JLabel("Address:");
	JLabel cityl=new JLabel("City:");
	JLabel statel=new JLabel("State:");
	JLabel contactl=new JLabel("Contact no:");
	JLabel countryl=new JLabel("Country:");


	JTextField namet=new JTextField(20);
	JTextField emailt=new JTextField(30);
	JTextField courset=new JTextField(20);
	JTextField feet=new JTextField(10);
	JTextField paidt=new JTextField(10);
	JTextField duet=new JTextField(10);
	JTextArea  addresst=new JTextArea();
	JTextField cityt=new JTextField(20);
	JTextField statet=new JTextField(20);
	JTextField contactt=new JTextField(10);
	JTextField countryt=new JTextField(15);

	JButton b1=new JButton("Update");
	JButton b2=new JButton("Back");

		EditStudent(){
			setSize(500,700);
			setVisible(true);
			setLayout(null);
			
			JPanel top=new JPanel();
			JPanel center=new JPanel();
			//top panel
			top.add(rollnol);
			top.add(rollt);
			top.add(load);
			top.setBounds(20,10,440,50);
			JSeparator separate=new JSeparator();
			separate.setBounds(40, 70, 400, 20);
			
			duet.setEditable(false);
			
			
			
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					name=namet.getText();
					if(name.isEmpty()){
						JOptionPane.showMessageDialog(null, "Empty Name Field","",JOptionPane.ERROR_MESSAGE);
						return;
					}
					email=emailt.getText();
					if(!(email.contains("@")&&email.contains("."))){
						{
							JOptionPane.showMessageDialog(null, "Invalid Email","",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					course=courset.getText();
					if(course.isEmpty()){
						{
							JOptionPane.showMessageDialog(null, "Empty Course Field","",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					try{
					fee=Integer.parseInt(feet.getText());
					paid=Integer.parseInt(paidt.getText());
					due=fee-paid;
					duet.setText(Integer.toString(due));
					}
					catch(Exception t){
						JOptionPane.showMessageDialog(null, "Empty Fees/Paid Field","",JOptionPane.ERROR_MESSAGE);
						return;
					}
					address=addresst.getText();
					if(address.isEmpty()){
						{
							JOptionPane.showMessageDialog(null, "Empty Address Field","",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					city=cityt.getText();
					if(city.isEmpty()){
						{
							JOptionPane.showMessageDialog(null, "Empty City Field","",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					state=statet.getText();
					if(state.isEmpty()){
						{
							JOptionPane.showMessageDialog(null, "Empty state Field","",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					contact=contactt.getText();
					if(contact.length()!=10){
						{
							JOptionPane.showMessageDialog(null, "Invalid Contact","",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					country=countryt.getText();
					if(country.isEmpty()){
						{
							JOptionPane.showMessageDialog(null, "Empty Country Field","",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					
					
				String query="update studentinfo set name='"+name+"',email='"+email+"',course='"+course+"',fee='"+fee+"',paid='"+paid+"',due='"+due+"',address='"+address+"',city='"+city+"',state='"+state+"',contact='"+contact+"',country='"+country+"' where id="+id+";";
				try {
					Sql_connection.main(new String[]{});
					PreparedStatement smt=Sql_connection.con.prepareStatement(query);
					if(smt.executeUpdate()>0){
						JOptionPane.showMessageDialog(null, "Update Successful","",JOptionPane.INFORMATION_MESSAGE);
						namet.setText("");courset.setText("");
						emailt.setText("");feet.setText("");
						paidt.setText("");duet.setText("");
						addresst.setText("");cityt.setText("");
						statet.setText("");
						contactt.setText("");
						countryt.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null, "Update Failed","",JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Update Failed","",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Update Failed","",JOptionPane.ERROR_MESSAGE);
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
			
			
			feet.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent e){
					char p=e.getKeyChar();
					if(!((p>='0'&&p<='9')||(p==KeyEvent.VK_BACK_SPACE)||(p==KeyEvent.VK_DELETE))){
						e.consume();
					}
				}
			});
			
			paidt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent e){
					
					char p=e.getKeyChar();
					if(!((p>='0'&&p<='9')||(p==KeyEvent.VK_BACK_SPACE)||(p==KeyEvent.VK_DELETE))){
						e.consume();
					}
				}
			});
			rollt.addKeyListener(new KeyAdapter(){
				public void keyTyped(KeyEvent e){
					
					char p=e.getKeyChar();
					if(!((p>='0'&&p<='9')||(p==KeyEvent.VK_BACK_SPACE)||(p==KeyEvent.VK_DELETE))){
						e.consume();
					}
				}
			});
			
			load.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String ids=rollt.getText();
					if(ids.isEmpty()){
						return;
					}
					id=Integer.parseInt(ids);
					
					try {
						Sql_connection.main(new String[]{});
						Statement smt=Sql_connection.con.createStatement();
						ResultSet rs=smt.executeQuery("Select * from studentinfo where id="+id+";");
						
						if(rs.next()){
							namet.setText(rs.getString(2));
							emailt.setText(rs.getString(3));
							courset.setText(rs.getString(4));
							feet.setText(rs.getString(5));
							paidt.setText(rs.getString(6));
							duet.setText(rs.getString(7));
							addresst.setText(rs.getString(8));
							cityt.setText(rs.getString(9));
							statet.setText(rs.getString(10));
							contactt.setText(rs.getString(11));
							countryt.setText(rs.getString(12));
							
							
						}
						else{
							JOptionPane.showMessageDialog(null, "Details cant be fetched/Invalid roll no","",JOptionPane.ERROR_MESSAGE);
							namet.setText("");courset.setText("");
							emailt.setText("");feet.setText("");
							paidt.setText("");duet.setText("");
							addresst.setText("");cityt.setText("");
							statet.setText("");
							contactt.setText("");
							countryt.setText("");
							return;
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			
			
			//center panel
			
			GroupLayout layout=new GroupLayout(center);
			center.setLayout(layout);
			layout.setAutoCreateContainerGaps(true);
			layout.setAutoCreateGaps(true);
			GroupLayout.SequentialGroup hgrp=layout.createSequentialGroup();
			GroupLayout.SequentialGroup vgrp=layout.createSequentialGroup();
			
			hgrp.addGroup(layout.createParallelGroup().addComponent(namel).addComponent(emaill).addComponent(coursel)
						.addComponent(feel).addComponent(paidl).addComponent(duel).addComponent(addressl).addComponent(cityl)
							.addComponent(statel).addComponent(contactl).addComponent(countryl)
								.addGroup(layout.createSequentialGroup().addGap(40).addComponent(b1)));
			
			
			hgrp.addGroup(layout.createParallelGroup().addComponent(namet,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE).addComponent(emailt,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE)
							.addComponent(courset,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE).addComponent(feet,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE)
							.addComponent(paidt,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE).addComponent(duet,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE).addComponent(addresst,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE)
							.addComponent(cityt,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE).addComponent(statet,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE)
							.addComponent(contactt,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE).addComponent(countryt,layout.PREFERRED_SIZE,200,layout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGap(70).addComponent(b2,layout.PREFERRED_SIZE,80,layout.PREFERRED_SIZE)));
			layout.setHorizontalGroup(hgrp);
			
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(namel).addComponent(namet));
			vgrp.addGap(20);
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(emaill).addComponent(emailt));
			vgrp.addGap(20);
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(coursel).addComponent(courset));
			vgrp.addGap(20);
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(feel).addComponent(feet));
			vgrp.addGap(20);
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(paidl).addComponent(paidt));
			vgrp.addGap(20);
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(duel).addComponent(duet));
			vgrp.addGap(20);
			vgrp.addGroup(layout.createParallelGroup().addComponent(addressl).addComponent(addresst,layout.PREFERRED_SIZE,70,layout.PREFERRED_SIZE));
			vgrp.addGap(20);
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(cityl).addComponent(cityt));
			vgrp.addGap(20);
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(statel).addComponent(statet));
			vgrp.addGap(20);
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(contactl).addComponent(contactt));
			vgrp.addGap(20);
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(countryl).addComponent(countryt));
			vgrp.addGap(30);
			vgrp.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(b1,layout.PREFERRED_SIZE,40,layout.PREFERRED_SIZE)
							.addComponent(b2));
			
			layout.setVerticalGroup(vgrp);
			center.setBounds(30,80,460,600);
			
			
			add(center);
			
			add(top);
			add(separate);
			
			
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				curr=new EditStudent();
			}
		});
	}

}
