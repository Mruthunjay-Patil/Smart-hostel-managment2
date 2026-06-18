package com.hostel;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hostel_management",
                    "root",
                    "1234"
            );

        } catch(Exception e) {

            e.printStackTrace();
        }

        return con;
    }
}
