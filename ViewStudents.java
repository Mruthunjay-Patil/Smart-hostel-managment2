package com.hostel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewStudents extends JFrame {

    JTable table;

    DefaultTableModel model;

    ViewStudents() {

        setTitle("View Students");

        setSize(800,400);

        setLocationRelativeTo(null);

        String[] columns = {

                "ID",
                "Name",
                "Gender",
                "Phone",
                "Room No",
                "Fees"
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
                    st.executeQuery("SELECT * FROM students");

            while(rs.next()) {

                model.addRow(new Object[] {

                        rs.getInt("id"),

                        rs.getString("name"),

                        rs.getString("gender"),

                        rs.getString("phone"),

                        rs.getString("room_no"),

                        rs.getDouble("fees")
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
