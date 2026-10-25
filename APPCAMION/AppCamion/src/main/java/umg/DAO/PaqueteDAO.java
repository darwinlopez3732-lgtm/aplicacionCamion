package umg.DAO;

import umg.modelo.Paquete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class PaqueteDAO {
    public void insertar(Paquete paquete) throws SQLException{
        String sql = "INSERT INTO paquete(descripcion, destinatario, peso, direccion, idCamionero, idCiudad) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, paquete.getDescripcion());
            ps.setString(2, paquete.getDestinatario());
            ps.setBigDecimal(3, paquete.getPeso());
            ps.setString(4, paquete.getDireccion());
            ps.setInt(5, paquete.getCamionero().getIdCamionero());
            ps.setInt(6, paquete.getCiudad().getIdCiudad());
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se almaceno ningún registro");
            }
        }
    }

    public void actualizar(Paquete paquete) throws SQLException{
        String sql = "UPDATE paquete SET descripcion = ?, destinatario = ?, peso = ?, direccion = ?, idCamionero = ?, idCiudad = ? WHERE idPaquete = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, paquete.getDescripcion());
            ps.setString(2, paquete.getDestinatario());
            ps.setBigDecimal(3, paquete.getPeso());
            ps.setString(4, paquete.getDireccion());
            ps.setInt(5, paquete.getCamionero().getIdCamionero());
            ps.setInt(6, paquete.getCiudad().getIdCiudad());
            ps.setInt(7, paquete.getIdPaquete());
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se actualizo ningún registro");
            }
        }
    }

    public void eliminar(int idPaquete) throws SQLException{
        String sql = "DELETE FROM paquete WHERE idPaquete = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idPaquete);
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se elimino ningún registro");
            }
        }
    }

    public Paquete buscarPorId(int idPaquete) throws SQLException{
        String sql = "SELECT idPaquete, descripcion, destinatario, peso, direccion, idCamionero, idCiudad FROM paquete WHERE idPaquete = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idPaquete);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Paquete paquete = new Paquete();
                    paquete.setIdPaquete(rs.getInt("idPaquete"));
                    paquete.setDescripcion(rs.getString("descripcion"));
                    paquete.setDestinatario(rs.getString("destinatario"));
                    paquete.setPeso(rs.getBigDecimal("peso"));
                    paquete.setDireccion(rs.getString("direccion"));

                    CamioneroDAO camDao = new CamioneroDAO();
                    CiudadDAO ciuDao = new CiudadDAO();
                    paquete.setCamionero(camDao.buscarPorId(rs.getInt("idCamionero")));
                    paquete.setCiudad(ciuDao.buscarPorId(rs.getInt("idCiudad")));

                    return paquete;
                }
            }
        }
        return null;
    }

    public List<Paquete> listar() throws SQLException{
        List<Paquete> lista = new ArrayList<>();
        String sql = "SELECT idPaquete, descripcion, destinatario, peso, direccion, idCamionero, idCiudad FROM paquete";
        CamioneroDAO camDao = new CamioneroDAO();
        CiudadDAO ciuDao = new CiudadDAO();
        try (Connection cn = ConexionDAO.abrir();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Paquete paquete = new Paquete();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setDescripcion(rs.getString("descripcion"));
                paquete.setDestinatario(rs.getString("destinatario"));
                paquete.setPeso(rs.getBigDecimal("peso"));
                paquete.setDireccion(rs.getString("direccion"));
                paquete.setCamionero(camDao.buscarPorId(rs.getInt("idCamionero")));
                paquete.setCiudad(ciuDao.buscarPorId(rs.getInt("idCiudad")));
                lista.add(paquete);
            }
        }
        return lista;
    }
}
