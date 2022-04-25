package hotelAPP;

import java.util.*;

public class Employee extends Person {
	
	String empCode="";
	double salary;
	String job;
	String shift;
	
	public Employee() {}
	
	public Employee(String empCode, double salary, String job, String shift) {
		this.empCode=empCode;
		this.salary=salary;
		this.job= job;
		this.shift= shift;
	}
	
	public void setEmpCode() {
		
		for(int i =0;i<3;i++) {
			this.empCode = empCode.toLowerCase() + String.valueOf(this.name.charAt(i)) +  String.valueOf(this.lastName.charAt(i)) + String.valueOf(this.DNI.charAt(i));
		}
	}
	
	public String getEmpCode() {
		return this.empCode;
	}
	
	/*public void setSalary(double salary) {
		this.salary=salary;
	}
	
	public double getSalary() {
		return this.salary;
	}*/
	
	public void setShift() {
		
		String[] shiftOption= {"Morning","Evening","Night"};
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose 1 for asigning morning shift.\nChoose 2 for asigning evening shift.\nChoose 3 for asigning night shift.");
		int choice = Integer.parseInt(sc.nextLine());
		this.shift = shiftOption[choice-1];
	}
	
	public String getShift() {
		return this.shift;
	}
	
	/*Método para sacar por pantallas todos los datos de la habitación*/
	@Override public String toString() {
	        return ("Employee name: "+this.getName()+"\nEmployee last name: "+this.getLastName()+"\nEmployee DNI: "+this.getDNI()
	        +"\nEmployee Code: "+this.getEmpCode()+"\nEmployee Shift: "+this.getShift());
	   }
	//Create a method to register the employees in a file
	
	//Create a method changeShift
	
	//Create a method riseSalary
	//Create a method lowSalary
	//Create a method doFunction
}
