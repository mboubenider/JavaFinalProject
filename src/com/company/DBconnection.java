//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    public DBconnection() {
    }

    public static Connection DBcon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://tommy.heliohost.org/ultimazs_CIS3368project", "ultimazs", "Ultima123");
            return conn;
        } catch (SQLException | ClassNotFoundException var1) {
            var1.printStackTrace();
            System.out.println("Fail to connect" + var1);
            return null;
        }
    }
}
