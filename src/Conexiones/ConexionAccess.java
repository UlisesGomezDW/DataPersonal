package Conexiones;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ConexionAccess {
    Connection ccn = null;
Statement st = null;

    public ConexionAccess(){
        try 
            {              
                String rutafile = "C:\\bd\\Personas.accdb";
                String Url = "jdbc:ucanaccess://" + rutafile;
                ccn = DriverManager.getConnection(Url);
                st = ccn.createStatement();
            } 
        catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, "CONEXION ERRONEA " + e);  
                }
    }
    
    public Connection getConnection(){
        return ccn;
    }
    
    public void Desconexion(){
        try 
            {
                ccn.close();            
                System.exit(0);
            } catch (SQLException ex) 
                {
                    Logger.getLogger(ConexionAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
