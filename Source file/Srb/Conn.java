
package Srb;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author sourabhsoni
 */
public class Conn {
    public static Connection c;
    public static Statement st;
    public static Statement st2;
    
    
    static{
    try{
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Portfolio","root","Sourabhs701@");
        st=c.createStatement();
        st2=c.createStatement();
   
        
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
    }
    }
    
    
}
