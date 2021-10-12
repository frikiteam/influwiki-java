package co.frikiteam.influwiki.model;

/**
 * 
 * @author yety9
 * 
 * clase encargada de realizar la conexión a la 
 * base de datos influwiki
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import javax.swing.JOptionPane;

public class ConexionPrincipalBD {
	private static Connection conexion = null;

	/**
	 * metodo encargado de realizar la conexion con base de datos
	 * 
	 * @return conexion
	 */
	public static Connection obetenerConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/influwikibd?serverTimezone=" + TimeZone.getDefault().getID();
			conexion = DriverManager.getConnection(url, "root", ""); // Producción Maria123-
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Se ha presentado un error al intentar con la base de datos" + e.getMessage());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Se ha presentado un error al intentar con la base de datos" + e.getMessage());
		}

		return conexion;

	}

	/**
	 * metodo que cierra la conexion a la base de datos
	 */
	public static void cerrarConexion() {

		if (conexion != null) {
			try {
				conexion.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Se ha presentado un error al intentar con la base de datos" + e.getMessage());
			}
		}

	}
}
