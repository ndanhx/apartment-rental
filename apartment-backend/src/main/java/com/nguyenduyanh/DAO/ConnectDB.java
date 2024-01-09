package com.nguyenduyanh.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
  //Local
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ApartmentDB?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    //deploy heroku
//    private static final String DB_URL = "jdbc:mysql://t0zxaguw2a4nkpn8:am9mkei130nj5f8t@oliadkuxrl9xdugh.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/d2de628z31sxlbpu?reconnect=true&allowPublicKeyRetrieval=true&useSSL=false";
//    private static final String USER = "t0zxaguw2a4nkpn8";
//    private static final String PASSWORD = "am9mkei130nj5f8t";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
