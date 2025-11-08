/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbcon;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author rishabh-sharma
 */
public class dbConnection {
    static Connection con;
    public static Connection getConnection(){
        if(con==null){
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //con= DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","Ramu#3210");
            Properties props = new Properties();
                FileInputStream fis = new FileInputStream("config.properties");
                props.load(fis);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.username");
                String pass = props.getProperty("db.password");
                con = DriverManager.getConnection(url, user, pass);
                
        }catch(Exception e){
              System.out.println(e);
        }
        }
        return con;
    }
    
}
