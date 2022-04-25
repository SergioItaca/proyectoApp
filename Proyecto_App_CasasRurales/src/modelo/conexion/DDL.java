package modelo.conexion;

import java.sql.Statement;
import java.util.Scanner;

import modelo.conexion.Conexion;

public class DDL {
	/*
	 * CREATE
	 * ALTER
	 * DROP
	 * */
	
	// Crear un constructor para la clase DDL, de esta forma se podr�n inicializar objetos de esta clase en otras clases
	public DDL() {};
	
	
	//Realizar m�todo para crear una tabla
	public void CreateTable() throws Exception {
		
		Conexion connect = new Conexion();
		Scanner sc = new Scanner(System.in);
		
		try {
			Statement st_=connect.Conexion("entornos","root","admin");
			System.out.println("Crea la tabla.");
			
			String n = sc.nextLine();
			st_.executeUpdate(n);
		}catch(Exception e) {
			
		}
	}
	
	//M�todo para borrar tablas
	public void DropTable() throws Exception {
		Conexion connect = new Conexion();
		Scanner sc = new Scanner(System.in);
		
		try {
			Statement st_=connect.Conexion("entornos","root","admin");
			System.out.println("Borra la tabla.");
			
			String n = sc.nextLine();
			st_.executeUpdate(n);
		}catch(Exception e) {
			
		}
	}
	
	//M�todo para alterar la tabla
	public void AlterTable() throws Exception {
		Conexion connect = new Conexion();
		Scanner sc = new Scanner(System.in);
		
		try {
			Statement st_=connect.Conexion("entornos","root","admin");
			System.out.println("Altera la tabla.");
			
			String n = sc.nextLine();
			st_.executeUpdate(n);
		}catch(Exception e) {
			
		}
	}
}
