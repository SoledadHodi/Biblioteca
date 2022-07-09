package biblioteca;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class ConsultarDescarga {
	
		Conexion conn = new Conexion();
		Connection usarConexion = null;
		Statement stm = null;
		ResultSet rs = null;
		PreparedStatement ps;

		public void mostrar() {
			ArrayList listaDescargas= new ArrayList();
			try {
				usarConexion = conn.conectar();
				stm = usarConexion.createStatement();
				rs = stm.executeQuery("SELECT * FROM descargas");
				while (rs.next()) {
				
					listaDescargas.add(0, rs.getInt(2));
					listaDescargas.add(1, rs.getInt(3));
					listaDescargas.add(2, rs.getInt(4));
					listaDescargas.add(3, rs.getInt(5));
					listaDescargas.add(4, rs.getInt(6));
							
					
					int iddescarga = rs.getInt(1);
					int idlibro= rs.getInt (2);
					int idusuario = rs.getInt(3);
					int dia = rs.getInt(4);
					int mes = rs.getInt(5);
					int cantidaddescarga = rs.getInt(6);
					
					
					System.out.println (iddescarga + " " + idlibro + " " + idusuario + " "+ dia + " " + mes + " " + cantidaddescarga);
				
				}
			} catch (Exception e) {

			}
		}

		public void insertar(int iddescarga, int idlibro, int idusuario, int dia, int mes, int cantidaddescarga) {
			try {
				String sql = "insert into descargas (iddescarga, idlibro, idusuario, dia, mes, cantidaddescarga)values(?,?,?,?,?,?)";
				usarConexion = conn.conectar();
				ps = usarConexion.prepareStatement(sql);
				ps.setObject(1, iddescarga);
				ps.setObject(2, idlibro);
				ps.setObject (3, idusuario);
				ps.setObject(4, dia); 
				ps.setObject(5, mes); 
				ps.setObject(6, cantidaddescarga);
				ps.executeUpdate();
			} catch (Exception e) {
			}
		}

		public void actualizar(int idlibro, int idusuario, int dia, int mes, int cantidaddescarga, int iddescarga) {

			String sql = "update descargas set idlibro=?, idusuario=?,  dia=?, mes=?, cantidaddescarga=? where iddescarga=?";
			try {
				usarConexion = conn.conectar();
				ps = usarConexion.prepareStatement(sql);
				ps.setObject(1, idlibro);
				ps.setObject(2, idusuario);
				ps.setObject(3, dia);
				ps.setObject(4, mes);
				ps.setObject(5, cantidaddescarga);
				ps.setObject(6, iddescarga);
				ps.executeUpdate();
			} catch (Exception e) {
			}
		}

		public void eliminar(int iddescarga) {
			String sql = "delete from descargas where iddescarga=?";
			try {
				usarConexion = conn.conectar();
				ps = usarConexion.prepareStatement(sql);
				ps.setInt(1, iddescarga);
				ps.executeUpdate();

			} catch (Exception e) {

			}
		}

	}

