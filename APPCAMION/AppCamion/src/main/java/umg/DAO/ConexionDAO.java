package umg.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexionDAO {
    private static final String URL =
            "jdbc:mysql://localhost:3306/conexion_BD"
            + "?useSSL=false"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=America/Guatemala";

    private static final String USER = "root";
    private static final String PASS = "37323771";

    public static Connection abrir() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
