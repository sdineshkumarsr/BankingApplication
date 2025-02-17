package repository;

import java.sql.*;

public class RepoConnection {
    Connection connection;
    public Statement statement;
    public RepoConnection(){


        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mbbank","root","1111");
            statement=connection.createStatement();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
