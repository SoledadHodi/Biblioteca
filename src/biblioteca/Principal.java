package biblioteca;

public class Principal {

	public static void main(String[] args) {

		
		ConsultarLibro funcioneslibro = new ConsultarLibro();
		funcioneslibro.insertar(6, "Orgullo y prejuicio", "Jane Austen", "Novela rosa", 43, 7852);
		funcioneslibro.insertar(7,"Dracula" , "Bram Stoker", "Novela de fantasia", 26, 5896);
		funcioneslibro.actualizar ("Dracula", "Bram Stoker", "Novela de fantasía", 32, 5896, 7);
		funcioneslibro.insertar(8, "La vuelta al mundo en 80 dias", "Julio Verne", "Novela de ciencia ficción", 21, 8563);
		funcioneslibro.insertar(9, "Martín Fierro", "José Hernández", "Poema gauchesco", 50, 4528);
		funcioneslibro.insertar(10, "El fantasma de la ópera", "Gastón Leroux", "Novela gótica", 26, 3574);
		funcioneslibro.insertar(11, "Guerra y paz", "Leo Tolstoy", "Novela realista", 17, 5371);
		funcioneslibro.mostrar();
		funcioneslibro.eliminar(11);
		funcioneslibro.actualizar("El Principito", "Antoine de Saint-Exupéry", "Novela corta infantil", 60, 6596, 1);
		funcioneslibro.mostrar();
		

		ConsultarUsuario funcionesusuario = new ConsultarUsuario();
		funcionesusuario.insertar(2,"mar26", "MI.26", "Martina", "García", "Socio");
		funcionesusuario.insertar(3, "Agus16", "ma1609", "Agustina", "Diaz", "Invitado");
		funcionesusuario.insertar(4, "VanGon", "vane45", "Vanina", "Gonzalez", "Invitado");
		funcionesusuario.insertar(5, "Caro0508", "CCORREA1992", "Carolina", "Correa", "Socio");
		funcionesusuario.actualizar("mar26", "MI.26.06", "Martina", "García", "Socio", 2);
		funcionesusuario.actualizar("SoledadH", "ASH.2801", "Soledad", "Hodi", "Administrador", 1);
		funcionesusuario.insertar(6, "Ana23", "AFL03", "Ana", "Lopez", "Dado de baja");
		funcionesusuario.mostrar();
		funcionesusuario.eliminar(6);
		funcionesusuario.mostrar();
		
		
		ConsultarDescarga funcionesdescarga = new ConsultarDescarga();
		funcionesdescarga.insertar(10, 3, 5, 3, 6, 2);
		funcionesdescarga.actualizar(3, 2, 28, 5, 2, 9);
		funcionesdescarga.insertar(11, 5, 4, 10, 6, 0);
		funcionesdescarga.mostrar();
		funcionesdescarga.eliminar(11);
		funcionesdescarga.mostrar();
		
		
	}
}
