package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    public static String Connection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:../../../../../ecommerce/ecommerce.db";

            conn = DriverManager.getConnection(url);

            String respon;
            respon = "database berhasil terkoneksi";
            return respon;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver SQLite tidak ditemukan!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database gagal terkoneksi!");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Koneksi database ditutup");
                }
            } catch (SQLException e) {
                System.out.println("koneksi database tidak dapat ditutup");
                e.printStackTrace();
            }
        }
        return null;
    }

}
