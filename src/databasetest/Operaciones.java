package databasetest;

/**
 *
 * @author Duvan
 */
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Operaciones {
    
    private final String tabla = "nombre";
    
    public void registrar(Connection conexion){
        try {
            
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + 
                    "(ID,CEDULA,NACIONALIDAD,NOMBRE)VALUES (?,?,?,?)");
            consulta.setInt(1,1);
            consulta.setInt(2,123456);
            consulta.setString(3,"Colombia");
            consulta.setString(4,"Juan");
            consulta.executeUpdate();
            System.out.println("Datos insertados");
            
        } catch (SQLException e) {
            System.out.println("Error de conexion " + e);
        }
    }
    
    public void actualizar(Connection conexion){
        try {
            
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("UPDATE " +this.tabla +" SET NOMBRE = ? WHERE ID = ?");
            consulta.setString(1,"Pepe");
            consulta.setInt(2,1);
            consulta.executeUpdate();
            System.out.println("Datos actualizados");
            
        } catch (SQLException e) {
            System.out.println("Error de conexion " + e);
        }
    }    
    
    public void eliminar(Connection conexion){
        try {
            
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("DELETE FROM " +this.tabla +" WHERE ID = ?");
            consulta.setInt(1,1);
            consulta.executeUpdate();
            System.out.println("Datos eliminados");
            
        } catch (SQLException e) {
            System.out.println("Error de conexion " + e);
        }
    }
    
    public void selecionar(Connection conexion){
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM nombre WHERE ID = ?");
            consulta.setInt(1,2);
            ResultSet rs = consulta.executeQuery();
            try {
                while(rs.next()){
                    int id = rs.getInt(1);
                    int cd = rs.getInt(2);
                    String nacionalidad = rs.getString(3);
                    String nombre = rs.getString(4);
                    System.out.println("ID: " + id + " Cedula: " + cd + " Pais: " + nacionalidad + " Nombre: " + nombre);
                }
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion " + e);
        }
    }
    
    public void selecionarTodo(Connection conexion){
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT NACIONALIDAD,NOMBRE FROM nombre");
            ResultSet rs = consulta.executeQuery();
            try {
                while(rs.next()){
                    String nacionalidad = rs.getString(1);
                    String nombre = rs.getString(2);
                    System.out.println(nacionalidad + " " + nombre);
                }
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion " + e);
        }
    }  
    
}
