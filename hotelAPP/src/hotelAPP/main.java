package hotelAPP;

import java.util.*;

import java.time.LocalDate;

public class main {
	
	static int choice1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fileClients = "clients.txt";
		String fileRervations = "reservations.txt";
		String fileEmployees = "employees.txt";
		List<String> lista = new ArrayList<>();
		
		Client client = new Client();
		Reservation reservation = new Reservation();
		Utilities_files utilities = new Utilities_files();
		Room room = new Room();
		Employee employee = new Employee();
		
		
		System.out.println("Important information about the hotel.\n\nThe hotel is open the whole year so you can make a reservation for any day."
				+ "\nThe hotel only has 10 rooms so you cannot make more than 10 reservations."
				+ "\nThe hotel has four types of rooms:"
				+ "\n\t4 rooms in category Superior."
				+ "\n\t3 rooms in category Premium."
				+ "\n\t2 rooms in category Junior Suit."
				+ "\n\t1 room in category Suite.\n\nFor example, you shouldn't choose more than 4 rooms of category Superior during your reservation, neither more than 3 rooms of category Premium and so on.\n\n"
				+ "In the programa first you are going to be the client and after the employee.\n\n");
		
		System.out.println("Now you are a client of the hotel.\n");
		System.out.println("Do you want to access to the reservation page? Yes or no.");
		String choice = sc.nextLine().toLowerCase();
		
		if(choice.equals("yes")) {
			int aux;
			do {
				System.out.println("You can make a maximum of "+ (room.totalRoomNumbers.length-room.totalRoomNumbersUsed.size()) +" reservations."+ "\nHow many reservations do you want to make? Indicate in numeric.");
				choice1 = Integer.parseInt(sc.nextLine());
				aux= choice1;
			}while(aux>room.totalRoomNumbers.length);
			
			int numRes = 1;
			while(aux>0) {
				if(aux==0) {
					System.out.println("-----------------------------------------------------------");
					System.out.println("Welcome to the reservations page!");
					System.out.println("-----------------------------------------------------------");
				}
				
				System.out.println("Now you have to introduce your personal details for the reservation number "+ (numRes));
				System.out.println("-----------------------------------------------------------");
				
				System.out.println("Insert your name without lastname.");
				client.setName(sc.nextLine());
				
				System.out.println("Insert your lastname.");
				client.setLastName(sc.nextLine());
				
				System.out.println("Insert your ID.");
				client.setDNI(sc.nextLine().toUpperCase());
				
				System.out.println("Insert your date of birth.");
				client.setDateBirth(sc.nextLine());
				
			
				client.chooseTC();
				
				System.out.println("Insert your email.");
				client.setEmail(sc.nextLine());
				
				System.out.println("Insert the telephone code of your country.");
				client.setCodPaisTelefono(sc.nextLine());
				
				System.out.println("Insert your telephone.");
				client.setTelephone(Integer.parseInt(sc.nextLine()));
				
				client.setClientCode(client.getDNI());
				
				client.setMembership();
				
				System.out.println(client.toString());
				
				utilities.escritorCliente(fileClients, client);
				
				//Al final del proceso se debe registrar al cliente y su reserva.
				
				System.out.println("-----------------------------------------------------------");
				System.out.println("Now you have to introduce the details of the reservation number " + (numRes));
				System.out.println("-----------------------------------------------------------");
				
				reservation.selectDates();
				
				reservation.calcultePrice();
				
				reservation.reservationCodeGenerator();
				
				reservation.setCodClient(client.DNI);
				
				System.out.println(reservation.toString());
				System.out.println("-----------------------------------------------------------");
				
				utilities.escritorReserva(fileRervations, reservation);
				
				aux--;
				numRes++;
				
			}
			System.out.println("-----------------------------------------------------------\n");
			System.out.println("Now you are the employee. Insert your personal information.\n");
			
			System.out.println("Insert your name without lastname.");
			employee.setName(sc.nextLine());
			
			System.out.println("Insert your lastname.");
			employee.setLastName(sc.nextLine());
			
			System.out.println("Insert your ID.");
			employee.setDNI(sc.nextLine().toUpperCase());
			
			employee.setEmpCode();
			
			employee.setShift();
			
			System.out.println("------------------------------------------------------------------");
			
			System.out.println("Now you are going to assign a room to each reservation.\n");
			List<Integer> list = room.createRooms();
			for(int i=0,j=1;i<choice1;i++,j++) {
				System.out.println("Reservation number "+j);
				room.bookRoom(room.roomOptions(reservation.categoryList[i]),list);
				System.out.println("------------------------------------------------------------");
				System.out.println(room.toString());
				System.out.println("------------------------------------------------------------");
			}
			
			System.out.println("The task has been made by:\n"+employee.toString());
			utilities.escritorEmpleado(fileEmployees, employee);
			
		}else if(choice.equals("no")){
			System.out.println("You exited the reservation page.");
		}
		
	}
}
