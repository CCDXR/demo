package com.example.demo.jdbc;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * @author Henry
 * @date 2020-1-20 10:34
 */
public class Test {

    private static String url =
            "jdbc:mysql://10.12.107.33:3306/vmp?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static String user = "cuapp";
    private static String password = "root";
    
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stat = conn.createStatement();
            PreparedStatement preparedStatement =
                    conn.prepareStatement("select * from model_dload_info limit 10");
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet rs = stat.executeQuery("select * from rj_t_models limit 10");
            while (rs.next()) {
                System.out.println(rs.getString("COMPNAME"));
            }
            while (resultSet.next()) {
                System.out.println(resultSet.getString("COMPNAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
