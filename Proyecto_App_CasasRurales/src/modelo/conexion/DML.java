package modelo.conexion;

import java.sql.Statement;
import java.util.Scanner;

public class DML {
	/*
	 * INSERT
	 * UPDATE
	 * DELETE
	 * SELET
	 * */
	
	// Crear un constructor para la clase DML, de esta forma se podrán inicializar objetos de esta clase en otras clases
	public DML() {};
	
	public void InsertData() {
		Conexion connect = new Conexion();
		Scanner sc = new Scanner(System.in);
		
		try {
			Statement st_=connect.Conexion("clientes_DB","root","admin");
			System.out.println("Insertar datos.");
			
			String n = sc.nextLine();
			st_.executeUpdate(n);
		}catch(Exception e) {
			
		}
	}
}
