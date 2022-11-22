/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela_antigua;
import javax.swing.table.DefaultTableModel; //tabla
import javax.swing.JOptionPane; //mensajes
import java.sql.ResultSet; //ejecutar consulta
import java.sql.PreparedStatement; //enviar parametros en consulta sql
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


public class Estudiante extends Persona {
    
    private String Carne;
    private String genero;
    public int id_estudiante;
    
    DefaultTableModel tblModelo;
    
    public Conexion cls_Conectar;
    
    PreparedStatement parametro;
    

    public String getCarne() {
        return Carne;
    }

    public void setCarne(String Carne) {
        this.Carne = Carne;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public DefaultTableModel tblEstudiante(){
        
        try{
            cls_Conectar = new Conexion();
            cls_Conectar.abrirConexion();
            String query;
            query = "SELECT * FROM estudiantes;";
            
            ResultSet consulta = cls_Conectar.conexionBD.createStatement().executeQuery(query);            
            
            
            String encabezado[] = {"id","carne","nombres","apellidos","direccion", "telefono", "correo", "genero", "nacimiento"};
             tblModelo = new DefaultTableModel();
             tblModelo.setColumnIdentifiers(encabezado);
             String datos[] = new String [9];
             while (consulta.next()){
                 datos[0] = consulta.getString("id_estudiante");
                 id_estudiante = consulta.getInt("id_estudiante");
                 datos[1] = consulta.getString("carne");
                 datos[2] = consulta.getString("nombres");
                 datos[3] = consulta.getString("apellidos");
                 datos[4] = consulta.getString("direccion");
                 datos[5] = consulta.getString("telefono");
                 datos[6] = consulta.getString("correo");
                 datos[7] = consulta.getString("genero");
                 datos[8] = consulta.getString("fecha_nacimiento");
                 
                 
                 
                 tblModelo.addRow(datos);
                 
             }
             cls_Conectar.cerrarConexion();
             return tblModelo;
        }
        catch(Exception ex){
            cls_Conectar.cerrarConexion();
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR QUERY",JOptionPane.ERROR_MESSAGE);
            return tblModelo;
        }
        
    }

        
        public void insertar(){
            
            try{
                cls_Conectar = new Conexion();
                cls_Conectar.abrirConexion();
                
                String query = "insert into estudiantes(carne, nombres, apellidos, direccion, telefono, correo, genero, fecha_nacimiento) \n" +
                                "values (?,?,?,?,?,?,?,?);";
                
                parametro = (PreparedStatement) cls_Conectar.conexionBD.prepareStatement(query);
                
                parametro.setString(1, getCarne());
                parametro.setString(2, getNombres());
                parametro.setString(3, getApellidos());
                parametro.setString(4, getDireccion());
                parametro.setString(5, getTelefono());
                parametro.setString(6, getCorreo());
                parametro.setString(7, getGenero());
                parametro.setString(8, getFecha_nacimiento());
                
                int ejecutar = parametro.executeUpdate();
                
                cls_Conectar.cerrarConexion();
                JOptionPane.showMessageDialog(null, "Se ha insertado exitosamente");
            
            
            
            }catch(Exception ex){
                
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR QUERY AGREGAR",JOptionPane.ERROR_MESSAGE);
                
            }

        }
        
        public void eliminar()
        {
            try{
                Conexion cls_conectar = new Conexion();
            cls_conectar.abrirConexion();
            String query ="DELETE FROM estudiantes WHERE id_estudiante=?;";
            parametro = (PreparedStatement) cls_conectar.conexionBD.prepareStatement(query);
            //parametro.setInt(1,getId_estudiante());
            parametro.setInt(1,getId_estudiante());
            int executar=parametro.executeUpdate();
              cls_conectar.cerrarConexion();
            JOptionPane.showMessageDialog(null, "Se ha eliminado exitosamente");
        }catch(Exception ex){
          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error Query",JOptionPane.ERROR_MESSAGE);


        }            
            
        }
        
    public void modificar(){
        try{
        Conexion cls_conectar = new Conexion();
        cls_conectar.abrirConexion();
        String query ="UPDATE estudiantes SET carne=?, nombres=?, apellidos=?, direccion=?, telefono"
                + "=?, correo=?, genero=?, fecha_nacimiento=? WHERE id_estudiante=?;";
        parametro = (PreparedStatement) cls_conectar.conexionBD.prepareStatement(query);
        //parametro.setInt(1,getId_estudiante());
        parametro.setString(1,getCarne());
        parametro.setString(2,getNombres());
        parametro.setString(3,getApellidos());
        parametro.setString(4,getDireccion());
        parametro.setString(5,getTelefono());
        parametro.setString(6,getCorreo());
        parametro.setString(7,getGenero());
        parametro.setString(8,getFecha_nacimiento());
        parametro.setInt(9,getId_estudiante());
        int executar=parametro.executeUpdate();
          cls_conectar.cerrarConexion();
        
        JOptionPane.showMessageDialog(null, "Se ha modificado exitosamente");
    }catch(Exception ex){
      JOptionPane.showMessageDialog(null,ex.getMessage(),"Error Query",JOptionPane.ERROR_MESSAGE);
    
    
    }
    
    }        
        
    



        
              
            
}
        
        
    
    
    
    

