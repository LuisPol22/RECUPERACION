/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela_antigua;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Antonio
 */
public class Conexion {
    
    public Connection conexionBD;
    private final String sgdb = "mysql";
    private final String servidor = "localhost";
    private final String puerto = ":3306";
    private final String bd = "escuela";
    private final String urlConexion = "jdbc:"+sgdb+"://"+servidor+puerto+"/"+bd;
    private final String usuario = "root";
    private final String contraseña = "Mega123";
    private final String jdbc = "com.mysql.jdbc.Driver";
    
    
    public void abrirConexion(){
        
        try{
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlConexion,usuario,contraseña);
            
            //JOptionPane.showMessageDialog(null, "Éxito",
            //"Conexión Exitosa",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
            "Error en la Conexión",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cerrarConexion(){
        try{
            
            conexionBD.close();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
            "Error en la Conexión",JOptionPane.ERROR_MESSAGE);
        }
    }
        
}


    
    

