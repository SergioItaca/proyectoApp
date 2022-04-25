package hotelAPP;

import java.util.*;

public class Client extends Person {
	int clientCode;
	String dateBirth;
	String TC;
	int fidelityPoints;
	String memberCategory;
	boolean member;
	//boolean checkIn;
	//boolean checkOut;
	
	
	
	public Client() {
		this.clientCode=-1;
		this.dateBirth=null;
		this.TC = null;
		this.fidelityPoints=-1;
		this.memberCategory=null;
		this.member=false;
	}
	
	public Client(String name, String lastName, String DNI, String email) {
		this.name = name;
		this.lastName=lastName;
		this.DNI=DNI;
		this.email = email;
	}
	
	public Client(int clientCode, String dateBirth, String tarjetaCredito, int fidelityPoints, String memberCategory,boolean member) {
		this.clientCode=clientCode;
		this.dateBirth=dateBirth;
		this.TC = tarjetaCredito;
		this.fidelityPoints=fidelityPoints;
		this.memberCategory=memberCategory;
		this.member=member;
	}
	
	public Client(String name, String lastName, String DNI, String email, String codPaisTelefono,int telephone,int clientCode, String dateBirth, String tarjetaCredito, int fidelityPoints, String memberCategory,boolean member) {
		this.name = name;
		this.lastName=lastName;
		this.DNI=DNI;
		this.email = email;
		this.codPaisTelefono=codPaisTelefono;
		this.telephone = telephone;
		this.clientCode=clientCode;
		this.dateBirth=dateBirth;
		this.TC = tarjetaCredito;
		this.fidelityPoints=fidelityPoints;
		this.memberCategory=memberCategory;
		this.member=member;
	}
	
	public void setDateBirth(String dateBirth){
		this.dateBirth= dateBirth;
	}
	
	public String getDateBirth() {
		return this.dateBirth;
	}
	
	/*Método para obtener y cifrar la Trajeta de crédito*/
	
	private void setTC(String tarjetaCredito) {
		this.TC=tarjetaCredito;
	}
	
	private void setTCnull() {
		this.TC=null;
	}
	
	public void chooseTC() {
		Scanner sc = new Scanner(System.in);
		boolean repeat = false;
		int i = 0;
		String choice;
		do {
			
			if(i==0) {
				System.out.println("Do you want to insert your credit card? Yes or no.");
				choice = sc.nextLine();
			}else {
				choice = sc.nextLine();
			}
			
			if(choice.toLowerCase().equals("yes")) {
				System.out.println("Insert your credit card number.");
				repeat = false;
				setTC(sc.nextLine());
			}else if(choice.toLowerCase().equals("no")) {
				repeat = false;
				setTCnull();
			}else {
				System.out.println("Wrong answer. Choose between yes or no.");
				repeat = true;
			}
			i++;
		}while(repeat==true);
		
	}
	
	public String getTC() {
		String tc = this.TC;
		String tcCoded ="";
		
		if(tc!=null) {
			for(int i =0; i<tc.length();i++) {
				if(i<4) {
					tcCoded = tcCoded +tc.charAt(i);
				}else {
					tcCoded = tcCoded + "*";
				}
		
			}
			
			return tcCoded;
		}else {
			return tcCoded=null;
		}
		
	}
	
	/*Método para crear el código del cliente a partir del método hashCode().
	 * El código del cliente se generará automaticamente cuando el cliente haga una reserva y se registre
	 * */
	
	public void setClientCode(String dni){
		int clientCode = dni.hashCode();
		if(clientCode<0) {
			this.clientCode = clientCode*(-1);
		}
		else {
			this.clientCode = clientCode;
		}
	}
	
	public int getClientCode() {
		return this.clientCode;
	}
	
	
	/*Método para hacer al cliente miembro
	 * Si el cliente no es miembro el valor de memberCategory es null
	 * Las categorias de miembro son:
	 * 	1. Blue
	 * 	2. Silver
	 * 	3. Gold
	 * 	4. Platinum
	 * 	5. VIP platinum
	 * */
	
	public void setMembership(){
		
		Scanner sc = new Scanner(System.in);
		
		if(member==false) {
			
			boolean repeat=false;
			while(repeat==false) {
				System.out.println("Do you want to become a member?\nYes\nNo\nYou will recieve 50 points after the registration!");
				String choice= sc.nextLine().toLowerCase();
				
				switch(choice) {
				case "yes": this.member=true; this.memberCategory="Blue"; this.fidelityPoints=50; System.out.println("Welcome!");break;
				case "no": this.member=false; this.memberCategory=null;this.fidelityPoints=0; System.out.println("Bye");break;
				default: System.out.println("Try again. Not a valid choice.");
				}
				if((choice.equals("yes"))||(choice.equals("no"))) {
					repeat=true;
				}
			}
		}
		else {
			System.out.println("You are already member. You category is "+this.memberCategory +" and you have "+this.fidelityPoints+ " points.");
		}
	}
	
	public String getMembership() {
		return this.memberCategory;
	}
	
	/*Método para añadir puntos en la cuenta del cliente
	 * Los puntos obtenidos van en concordancia al precio pagado por la reserva.
	 * 	De 25 a 75 € son 10 puntos.
	 * 	De >75 a 100€ son 15 puntos
	 * 	De >100 a 175€ son 20 puntos
	 * 	De >175 a 275€ son 30 puntos.
	 * 	De >275 en adelante son 50 puntos.
	 * 
	 * En este método habrá que introducir el método getPrice de la clase Reservation en el segundo parámetro.
	 * */
	public void setFidelityPoints(int fidelityPoints, double price){
		if((price>=25)&&(price<=75)) {
			this.fidelityPoints = fidelityPoints +10;
		}
		
		if((price>75)&&(price<=100)) {
			this.fidelityPoints = fidelityPoints +15;
		}
		
		if((price>100)&&(price<=175)) {
			this.fidelityPoints = fidelityPoints +20;
		}
		
		if((price>175)&&(price<=275)) {
			this.fidelityPoints = fidelityPoints + 30;
		}
		
		if(price>275) {
			this.fidelityPoints = fidelityPoints +50;
		}
	}
	
	public int getFidelityPoints() {
		return this.fidelityPoints;
	}
	
	/*Método para pagar la reserva con tarjeta de crédito, cash o puntos
	 * 
	 * Podrá elegir pagar con CD: Se le pedirá la tarjeta de crétido al cliente sin no la ha introducido en la creación de la reserva
	 * 
	 * Podrá elegir pagar con puntos:
	 * 	Se convertirá el precio a puntos
	 * 		1 punto equivale a 0,10 €
	 * 	Se comprobará si el cliente tiene suficientes puntos.
	 * 	Se realizará el pago
	 * */
	
	/*Método para que el cliente mire los puntos que tiene*/
	
	
	/*Método para sacar por pantallas todos los datos del cliente*/
	@Override public String toString() {
	        return ("Name: " + this.getName()+" "+ this.getLastName() +"\nDNI: "+ this.getDNI() +"\nBirthday: "
	        		+ this.getDateBirth()+ "\nEmail: "+ this.getEmail()+ "\nTelephone: "+this.getCodPaisTelefono()+ " " + this.getTelephone()+ "\nCredit card: "
	        		+ this.getTC() + "\nClient code: "+ this.getClientCode() + "\nMember category: "+ this.getMembership()
	        		+ "\nFidelity points: "+ this.getFidelityPoints());
	   }
	
	
	/*Crear un método para guardar a los clientes en un documento de texto*/
	
	/*Crear un método para leer ese documento y ver que clientes son miembros de nuestro programa de fidelidad*/
}