package co.frikiteam.influwiki.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.frikiteam.influwiki.model.AreaModel;
import co.frikiteam.influwiki.model.ConexionPrincipalBD;
import co.frikiteam.influwiki.model.Usuario;

public class AreaDao {
	
	// establecemos la Conexión
		static ConexionPrincipalBD conBD = null;
		
		public ArrayList<AreaModel> getAreasInfluwiki() {
			Connection conectBD = null;
			PreparedStatement prpStmt = null;
			ResultSet rstAreas = null;
			ArrayList <AreaModel>listaAreas = new ArrayList<AreaModel>();
			AreaModel areasInfluwiki;
			
			try {
				String strStm;
				
				//Consulta sql donde se traen todos los resgistros de la tabla Usuarios
				
				conectBD = conBD.obetenerConexion();
				
				strStm = "SELECT "
						+ "a.id, a.nombre_area "
						+ "FROM tipo_area a ";
				//
				prpStmt = conectBD.prepareStatement(strStm);
				rstAreas = prpStmt.executeQuery();

				while(rstAreas.next()) {
					areasInfluwiki = new AreaModel();
					areasInfluwiki.setId(Integer.parseInt(rstAreas.getString("id")));
					areasInfluwiki.setNombreArea(rstAreas.getString("nombre_area"));
					
					listaAreas.add(areasInfluwiki);
					
				}
				rstAreas.close();
				
				
							
			}catch (Exception e) {
				System.out.println("Se presento un error al reallizar la consulta a la BD " + e);
			}
			return listaAreas;
		}

}
