/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

/**
 *
 * @author HP
 */
public class Accounts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            try
     {
         //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
               try
                {
                     Connection con= Finance.connecrdb();
                 String a="select * from login where id=1";
              
                    Statement st=con.createStatement();
                 
                    ResultSet rs=st.executeQuery(a);
                  String key_value="";
                  int attempt=0;
                               
                    while(rs.next())
                    {
                         key_value=rs.getString("first");
                     
                 }
                    if(key_value.equals("registered"))
                    {
                       
                          
                  new payment().setVisible(true);
               
                
                           }
                    else
                    {
                           new register().setVisible(true);
                    }
                    
                }
           catch(Exception ex)
           {
               
           }
      
     }
     catch(Exception ex){}
    }
        
    
    
}
