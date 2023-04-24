
package CabBooking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


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
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Logged in Successfully");
                    frame.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong Credential. Please Try Again");
                    frame.setVisible(false); // just to clear the input fields;
                    frame.setVisible(true); 

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    } 

    public static void main(String[] args) {
        new Login();
    }
}