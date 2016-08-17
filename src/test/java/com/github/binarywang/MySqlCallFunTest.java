package com.github.binarywang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MySqlCallFunTest {

    @Test
    public void testApp() throws SQLException {
        String url = "jdbc:mysql://10.255.33.162:3306/uu_dream?useUnicode=true";
        // for 6.0, Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "tmp";
        String password = "temp";
        try (Connection conn = DriverManager.getConnection(url, username,
            password);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(
                    "SELECT `rrzx_application_id_sequence.nextVal`()")) {
            while (rs.next()) {
                System.err.println(rs.getInt(1));
            }
        }
    }
}
