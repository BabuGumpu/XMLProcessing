package com.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUpdate {
    public static void main(String args[]){
        try{
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myURL = "jdbc:mysql://localhost/college_students";
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(myURL,"root","test");
            String sql = "UPDATE college_students SET student_name = 'GOPAL' WHERE student_address = 'kuppam'";
            Statement statement = connection.createStatement();

            int rows = statement.executeUpdate(sql);
            if(rows>0){
                System.out.println("The students information has been updated.");
            }
            connection.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
