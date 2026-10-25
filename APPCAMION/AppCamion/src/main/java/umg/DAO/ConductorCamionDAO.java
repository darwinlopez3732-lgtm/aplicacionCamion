package umg.DAO;

import umg.modelo.ConductorCamion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class ConductorCamionDAO {
    public void insertar(ConductorCamion cc) throws SQLException{
        String sql = "INSERT INTO conductorcamion(idCamionero, idCamion, fecha) VALUES (?, ?, ?)";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, cc.getConductor().getIdCamionero());
            ps.setInt(2, cc.getCamion().getIdCamion());
            ps.setObject(3, cc.getFecha());
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se almaceno ningún registro");
            }
        }
    }

    public void actualizar(ConductorCamion cc) throws SQLException{
        String sql = "UPDATE conductorcamion SET idCamionero = ?, idCamion = ?, fecha = ? WHERE idConductorCamion = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, cc.getConductor().getIdCamionero());
            ps.setInt(2, cc.getCamion().getIdCamion());
            ps.setObject(3, cc.getFecha());
            ps.setInt(4, cc.getIdConductorCamion());
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se actualizo ningún registro");
            }
        }
    }

    public void eliminar(int idConductorCamion) throws SQLException{
        String sql = "DELETE FROM conductorcamion WHERE idConductorCamion = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idConductorCamion);
            int filas = ps.executeUpdate();
            if (filas == 0){
                throw new SQLException("No se elimino ningún registro");
            }
        }
    }

    public ConductorCamion buscarPorId(int idConductorCamion) throws SQLException{
        String sql = "SELECT idConductorCamion, idCamionero, idCamion, fecha FROM conductorcamion WHERE idConductorCamion = ?";
        try(Connection cn = ConexionDAO.abrir();
            PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, idConductorCamion);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    ConductorCamion cc = new ConductorCamion();
                    cc.setIdConductorCamion(rs.getInt("idConductorCamion"));

                    CamioneroDAO camDao = new CamioneroDAO();
                    CamionDAO camiDao = new CamionDAO();
                    cc.setConductor(camDao.buscarPorId(rs.getInt("idCamionero")));
                    cc.setCamion(camiDao.buscarPorId(rs.getInt("idCamion")));
                    cc.setFecha(rs.getObject("fecha", LocalDate.class));

                    return cc;
                }
            }
        }
        return null;
    }

    public List<ConductorCamion> listar() throws SQLException{
        List<ConductorCamion> lista = new ArrayList<>();
        String sql = "SELECT idConductorCamion, idCamionero, idCamion, fecha FROM conductorcamion";
        CamioneroDAO camDao = new CamioneroDAO();
        CamionDAO camiDao = new CamionDAO();
        try (Connection cn = ConexionDAO.abrir();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                ConductorCamion cc = new ConductorCamion();
                cc.setIdConductorCamion(rs.getInt("idConductorCamion"));
                cc.setConductor(camDao.buscarPorId(rs.getInt("idCamionero")));
                cc.setCamion(camiDao.buscarPorId(rs.getInt("idCamion")));
                cc.setFecha(rs.getObject("fecha", LocalDate.class));
                lista.add(cc);
            }
        }
        return lista;
    }
}
