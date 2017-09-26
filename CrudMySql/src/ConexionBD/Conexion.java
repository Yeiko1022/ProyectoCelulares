package ConexionBD;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    String dbname = "celulares";
    String url_host = "jdbc:mysql://localhost/"+dbname;
    String user = "root";
    String password = "";
    
    public Conexion(){
        
    }
    
    public Connection Conectar(){
        Connection link = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url_host, this.user, this.password);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);         
        }
        
        return link;
    }
}
