package com.hostel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewAllotment extends JFrame {

    JTable table;

    DefaultTableModel model;

    ViewAllotment() {

        setTitle("View Allotment");

        setSize(700,400);

        setLocationRelativeTo(null);

        String[] columns = {

                "Allotment ID",
                "Student Name",
                "Room Number",
                "Allotment Date"
        };

        model = new DefaultTableModel(columns,0);

        table = new JTable(model);

        table.setRowHeight(25);

        table.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        table.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
            st.executeQuery("SELECT * FROM room_allotment");

            while(rs.next()) {

                model.addRow(new Object[] {

                        rs.getInt("allotment_id"),

                        rs.getString("student_name"),

                        rs.getString("room_no"),

                        rs.getString("allotment_date")
                });
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);

        add(sp);

        setVisible(true);
    }
}
