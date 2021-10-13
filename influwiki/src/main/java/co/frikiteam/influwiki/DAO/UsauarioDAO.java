package co.frikiteam.influwiki.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;


import co.frikiteam.influwiki.model.ConexionPrincipalBD;
import co.frikiteam.influwiki.model.Usuario;

public class UsauarioDAO {

	// establecemos la Conexión
	static ConexionPrincipalBD conBD = null;

	public boolean almacenarUsuario(Usuario usuario) {
		
		Connection conexionBD = null;
		boolean ingresarDatos = true;
		
		if (conexionBD == null) {
			conexionBD = conBD.obetenerConexion();
		}
		
		// prpStmt se encarga de definir unaconsulta y ejecutarla
		
		PreparedStatement prpStmt = null;
		
		try {
			String sentenciSQL ="INSERT INTO influwiki.usuarios"
					+ "(nombres, apellidos, genero, apodo, email, contrasena, id_perfil, contenido_principal, fecha_registro, actulizado, id_area) "
					+ " VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			/**
			 * INSERT INTO `usuarios` (`id`, `nombres`, `apellidos`, `genero`, `apodo`, `email`, `contrasena`, `id_perfil`, `contenido_principal`, `fecha_registro`, `actulizado`, `id_area`) 
			 * VALUES (NULL, 'Maria', 'Garcia', 'Femenino', 'alejandra', 'Maria.garcia@hotmail.com', '12345678', '1', 'Tutora en matematicas', '2021-10-01', '2021-10-12', '2');
			 */
			
			
			//Asociamos cada uno de los elementos del objeto Usuario
			//a cada una de los Signos ? de pregunta
			prpStmt.setString(1, usuario.getNombres());
			prpStmt.setString(2, usuario.getApellidos());
			prpStmt.setString(3, usuario.getGenero());
			prpStmt.setString(4, usuario.getApodo());
			prpStmt.setString(5, usuario.getCorreo());
			prpStmt.setString(6, usuario.getContrasena());
			prpStmt.setInt(7, usuario.getId_perfil());
			prpStmt.setString(8, usuario.getContenido());
			prpStmt.setString(9, usuario.getFecha_registro());
			prpStmt.setString(10, usuario.getActulizado());
			prpStmt.setInt(11, usuario.getId_area());
			
			prpStmt.execute();
			
		} catch (Exception e) {
			System.out.println("Se presento error al crear el ingreso a la tabla libros " + e);
			ingresarDatos = false;
		}finally {
			try {
				conexionBD.close();
				conBD.cerrarConexion();
				
			} catch (Exception errorException) {
				System.out.println("Se presento error al cerrar la conexion a la base de datos " + errorException);
			}
		}
		
		return ingresarDatos;
	}

}
