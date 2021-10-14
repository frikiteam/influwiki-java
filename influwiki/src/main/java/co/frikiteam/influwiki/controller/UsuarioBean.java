package co.frikiteam.influwiki.controller;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.frikiteam.influwiki.Dao.UsuarioDao;

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

	private long id;

	private String nombres;

	private String apellidos;

	private String genero;

	private String apodo;

	private String correo;

	private String contrasena;

	private String id_perfil; // hace referencia si es un influencer o Administrador

	private String contenido;

	private String fecha_registro;

	private String actulizado;

	private int id_area; // hace referencia al tipo detematica

	private String mensajeSaludo;
	
	private boolean terminosCondiciones;
	
	//Variable selecionada de forma permamente para pefil influwiki
	

	public UsuarioBean() {

	}
	
	/**
	 * Función encargada de activar el check en id_influwiki
	 */
    public void init() {
    	id_perfil = "1";
    }


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

	public String getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(String id_perfil) {
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

	public boolean isTerminosCondiciones() {
		return terminosCondiciones;
	}

	public void setTerminosCondiciones(boolean terminosCondiciones) {
		this.terminosCondiciones = terminosCondiciones;
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

	//Creación del obejeto Usuario
	static UsuarioDao usuarioDAO = new UsuarioDao();
	
	//Creación del Mapeo
	private static Map<String, Object> mapUsuario;
	
	static {
		mapUsuario = new LinkedHashMap<String, Object>();
		//mapUsuario = 
	}
	
	//Arreglo que recibe las datos del usuarioDAO
	
	
	
}