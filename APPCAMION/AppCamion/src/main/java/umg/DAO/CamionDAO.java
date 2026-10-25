package umg.DAO;

import umg.modelo.Camion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class CamionDAO {
    public void insertar(Camion camion) throws SQLException{
        String sql = "INSERT INTO camion(modelo, tipo, potencia, noPlaca) VALUES (?, ?, ?, ?)";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, camion.getModelo());
            ps.setString(2, camion.getTipo());
            ps.setBigDecimal(3, camion.getPotencia());
            ps.setString(4, camion.getNoPlaca());
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se almaceno ningun registro");
                
            }
        }
    }

    public void actualizar(Camion camion) throws SQLException{
        String sql = "UPDATE camion SET modelo = ?, tipo = ?, potencia = ?, noPlaca = ? WHERE idCamion = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, camion.getModelo());
            ps.setString(2, camion.getTipo());
            ps.setBigDecimal(3, camion.getPotencia());
            ps.setString(4, camion.getNoPlaca());
            ps.setInt(5, camion.getIdCamion());
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se actualizo ningún registro");
            }
        }
    }

    public void eliminar(int idCamion) throws SQLException{
        String sql = "DELETE FROM camion WHERE idCamion = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idCamion);
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se elimino ningún registro");
            }
        }
    }

    public Camion buscarPorId(int idCamion) throws SQLException{
        String sql = "SELECT idCamion, modelo, tipo, potencia, noPlaca FROM camion WHERE idCamion = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idCamion);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Camion camion = new Camion();
                    camion.setIdCamion(rs.getInt("idCamion"));
                    camion.setModelo(rs.getString("modelo"));
                    camion.setTipo(rs.getString("tipo"));
                    camion.setPotencia(rs.getBigDecimal("potencia"));
                    camion.setNoPlaca(rs.getString("noPlaca"));
                    return camion;
                }
            }
        }
        return null;
    }

    public List<Camion> listar() throws SQLException{
        List<Camion> lista = new ArrayList<>();
        String sql = "SELECT idCamion, modelo, tipo, potencia, noPlaca FROM camion";
        try (Connection cn = ConexionDAO.abrir();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Camion camion = new Camion();
                camion.setIdCamion(rs.getInt("idCamion"));
                camion.setModelo(rs.getString("modelo"));
                camion.setTipo(rs.getString("tipo"));
                camion.setPotencia(rs.getBigDecimal("potencia"));
                camion.setNoPlaca(rs.getString("noPlaca"));
                lista.add(camion);
            }
        }
        return lista;
    }
}
