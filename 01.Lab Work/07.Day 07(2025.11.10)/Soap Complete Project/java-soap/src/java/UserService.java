package com.example.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebService
public class UserService {
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/soap_db", "root", ""
        );
    }

    @WebMethod
    public List<String> getAllUsers() {
        List<String> users = new ArrayList<>();
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, email FROM users");
            while (rs.next()) {
                users.add(rs.getString("name") + " - " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
