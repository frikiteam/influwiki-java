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
		
		private String id_perfil; // hace referencia si es un influencer o Administrador
		
		private String area; // hace referencia al tipo detematica
		
		private String fecha_registro;
		
		private String actulizado;

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

		public String getId_perfil() {
			return id_perfil;
		}

		public void setId_perfil(String id_perfil) {
			this.id_perfil = id_perfil;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
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

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", genero=" + genero
					+ ", apodo=" + apodo + ", correo=" + correo + ", id_perfil=" + id_perfil + ", area=" + area
					+ ", fecha_registro=" + fecha_registro + ", actulizado=" + actulizado + "]";
		}
		
		
		

}
