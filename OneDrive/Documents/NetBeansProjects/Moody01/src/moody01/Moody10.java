package moody01;
import java.sql.*;
import java.util.Calendar;

public class Moody01 {
    public static void main(String[] args) {
      
        Connection con = dbconnection.conectar();
        
        if (con == null) {
            System.out.println("No se pudo establecer la conexión a la base de datos");
            return;
        }
    
        crud operaciones = new crud();
        
       
        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.JUNE, 15);
        Date fechaNacimiento = new Date(cal.getTimeInMillis());
        
       
        operaciones.insertarDato(123, "Juan", "Juan@example.com", "password12344", fechaNacimiento);
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}