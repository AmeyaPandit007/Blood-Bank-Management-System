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

public class Add_Donar extends JFrame
{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public Add_Donar() 
	{
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("ADD NEW DONAR");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 50));
        lblNewLabel_1.setBounds(184, 50, 424, 78);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Full Name :- ");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_2.setBounds(52, 176, 133, 30);
        getContentPane().add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setBounds(215, 180, 200, 30);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Age :-");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3.setBounds(52, 226, 133, 30);
        getContentPane().add(lblNewLabel_3);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Arial", Font.BOLD, 18));
        textField_1.setColumns(10);
        textField_1.setBounds(215, 230, 200, 30);
        getContentPane().add(textField_1);
        
        JLabel lblNewLabel_3_1 = new JLabel("Mobile No. :-");
        lblNewLabel_3_1.setForeground(Color.WHITE);
        lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1.setBounds(52, 279, 133, 30);
        getContentPane().add(lblNewLabel_3_1);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Arial", Font.BOLD, 18));
        textField_2.setColumns(10);
        textField_2.setBounds(215, 280, 200, 30);
        getContentPane().add(textField_2);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("City :-");
        lblNewLabel_3_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1_1.setBounds(52, 332, 133, 30);
        getContentPane().add(lblNewLabel_3_1_1);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Arial", Font.BOLD, 18));
        textField_3.setColumns(10);
        textField_3.setBounds(215, 330, 200, 30);
        getContentPane().add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Arial", Font.BOLD, 18));
        textField_4.setColumns(10);
        textField_4.setBounds(215, 487, 200, 30);
        getContentPane().add(textField_4);
        
        JLabel lblNewLabel_3_1_1_1 = new JLabel("Gender :-");
        lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1_1_1.setBounds(52, 381, 133, 30);
        getContentPane().add(lblNewLabel_3_1_1_1);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Arial", Font.BOLD, 18));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "I Prefer Not To Say"}));
        comboBox.setBounds(215, 380, 200, 30);
        getContentPane().add(comboBox);
        
        JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Blood Group :-");
        lblNewLabel_3_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1_1_1_1.setBounds(52, 436, 153, 30);
        getContentPane().add(lblNewLabel_3_1_1_1_1);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
        comboBox_1.setFont(new Font("Arial", Font.BOLD, 18));
        comboBox_1.setBounds(215, 430, 200, 30);
        getContentPane().add(comboBox_1);
        
        JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Aadhar No. :-");
        lblNewLabel_3_1_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1_1_1_1_1.setBounds(52, 487, 153, 30);
        getContentPane().add(lblNewLabel_3_1_1_1_1_1);
        
        JButton btnNewButton = new JButton("Insert");
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
        btnNewButton.setBounds(75, 574, 145, 37);
        getContentPane().add(btnNewButton);
        
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Arial", Font.BOLD, 18));
        btnExit.setBounds(440, 574, 145, 37);
        getContentPane().add(btnExit);
        
        btnExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(btnExit,"Visit Again..!\nSee you soon.","Thank You..!",JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
        
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 18));
        btnBack.setBounds(261, 574, 145, 37);
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
				// TODO Auto-generated method stub
				try 
				{
					String aadhar = textField_4.getText();
					String name = textField.getText();				
					String age = textField_1.getText();
					String mob = textField_2.getText();
					String city = textField_3.getText();
					String gender = (String)comboBox.getSelectedItem();
					String BG = (String)comboBox_1.getSelectedItem();
					
					if(aadhar.equals("") || name.equals("") || age.equals("") || mob.equals("") || city.equals(""))
					{
						JOptionPane.showMessageDialog(btnNewButton,"All fiels are required..!","Error",JOptionPane.ERROR_MESSAGE);
					}
					else if (mob!=null && mob.length()!=10) 
					{
						JOptionPane.showMessageDialog(btnNewButton,"Mobile No. Should be of 10 Digits..!","Error",JOptionPane.ERROR_MESSAGE);
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
	                    
	                    ////////////////////////////////////////
	                    BasicDBObject doc = new BasicDBObject("Aadhar_No",aadhar);
	                    doc.put("Name",name);
	                    doc.put("Age",age);
	                    doc.put("Mob",mob);
	                    doc.put("City",city);
	                    doc.put("Gender",gender);
	                    doc.put("Blood_Group",BG);
	                    
	                    coll.insert(doc);
	                    JOptionPane.showMessageDialog(btnNewButton,"Donor Added successfully..!","Thank You..",JOptionPane.INFORMATION_MESSAGE);
			        	textField_4.setText("");
			        	textField.setText("");
			        	textField_1.setText("");
			        	textField_2.setText("");
			        	textField_3.setText("");
					}				
				} 
				catch (Exception e1) 
				{
					System.out.println(e1);
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
		new Add_Donar();
	}
}
