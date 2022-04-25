package modelo.conexion;

import javax.swing.*;

import modelo.conexion.Conexion;

import java.awt.*;
import java.sql.*;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		JFrame mimarco = new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion() {
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus = new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		nombres = new JComboBox();
		
		nombres.setEditable(false);
		
		nombres.addItem("Nombres");
		
		categorias = new JComboBox();
		
		categorias.setEditable(false);
		
		categorias.addItem("Edad");
		
		resultado = new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(nombres);
		
		menus.add(categorias);
		
		add(menus, BorderLayout.NORTH);
		
		add(menus, BorderLayout.CENTER);
		
		JButton botonConsulta = new JButton("Consulta");
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/entornos","root","admin");
			Statement sentencia = miConexion.createStatement();
			
			
			//CARGA NOMBRES
			String consulta = "SELECT DISTINCTROW NOMBRE FROM CLIENTES";
			
			ResultSet rs = sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				
				nombres.addItem(rs.getString(1));
			}
			
			rs.close();
			
			//CARGA CATEGORIAS
			consulta = "SELECT DISTINCTROW edad FROM CLIENTES";
			
			rs = sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				
				categorias.addItem(rs.getString(1));
			}
			
			rs.close();

		}catch(Exception e) {};
		
	}
	
	private JComboBox nombres;
	
	private JComboBox categorias;
	
	private JTextArea resultado;
	
}