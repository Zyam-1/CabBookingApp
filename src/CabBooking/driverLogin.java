package CabBooking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Properties;
import static javax.swing.JOptionPane.showMessageDialog;

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
        loginBtn.setBounds(125, 200, 140, 30);
        add(loginBtn);

        loginBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Login")) {
            String email = emailF.getText();
            String pass = passF.getText();
//            System.out.print(pass);

            try {
                ConnectionClass conn_hq = new ConnectionClass();
                String sql = "SELECT * FROM registered_drivers where email = '" + email + "' and  password = '" + pass + "'";
                ResultSet rs = conn_hq.stm.executeQuery(sql);
                if (rs.next()) {
                    
                    FileOutputStream input = new FileOutputStream("C:\\Users\\HP\\Desktop\\CabBookingApp\\src\\CabBooking\\driver.properties");
                    Properties prop = new Properties();
                    prop.setProperty("email", email);
                    prop.setProperty("isLoggedIn", "true");
                    
                    
                    prop.store(input, null);
                    showMessageDialog(null, "Driver logged in Successfuly");
                    setVisible(false);
                    new DriverHome();
                }
                else {
                    showMessageDialog(null, "Wrong Credientials. Please try again");
                }
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }

    }

    public static void main(String args[]) {
        new driverLogin();

    }
}
