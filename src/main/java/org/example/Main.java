package org.example;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Main {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("dynamics.crm.dynamics.cn");
        ds.setDatabaseName("dynamicsDatabase");
        ds.setUser("yourAccount");
        ds.setPassword("password");
        ds.setAuthentication("ActiveDirectoryPassword");

        try(Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select TOP 10 accountid from account")){
            if (resultSet.next()){
                System.out.println("我登录成功了");
                System.out.println("第一条数据是："+resultSet.getString("accountid"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}