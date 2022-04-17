/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**registro
 *
 * @author serdn
 */
public class Conexion {
    Connection con;
    String url= "jdbc:mysql://localhost:3306/insumos";
    String user ="root";
//    String pass = "david";
    String pass = "1234";
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return con;
    }
}
