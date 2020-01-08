
package modelo;

import com.mysql.jdbc.Connection;
import java.net.ConnectException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {
    private final String base = "usuarios";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection con=null;
    
    public Connection getconexion(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }
}
