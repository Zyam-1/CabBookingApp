
package CabBooking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.sql.*;
import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home extends JFrame implements ActionListener{
   JLabel imgl;
   JPanel panel;
   
   
   Home() throws FileNotFoundException, IOException {
	   
	   //main frame configuration
	   super("Taxi Booking Manager");
	   setVisible(true);
	   setLocation(0,0);
	   setSize(1366, 750);
	    
	   //background Image
	   ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("CabBooking/img/Home.jpg"));
	   Image im1 = img.getImage().getScaledInstance(1366, 700, Image.SCALE_DEFAULT);
	   ImageIcon background = new ImageIcon(im1);
	   imgl = new JLabel(background);
	   
	   // menuBar
	   
	   JMenuBar menuBar = new JMenuBar();
	   
	   JMenu BookRide = new JMenu("Book a Ride");
	   JMenuItem brItem = new JMenuItem("Book a Local Ride");
	   JMenuItem brItem2 = new JMenuItem("Book a Long Distance Ride");
	   
	   JMenu transport = new JMenu("Transport Services");
	   JMenuItem transMenu = new JMenuItem("Cargo Transport");
	   
	   JMenu billInfo = new JMenu("Bill Information");
           JMenuItem totalBill = new JMenuItem("Total Bill");
           billInfo.add(totalBill);
	   
	   JMenu account = new JMenu("Account");
           JMenuItem logOut = new JMenuItem("LogOut");
	   
	  
	   BookRide.add(brItem);
	   BookRide.add(brItem2);
	   
	   transport.add(transMenu);
           
           account.add(logOut);
	   
	   menuBar.add(BookRide);
	   menuBar.add(transport);
	   menuBar.add(billInfo);
	   menuBar.add(account);
           
           brItem.addActionListener(this);
           brItem2.addActionListener(this);
           totalBill.addActionListener(this);
           transMenu.addActionListener(this);
           logOut.addActionListener(this);
           
           
	   
           panel = new JPanel(new BorderLayout());
           panel.add(menuBar, BorderLayout.NORTH);
	   setJMenuBar(menuBar);
           add(panel);
	   add(imgl);
           imgl.setBounds(0, 0, 1366, 700);
           ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Desktop\\CabBookingApp\\src\\CabBooking\\img\\favicon.png");
           setIconImage(icon.getImage());
       
       
	   
   }
   
   @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("Book a Local Ride")){
            System.out.println("Book a Local Ride Clicked");
        }
        else if(action.equals("Book a Long Distance Ride")){
            System.out.println("Book a Long Distance Ride Clicked");
        }
        
        else if(action.equals("Cargo Transport")){
            System.out.println("Cargo Transport Clicked");
        }
        else if(action.equals("Total Bill")){
         System.out.println("Total Bill Clicked");   
        }
        else if(action.equals("LogOut")){
            System.out.println("LogOut Clicked");
            try {
           FileOutputStream readProp = new FileOutputStream("C:\\Users\\HP\\Desktop\\CabBookingApp\\src\\CabBooking\\user.properties");
           Properties prop = new Properties();
           prop.setProperty("name", "");
           prop.setProperty("phone", "");
           prop.setProperty("isLoggedIn", "false");
                try {
                    prop.store(readProp, null);
                    setVisible(false);
                    new Login();
                } catch (IOException ex) {
                   ex.printStackTrace();
                }

           
           
       } catch (FileNotFoundException ex) {
           ex.printStackTrace();
       }
        }
    }
   
  public static void main(String[] args) throws IOException {
	  new Home();
  }

    
   
}
