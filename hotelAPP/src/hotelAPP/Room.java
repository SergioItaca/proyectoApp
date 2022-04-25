package hotelAPP;

import java.util.*;

public class Room {
	int number;
	String category;
	
	ArrayList<Integer> totalRoomNumbersFree = new ArrayList<>();
	ArrayList<Integer> totalRoomNumbersUsed = new ArrayList<>();
	int[] totalRoomNumbers = new int[] {1,2,3,4,5,6,7,8,9,10};
	
	public Room() {}
	
	public Room(int number, String category) {
		this.number= number;;
		this.category = category;
	}
	
	Reservation reservation;
	
	public ArrayList<Integer> createRooms() {
		for(int i=0; i<totalRoomNumbers.length;i++) {
			totalRoomNumbersFree.add(totalRoomNumbers[i]);
		}
		return totalRoomNumbersFree;
	}
	
	//Crear un método para mostrar las opciones de habitación según la categoría elegida por el cliente.
	public String roomOptions(int select){
		if(select!=0) {
			int category = select;
			switch(category) {
			case 1:
				this.category="Superior";
				break;
			case 2: this.category="Premium";
				break;
			case 3: this.category="Junior Suit";
				break;
			case 4: this.category="Suit";
				break;
			}
			return this.category;
		}
		return "";
	}
	
	public void bookRoom(String category, List<Integer> lista) {
		//createRooms();
		Scanner sc = new Scanner(System.in);
		if(category.length()>1) {
			switch(category) {
			case "Superior":
				System.out.println("Category Superior: Choose room number available from the list below:");
				for(int i: lista) {
					if((i==1)||(i==3)||(i==4)||(i==9)) {
						if(!totalRoomNumbersUsed.contains(i)) {
							System.out.println("Room number "+i);
						}					}
				}
				int choice = Integer.parseInt(sc.nextLine());
				this.number=choice;
				totalRoomNumbersUsed.add(choice);
				break;
			case "Premium":
				System.out.println("Category Premium: Choose room number available from the list below:");
				for(int i: lista) {
					if((i==5)||(i==7)||(i==8)) {
						if(!totalRoomNumbersUsed.contains(i)) {
							System.out.println("Room number "+i);
						}
					}
				}
				int choice1 = Integer.parseInt(sc.nextLine());
				this.number=choice1;
				totalRoomNumbersUsed.add(choice1);
				break;
			case "Junior Suit":
				
				System.out.println("Category Junior Suit: Choose room number available from the list below:");
				for(int i: lista) {
					if((i==2)||(i==6)) {
						if(!totalRoomNumbersUsed.contains(i)) {
							System.out.println("Room number "+i);
						}					}
				}
				int choice2 = Integer.parseInt(sc.nextLine());
				this.number=choice2;
				totalRoomNumbersUsed.add(choice2);				
				break;
			case "Suit":
				System.out.println("Category Suite: Choose room number available from the list below:");
				for(int i: lista) {
					if((i==10)) {
						if(!totalRoomNumbersUsed.contains(i)) {
							System.out.println("Room number "+i);
						}					}
				}
				int choice3 = Integer.parseInt(sc.nextLine());
				this.number=choice3;
				totalRoomNumbersUsed.add(choice3);
				break;
			}
		}
		
	}
	
	public int getRoomNumber() {
		return this.number;
	}
	
	public String getRoomCategory() {
		return this.category;
	}
	
	/*Método para sacar por pantallas todos los datos de la habitación*/
	@Override public String toString() {
	        return ("Room number: "+this.getRoomNumber()+"\nRoom Category: "+this.getRoomCategory());
	   }
}
