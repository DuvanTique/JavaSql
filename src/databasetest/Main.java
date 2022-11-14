package databasetest;

/**
 *
 * @author Duvan
 */
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    
    private static Connection con;
    public static String driver = "com.mysql.jdbc.Driver";
    public static String user ="root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost:3306/usuarios";
    
    public static void main(String[] args) throws SQLException {
        
        con = null;
        
        try {
            con = (Connection) DriverManager.getConnection(url,user,pass);
            if (con != null){
                System.out.println("Conexion establecida");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion " + e);
        }
        
        Operaciones op = new Operaciones();
        //op.registrar(con);
        //op.actualizar(con);
        //op.eliminar(con);
        //op.selecionar(con);
        //op.selecionarTodo(con);
    }
    
}
