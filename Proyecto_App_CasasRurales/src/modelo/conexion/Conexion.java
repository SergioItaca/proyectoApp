package modelo.conexion;

import java.sql.*;

public class Conexion {
	
	private static String url = "jdbc:mysql://localhost:3306/";
	private static Connection connection_;
	private static Statement st_ =null;

	public Conexion() {};
	
    public static Statement Conexion(String db, String user, String passw) throws Exception {
        try {
        	//1. Obtener el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2. obtener la conexion
            connection_ = DriverManager.getConnection(url+db,user,passw);
 
            if(connection_ != null ) {
            	//Crear objeto statement para realizar consultas sobre la BBDD
            	st_ = connection_.createStatement();
				System.out.println( "Conexión a base de datos " + db + " correcta. " );
			}else {
				System.out.println("Conexión fallida.");
			}
			
		} catch ( SQLException e ) { e.printStackTrace() ;}
		catch ( ClassNotFoundException e ) { e.printStackTrace() ;}
		catch ( Exception e ) { e.printStackTrace() ;}
		return st_;
 
    }
    /*public void CreateTable() throws Exception {
		
		try {
			Statement st_=Conexion("clientes_DB","root","admin");
			String alg = "Create table cli2(nom varchar(10))";
			st_.executeUpdate(alg);
		}catch(Exception e) {
			
		}
	}*/
}