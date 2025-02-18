/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Heizxje
 */
public class DBConnect {
    Connection conn=null;
    public DBConnect(String URL, String userName,String password){
        try{
       // URL: string connection: Server,Datebase
       // username,password: account of SQL Sever
       // cal driver
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                //call connection
                conn= DriverManager.getConnection(URL, userName, password);
                System.out.println("connected");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    public DBConnect(){
        this("jdbc:sqlserver://localhost:1433;databaseName=test", "sa","123");
    }
    
    public static void main(String[] args){
        DBConnect conn=new DBConnect();
        if(conn==null){
            System.out.println("failed");
        }
    }
}
