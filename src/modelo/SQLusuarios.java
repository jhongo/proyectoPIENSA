package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SQLusuarios extends conexion {

    //********************//
    // REGISTRAR USUARIOS//
    //******************//
    public boolean registrar(usuarios usr) {
        PreparedStatement ps = null;
        Connection con = getconexion();

        String sql = "INSERT INTO usuarios (usuario,password,nombre,correo,id_tipo) VALUES(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUser());
            ps.setString(2, usr.getPassword());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getCorreo());
            ps.setInt(5, usr.getId_tipo());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQLusuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //******************************************//
    //VERIFICAR USUARIOS EXISTENTES             //
    //*****************************************//
    public int existeUsuario(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getconexion();

        String sql = "SELECT count(id) FROM usuarios WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return 1;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }

    //********************************//
    //VALIDACION DE CORREO EECTRONICO //
    //********************************//
    public boolean esEmail(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.find();

    }

    //***************//
    //INICIAR SESION//
    //*************//
    
    public boolean Login(usuarios usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getconexion();

        String sql = "SELECT id,usuario,password,nombre,id_tipo FROM usuarios WHERE usuario =?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUser());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (usr.getPassword().equals(rs.getString(3))) {

                    String sqlUpdate = "UPDATE usuarios SET last_time=? WHERE id=?";

                    ps = con.prepareStatement(sqlUpdate);
                    ps.setString(1, usr.getLast_sesion());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();

                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setId_tipo(rs.getInt(5));
                    return true;
                } else {
                    return false;
                }
            }

            return false;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
}
