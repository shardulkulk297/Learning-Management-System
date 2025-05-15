package com.lms.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static String url = "jdbc:mysql://localhost:3306/lms";
    private static String username = "root";
    private static String password = "Shardul@297";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static Connection con;
    public static Connection getConnection(){
        //Load Driver
        try{
            Class.forName(driver);
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //Establish Connection

        try{
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }


}
