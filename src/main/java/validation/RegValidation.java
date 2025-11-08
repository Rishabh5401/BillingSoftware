/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rishabh-sharma
 */
public class RegValidation {
    private Pattern name,email,phno,password;
    private Matcher matcher;
    
    String name_pattern="^[a-zA-Z ]{3,30}$";
    String email_pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    String phone_pattern="^[0-9]{10}$";
    String pass_pattern="^(?=.*[0-9])"
                     + "(?=.*[a-z])"
                     + "(?=.*[A-Z])"
                     + "(?=.*[@#$%^&+=!])"
                     + "(?=\\S+$)"
                     + ".{8,}$";
    
    
    public RegValidation(){
        name=Pattern.compile(name_pattern);
        email=Pattern.compile(email_pattern);
        phno=Pattern.compile(phone_pattern);
        password=Pattern.compile(pass_pattern);
        
    }
    public boolean nameValidation(String user_name){
        matcher=name.matcher(user_name);
        return matcher.matches();
    }
    public boolean emailValidation(String user_email){
        matcher=email.matcher(user_email);
        return matcher.matches();
    }
    public boolean phonenoValidation(String user_phoneno){
        matcher=phno.matcher(user_phoneno);
        return matcher.matches();
    }
    public boolean passwordValidation(String user_password){
        matcher=password.matcher(user_password);
        return matcher.matches();
    }
    
}
