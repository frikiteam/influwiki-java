package co.frikiteam.influwiki.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.swing.JOptionPane;

import org.primefaces.PrimeFaces;
import org.primefaces.component.chip.Chip;
import org.primefaces.model.DefaultStreamedContent;

import co.frikiteam.influwiki.Dao.AreaDao;
import co.frikiteam.influwiki.Dao.UsuarioDao;
import co.frikiteam.influwiki.model.AreaModel;
import co.frikiteam.influwiki.model.Usuario;

/**
 * Clase bean de usuario
 * 
 * @author yety9
 *
 */
@ManagedBean(name = "UsuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

	/**
	 * Serialización de la Clase
	 */
	private static final long serialVersionUID = 1L;
	UsuarioDao usuariosinfluwiki = new UsuarioDao();


	private long id;

	private String nombres;

	private String apellidos;

	private String genero;

	private String apodo;

	private String correo;

	private String contrasena;

	private boolean id_perfil = true; // hace referencia si es un influencer o Administrador

	private String contenido;

	private String fecha_registro;

	private String actulizado;

	private int id_area; // hace referencia al tipo detematica

	private String mensajeSaludo;

	private boolean terminosCondiciones;

	private String urlImgPerfil;
	
	private ArrayList<Usuario> listaCompleta;



	/**
	 * Función encargada de activar el check en id_influwiki
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean isId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(boolean id_perfil) {
		this.id_perfil = id_perfil;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getActulizado() {
		return actulizado;
	}

	public void setActulizado(String actulizado) {
		this.actulizado = actulizado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMensajeSaludo() {
		return mensajeSaludo;
	}

	public void setMensajeSaludo(String mensajeSaludo) {
		this.mensajeSaludo = mensajeSaludo;
	}

	public String getUrlImgPerfil() {
		return urlImgPerfil;
	}

	public void setUrlImgPerfil(String urlImgPerfil) {
		this.urlImgPerfil = urlImgPerfil;
	}
	
	public boolean isTerminosCondiciones() {
		return terminosCondiciones;
	}

	public void setTerminosCondiciones(boolean terminosCondiciones) {
		this.terminosCondiciones = terminosCondiciones;
	}
	
	public ArrayList<Usuario> getListaCompleta() {
		return listaCompleta;
	}

	public void setListaCompleta(ArrayList<Usuario> listaCompleta) {
		this.listaCompleta = listaCompleta;
		
	}
	
	
	/*
	 * Metodos encargados de realixar las distintas validaciones
	 */

	/*
	 * Metodo encargado de validar el inicio de sesion
	 */
	public void iniciarSesion() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido " + correo));
	}

	/*
	 * Metodo encargado de enviar correo para recuperacion de contraseña.
	 */
	public void recuperacionContrasena() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correo enviado a " + correo));
	}

	/**
	 * Redierecciones al formulario de inicio de sesión
	 * 
	 * @return
	 */
	public String retornarLogin() {
		String url = "login_form.xhtml";
		return url;
	}

	/**
	 * Redierecciones a la pagina datos de perfil
	 * 
	 * @return
	 */
	public String verPerfil() {
		String url = "perfil_form.xhtml";
		return url;

	}

	/**
	 * Redierecciones al editar perfil
	 * 
	 * @return
	 */
	public String retornarEdicionPerfil() {
		String url = "editar_perfil.xhtml";
		return url;
	}



	/**
	 * 
	 */
	public void mostrarDatos() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome " + terminosCondiciones));

	}

	/*
	 * Metodos que ejecutam sql
	 */

	// Creación del obejeto Usuario
	static UsuarioDao usuarioDAO = new UsuarioDao();

	// Creación del Mapeo
	private static Map<String, Object> mapUsuario;

	static {
		mapUsuario = new LinkedHashMap<String, Object>();
		// mapUsuario =
	}

	// Arreglo que recibe las datos del usuarioDAO

	// Asignar Perfil influwiki obligatorio
	public int asignarPerfilInfluwiki() {
		id_perfil = true;
		int perfilInfluwiki = 0;

		if (id_perfil) {
			perfilInfluwiki = 1;

		}
		return perfilInfluwiki;
	}

	/**
	 * Metodo que guarda la información en base de datos
	 */
	public String guardarUsuarioForm() {
		boolean conexionExitosa;
		String Url = "login_form.xhtm";

		// Obtención de fecha
		String fechaActual = LocalDate.now().toString();

		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		fecha_registro = fechaActual;
		actulizado = fechaActual;

		// clase que contiene el metodo de guardar en bd
		UsuarioDao usuarioDao = new UsuarioDao();
		// Clase de modelo
		Usuario usuario = new Usuario();

		// Asiagnación de datos al modelo de usuario
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setApodo(apodo);
		usuario.setCorreo(correo);
		usuario.setContrasena(contrasena);
		usuario.setGenero(genero);
		usuario.setId_perfil(asignarPerfilInfluwiki());
		usuario.setId_area(id_area);
		usuario.setContenido(contenido);
		usuario.setFecha_registro(fecha_registro);
		usuario.setActulizado(actulizado);

		

		// Ejecuación de inserción de datos en bd
		conexionExitosa = usuarioDao.almacenarUsuario(usuario);
		conexionExitosa = true;

		// se detiene 4 segundos antes de seguir

		if (conexionExitosa) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Se esta validando el " + "Registro para " + nombres));

		}

		try {
			Thread.sleep(4 * 1000);
		} catch (Exception e) {
			System.out.println(e);

		}

		return Url;

	}

	/**
	 * Trae la listas de todos los usuarios
	 * 
	 * @return
	 */

	public ArrayList<Usuario> consultarUsariosInfluwiki() {

		UsuarioDao usuarios = new UsuarioDao();
		
		ArrayList<Usuario>listaCompleta =  usuarios.getInflusuarios();
		
		/*
		 * for (int i = 0; i < listaCompleta.size(); i++) {
		 * System.out.println(listaCompleta.get(i)); prueba = listaCompleta.get(i); }
		 */
			
		return listaCompleta;
	}




	

	/**
	 * Trae las areas existentes en influwikibd
	 * 
	 * @return
	 */
	public void consultarAreasInfluwiki() {
		AreaModel areasInfluwiki;
		int tamanioArray;
		AreaDao areas = new AreaDao();

		ArrayList<AreaModel> listaCompletaAreas = areas.getAreasInfluwiki();

		for (int i = 0; i < listaCompletaAreas.size(); i++) {
			System.out.println(listaCompletaAreas.get(i).getNombreArea());
		}

	}

	/**
	 * Valida si los datos ingresados existen en la base datos
	 */
	public void validarLogin() {

		String Url2 = "login_form.xhtml";


		UsuarioDao usuarioLogin = new UsuarioDao();
		Usuario usuarioBD;
		usuarioBD = usuarioLogin.getInflusuario(correo, contrasena);

		if (usuarioBD.getNombres() != null) {

			this.setNombres(usuarioBD.getNombres());
			this.setApellidos(usuarioBD.getApellidos());
			this.setApodo(usuarioBD.getApodo());
			this.setCorreo(usuarioBD.getCorreo());
			this.setContrasena(usuarioBD.getContrasena());
			this.setGenero(usuarioBD.getGenero());
			this.setId_area(usuarioBD.getId_area());
			this.setContenido(usuarioBD.getContenido());
			this.setUrlImgPerfil(asignarFotoPerfil(usuarioBD));

			// redireccione a la pagina editar_perfil.xhtml en caso de de que exista login y
			// contraseña
			try {

				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect("editar_perfil.xhtml");

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Se ha presentado un error" + e);
			}

		} else {

			try {
				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect(Url2);
			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Se ha presentado un error" + e);
			}

		}

	}

	/**
	 * Asigna la imagen de perfil si es hombre o mujer
	 * 
	 * @param usuario
	 * @return
	 */
	public String asignarFotoPerfil(Usuario generoUsuario) {

		String generoMasculino = "Masculino";
		String generoFemenino = "Femenino";

		String urlImagenHombre = "img/foto_perfil_h.png";
		String urlImagenMujer = "img/foto_perfil.jpg";
		String imgDefault = "img/infliwiki_buho.png";

		if (generoUsuario.getGenero().equals(generoMasculino)) {
			return urlImagenHombre;

		} else if (generoUsuario.getGenero().equals(generoFemenino)) {
			return urlImagenMujer;
		} else {
			return imgDefault;
		}

	}



}