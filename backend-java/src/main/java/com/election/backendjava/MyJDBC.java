package com.election.backendjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://oege.ie.hva.nl:3306/zgerkems", "gerkems", "ntIN34PgdmFP8KBO");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT id, naam FROM gebruikers");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("naam"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
