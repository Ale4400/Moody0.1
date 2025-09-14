package moody01;
import java.sql.*;

public class dbconnection {
    
    static String url = "jdbc:mysql://localhost:3306/base_datos";
    static String user = "root";
    static String pass = "LEYENDA789";
    
    public static Connection conectar() {
        Connection con = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC");
            e.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos:");
            System.out.println("URL: " + url);
            System.out.println("Usuario: " + user);
            ex.printStackTrace();
        }
        return con;
    }
}