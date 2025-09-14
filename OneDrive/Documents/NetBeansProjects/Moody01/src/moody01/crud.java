package moody01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class crud {
    
   
    public void insertarDato(int id, String Nombre, String Email, String Contraseña, Date Fechadenacimiento) {
        String query = "INSERT INTO usuario (IDusuario, Nombre, Email, Contraseña, Fechadenacimiento) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = new dbconnection().conectar();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setInt(1, id);
            ps.setString(2, Nombre);
            ps.setString(3, Email);
            ps.setString(4, Contraseña);
            ps.setDate(5, Fechadenacimiento);
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario insertado con éxito");
            } else {
                System.out.println("No se pudo insertar el usuario");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar usuario: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
  
    public void leerDatos() {
        String query = "SELECT * FROM usuario";
        
        try (Connection con = new dbconnection().conectar();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.println("\n--- LISTA DE USUARIOS ---");
            while (rs.next()) {
                int id = rs.getInt("IDusuario");
                String nombre = rs.getString("Nombre");
                String email = rs.getString("Email");
                String contraseña = rs.getString("Contraseña");
                Date fechaNac = rs.getDate("Fechadenacimiento");
                
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Email: " + email + 
                                 ", Fecha Nacimiento: " + fechaNac);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al leer los datos: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    

    public void actualizarDato(int id, String nuevoNombre, String nuevoEmail, String nuevaContraseña, Date nuevaFechaNac) {
        String query = "UPDATE usuario SET Nombre = ?, Email = ?, Contraseña = ?, Fechadenacimiento = ? WHERE IDusuario = ?";
        
        try (Connection con = new dbconnection().conectar();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevoEmail);
            ps.setString(3, nuevaContraseña);
            ps.setDate(4, nuevaFechaNac);
            ps.setInt(5, id);
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario actualizado con éxito");
            } else {
                System.out.println("No se pudo actualizar el usuario. Verifique el ID.");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar usuario: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
   
    public void eliminarDato(int id) {
        String query = "DELETE FROM usuario WHERE IDusuario = ?";
        
        try (Connection con = new dbconnection().conectar();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario eliminado con éxito");
            } else {
                System.out.println("No se pudo eliminar el usuario. Verifique el ID.");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar usuario: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}