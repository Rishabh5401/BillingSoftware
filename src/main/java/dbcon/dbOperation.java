/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbcon;

import admin.AdminPanel;
import getterSetter.RegisterModel;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author rishabh-sharma
 */
public class dbOperation {
    public static ResultSet login(String email1,String pass){
        ResultSet rs=null;
        try{
            
            Connection  con= dbcon.dbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("Select * from register where email=? and password=?");
            ps.setString(1, email1);
            ps.setString(2, pass);
            
            rs= ps.executeQuery();
            
        }catch(Exception e){
                    System.out.println(e);
                    }
        return rs;
    }
    public static boolean register(RegisterModel reg){
        
        boolean status=false;
        try{
                
                Connection con=dbcon.dbConnection.getConnection();
                PreparedStatement  ps=con.prepareStatement("insert into register values(?,?,?,?,?,?)");
                        ps.setString(1, reg.getName());
                        ps.setString(2, reg.getEmail());
                        ps.setString(3, reg.getPassword());
                        ps.setString(4, reg.getGender());
                        ps.setString(5, reg.getPhoneno());
                        ps.setString(6, reg.getModule());
                        
                        
                        int i= ps.executeUpdate();
                        if(i>0){
                            status=true;
                            
                        }else{
                            status = false;
                            
                        }
            }
            catch(Exception e){
                System.out.println(e);
            }
        return status;
    }
    public static ResultSet showAllEmpsData(){
        ResultSet rs=null;
        try{
            Connection con=dbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM register WHERE module='Employee'");
            
            rs=ps.executeQuery();
            
        }catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    public static ResultSet getSelectedEmployee(String email){
        ResultSet rs=null;
        try{
            Connection con=dbConnection.getConnection();
            PreparedStatement ps= con.prepareStatement("SELECT * FROM register WHERE email=?");
            ps.setString(1, email);
            rs= ps.executeQuery();
            
        }catch(Exception e){
            System.out.println(e);
        }
        return rs;
        
    }
    public static int updateEmpDetails(RegisterModel reg){
        int i=0;
        try{
            Connection con= dbConnection.getConnection();
            PreparedStatement ps= con.prepareStatement("UPDATE register set name=?,password=?,gender=?,phone_no=? where email=?");
            ps.setString(1, reg.getName());
            ps.setString(2, reg.getPassword());
            ps.setString(3, reg.getGender());
            ps.setString(4, reg.getPhoneno());
            ps.setString(5, reg.getEmail());
            i=ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }return i;
    }
    public static int deleteEmpDetails(String email){
        int i=0;
        try{
            Connection con= dbConnection.getConnection();
            PreparedStatement ps= con.prepareStatement("DELETE from register  where email=?");
            
            ps.setString(1, email);
            i=ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }return i;
    }
    public static boolean insertImageDetails(FileInputStream fis, String... str){
        boolean status=false;
        try{
            Connection con= dbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("insert into items values(?,?,?,?,?,?)");
            ps.setString(1, str[0]);
            ps.setString(2, str[1]);
            ps.setString(3, str[2]);
            ps.setString(4, str[3]);
            ps.setString(5, str[4]);
            ps.setBinaryStream(6, fis);
            
            int i=ps.executeUpdate();
            if(i>0){
                status=true;
            }else{
                status=false;
            }
            
        }catch(Exception e){
            System.out.println(e);
        }return status;
        
    }
    public static ResultSet getAllItems() {
        try {
            Connection con = dbConnection.getConnection();
            String query = "SELECT * FROM items";
            PreparedStatement ps = con.prepareStatement(query);
            return ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static ResultSet getSelectedItem(String item_id) {
        ResultSet rs=null;
        try {
            Connection con = dbConnection.getConnection();
            String query = "SELECT * FROM items WHERE item_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, item_id);
            rs= ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
            
        }return rs;
    }
    public static boolean updateItemWithoutImage(String id, String name, String price, String desc, String category) {
        try {
            Connection con = dbConnection.getConnection();
            String query = "UPDATE items SET item_name=?, item_price=?, item_desc=?, item_category=? WHERE item_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, desc);
            ps.setString(4, category);
            ps.setString(5, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean updateItemWithImage(FileInputStream fis, String id, String name, String price, String desc, String category) {
        try {
            Connection con = dbConnection.getConnection();
            String query = "UPDATE items SET item_name=?, item_price=?, item_desc=?, item_category=?, item_img=? WHERE item_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, desc);
            ps.setString(4, category);
            ps.setBinaryStream(5, fis);
            ps.setString(6, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
     public static boolean deleteItem(String id) {
        try {
            Connection con = dbConnection.getConnection();
            String query = "DELETE FROM items WHERE item_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
     public static boolean checkOldPassword(String old_password,String email){
         boolean status=false;
         try{
             Connection con=dbConnection.getConnection();
             PreparedStatement ps=con.prepareStatement("Select * from register where email=? and password=?");
             ps.setString(1, email);
             ps.setString(2, old_password);
             
             ResultSet rs= ps.executeQuery();
             if(rs.next()){
                 status=true;
             }else{
                 status=false;
             }
             
         }catch(Exception e){
             System.out.println(e);
         }return status;
     }
     
     public static boolean updatePassword(String new_pass,String email){
         boolean status=false;
         try{
             Connection con= dbConnection.getConnection();
             PreparedStatement ps=con.prepareStatement("update register set password=? where email=?");
             ps.setString(1, new_pass);
             ps.setString(2, email);
             int i=ps.executeUpdate();
             if(i>0){
                 status=true;
             }else{
                 status=false;
             }
         }catch(Exception e){
             System.out.println(e);
         }return status;
     }
     
     
     public static boolean updateMyprofile(String name,String phno,String gender,String email){
         boolean status=false;
         try{
             Connection con=dbConnection.getConnection();
             PreparedStatement ps=con.prepareStatement("update register set name=? ,gender=?,phone_no=? where email=?");
             ps.setString(1, name);
             ps.setString(2, gender);
             ps.setString(3, phno);
             ps.setString(4, email);
             
             int i=ps.executeUpdate();
             if(i>0){
                 status=true;
             }else{
                 status=false;
             }
         }catch(Exception e){
             System.out.println(e);
         }
         return status;
     }
    
     public static boolean insertCustomerDetails(String... str){
         String name1=str[0];
         String email1=str[1];
         String pass1=str[2];
         String gender1=str[3];
         String phno1=str[4];
         String module1=str[5];
         boolean status=false;
         
         try{
             Connection con=dbConnection.getConnection();
             PreparedStatement ps=con.prepareStatement("Insert into register values(?,?,?,?,?,?)");
             ps.setString(1, name1);
              ps.setString(2, email1);
               ps.setString(3, pass1);
                ps.setString(4, gender1);
                 ps.setString(5, phno1);
                  ps.setString(6, module1);
            
                  int i=ps.executeUpdate();
                  if(i>0){
                      status=true;
                  }else{
                      status=false;
                  }
             
         }catch(Exception e){
             System.out.println(e);
         }
         return status;
     }
     
    public static ResultSet checkCustomerExist(String phno){
        ResultSet rs=null;
        try{
            Connection con=dbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from register where phone_no=?");
            ps.setString(1, phno);
             rs=ps.executeQuery();
             
            
        }catch(Exception e){
            System.out.println(e);
        }return rs;
    }
    
    public static boolean customerBillingDetails(String cust_phno,String items,String date1,String time1,String emp_email){
        boolean status=false;
        try{
            Connection con=dbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into shoping values(?,?,?,?,?)");
            ps.setString(1, cust_phno);
            ps.setString(2, items);
            ps.setString(3, date1);
            ps.setString(4, time1);
            ps.setString(5, emp_email);
            int i=ps.executeUpdate();
            if(i>0){
                status=true;
            }else{
                status=false;
            }
            
        }catch(Exception e){
            System.out.println(e);
        }return status;
    }
    
    
    public static ResultSet  getCustomerShippingdetails(String phno){
        ResultSet rs=null;
        try{
            Connection con=dbConnection.getConnection();
            PreparedStatement ps= con.prepareStatement("select * from shoping where customer_phno=?");
            ps.setString(1, phno);
            rs=ps.executeQuery();
            
        }catch(Exception e){
            System.out.println(e);
        }return rs;
    }
}
