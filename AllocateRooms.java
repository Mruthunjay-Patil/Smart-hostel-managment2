package com.hostel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AllocateRooms extends JFrame implements ActionListener {

    JTextField tfStudent;
    JTextField tfRoom;
    JTextField tfDate;

    JButton allocate;

    AllocateRooms() {

        setTitle("Allocate Rooms");

        setSize(400,300);

        setLayout(new GridLayout(4,2,10,10));

        setLocationRelativeTo(null);

        add(new JLabel("Student Name"));

        tfStudent = new JTextField();

        add(tfStudent);

        add(new JLabel("Room Number"));

        tfRoom = new JTextField();

        add(tfRoom);

        add(new JLabel("Allotment Date"));

        tfDate = new JTextField();

        add(tfDate);

        allocate = new JButton("Allocate Room");

        allocate.addActionListener(this);

        add(allocate);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "INSERT INTO room_allotment(student_name,room_no,allotment_date) VALUES(?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, tfStudent.getText());

            pst.setString(2, tfRoom.getText());

            pst.setString(3, tfDate.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Room Allocated Successfully"
            );

            // Clear Fields
            tfStudent.setText("");

            tfRoom.setText("");

            tfDate.setText("");

            tfStudent.requestFocus();

            con.close();

        } catch(Exception ex) {

            ex.printStackTrace();
        }
    }
}
