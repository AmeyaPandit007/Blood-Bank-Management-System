import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class All_Donar_Details extends JFrame
{
	JFrame frame1;
    String[] columnNames = {"Aadhar_No","Name","Age","Mob","City","Gender","Blood_Group"};
    static JTable table;
    JScrollPane scroll;
	public All_Donar_Details() 
	{
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("All Donar Details");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 50));
        lblNewLabel_1.setBounds(150, 51, 503, 78);
        getContentPane().add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("Show");
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
        btnNewButton.setBounds(62, 411, 145, 37);
        getContentPane().add(btnNewButton);
        
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Arial", Font.BOLD, 18));
        btnExit.setBounds(204, 489, 145, 37);
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
        btnBack.setBounds(351, 411, 145, 37);
        getContentPane().add(btnBack);
        
        btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new HomePage().setVisible(true);
				setVisible(false);
			}
		});
        
        JLabel lblNewLabel_2 = new JLabel("Click On Show Button");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Algerian", Font.BOLD, 35));
        lblNewLabel_2.setBounds(33, 199, 503, 56);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("To get All Donar Details");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Algerian", Font.BOLD, 35));
        lblNewLabel_2_1.setBounds(33, 265, 503, 56);
        getContentPane().add(lblNewLabel_2_1);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Add_Donar.class.getResource("/icons/Add_Donar.jpg")));
        lblNewLabel.setBounds(0, 0, 900,700);
        getContentPane().add(lblNewLabel);
        
        btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
                    MongoClient mongo = new MongoClient("localhost", 27017);

                    DB db = mongo.getDB("Blood_Bank");

                    // if collection doesn't exists, MongoDB will create it for you
                    DBCollection coll = db.getCollection("Add_Donar");
                    
                    /***********************************/
                    
                    frame1 = new JFrame("Database Donor List");

                    //frame1.add(mb);
                    //frame1.setJMenuBar(mb);

                    //frame1.setDefaultCloseOperation(JFrame.);
                    frame1.getContentPane().setLayout(new BorderLayout());
                    
                    DefaultTableModel model = new DefaultTableModel();
                    model.setColumnIdentifiers(columnNames);
                    All_Donar_Details.table = new JTable();
                    All_Donar_Details.table.setModel(model);
                    All_Donar_Details.table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    All_Donar_Details.table.setFillsViewportHeight(true);

                    scroll = new JScrollPane(All_Donar_Details.table);
                    
                    scroll.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    scroll.setVerticalScrollBarPolicy(
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    
                    /***********************************/
                    BasicDBObject doc = new BasicDBObject();
                    
                    ///////////////////////////////////
                    /*String aadhar = "";
                    String name = "";
                    String age = "";
                    String mob = "";
                    String city = "";
                    String gender = "";
                    String BG= "";*/
                    
                    DBCursor cursor = coll.find();
                    int i=0;
                    while (cursor.hasNext()) 
                    {
                    	DBObject disp = cursor.next();
                    	
                    	String aadhar = (String)disp.get("Aadhar_No");
                    	String name = (String)disp.get("Name");
                    	String age = (String)disp.get("Age");
                    	String mob = (String)disp.get("Mob");
                    	String city = (String)disp.get("City");
                    	String gender = (String)disp.get("Gender");
                    	String BG = (String)disp.get("Blood_Group");
    					
                        //model.addRow(new Object[]{"Aadhar_No","Name","Age","Mob","City","Gender","Blood_Group"});
                        model.addRow(new Object[]{aadhar,name,age,mob,city,gender,BG});
                        i++;
    					//lblNewLabel_2.setText("Aadhar_No : "+aadhar+"  Name : "+name);
    					//continue;
    					//lblNewLabel_2.setText("Aadhar_No : "+aadhar+"  Name : "+name+"  Age : "+age+"  Mob : "+mob+"\n"+"City : "+city+"\nGender : "+gender+"\nBlood_Group : "+BG);
  
                    }                  
                             
                    frame1.getContentPane().add(scroll);
                    frame1.setVisible(true);
                    frame1.setSize(1200,600);
                    //////////////////////////////////
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
		new All_Donar_Details();
	}
}
