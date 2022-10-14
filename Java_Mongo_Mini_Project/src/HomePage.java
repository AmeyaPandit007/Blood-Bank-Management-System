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

public class HomePage extends JFrame
{
	JMenuBar menuBar;
	JMenu Donar,Search,Delete,Exit;
	JMenuItem Add,Update,All_Donar,Delete_Donar,Logout,Exit_App;
	public HomePage() 
	{
		getContentPane().setLayout(null);
		
        menuBar = new JMenuBar();
        menuBar.setBackground(UIManager.getColor("CheckBox.background"));
        menuBar.setForeground(new Color(230, 230, 250));
        menuBar.setBounds(0, 0, 886, 50);
        getContentPane().add(menuBar);
        
        Donar = new JMenu("Donor");
        Donar.setBackground(Color.WHITE);
        Donar.setForeground(new Color(0, 0, 0));
        Donar.setIcon(new ImageIcon(HomePage.class.getResource("/icons/Donor.png")));
        Donar.setFont(new Font("Arial", Font.BOLD, 18));
        menuBar.add(Donar);
        
        Add = new JMenuItem("Add New");
        Add.setBackground(UIManager.getColor("CheckBox.background"));
        Add.setIcon(new ImageIcon(HomePage.class.getResource("/icons/New.png")));
        Add.setFont(new Font("Arial", Font.PLAIN, 18));
        Donar.add(Add);
        
        Add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Add_Donar().setVisible(true);
				setVisible(false);
			}
		});
        
        Update = new JMenuItem("Update Details");
        Update.setIcon(new ImageIcon(HomePage.class.getResource("/icons/Update.png")));
        Update.setBackground(UIManager.getColor("CheckBox.background"));
        Update.setFont(new Font("Arial", Font.PLAIN, 18));
        Donar.add(Update);
        
        Update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Update_Donar().setVisible(true);
				setVisible(false);
			}
		});
        
        Search = new JMenu("Search Donar");
        Search.setIcon(new ImageIcon(HomePage.class.getResource("/icons/Donar.png")));
        Search.setForeground(Color.BLACK);
        Search.setFont(new Font("Arial", Font.BOLD, 18));
        menuBar.add(Search);
        
        All_Donar = new JMenuItem("All Donar Details");
        All_Donar.setBackground(UIManager.getColor("CheckBox.background"));
        All_Donar.setIcon(new ImageIcon(HomePage.class.getResource("/icons/AllDetails.png")));
        All_Donar.setFont(new Font("Arial", Font.PLAIN, 18));
        Search.add(All_Donar);
        
        All_Donar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new All_Donar_Details().setVisible(true);
				setVisible(false);
			}
		});
        
        Delete = new JMenu("Delete Donar");
        Delete.setIcon(new ImageIcon(HomePage.class.getResource("/icons/DelDon.png")));
        Delete.setForeground(Color.BLACK);
        Delete.setFont(new Font("Arial", Font.BOLD, 18));
        menuBar.add(Delete);
        
        Delete_Donar = new JMenuItem("Delete Donar");
        Delete_Donar.setIcon(new ImageIcon(HomePage.class.getResource("/icons/Delete.png")));
        Delete_Donar.setBackground(UIManager.getColor("CheckBox.background"));
        Delete_Donar.setFont(new Font("Arial", Font.PLAIN, 18));
        Delete.add(Delete_Donar);
        
        Delete_Donar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Delete_Donar().setVisible(true);
				setVisible(false);
			}
		});
        
        Exit = new JMenu("Exit");
        Exit.setIcon(new ImageIcon(HomePage.class.getResource("/icons/Exit.png")));
        Exit.setForeground(Color.BLACK);
        Exit.setFont(new Font("Arial", Font.BOLD, 18));
        menuBar.add(Exit);
        
        Logout = new JMenuItem("Logout");
        Logout.setBackground(UIManager.getColor("CheckBox.background"));
        Logout.setIcon(new ImageIcon(HomePage.class.getResource("/icons/Logout.png")));
        Logout.setFont(new Font("Arial", Font.PLAIN, 18));
        Exit.add(Logout);
        
        Logout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Login().setVisible(true);
				setVisible(false);
			}
		});
        
        Exit_App = new JMenuItem("Exit Application");
        Exit_App.setIcon(new ImageIcon(HomePage.class.getResource("/icons/Cross.png")));
        Exit_App.setBackground(UIManager.getColor("CheckBox.background"));
        Exit_App.setFont(new Font("Arial", Font.PLAIN, 18));
        Exit.add(Exit_App);
        
        Exit_App.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Exit_App,"Visit Again..!\nSee you soon.","Thank You..!",JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
        
        JLabel lblNewLabel_1 = new JLabel("Donate Blood");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 70));
        lblNewLabel_1.setBounds(344, 194, 521, 170);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Save Lives");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 70));
        lblNewLabel_2.setForeground(Color.RED);
        lblNewLabel_2.setBounds(460, 303, 426, 170);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBackground(Color.LIGHT_GRAY);
        lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("/icons/HomePage.jpg")));
        lblNewLabel.setBounds(0, 0, 900,700);
        getContentPane().add(lblNewLabel);
        

               
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Blood Bank Management System");
        setSize(900,700);
        setLocation(330,70);
        getContentPane().setLayout(null);
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new HomePage().setVisible(true);
	}
}
