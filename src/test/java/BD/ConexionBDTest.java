package BD;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;
import BD.ConexionBD;
   
public class ConexionBDTest {

    @Test
    public void testConexionExitosa() {
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conn = conexionBD.obtenerConexion()) {
            assertNotNull(conn, "La conexión no debe ser null");
            assertFalse(conn.isClosed(), "La conexión debe estar abierta");
            System.out.println("✅ Conexión exitosa");
        } catch (Exception e) {
            fail("❌ Error al conectar: " + e.getMessage());
        }
    }
}
