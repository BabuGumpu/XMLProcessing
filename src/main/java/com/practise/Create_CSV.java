package com.practise;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Create_CSV {
        public static void main(String[] args) {

            try {
               // PrintWriter pw= new PrintWriter(new File("D:\\CSV1-Column-Copy.csv"));
                PrintWriter pw= new PrintWriter(new File("D:\\Sample_CSV.csv"));
                StringBuilder sb=new StringBuilder();
                Connection connection=null;
                DB_Connection obj_DB_Connection=new DB_Connection();
                connection=obj_DB_Connection.getConnection();
                ResultSet rs=null;

                String query="select * from agents";
                PreparedStatement ps=connection.prepareStatement(query);
                rs=ps.executeQuery();

                while(rs.next()){
                    sb.append(rs.getString("agent_code"));
                    sb.append(",");
                    sb.append(rs.getString("agent_name"));
                    sb.append(",");
                    sb.append(rs.getString("working_area"));
                    sb.append(",");
                    sb.append(rs.getString("commission"));
                    sb.append(",");
                    sb.append(rs.getString("phone_no"));
                    sb.append(",");
                    sb.append(rs.getString("country"));
                    sb.append("\r\n");
                }
                pw.write(sb.toString());
                pw.close();
                System.out.println("finished");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

