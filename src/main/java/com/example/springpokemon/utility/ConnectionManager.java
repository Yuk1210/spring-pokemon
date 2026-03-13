package com.example.springpokemon.utility;

import java.sql.*;

public class ConnectionManager {
    private Connection conn;

    public ConnectionManager() throws SQLException {
        this.conn = DriverManager.getConnection(
                System.getenv("DB_URL"),
                System.getenv("DB_USER"),
                System.getenv("DB_PASSWORD")
        );
    }

    public Connection getConnection (){
        return this.conn;
    }

    public void closeConnection(){
        try{
            this.conn.close();
        }
        catch(Exception E){
            System.out.println("Could not close connection");
        }
    }
}
