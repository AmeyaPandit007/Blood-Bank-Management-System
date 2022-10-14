import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Update_Donar extends JFrame
{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	boolean bool = false;
	public Update_Donar() 
	{
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Update Donar Details\r\n");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 50));
        lblNewLabel_1.setBounds(93, 45, 630, 78);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Full Name :- ");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_2.setBounds(52, 209, 133, 30);
        getContentPane().add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setBounds(215, 210, 200, 30);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Age :-");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3.setBounds(52, 259, 133, 30);
        getContentPane().add(lblNewLabel_3);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Arial", Font.BOLD, 18));
        textField_1.setColumns(10);
        textField_1.setBounds(215, 260, 200, 30);
        getContentPane().add(textField_1);
        
        JLabel lblNewLabel_3_1 = new JLabel("Mobile No. :-");
        lblNewLabel_3_1.setForeground(Color.WHITE);
        lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1.setBounds(52, 309, 133, 30);
        getContentPane().add(lblNewLabel_3_1);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Arial", Font.BOLD, 18));
        textField_2.setColumns(10);
        textField_2.setBounds(215, 310, 200, 30);
        getContentPane().add(textField_2);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("City :-");
        lblNewLabel_3_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1_1.setBounds(52, 359, 133, 30);
        getContentPane().add(lblNewLabel_3_1_1);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Arial", Font.BOLD, 18));
        textField_3.setColumns(10);
        textField_3.setBounds(215, 360, 200, 30);
        getContentPane().add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Arial", Font.BOLD, 18));
        textField_4.setColumns(10);
        textField_4.setBounds(215, 140, 200, 30);
        getContentPane().add(textField_4);
        
        JLabel lblNewLabel_3_1_1_1 = new JLabel("Gender :-");
        lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1_1_1.setBounds(52, 409, 133, 30);
        getContentPane().add(lblNewLabel_3_1_1_1);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Arial", Font.BOLD, 18));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "I Prefer Not To Say"}));
        comboBox.setBounds(215, 410, 200, 30);
        getContentPane().add(comboBox);
        
        JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Blood Group :-");
        lblNewLabel_3_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1_1_1_1.setBounds(52, 459, 153, 30);
        getContentPane().add(lblNewLabel_3_1_1_1_1);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
        comboBox_1.setFont(new Font("Arial", Font.BOLD, 18));
        comboBox_1.setBounds(215, 460, 200, 30);
        getContentPane().add(comboBox_1);
        
        JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Aadhar No. :-");
        lblNewLabel_3_1_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1_1_1_1_1.setBounds(52, 139, 153, 30);
        getContentPane().add(lblNewLabel_3_1_1_1_1_1);
        
        JButton btnNewButton = new JButton("Update");
        btnNewButton.setEnabled(false);
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
        btnNewButton.setBounds(84, 544, 145, 37);
        getContentPane().add(btnNewButton);
        
        JButton btnExit = new JButton("Exit");
        btnExit.setIcon(null);
        btnExit.setFont(new Font("Arial", Font.BOLD, 18));
        btnExit.setBounds(295, 544, 145, 37);
        getContentPane().add(btnExit);
        
        btnExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(btnExit,"Visit Again..!\nSee you soon.","Thank You..!",JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
        
        JButton btnSearch = new JButton("Search");
        btnSearch.setIcon(new ImageIcon(Update_Donar.class.getResource("/icons/Search.png")));
        btnSearch.setBackground(new Color(224, 255, 255));
        btnSearch.setFont(new Font("Arial", Font.BOLD, 18));
        btnSearch.setBounds(431, 135, 145, 40);
        getContentPane().add(btnSearch);
        
        btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
					String aadhar = textField_4.getText();
					
					if(aadhar.equals(""))
					{
						JOptionPane.showMessageDialog(btnNewButton,"Aadhar No. Cannot be Empty..!","Error",JOptionPane.ERROR_MESSAGE);
					}
					else if(aadhar!=null && aadhar.length()!=12)
					{
						JOptionPane.showMessageDialog(btnNewButton,"Adhaar No. Should be of 12 Digits..!","Error",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
	                    MongoClient mongo = new MongoClient("localhost", 27017);

	                    DB db = mongo.getDB("Blood_Bank");

	                    // if collection doesn't exists, MongoDB will create it for you
	                    DBCollection coll = db.getCollection("Add_Donar");
	                    
	                    BasicDBObject doc = new BasicDBObject("Aadhar_No",aadhar);
	                    
	                    DBCursor cursor1 = coll.find(doc);
	                    if(cursor1.hasNext())
	                    {
	                    	JOptionPane.showMessageDialog(btnSearch,"Click On Update for Updation of record.","Search Found..!",JOptionPane.INFORMATION_MESSAGE);
	                    	//bool = true;
	                    	btnNewButton.setEnabled(true);
	                    	//setVisible(false);
	                    	//new HomePage().setVisible(true);
	                    }
	                    else 
	                    {
	                    	JOptionPane.showMessageDialog(btnSearch,"Search Not Found..!","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				} 
				catch (Exception e2) 
				{
					System.out.println(e2);
				}
			}
		});
        
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 18));
        btnBack.setBounds(188, 603, 145, 37);
        getContentPane().add(btnBack);
        
        btnBack.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HomePage().setVisible(true);
				setVisible(false);
			}
		});
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Add_Donar.class.getResource("/icons/Add_Donar.jpg")));
        lblNewLabel.setBounds(0, 0, 900,700);
        getContentPane().add(lblNewLabel);
        
        btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String aadhar = textField_4.getText();
					String name = textField.getText();				
					String age = textField_1.getText();
					String mob = textField_2.getText();
					String city = textField_3.getText();
					String gender = (String)comboBox.getSelectedItem();
					String BG = (String)comboBox_1.getSelectedItem();
					
					if (mob!=null && mob.length()!=10) 
					{
						JOptionPane.showMessageDialog(btnNewButton,"Mobile No. Should be of 10 Digits..!","Error",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
	                    MongoClient mongo = new MongoClient("localhost", 27017);

	                    DB db = mongo.getDB("Blood_Bank");

	                    // if collection doesn't exists, MongoDB will create it for you
	                    DBCollection coll = db.getCollection("Add_Donar");
									
			        	BasicDBObject doc1 = new BasicDBObject();
			        	doc1.append("Aadhar_No",aadhar);
			        	doc1.append("Name",name);
			        	doc1.append("Age",age);
			        	doc1.append("Mob",mob);
			        	doc1.append("City",city);
			        	doc1.append("Gender",gender);
			        	doc1.append("Blood_Group",BG);
			        	 
			        	BasicDBObject searchQuery = new BasicDBObject();
			        	searchQuery.append("Aadhar_No",aadhar);
			        		
			        	 
			        	coll.update(searchQuery, doc1);
			        	
			        	JOptionPane.showMessageDialog(btnNewButton,"Donor Updated successfully..!","Thank You..",JOptionPane.INFORMATION_MESSAGE);
			        	textField_4.setText("");
			        	textField.setText("");
			        	textField_1.setText("");
			        	textField_2.setText("");
			        	textField_3.setText("");
			        	//System.out.println("Data updated");
					}
				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
				
			}
		});
        
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Blood Bank Management System");
        setSize(900,700);
        setLocation(330,70);
        getContentPane().setLayout(null);
	}
	public static void main(String[] args) 
	{
		new Update_Donar();
	}
}
