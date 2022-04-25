package hotelAPP;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.*;

public class Probador {

	public static void main(String[] args) {
		String fileEmployees = "employees.txt";
		Utilities_files utilities = new Utilities_files();
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
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
		System.out.println("The task has been made by:\n"+employee.toString());
		utilities.escritorEmpleado(fileEmployees, employee);
		
		
		
	}
}
