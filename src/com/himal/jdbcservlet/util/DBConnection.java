package com.himal.jdbcservlet.util;


import com.himal.jdbcservlet.constant.DbConstant;

import java.sql.*;



/**
 * Created by Himal Acharya on 2016-09-07.
 */
public class DBConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(DbConstant.DB_URL, DbConstant.DB_userName, DbConstant.password);
        return con;

    }


    public static void closeConnection(Connection conn) throws SQLException {
        if(conn!=null && !conn.isClosed()){
            conn.close();
            conn=null;
        }
    }

    public static void closeAll(PreparedStatement preparedStatement){
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
