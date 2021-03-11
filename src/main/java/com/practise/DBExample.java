package com.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBExample {
    public static void main(String[] args) {
        try {
            // create a java mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/mysql";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "test");

            String query = " insert into employee (emp_id, emp_first_name, emp_last_name, emp_address, emp_city, emp_mobile_number)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 10002);
            preparedStmt.setString(2, "RamaBalam");
            preparedStmt.setString(3, "Devi");
            preparedStmt.setString(4, "Adapalastreet");
            preparedStmt.setString(5, "Anantapur");
            preparedStmt.setInt(6, 944151321);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e);
        }
    }
}
