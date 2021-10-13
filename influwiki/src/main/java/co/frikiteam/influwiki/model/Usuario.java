package co.frikiteam.influwiki.model;

/**
 * 
 * @author yety9
 * 
 *Clase utiliza para generar el modelo
 */
public class Usuario {
	
private long id;
	
	private String nombres;
	
	private String apellidos;
	
	private String genero;
	
	private String apodo;
	
	private String correo;
	
	private String contrasena;
	
	private int id_perfil; // hace referencia si es un influencer o Administrador
	
	private String contenido;
	
	private String fecha_registro;
	
	private String actulizado;
	
	private int id_area; // hace referencia al tipo detematica
	
	

	public Usuario() {
		super();
	}

	public Usuario(String nombres, String apellidos, String genero, String apodo, String correo, String contrasena,
			int id_perfil, String contenido, String fecha_registro, String actulizado, int id_area) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.genero = genero;
		this.apodo = apodo;
		this.correo = correo;
		this.contrasena = contrasena;
		this.id_perfil = id_perfil;
		this.contenido = contenido;
		this.fecha_registro = fecha_registro;
		this.actulizado = actulizado;
		this.id_area = id_area;
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

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
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

	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", genero=" + genero
				+ ", apodo=" + apodo + ", correo=" + correo + ", contrasena=" + contrasena + ", id_perfil=" + id_perfil
				+ ", contenido=" + contenido + ", fecha_registro=" + fecha_registro + ", actulizado=" + actulizado
				+ ", id_area=" + id_area + "]";
	}

	
	
		
		

}
