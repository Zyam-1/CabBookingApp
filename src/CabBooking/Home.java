
package CabBooking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Home extends JFrame{
   JLabel imgl;
   JPanel panel;
   
   
   Home(){
	   
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
	   
	   JMenu bill = new JMenu("Total Bill");
	   
	   JMenu LogOut = new JMenu("Log Out");
	   
	  
	   BookRide.add(brItem);
	   BookRide.add(brItem2);
	   
	   transport.add(transMenu);
	   
	   menuBar.add(BookRide);
	   menuBar.add(transport);
	   menuBar.add(bill);
	   menuBar.add(LogOut);
	   
           panel = new JPanel(new BorderLayout());
           panel.add(menuBar, BorderLayout.NORTH);
	   setJMenuBar(menuBar);
           add(panel);
	   add(imgl);
           imgl.setBounds(0, 0, 1366, 700);
           ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Desktop\\CabBookingApp\\src\\CabBooking\\img\\favicon.png");
           setIconImage(icon.getImage());
	   
   }
   
  public static void main(String[] args) {
	  new Home();
  }
   
}
