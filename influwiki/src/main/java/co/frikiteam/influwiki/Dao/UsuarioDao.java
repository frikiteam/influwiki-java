package co.frikiteam.influwiki.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import co.frikiteam.influwiki.model.ConexionPrincipalBD;
import co.frikiteam.influwiki.model.Usuario;
import javassist.expr.NewArray;

public class UsuarioDao {

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
			String sentenciSQL = "INSERT INTO usuarios"
					+ "( nombres, apellidos, genero, apodo, email, contrasena, id_perfil, contenido_principal, fecha_registro, actulizado, id_area) "
					+ " VALUES" + "(?,?,?,?,?,?,?,?,?,?,?)";

			/**
			 * INSERT INTO `usuarios` (`id`, `nombres`, `apellidos`, `genero`, `apodo`,
			 * `email`, `contrasena`, `id_perfil`, `contenido_principal`, `fecha_registro`,
			 * `actulizado`, `id_area`) VALUES (NULL, 'Maria', 'Garcia', 'Femenino',
			 * 'alejandra', 'Maria.garcia@hotmail.com', '12345678', '1', 'Tutora en
			 * matematicas', '2021-10-01', '2021-10-12', '2');
			 */

			prpStmt = conexionBD.prepareStatement(sentenciSQL);

			// Asociamos cada uno de los elementos del objeto Usuario
			// a cada una de los Signos ? de pregunta
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
			System.out.println("Se presento error al crear el ingreso a la tabla usuarios " + e);
			ingresarDatos = false;
		} finally {
			try {
				conexionBD.close();
				conBD.cerrarConexion();

			} catch (Exception errorException) {
				System.out.println("Se presento error al cerrar la conexion a la base de datos " + errorException);
			}
		}

		return ingresarDatos;
	}

	/**
	 * Metodo que retorna la lista de usuarios influwiki
	 * @return
	 */
	public ArrayList<Usuario> getInflusuarios() {
		Connection conectBD = null;
		PreparedStatement prpStmt = null;
		ResultSet rstUsuario = null;
		ArrayList <Usuario>listaUsuarios = new ArrayList<Usuario>();
		Usuario usuarioInfluwili;
		
		try {
			//Consulta sql donde se traen todos los resgistros de la tabla Usuarios
			String strStm = null;
			conectBD = ConexionPrincipalBD.obetenerConexion();
			strStm = "SELECT id,nombres, apellidos, genero, apodo, email, contrasena, id_perfil, contenido_principal, fecha_registro, actulizado, id_area, "
					+ "FROM usuarios ";
			//
			rstUsuario = prpStmt.getGeneratedKeys();
			
			while(rstUsuario.next()) {
				usuarioInfluwili = new Usuario();
				usuarioInfluwili.setId(Integer.parseInt(rstUsuario.getString("id")));
				usuarioInfluwili.setNombres(rstUsuario.getNString("nombres"));
				usuarioInfluwili.setApellidos(rstUsuario.getNString("apellidos"));
				usuarioInfluwili.setGenero(rstUsuario.getNString("genero"));
				usuarioInfluwili.setApodo(rstUsuario.getNString("apodo"));
				usuarioInfluwili.setCorreo(rstUsuario.getNString("email"));
				usuarioInfluwili.setContrasena(rstUsuario.getNString("contrasena"));
				usuarioInfluwili.setId_perfil(Integer.parseInt(rstUsuario.getNString("id_perfil")));
				usuarioInfluwili.setContenido(rstUsuario.getNString("contenido_principal"));
				usuarioInfluwili.setFecha_registro(rstUsuario.getNString("fecha_registro"));
				usuarioInfluwili.setActulizado(rstUsuario.getNString("actualizado"));
				usuarioInfluwili.setId_area(Integer.parseInt(rstUsuario.getNString("id_area")));
				
				listaUsuarios.add(usuarioInfluwili);
				
			}
			rstUsuario.close();
			
			
						
		}catch (Exception e) {
			System.out.println("Se presento un error al reallizar la consulta a la BD " + e);
		}
		return listaUsuarios;
	}

}
