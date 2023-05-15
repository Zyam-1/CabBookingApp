package CabBooking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addDriver extends JFrame implements ActionListener {

    JLabel nameL, vehicleL, carPlateL, cnicL, pAddL;
    JTextField nameField, vehicleField, carPlateField, cnicField, pAddField;
    JButton addDriverBtn;

    addDriver() {
        super("Driver Registration");
        setLocation(450, 50);
        setSize(450, 400);

        nameL = new JLabel("Driver's Name");
        vehicleL = new JLabel("Vehicle Name");
        carPlateL = new JLabel("Car Plate #");
        cnicL = new JLabel("CNIC");
        pAddL = new JLabel("Driver Address");

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));

        vehicleField = new JTextField();
        vehicleField.setFont(new Font("Arial", Font.PLAIN, 16));

        cnicField = new JTextField();
        cnicField.setFont(new Font("Arial", Font.PLAIN, 16));

        pAddField = new JTextField();
        pAddField.setFont(new Font("Arial", Font.PLAIN, 16));

        carPlateField = new JTextField();
        carPlateField.setFont(new Font("Arial", Font.PLAIN, 16));

        addDriverBtn = new JButton("Add Driver");

        addDriverBtn.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(nameL);
        panel.add(nameField);

        panel.add(vehicleL);
        panel.add(vehicleField);

        panel.add(carPlateL);
        panel.add(carPlateField);

        panel.add(cnicL);
        panel.add(cnicField);

        panel.add(pAddL);
        panel.add(pAddField);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1, 10, 10));
        panel2.add(addDriverBtn);

        setLayout(new BorderLayout(10, 10));

        add(panel2, "South");
        add(panel, "Center");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Add Driver")) {

            String name = nameField.getText();
            String vehicle = vehicleField.getText();
            String plate = carPlateField.getText();
            String cnic = cnicField.getText();
            String address = pAddField.getText();

            // code to generate email
            char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            StringBuilder sb = new StringBuilder();
            Random rand = new Random();
            int length = 6;

            for (int i = 0; i < length; i++) {
                int randomIndex = rand.nextInt(chars.length);
                char randomChar = chars[randomIndex];
                sb.append(randomChar);
            }
            String randomEmail = sb.toString();
            String email = randomEmail + "@gorider.com";

            // coede to generate password
            char[] chars1 = {'g', 'i', 'a', 'e', 'q', '1', '^', '>', '<', '|', 'k', 'l', 'm', ']', 'o', '=', 'q', 'r', '/', 't', '1', 'v', 'w', '0', '*', '2'};
            StringBuilder sb1 = new StringBuilder();
            Random rand1 = new Random();
            int size = 8;

            for (int i = 0; i < size; i++) {
                int randomIndex = rand1.nextInt(chars1.length);
                char randomChar = chars1[randomIndex];
                sb1.append(randomChar);
            }
            String password = sb1.toString();
            // You need to check if the same data exists in the and then also get email and pass from db and show it the user. 

            try {
                ConnectionClass link = new ConnectionClass();
                String checkQuery = "Select * from registered_drivers where plate = '"+ plate +"' OR cnic = '"+ cnic + "'";
                ResultSet rs = link.stm.executeQuery(checkQuery);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Driver Already Exists. Try again");

                }
                else {
                String q = "INSERT INTO registered_drivers VALUES('" + name + "', '" + vehicle + "', '" + plate + "', '" + cnic + "', '" + address + "', '" + email + "', '" + password + "' )"; // This is the mySQL query to store the values. Note: The query is not executed here
                int qCheck = link.stm.executeUpdate(q); // The query q is executed here
                if (qCheck == 1) {
                    String getQuery = "Select email, password from registered_drivers where plate = '" + plate + "' ";
                    ResultSet driverInfo = link.stm.executeQuery(getQuery);
                    if(driverInfo.next()){
                        String driverEmail = driverInfo.getString(1);
                        String driverPass = driverInfo.getString(2);
                        JOptionPane.showMessageDialog(null, "Driver Registered Successfully\n Email: '"+ driverEmail +"' \n Password: '"+ driverPass +"' ");
                    }
                    
                    setVisible(false);

                }
                }
            } catch (Exception ex) {
                ex.printStackTrace();

            }
//           
        }
    }

    public static void main(String[] args) {
        new addDriver().setVisible(true);
    }

}
