package com.hostel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener {

    JTextField tfName;
    JTextField tfGender;
    JTextField tfPhone;
    JTextField tfRoom;
    JTextField tfFees;

    JButton save;

    AddStudent() {

        setTitle("Add Student");

        setSize(400,400);

        setLayout(new GridLayout(6,2,10,10));

        setLocationRelativeTo(null);

        add(new JLabel("Name"));

        tfName = new JTextField();

        add(tfName);

        add(new JLabel("Gender"));

        tfGender = new JTextField();

        add(tfGender);

        add(new JLabel("Phone"));

        tfPhone = new JTextField();

        add(tfPhone);

        add(new JLabel("Room No"));

        tfRoom = new JTextField();

        add(tfRoom);

        add(new JLabel("Fees"));

        tfFees = new JTextField();

        add(tfFees);

        save = new JButton("Save");

        save.addActionListener(this);

        add(save);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "INSERT INTO students(name,gender,phone,room_no,fees) VALUES(?,?,?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, tfName.getText());

            pst.setString(2, tfGender.getText());

            pst.setString(3, tfPhone.getText());

            pst.setString(4, tfRoom.getText());

            pst.setDouble(5,
                    Double.parseDouble(tfFees.getText()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Student Added Successfully"
            );

            // Clear Fields
            tfName.setText("");

            tfGender.setText("");

            tfPhone.setText("");

            tfRoom.setText("");

            tfFees.setText("");

            tfName.requestFocus();

            con.close();

        } catch(Exception ex) {

            ex.printStackTrace();
        }
    }
}
