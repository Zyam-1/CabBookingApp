
package CabBooking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



public class Login extends javax.swing.JFrame implements ActionListener {
    JFrame frame;
    JTextField unamef;
    JPasswordField passf;
    JButton logBtn, signBtn;
    JLabel unamel, passl, title;
    
    Login(){
        frame = new JFrame("Login");
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        
        title =  new JLabel("Login");
        title.setBounds(160, 30, 100, 50);
        title.setFont(new Font("Ariel", Font.BOLD, 30));
        frame.add(title);
        
        unamel = new JLabel("Username");
        unamel.setBounds(70, 90, 70, 30);
        frame.add(unamel);
        
        passl = new JLabel("Password");
        passl.setBounds(70, 140, 70, 30);
        frame.add(passl);
        
        unamef = new JTextField();
        unamef.setBounds(190, 90, 150, 30);
        frame.add(unamef);
        
        passf = new JPasswordField();
        passf.setBounds(190, 140, 150, 30);
        frame.add(passf);
        
        logBtn = new JButton("Login");
        logBtn.setBackground(Color.WHITE);
        logBtn.setForeground(Color.BLACK);
        logBtn.setBounds(230, 200, 80, 30);
        frame.add(logBtn);
        
        signBtn = new JButton("Create Account");
        signBtn.setBackground(Color.WHITE);
        signBtn.setForeground(Color.BLACK);
        signBtn.setBounds(40, 200, 160, 30);
        frame.add(signBtn);
        
        logBtn.addActionListener(this);
        signBtn.addActionListener(this);
        
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Desktop\\CabBookingApp\\src\\CabBooking\\img\\favicon.png");
        frame.setIconImage(icon.getImage());

        frame.setVisible(true);
        frame.setSize(400,300);
        frame.setLocation(400,300);
    }

    public void actionPerformed(ActionEvent ee){
        if(ee.getSource()==signBtn){
            new SignUp();
            this.frame.setVisible(false);
        }
        if(ee.getSource()==logBtn){
            try {
                ConnectionClass connec = new ConnectionClass();
                String uname = unamef.getText();
                String pass = passf.getText();
                String query = "select * from users where username = '"+uname+"' and password = '"+pass+"'";
                ResultSet rs = connec.stm.executeQuery(query);
//                System.out.println(rs);
                String name;
            	String phone;
                if(rs.next()){
                	
                	name = rs.getString(2);
                	phone = rs.getString(4);
                	System.out.println("Read before Storing");
                	
                	System.out.println("Username: " + name);
                	System.out.println("UserPhone Num: " + phone);
                	
                	FileOutputStream output = new FileOutputStream("C:\\Users\\hp\\Desktop\\CabBookingApp\\src\\CabBooking\\user.properties");
                	Properties prop = new Properties();
                        prop.setProperty("name", name);
                        prop.setProperty("phone", phone);
                        prop.setProperty("isLoggedIn", "true");
                        prop.store(output, null);
                        try (FileInputStream input = new FileInputStream("C:\\Users\\hp\\Desktop\\CabBookingApp\\src\\CabBooking\\user.properties")) {
                        prop.load(input);

                        String name1 = prop.getProperty("name");
                        String phone1 = prop.getProperty("phone");
                        

                        System.out.println("Read through Property Files");
                        System.out.println("Name: " + name1);
                        System.out.println("Phone: " + phone1);
                        

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    
                    
                    JOptionPane.showMessageDialog(null, "Logged in Successfully");
                    frame.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong Credentials. Please Try Again");
                    frame.setVisible(false); // just to clear the input fields;
                    frame.setVisible(true); 

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    } 

    public static void main(String[] args) {
        new Login();
    }
}