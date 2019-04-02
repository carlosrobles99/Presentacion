/**
 * @author: Carlos Robles
 * @version: W219
*/
public class Persona {
	
	protected String nombre;
	protected String apellidos;
	protected String DNI;
	protected String estadoCivil;
	
	public Persona() {
		this.nombre = "";
		this.apellidos = "";
		this.DNI = "";
		this.estadoCivil = "";
	}
	
	public Persona(String nombre, String apellidos, String DNI, String estadoCivil) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = DNI;
		this.estadoCivil = estadoCivil;
	}
	
	public void cambiarEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public Persona(Persona pe) {
		this(pe.nombre, pe.apellidos, pe.DNI, pe.estadoCivil);
	}
	
	public Persona clonar() {
		return new Persona();
	}
	
	public void visualizar() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Apellidos: " + this.apellidos);
		System.out.println("DNI: " + this.DNI);
		System.out.println("Estado civil: " + this.estadoCivil);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", estadoCivil="
				+ estadoCivil + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
