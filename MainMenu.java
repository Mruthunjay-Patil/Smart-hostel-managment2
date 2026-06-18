
package com.hostel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {

    JButton addStudent;
    JButton viewStudents;
    JButton allocateRoom;
    JButton viewAllotment;
    JButton exit;

    MainMenu() {

        setTitle("Smart Hostel Management System");

        setSize(500,500);

        setLayout(new GridLayout(6,1,10,10));

        setLocationRelativeTo(null);

        JLabel title = new JLabel(
                "SMART HOSTEL MANAGEMENT SYSTEM",
                JLabel.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 20));

        addStudent = new JButton("Add Student");

        viewStudents = new JButton("View Students");

        allocateRoom = new JButton("Allocate Room");

        viewAllotment = new JButton("View Allotment");

        exit = new JButton("Exit");

        addStudent.addActionListener(this);

        viewStudents.addActionListener(this);

        allocateRoom.addActionListener(this);

        viewAllotment.addActionListener(this);

        exit.addActionListener(this);

        add(title);

        add(addStudent);

        add(viewStudents);

        add(allocateRoom);

        add(viewAllotment);

        add(exit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addStudent) {

            new AddStudent();
        }

        if(e.getSource() == viewStudents) {

            new ViewStudents();
        }

        if(e.getSource() == allocateRoom) {

            new AllocateRooms();
        }

        if(e.getSource() == viewAllotment) {

            new ViewAllotment();
        }

        if(e.getSource() == exit) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new MainMenu();
    }
}