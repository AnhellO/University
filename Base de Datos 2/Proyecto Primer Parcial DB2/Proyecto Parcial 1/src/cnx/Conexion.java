package cnx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private Connection conexion = null;
	
	public Conexion() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se encontr� el driver JBDC de Oracle");
			e.printStackTrace();
			return;
		}
		System.out.println("Oracle JDBC encontrado!");
		try {
			conexion = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "system",
					"oracle");

		} catch (SQLException e) {
			System.out.println("Conexi�n fallada. Verificar Consola");
			e.printStackTrace();
			return;
		}
		if (conexion != null) {
			System.out.println("Ejecutando Conexi�n...");
		} else {
			System.out.println("Se fall� al hacer la conexi�n");
		}
	}
	
	public Connection getConexion() {
		return conexion;
	}
	
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
}
