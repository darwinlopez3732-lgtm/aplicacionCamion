package umg.DAO;

import umg.modelo.Camionero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class CamioneroDAO {
    public void insertar(Camionero camionero) throws SQLException{
        String sql = "INSERT INTO camionero(nombre, apellidos, direccion, salario, poblacion, dpi, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, camionero.getNombre());
            ps.setString(2, camionero.getApellidos());
            ps.setString(3, camionero.getDireccion());
            ps.setBigDecimal(4, camionero.getSalario());
            ps.setString(5, camionero.getPoblacion());
            ps.setString(6, camionero.getDpi());
            ps.setString(7, camionero.getTelefono());
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se almaceno ningún registro");
            }
        }
    }

    public void actualizar(Camionero camionero) throws SQLException{
        String sql = "UPDATE camionero SET nombre = ?, apellidos = ?, direccion = ?, salario = ?, poblacion = ?, dpi = ?, telefono = ? WHERE idCamionero = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, camionero.getNombre());
            ps.setString(2, camionero.getApellidos());
            ps.setString(3, camionero.getDireccion());
            ps.setBigDecimal(4, camionero.getSalario());
            ps.setString(5, camionero.getPoblacion());
            ps.setString(6, camionero.getDpi());
            ps.setString(7, camionero.getTelefono());
            ps.setInt(8, camionero.getIdCamionero());
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se actualizo ningún registro");
            }
        }
    }

    public void eliminar(int idCamionero) throws SQLException{
        String sql = "DELETE FROM camionero WHERE idCamionero = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idCamionero);
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se elimino ningún registro");
            }
        }
    }

    public Camionero buscarPorId(int idCamionero) throws SQLException{
        String sql = "SELECT idCamionero, nombre, apellidos, direccion, salario, poblacion, dpi, telefono FROM camionero WHERE idCamionero = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idCamionero);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Camionero camionero = new Camionero();
                    camionero.setIdCamionero(rs.getInt("idCamionero"));
                    camionero.setNombre(rs.getString("nombre"));
                    camionero.setApellidos(rs.getString("apellidos"));
                    camionero.setDireccion(rs.getString("direccion"));
                    camionero.setSalario(rs.getBigDecimal("salario"));
                    camionero.setPoblacion(rs.getString("poblacion"));
                    camionero.setDpi(rs.getString("dpi"));
                    camionero.setTelefono(rs.getString("telefono"));
                    return camionero;
                }
            }
        }
        return null;
    }

    public List<Camionero> listar() throws SQLException{
        List<Camionero> lista = new ArrayList<>();
        String sql = "SELECT idCamionero, nombre, apellidos, direccion, salario, poblacion, dpi, telefono FROM camionero";
        try (Connection cn = ConexionDAO.abrir();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Camionero camionero = new Camionero();
                camionero.setIdCamionero(rs.getInt("idCamionero"));
                camionero.setNombre(rs.getString("nombre"));
                camionero.setApellidos(rs.getString("apellidos"));
                camionero.setDireccion(rs.getString("direccion"));
                camionero.setSalario(rs.getBigDecimal("salario"));
                camionero.setPoblacion(rs.getString("poblacion"));
                camionero.setDpi(rs.getString("dpi"));
                camionero.setTelefono(rs.getString("telefono"));
                lista.add(camionero);
            }
        }
        return lista;
    }
}
