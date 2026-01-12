package org.mall.dao;

import java.sql.*;

import static java.sql.DriverManager.getConnection;
public class JdbcTest {
    public static void main(String[] args) {
        String url =  "jdbc:mysql://127.0.0.1:3306/mall?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "ubuntu";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "select * from users;";
            Statement stmt = conn.createStatement();
            String sqll = "select * from users;";
            ResultSet result = stmt.executeQuery(sqll);
            while (result.next()) {
                String name = result.getString("username");
                String lv = result.getString("id");
                System.out.println("" + name + "" + lv);
            }
            result.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}