/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

/**
 *
 * @author julio
 */
public class conectar {
    
    
    
    public static String URL = "";
    public static String USER = "";
    public static String CLAVE = "";
    
    
    public Connection getConexion(){
        Connection con = null;
        String everythingSettings = "";
        try (BufferedReader br = new BufferedReader(new FileReader("Settings.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            everythingSettings = sb.toString();
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        String[] Settings = everythingSettings.split(",");
        
        URL = Settings[0];
        USER = Settings[1];
        CLAVE = Settings[2];

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
    
}
