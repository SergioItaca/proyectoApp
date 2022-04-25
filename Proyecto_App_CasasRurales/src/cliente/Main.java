package cliente;

import java.sql.Connection;
import java.sql.Statement;
import java.util.*;

import modelo.conexion.Conexion;
import modelo.conexion.DDL;

public class Main {
	
	
	//El objetivo es registrar clientes en la tabla clientes
	public static void main(String[] args) throws Exception {
		
		
		DDL ddl = new DDL();

		//ddl.CreateTable();
		
		//ddl.DropTable();
		
		ddl.AlterTable();
		
		
	}

}
