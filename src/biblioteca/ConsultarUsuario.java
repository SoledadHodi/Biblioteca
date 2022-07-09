package biblioteca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class ConsultarUsuario {
	
	Conexion conn = new Conexion();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;

	public void mostrar() {
		ArrayList listaUsuarios= new ArrayList();
		try {
			usarConexion = conn.conectar();
			stm = usarConexion.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuarios");
			while (rs.next()) {

				listaUsuarios.add(0, rs.getString(2));
				listaUsuarios.add(1, rs.getString(3));
				listaUsuarios.add(2, rs.getString(4));
				listaUsuarios.add(3, rs.getString(5));
				listaUsuarios.add(4, rs.getString(6));
									
				int idusuario = rs.getInt(1);
				String login = rs.getString(2);
				String clave = rs.getString(3);
				String nombre = rs.getString(4);
				String apellido = rs.getString(5);
				String condicion = rs.getString(6);
				
				
				System.out.println (idusuario + " " + login + " " + clave + " " + nombre +" " + apellido + " " + condicion);
			}
		} catch (Exception e) {

		}
	}

	public void insertar(int id, String login, String clave,  String nom, String ape, String cond) {
		try {
			String sql = "insert into usuarios (idusuario, login, clave, nombre,apellido,condicion)values(?,?,?,?,?, ?)";
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(sql);
			ps.setObject(1, id);
			ps.setObject(2, login);
			ps.setObject (3, clave);
			ps.setObject(4, nom); 
			ps.setObject(5, ape); 
			ps.setObject(6, cond);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void actualizar(String login, String clave, String nom, String ape, String cond, int idusuario) {

		String sql = "update usuarios set login=?, clave=?,  nombre=?, apellido=?, condicion=? where idusuario=?";
		try {
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(sql);
			ps.setObject(1, login);
			ps.setObject(2, clave);
			ps.setObject(3, nom);
			ps.setObject(4, ape);
			ps.setObject(5, cond);
			ps.setObject(6, idusuario);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void eliminar(int idusuario) {
		String sql = "delete from usuarios where idusuario=?";
		try {
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(sql);
			ps.setInt(1, idusuario);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

}
	
		

