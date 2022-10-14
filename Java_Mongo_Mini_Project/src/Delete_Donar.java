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

public class Delete_Donar extends JFrame
{
	private JTextField textField_4;
	Boolean bts = false;
	public Delete_Donar() 
	{
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Delete DONAR");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 50));
        lblNewLabel_1.setBounds(194, 52, 424, 78);
        getContentPane().add(lblNewLabel_1);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Arial", Font.BOLD, 18));
        textField_4.setColumns(10);
        textField_4.setBounds(267, 237, 200, 30);
        getContentPane().add(textField_4);
        
        JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Aadhar No. :-");
        lblNewLabel_3_1_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_3_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3_1_1_1_1_1.setBounds(67, 236, 153, 30);
        getContentPane().add(lblNewLabel_3_1_1_1_1_1);
        
        JButton btnNewButton = new JButton("Delete");
        btnNewButton.setIcon(new ImageIcon(Delete_Donar.class.getResource("/icons/Delete.png")));
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
        btnNewButton.setBounds(160, 308, 192, 37);
        getContentPane().add(btnNewButton);
        
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Arial", Font.BOLD, 18));
        btnExit.setBounds(322, 444, 145, 37);
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
        btnBack.setBounds(67, 444, 145, 37);
        getContentPane().add(btnBack);
        
        btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HomePage().setVisible(true);
				setVisible(false);
			}
		});
        
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Arial", Font.BOLD, 18));
        btnClear.setBounds(192, 516, 145, 37);
        getContentPane().add(btnClear);
        
        btnClear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField_4.setText("");
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
					
					if(aadhar.equals(""))
					{
						JOptionPane.showMessageDialog(btnNewButton,"Adhaar No. Field cannot be empty..!","Error",JOptionPane.ERROR_MESSAGE);
					}
					else if(aadhar.length()!=12)
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
	                    while(cursor1.hasNext())
	                    {
	                        if(cursor1.hasNext())
	                        {
	                        	//JOptionPane.showMessageDialog(btnNewButton,"Click On Update for Updation of record.","Search Found..!",JOptionPane.INFORMATION_MESSAGE);
	                        	bts = true;
	                        	break;
	                        }
	                        else 
	                        {
	                        	bts=false;
	                        	continue;
	                        	//JOptionPane.showMessageDialog(btnNewButton,"Cannot Not Found the Record That You Want To Delete..!","Error",JOptionPane.ERROR_MESSAGE);
	    					}
	                    }

	                    
	                    if(bts==true)
	                    {

	    	        	 	while (cursor1.hasNext()) 
	    	        	 	{
	    	        	 		DBObject item = cursor1.next();
	    	        	 		coll.remove(item);
	    	        	 		//bts=true;
	    	        	 		JOptionPane.showMessageDialog(btnNewButton,"Donor Deleted successfully..!","Thank You..",JOptionPane.INFORMATION_MESSAGE);
	    	        	 		textField_4.setText("");
	    	        	 		break; 
	    	        	 	}
	    	        	 	
	                    }
	                    else 
	                    {
	                    	JOptionPane.showMessageDialog(btnNewButton,"Cannot Not Found the Record That You Want To Delete..!","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
                    /*MongoClient mongo = new MongoClient("localhost", 27017);

                    DB db = mongo.getDB("Blood_Bank");

                    // if collection doesn't exists, MongoDB will create it for you
                    DBCollection coll = db.getCollection("Add_Donar");
                    
                    BasicDBObject doc = new BasicDBObject("Aadhar_No",aadhar);
                    
                    DBCursor cursor1 = coll.find(doc);
                    while(cursor1.hasNext())
                    {
                        if(cursor1.hasNext())
                        {
                        	//JOptionPane.showMessageDialog(btnNewButton,"Click On Update for Updation of record.","Search Found..!",JOptionPane.INFORMATION_MESSAGE);
                        	bts = true;
                        	break;
                        }
                        else 
                        {
                        	bts=false;
                        	continue;
                        	//JOptionPane.showMessageDialog(btnNewButton,"Cannot Not Found the Record That You Want To Delete..!","Error",JOptionPane.ERROR_MESSAGE);
    					}
                    }

                    
                    if(bts==true)
                    {

    	        	 	while (cursor1.hasNext()) 
    	        	 	{
    	        	 		DBObject item = cursor1.next();
    	        	 		coll.remove(item);
    	        	 		//bts=true;
    	        	 		JOptionPane.showMessageDialog(btnNewButton,"Donor Deleted successfully..!","Thank You..",JOptionPane.INFORMATION_MESSAGE);
    	        	 		textField_4.setText("");
    	        	 		break; 
    	        	 	}
    	        	 	
                    }
                    else 
                    {
                    	JOptionPane.showMessageDialog(btnNewButton,"Cannot Not Found the Record That You Want To Delete..!","Error",JOptionPane.ERROR_MESSAGE);
					}*/
                    
				} 
				catch (Exception e2) 
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
		new Delete_Donar();
	}
}
