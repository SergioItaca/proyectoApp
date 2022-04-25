package hotelAPP;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
	String codeReservation;
	LocalDate checkIn;
	LocalDate checkOut;
	double price;
	int clientCode;
	
	int[] categoryList = new int[10];
	int indice = 0;
	
	public Reservation() {}
	
	public Reservation(String codeReservation, double price, LocalDate checkIn, LocalDate checkOut, int clientCode) {
		
		this.codeReservation=codeReservation;
		this.price=price;
		this.checkIn= checkIn;
		this.checkOut= checkOut;
		this.clientCode=clientCode;
	}
	
	Scanner sc = new Scanner(System.in);
	
	Client client = new Client();
	
	/*Método para generar el código del cliente en la reserva*/
	
	public void setCodClient(String dni) {
		client.setClientCode(dni);
		int aux = client.getClientCode();
		this.clientCode = aux;
	}
	
	public int getCodClient() {
		return this.clientCode;
	}
	
	//Método para escoger la fecha de check in y de check out
	
	public void selectDates() {
		int i=0;
		
		while(i<=1) {
			if(i==0) {
				//Seleccionar la fecha del checkIn
				boolean valid = true;
				do {
					int year;
					int month;
					int day;
					
					System.out.println("Select the date of your arrival.");
					
					while(2>1) {
						System.out.println("Enter the year: ");
						try {
							year = Integer.parseInt(sc.nextLine());
							break;
							
						}catch(Exception e) {System.out.println("Try again in numeric.");}
					}
										
					while(2>1) {
						System.out.println("Enter the month: ");
						try {
							month = Integer.parseInt(sc.nextLine());
							break;
							
						}catch(Exception e) {System.out.println("Try again in numeric.");}
					}
					
					calendar(year, month);
					
					
					while(2>1) {
						System.out.println("Enter the day.");
						try {
							day = Integer.parseInt(sc.nextLine());
							break;
							
						}catch(Exception e) {System.out.println("Try again in numeric.");}
					}

					LocalDate checkIn = LocalDate.of(year, month, day);
					
					if(checkIn.isBefore(checkIn.now())){
						System.out.println("Invaled date. Choose another date.");
						System.out.println("----------------------------------------");
						valid = false;
					}
					else{
						String[] months = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
						System.out.println("The day of your checkIn is the " + day + " of " + months[month-1] + " of "+ year);
						System.out.println("------------------------------------------------------------------------");
						this.checkIn=checkIn;
						valid = true;
					}
					
				}while(valid==false);
				
			}
			
			if(i==1) {
				
				//Seleccionar la fecha del check out
				boolean valid = true;
				do {
					int year;
					int month;
					int day;
					System.out.println("Select the date of your departure.");
					
					while(2>1) {
						System.out.println("Enter the year: ");
						try {
							year = Integer.parseInt(sc.nextLine());
							break;
							
						}catch(Exception e) {System.out.println("Try again in numeric.");}
					}
										
					while(2>1) {
						System.out.println("Enter the month: ");
						try {
							month = Integer.parseInt(sc.nextLine());
							break;
							
						}catch(Exception e) {System.out.println("Try again in numeric.");}
					}
					
					calendar(year, month);
					
					
					while(2>1) {
						System.out.println("Enter the day.");
						try {
							day = Integer.parseInt(sc.nextLine());
							break;
							
						}catch(Exception e) {System.out.println("Try again in numeric.");}
					}

					LocalDate checkOut = LocalDate.of(year, month, day);
					
					if(checkOut.isBefore(checkIn)){
						String[] months = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
						System.out.println("Invaled date. Choose another date.\nThe checkOut date has to be after the "+checkIn.getDayOfMonth()+" of " + months[checkIn.getMonthValue()-1] + " of "+ checkIn.getYear()+" which is the checkIn date.");
						System.out.println("----------------------------------------");
						valid = false;
					}
					else{
						String[] months = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
						System.out.println("The day of your checkOut is the " + day + " of " + months[month-1] + " of "+ year);
						System.out.println("------------------------------------------------------------------------");
						this.checkOut=checkOut;
						valid = true;
					}
					
				}while(valid==false);
			}
			i++;
		}
		
	}
		
	public LocalDate getCheckIn() {
		return this.checkIn;
	}
	
	public LocalDate getCheckOut() {
		return this.checkOut;
	}
	
	
	//Método para calcular el precio dependiendo de las caracteristicas que elija el cliente para la reserva
	
	public double calcultePrice(){
		Scanner sc = new Scanner(System.in);
		double price = 0;
		
		System.out.println("Choose the number of type of room\n\t1) Superior 88€\n\t2) Premium 98€\n\t3) Junior Suit 198€\n\t4) Suite 300€");
		int category = Integer.parseInt(sc.nextLine());
		categoryList[indice] = category;
		indice++;
		switch(category) {
		
		case 1: price = 88*daysStay(); break;
		
		case 2: price = 98*daysStay(); break;
		
		case 3: price = 128*daysStay(); break;
		
		case 4: price = 300*daysStay(); break;
		
		}
		
		System.out.println("Do you want breakfast?\n\t14€ per person per day\n\tYes or No.");
		String selection1 = sc.nextLine().toLowerCase();
		
		if(selection1.equals("yes")) {
			System.out.println("For how many people? Type only numbers.");
			int person = Integer.parseInt(sc.nextLine());
			System.out.println("Your stay is "+daysStay()+" days.\n"+"How many days will you have breakfast? Type only numbers.");
			
			int breakfast = Integer.parseInt(sc.nextLine());
			
			price = price + (14*person*breakfast);
		}
		
		System.out.println("Do you need a slot in our parking?\n\t22€ per night\n\tYes or No.");
		String selection2 = sc.nextLine().toLowerCase();
		
		if(selection2.equals("yes")) {
			System.out.println("Your stay is"+daysStay()+" days.\n"+"How many nights will you use the parking? Type only numbers.");
			int night = Integer.parseInt(sc.nextLine());
			
			price = price + (22*night);
		}
		
		System.out.println("Do you bring a pet with you? Yes or No.\n\t35€ per pet during the whole stay.");
		String selection3 = sc.nextLine();
		
		if(selection3.equals("yes")) {
			System.out.println("How many pets? Type only numbers.");
			int pet = Integer.parseInt(sc.nextLine());
			
			price = price + (35*pet);
		}
		
		return this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	//Método para calcular el código de la reserva
	
	public String reservationCodeGenerator() {
		String code= "";
		for(int i=0 ;i<8;i++) {
			int num= (int)Math.floor((Math.random()*(125-45+1)+45));
			if((num>=48)&&(num<=57)) {
				code = code + (char)num;
			}
			else if((num>=65)&&(num<=90)) {
				code = code + (char)num;
			}
			else if((num>=97)&&(num<=122)) {
				code = code + (char)num;
			}
			else {
				i--;
			}
			
		}
		return this.codeReservation=code;
	}
	
	public String getReservationCode() {
		return this.codeReservation;
	}
	
	//Métodos para generar un calendario para seleccionar la fech de la reserva
	private void calendar(int year, int month) {
		
		int selectedYear = year;
		int selectedMonth = month-1; //March = 3-1
		
		/*Calendar cal = new GregorianCalendar();
		int cDay = cal.get(Calendar.DATE);
		int cMonth = cal.get(Calendar.MONTH);
		int cYear = cal.get(Calendar.YEAR);*/
		
		GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth, 1);
		int days = gCal.getActualMaximum(Calendar.DATE);
		int weekDays = gCal.get(Calendar.DAY_OF_WEEK); // Sunday-1	Monday-2 Tuesday-3	Wednesday-4	Thursday-5	Friday-6 Saturday-7
		int weekDay=0;
		switch(weekDays) {
		case 1: weekDay= weekDays + 6; break;  //Sunday
		case 2: weekDay= weekDays - 1; break; //Monday
		case 3: weekDay= weekDays - 1; break; //Tuesday
		case 4: weekDay= weekDays - 1; break; //Wednesday
		case 5: weekDay= weekDays - 1; break; //Thursday
		case 6: weekDay= weekDays - 1; break; //Friday
		case 7: weekDay= weekDays - 1; break; //Saturday
		}
		
		/*gCal = new GregorianCalendar(selectedYear, selectedMonth, 1);
		int totalWeeks = gCal.getActualMaximum(Calendar.WEEK_OF_MONTH);*/
		
		
		//Count the days
		int count = 1;
		String[] months = {"January", "February","March","April","May","June","July","August","September","October","November","December"};
		System.err.println(months[selectedMonth] + " - " + selectedYear);
		
		System.out.println();
		
		System.out.println("MO TU WE TH FR SA SU");
		
		for(int i =1; i<=6;i++) {
			System.out.println();
			for(int j = 1; j<=7; j++) {
				
				if((count < weekDay) || ((count - weekDay+1) > 31)) {
					System.out.print("__");
					System.out.print(" ");
				}
				else if(((count - weekDay+1) > 28)&&(selectedMonth==1)) {
					System.out.print("__");
					System.out.print(" ");
				}
				else if(((count - weekDay+1)>30)&&((selectedMonth==3)||(selectedMonth==5)||(selectedMonth==8)||(selectedMonth==10))) {
					System.out.print("__");
					System.out.print(" ");
				}
				else {
					System.out.print(getDay((count - weekDay +1)));
					System.out.print(" ");
				}
				count++;
			}
		}
		
		System.out.println();
	}
	
	
	//Este método pasa los días de la semana de enteros a String y además añade un 0 delante de aquellos días formados por una sola cifra
	private static String getDay(int i) {
		String sDate = Integer.toString(i);
		if(sDate.length() == 1) {
			sDate = "0" + sDate;
			return sDate;
		}
		else {
			return sDate;
		}
	}
	
	//Método para calcular los días de estancia en el hotel
	
	private int daysStay() {
		LocalDate checkIn = this.checkIn;
		LocalDate checkOut = this.checkOut;
		int stay = (int)checkIn.until(checkOut, ChronoUnit.DAYS);
		return stay;
	}
	
	/*Método para sacar por pantallas todos los datos del la reserva*/
	@Override public String toString() {
	        return ("The reservation code is: "+this.getReservationCode()+"\nThe checkIn date is: "+ this.getCheckIn() +"\nThe checkOut date is: "+ this.getCheckOut() 
	        +"\nThe total price of your reservation is: "+ this.getPrice()+" €"+"\nThe code of the client of this reservation is: "+this.getCodClient());
	   }
	
	
	//Método para editar la reserva (crearla, editarla o cancelarla)
		
	//Método para pagar la reserva con tarjeta de crédito, cash o puntos.
	
}
