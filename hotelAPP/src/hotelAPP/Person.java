package hotelAPP;

public class Person {
	String name;
	String lastName;
	String secondLastName;
	String DNI;
	String email;
	String codPaisTelefono;
	int telephone;
	
	public Person() {
		this.name = null;
		this.lastName=null;
		this.DNI=null;
		this.email = null;
		this.codPaisTelefono=null;
		this.telephone = -1;
	}
	
	public Person(String name, String lastName, String DNI, String email, String codPaisTelefono,int telephone) {
		this.name = name;
		this.lastName=lastName;
		this.DNI=DNI;
		this.email = email;
		this.codPaisTelefono=codPaisTelefono;
		this.telephone = telephone;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	/*Crear un metodo para comprobar que el usuario introduce las ocho cifras*/
	
	public void setDNI(String DNI) {
		this.DNI=DNI;
	}
	
	public String getDNI() {
		return this.DNI;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setCodPaisTelefono(String codPaisTelefono) {
		this.codPaisTelefono=codPaisTelefono;
	}
	
	public String getCodPaisTelefono() {
		return this.codPaisTelefono;
	}

	
	public void setTelephone(int telephone) {
		this.telephone=telephone;
	}
	
	public int getTelephone() {
		return this.telephone;
	}

}
