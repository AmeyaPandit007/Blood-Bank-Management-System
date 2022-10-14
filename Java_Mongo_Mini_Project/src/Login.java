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

public class Login extends JFrame
{
	private JTextField textField;
	private JPasswordField passwordField;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3;
	private JLabel lblNewLabel;
	
	public Login() 
	{
		getContentPane().setLayout(null);
        
		l1 = new JLabel("Enter Your Username :- ");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Arial", Font.BOLD, 18));
		l1.setBounds(192, 298, 236, 33);
        getContentPane().add(l1);
        
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setBounds(458, 300, 261, 33);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        l2 = new JLabel("Log-In");
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 40));
        l2.setBounds(10, 222, 866, 49);
        getContentPane().add(l2);
        
        l3 = new JLabel("Enter Your Password :-");
        l3.setFont(new Font("Arial", Font.BOLD, 18));
        l3.setForeground(Color.WHITE);
        l3.setBounds(192, 364, 236, 33);
        getContentPane().add(l3);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.BOLD, 18));
        passwordField.setBounds(458, 366, 261, 33);
        getContentPane().add(passwordField);
        
        b1 = new JButton("Sign In");
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b1.setBounds(246, 465, 149, 40);
        getContentPane().add(b1);
        
        b2 = new JButton("Exit");
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setBounds(480, 465, 149, 40);
        getContentPane().add(b2);
        
        b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(b2,"Visit Again..!\nSee you soon.","Thank You..!",JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} 
		});
        
        lblNewLabel = new JLabel("Welcome to Blood-Bank");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
        lblNewLabel.setBounds(10, 161, 866, 49);
        getContentPane().add(lblNewLabel);
        
        l4 = new JLabel("New label");
        l4.setIcon(new ImageIcon("D:\\Eclipse-Java-Workspace\\Java_Mongo_Mini_Project\\src\\icons\\Login.jpg"));
        l4.setBounds(0, -34, 900,700);
        getContentPane().add(l4);
        
        //getContentPane().setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Blood Bank Management System");
        setSize(900,700);
        setLocation(330,70);
        
        b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
                    String s1 = textField.getText();
                    String s2 = passwordField.getText();
                    
                    if(s1.equals("") && !s2.equals(""))
                    {
                    	JOptionPane.showMessageDialog(b1,"Username field Cannot be empty","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(s2.equals("") && !s1.equals(""))
                    {
                    	JOptionPane.showMessageDialog(b1,"Password field Cannot be empty","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(s2.equals("") && s1.equals(""))
                    {
                    	JOptionPane.showMessageDialog(b1,"Username and Password field Cannot be empty","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        /**** Connect to MongoDB ****/
                        // uses MongoClient
                        MongoClient mongo = new MongoClient("localhost", 27017);

                        /**** Get database ****/
                        // if database doesn't exists, MongoDB will create it for you
                        DB db = mongo.getDB("Blood_Bank");

                        // if collection doesn't exists, MongoDB will create it for you
                        DBCollection coll = db.getCollection("Login");
                        
                        System.out.println("Connection Successfull..!");
                                               
                        BasicDBObject bo = new BasicDBObject("Username",s1).append("Password",s2);
                            
                        DBCursor cursor1 = coll.find(bo);
                        if(cursor1.hasNext())
                        {
                        	JOptionPane.showMessageDialog(b1,"Logged in successfull..!","Welcome to Blood Bank.",JOptionPane.INFORMATION_MESSAGE);
                            setVisible(false);
                            new HomePage().setVisible(true);
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(b1,"Enter Proper Credentials..!","Error",JOptionPane.ERROR_MESSAGE);
    					}				
                    }

				} 
				catch (Exception e2) 
				{
					System.out.println("Error Occurred..!"+e2);
				}
			}
		});
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Login();
	}
}
