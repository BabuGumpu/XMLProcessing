package com.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInsert {
    public static void main(String args[]){
        try{
        //code to connect to database, so need to define jdbc url
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost/college_students";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "test");

        String sql = "INSERT INTO college_students(student_name,student_rollno, student_address, student_stream)"
                    + "VALUES ('GUMPU', 919, 'Kuppam', 'HEC')";
        Statement statement = conn.createStatement();
        int rows = statement.executeUpdate(sql);

        if(rows > 0){
                System.out.println("A new user has been inserted successfully.");
        }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
