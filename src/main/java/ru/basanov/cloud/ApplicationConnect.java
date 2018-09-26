package ru.basanov.cloud;

import java.sql.*;

public class ApplicationConnect {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement createStmt = null;
        try {
            conn.setAutoCommit(false);
            createStmt = conn.createStatement();
            int createTable = createStmt.executeUpdate("CREATE TABLE Team (TeamID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "  Name TEXT NOT  NULL, PlayedGames INTEGER NOT NULL, Score INTEGER NOT NULL)");
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }




    }
}
