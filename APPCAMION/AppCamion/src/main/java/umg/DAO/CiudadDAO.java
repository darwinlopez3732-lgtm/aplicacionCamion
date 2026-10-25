package umg.DAO;

import umg.modelo.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

public class CiudadDAO {
    // metodo para almacenar datos en la tabla ciudad
    public void insertar(Ciudad ciudad) throws SQLException{
        String sql = "INSERT INTO ciudad(Nombre) VALUES (?)";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, ciudad.getNombre());
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se almaceno ningún registro");
            }
        }
    }

    // metodo para actualizar Datos
    public void actualizar(Ciudad ciudad) throws SQLException{
        String sql = "UPDATE ciudad SET Nombre = (?) WHERE idCiudad= (?)";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, ciudad.getNombre());
            ps.setInt(2, ciudad.getIdCiudad());
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se actualizo ningún registro");
            }
        }
    }

    // metodo para eliminar
    public void eliminar(int idCiudad) throws SQLException{
        String sql = "DELETE FROM ciudad WHERE idCiudad = (?)";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idCiudad);
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se elimino ningún registro");
            }
        }
    }

    // metodo para buscar por id
    public Ciudad buscarPorId(int idCiudad) throws SQLException{
        String sql = "SELECT idCiudad, Nombre FROM ciudad WHERE idCiudad = (?)";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idCiudad);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Ciudad ciudad = new Ciudad();
                    ciudad.setIdCiudad(rs.getInt("idCiudad"));
                    ciudad.setNombre(rs.getString("Nombre"));
                    return ciudad;
                }
            }
        }
        return null;
    }

    // metodo para traer los registros
    public List<Ciudad> listar() throws SQLException{
        List<Ciudad> lista = new ArrayList<>();
        String sql = "SELECT idCiudad, Nombre FROM ciudad";

        try (Connection cn = ConexionDAO.abrir();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(rs.getInt("idCiudad"));
                ciudad.setNombre(rs.getString("Nombre"));
                lista.add(ciudad);
            }
        }
        return lista;
    }
}
