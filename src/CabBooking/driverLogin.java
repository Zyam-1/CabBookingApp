package CabBooking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class driverLogin extends JFrame implements ActionListener {

    JTextField emailF;
    JPasswordField passF;
    JLabel emailL, passL;
    JButton loginBtn;

    driverLogin() {
        //JFrame congfiguration
        super("Driver Login");
        setLocation(450, 250);
        setSize(400, 350);
        setVisible(true);
        setLayout(null);
        setResizable(false);

        //favicon
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Desktop\\CabBookingApp\\src\\CabBooking\\img\\favicon.png");
        setIconImage(icon.getImage());

        emailL = new JLabel("Email: ");
        emailL.setBounds(30, 40, 130, 30);
        add(emailL);
        
        
        passL = new JLabel("Password: ");
        passL.setBounds(30, 140, 130, 30);
        add(passL);
        
        emailF = new JTextField();
        emailF.setBounds(180, 40, 180, 30);
        add(emailF);

        passF = new JPasswordField();
        passF.setBounds(180, 140, 180, 30);
        add(passF);
        
        loginBtn = new JButton("Login");
        loginBtn.setBounds(125,200, 140, 30);
        add(loginBtn);
        
        loginBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("Login")){
            String email = emailF.getText();
            String pass = passF.getText();
            System.out.print(pass);

        }
    }

    public static void main(String args[]) {
        new driverLogin();

    }

}
