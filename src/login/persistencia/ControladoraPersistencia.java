
package login.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.logica.Rol;
import login.logica.Usuario;
import login.persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
        
        List<Usuario> listaUsuario = usuJpa.findUsuarioEntities();
        return listaUsuario;
        //SELECT * FROM USUARIOS // Trae todos los usuarios desde la base de datos
    }
    
    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
        
        // SELECT * FROM Roles
    }

    public void crearUsuario(Usuario usu) {
        try {
            usuJpa.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarUsuario(int id_usuario) {
        try {
            usuJpa.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Usuario traerUsuario(int id_usuario) {
        return usuJpa.findUsuario(id_usuario);
    }

    public Usuario traerUsuarios(int id_usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    
    
    
}
