package com.practise;

import java.sql.*;

public class SqlDelete {
    public static void main(String args[]){
        try{
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myURL = "jdbc:mysql://localhost/college_students";
            Class.forName(myDriver);

            String student_name = "Jyothi";

            Connection connection = DriverManager.getConnection(myURL,"root","test");
            String sql = "DELETE FROM college_students WHERE student_name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,student_name);
            int rows = statement.executeUpdate();
            if(rows>0){
                System.out.println("The students information has been deleted.");
            }
            connection.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
