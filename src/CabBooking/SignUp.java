package CabBooking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignUp extends javax.swing.JFrame implements ActionListener {
	
    JFrame frame;  // This is the frame of the SignUp Page window
    JLabel unameL, nameL, passL, phoneL, imgL; // These variable are used for the labels in the Sign-up page
    JTextField unameF, nameF, phoneF;// These variable are used for the textField in the signup page
    JPasswordField passF; // This variable is used for password field
    JButton signBtn, logBtn; // Signup and Back button

    SignUp() {
        frame = new JFrame("Create New Account"); // Window Title
        frame.setBackground(Color.WHITE); // background color of the frame
        frame.setLayout(null);

        //icon
        //Labels
        unameL = new JLabel("Username:"); // Speciies the name of the Label
        unameL.setBounds(40, 20, 100, 30); // This specifies the postion and size of the label on the signup window
        frame.add(unameL); // Adds the Label to the SignUp page window

        nameL = new JLabel("Name:");
        nameL.setBounds(40, 70, 100, 30);
        frame.add(nameL);

        passL = new JLabel("Password:");
        passL.setBounds(40, 120, 100, 30);
        frame.add(passL);
        phoneL = new JLabel("Phone:");
        phoneL.setBounds(40, 170, 100, 30);
        frame.add(phoneL);

        //InputField
        unameF = new JTextField("");
        unameF.setBounds(150, 20, 100, 30);
        frame.add(unameF);
        nameF = new JTextField("");
        nameF.setBounds(150, 70, 100, 30);
        frame.add(nameF);
        passF = new JPasswordField("");
        passF.setBounds(150, 120, 100, 30);
        frame.add(passF);
        phoneF = new JTextField("");
        phoneF.setBounds(150, 170, 100, 30);
        frame.add(phoneF);

        //SignUp Page Image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("CabBooking/img/SignUp.png")); // This gets the image from the system
        Image image2 = image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // This set the widht and height of the image
        ImageIcon image3 = new ImageIcon(image2);
        imgL = new JLabel(image3);
        imgL.setBounds(330, 65, 150, 150);
        frame.add(imgL);

        //button
        signBtn = new JButton("Sign-Up");
        signBtn.setBackground(Color.WHITE);
        signBtn.setForeground(Color.BLACK);
        signBtn.setBounds(40, 240, 120, 30);
        frame.add(signBtn);
        signBtn.addActionListener(this);

        logBtn = new JButton("Already Have An Account? Login");
        logBtn.setBackground(Color.WHITE);
        logBtn.setForeground(Color.BLACK);
        logBtn.setBounds(180, 240, 200, 30);
        frame.add(logBtn);
        logBtn.addActionListener(this);

        ImageIcon img = new ImageIcon("C:\\Users\\hp\\Desktop\\CabBookingApp\\src\\CabBooking\\img\\favicon.png");
        frame.setIconImage(img.getImage());
        frame.getContentPane();
        frame.setVisible(true);
        frame.setSize(550, 340);
        frame.setLocation(400, 300);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signBtn) {
            //storing data from inputs in varaibles
            String username = unameF.getText();
            String name = nameF.getText();
            String password = passF.getText();
            String phone = phoneF.getText();

            // to create a connection to DB using ConnectionClass
            try {
                ConnectionClass link = new ConnectionClass();
                String q = "INSERT INTO users VALUES('" + username + "', '" + name + "', '" + password + "', '" + phone + "' )"; // This is the mySQL query to store the values. Note: The query is not executed here
                int qCheck = link.stm.executeUpdate(q); // The query q is executed here
                if (qCheck == 1) {
                    JOptionPane.showMessageDialog(null, "Account Created");
                    this.setVisible(false);
                    frame.setVisible(false);
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(null, "Account Created");
                    this.frame.setVisible(false);
                    this.frame.setVisible(true);

                }

            } catch (Exception ex) {
                ex.printStackTrace();

            }

        }
        if (e.getSource() == logBtn) {
            this.frame.setVisible(false);
            new Login();
        } // This block will execute if the backBtn is clicked

    }

    public static void main(String[] args) {
        new SignUp();
    }
}
