package hotelAPP;

import java.util.*; //Se importa java.util


import java.io.FileReader;// Se importa la clase FileReader
import java.io.File; // Se importa la clase File
import java.io.FileWriter; // Se importa la clase FileWriter

public class Utilities_files {
	
	/* ¿Cómo se van a guardar los datos? (Formateo)
	 * 		Todos los strings se van a guardar en minúsculas.
	 * 		Si hay más de un espacio entre dos palabras, cambiarlo por un único espacio.
	 * 		Se introducirá un punto y coma entre cada atributo.
	 * 		La clave primaria de cada cliente será su id (hashCode) que se obtendrá a partir del DNI del cliente.
	 * 		Se introducirá el caracter > cuando se hayan terminado de guardar en el fichero todos los atributos del cliente.
	 * 		Los atributos que se pueden guardar como nulos son: Tarjeta de crédito y memberCategory. El resto de atributos deben contener información.
	 * */
	
	/*Método para guardar los datos en un fichero txt*/
	
	/*Métodos de búsqueda de clientes:
	 * 	bucarPorNombre() // Ojo con los apellidos compuestos. Cuando se haga la busqueda deben aparecer los dos.
	 * 	buscarPorApellido() // Ojo con los apellidos compuestos. Cuando se haga la busqueda deben aparecer los dos.
	 * */
	
	/*Para guardar los nombres y paellidos compuestos:
	 * 	Convertir todas las letras a minúsculas
	 * 	eliminar los espacios sobrantes entre palabras.
	 * 	Transformar el espacio entre nombres o apellidos a un asterisco(*).
	 * 	Cuando se vaya a buscar por el nombre, se mostrarán los dos nombres por pantalla y la primera letra después del asterisco pasará a mayuscula y la primera despues del punto y coma y el asterisco se sustituirá por un espacio.*/
	
	/*Hay que darle formato .txt al fichero*/
	
	/*Este método sirve para guardar en un fichero los datos del cliente*/
	public void escritorCliente(String f, Client c) {
		try {
			FileWriter fw = new FileWriter(f, true);
			
			fw.write(c.name+";"+c.lastName+";"+c.DNI+";"+c.dateBirth+";"+c.TC+";"+c.email+";"+c.codPaisTelefono+c.telephone+";"+
			c.clientCode+";"+c.memberCategory+";"+c.fidelityPoints+";"+c.member+">"+"\n");
			
			fw.close();
			
		}catch(Exception e) {System.out.println("Something went wrong.");System.out.println(e);}
		System.out.println("Client data saved.");
	}
	
	/*Este método sirve para guardar en un fichero los datos de la reserva*/
	public void escritorReserva(String f, Reservation r) {
		try {
			FileWriter fw = new FileWriter(f, true);
			
			fw.write(r.codeReservation+";"+r.price+";"+r.checkIn+";"+r.checkOut+";"+r.clientCode+">"+"\n");
			
			fw.close();
			
		}catch(Exception e) {System.out.println("Something went wrong.");System.out.println(e);}
		System.out.println("Reservation data saved.");
	}
	
	/*Este método sirve para guardar en un fichero los datos del empleado*/
	public void escritorEmpleado(String f, Employee emp) {
		try {
			FileWriter fw = new FileWriter(f, true);
			
			fw.write(emp.name+";"+emp.lastName+";"+emp.DNI+";"+emp.empCode+";"+emp.shift+">"+"\n");
			
			fw.close();
			
		}catch(Exception e) {System.out.println("Something went wrong.");System.out.println(e);}
		System.out.println("Reservation data saved.");
	}
	
	public void lectorFicheroCliente(String f) {
		Client client = new Client();
		try {
			
			FileReader fr = new FileReader(f);
			List<Client> listClients = new ArrayList<>();
			
			int valor;
            int indice=0;
            String prueba = "";
            int puntoycoma =0;
            
            while((valor=fr.read())!=-1) { //Es redundante. Si no hay más caracteres para leer, ';' no implica nada
            	while((char)valor != ';') {
            		prueba = prueba + (char)valor;
            		valor=fr.read();
 
            	}
            		puntoycoma++;
            		switch(puntoycoma){
            		case 1: client.name = prueba;
            		prueba = "";
            		break;
            		case 2: client.lastName=prueba;
            		prueba = "";
            		break;
            		case 3: client.DNI=prueba;
            		prueba = "";
            		break;
            		case 4: client.email = prueba;
            		prueba = "";
            		puntoycoma=0;
            		listClients.add(new Client(client.name, client.lastName, client.DNI, client.email));
            	    
        			for(Client i: listClients) {
        				if(indice<listClients.size()) {
        					System.out.println("Esto es lo que escojo:\n"+ listClients.get(indice).email);
                 			
        				}
             			indice++;
             		}
            		
            		 break;
            		 
            		}
            		

            		
            	}
            
			fr.close();
			System.out.println("Fin.");
		}catch(Exception e) {System.out.println(e);System.out.println("Something went wrong.");}
	}
	
}
