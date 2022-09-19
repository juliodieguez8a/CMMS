/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cmms;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
/**
 *
 * @author julio
 */
public class CMMS {

    /**
     * @param args the command line arguments
     */

    Statement stmt = null;
    ResultSet rs = null;
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
    conectar conecta = new conectar();
    Connection con = conecta.getConexion();
    Statement stmt = con.createStatement();
    
        //INSERTAR REGISTROS
        //stmt.executeUpdate("INSERT INTO country VALUES (110, 'Guatemala', curdate())");
    int n = stmt.executeUpdate("UPDATE sakila.country SET country='GUATE', country_id='111'"
                + "WHERE country = 'Guatemala'");
    
    System.out.println(n);
    ResultSet rs = stmt.executeQuery("SELECT * FROM country");
    
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnsNumber = rsmd.getColumnCount();
    //System.out.println(columnsNumber);
    
    while (rs.next()) {
       for (int i = 1; i <= columnsNumber; i++) {
           if (i > 1) System.out.print(",  ");
           String columnValue = rs.getString(i);
           System.out.print(columnValue + " " + rsmd.getColumnName(i));
       }
       System.out.println("");
    }
    }
     
}
