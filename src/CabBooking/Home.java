
package CabBooking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Home extends JFrame{
   JLabel imgl;
   
   
   Home(){
	   
	   //main frame configuration
	   super("Taxi Booking Manager");
	   setVisible(true);
	   setLocation(0,0);
	   setSize(1366, 750);
	    
	   //background Image
	   ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("CabBooking/img/SignUp.png"));
	   Image im1 = img.getImage().getScaledInstance(1366, 700, Image.SCALE_DEFAULT);
	   ImageIcon background = new ImageIcon(im1);
	   imgl = new JLabel(background);
	   
	   // menuBar
	   
	   JMenuBar menuBar = new JMenuBar();
	   JMenu BookRide = new JMenu();
//	   JMenuItem 
   }
   
  public static void main(String[] args) {
	  new Home();
  }
   
}
