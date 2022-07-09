package biblioteca;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class ConsultarLibro {
	Conexion conn = new Conexion();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;

	public void mostrar() {
		ArrayList listaLibros = new ArrayList();
		try {
			usarConexion = conn.conectar();
			stm = usarConexion.createStatement();
			rs = stm.executeQuery("SELECT * FROM libros");
			while (rs.next()) {

				
				listaLibros.add(0, rs.getString(2));
				listaLibros.add(1, rs.getString(3));
				listaLibros.add(2, rs.getString(4));
				listaLibros.add(3, rs.getInt(5));
				listaLibros.add(4, rs.getInt(6));
				
				int idlibro = rs.getInt(1);
				String titulo = rs.getString(2);
				String autor = rs.getString(3);
				String descripcion = rs.getString(4);
				int cantidad = rs.getInt(5);
				int codigo = rs.getInt(6);
				
				System.out.println(idlibro + " "+ titulo +" "+ autor +" "+ descripcion +" "+ cantidad + " "+ codigo);
			}
		} catch (Exception e) {

		}
	}

	public void insertar(int lib, String tit, String aut, String des, int cant, int cod) {
		try {
			String sql = "insert into libros (idlibro, titulo , autor, descripcion, cantidad, codigo)values(?,?,?,?,?,?)";
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(sql);
			ps.setObject(1, lib);
			ps.setObject(2, tit); 
			ps.setObject(3, aut);
			ps.setObject(4, des);
			ps.setObject(5, cant);
			ps.setObject(6, cod);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void actualizar(String tit, String aut, String des, int cant, int cod, int lib) {

		String sql = "update libros set titulo=?, autor=?, descripcion=?, cantidad=?, codigo=? where idlibro=?";
		try {
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(sql);
			
			ps.setObject(1, tit);
			ps.setObject(2, aut);
			ps.setObject(3, des);
			ps.setObject(4, cant);
			ps.setObject(5, cod);
			ps.setObject(6, lib);
			
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void eliminar(int idlibro) {
		String sql = "delete from libros where idlibro=?";
		try {
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(sql);
			ps.setInt(1, idlibro);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

}

	
	
