package database.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static final String url = "jdbc:postgresql://localhost/tcontas";
	private static final String usuario = "postgres";
	private static final String senha = "postgres";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, usuario, senha);
	}
	
}
