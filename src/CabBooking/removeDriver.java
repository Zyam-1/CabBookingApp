package CabBooking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class removeDriver extends JFrame implements ActionListener {

    JLabel cnicL;
    JTextField cnicField;
    JButton delDriver;
    JPanel p1, p2;

    removeDriver() {
        //location and title of JFrame
        super("Delete Driver");
        setLocation(450, 200);
        setSize(500, 200);
        setLayout(null);
        setResizable(false);
        // Favicon
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Desktop\\CabBookingApp\\src\\CabBooking\\img\\favicon.png");
        setIconImage(icon.getImage());

        cnicL = new JLabel("Enter Driver's Cnic");
        cnicL.setBounds(30, 40, 130, 30);
        add(cnicL);
        cnicField = new JTextField();
        cnicField.setBounds(230, 40, 250, 30);
        add(cnicField);

        delDriver = new JButton("Delete Driver");
        delDriver.setBounds(180, 100, 130, 30);
        add(delDriver);
        delDriver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("Delete Driver")){
            String cnic = cnicField.getText();
            try {
                ConnectionClass link = new ConnectionClass();
 
                String sql = "Delete from registered_drivers where cnic = '"+ cnic + "'";
                int result = link.stm.executeUpdate(sql);
                if(result==1){
                    JOptionPane.showMessageDialog(null, "Driver Removed");
                    cnicField.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null, "An error occured. Please try again");

                }
            } catch (Exception ex) {
                 ex.printStackTrace();

            }
              
      }
    }

    public static void main(String args[]) {
        new removeDriver().setVisible(true);
    }

}
