/**
 * @author: Carlos Robles
 * @version: W219
*/
public class PersonalServicio extends Empleados{
	
	private String seccion;
	
	public PersonalServicio() {
		super();
		this.seccion = "";
		calcularSalario();
	}
	
	public PersonalServicio(String nombre, String apellidos, String DNI, String estadoCivil, int fechaIncorporacion, String seccion, float salario) {
		super(nombre,apellidos,DNI,estadoCivil, fechaIncorporacion, salario);
		this.seccion = seccion;
		calcularSalario();
	}
	
	public void cambaiarSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public void calcularSalario() {
		if(this.fechaIncorporacion > 2000) {
			this.salario*=0.5;
		}
	}
	
	public PersonalServicio(PersonalServicio pe) {
		this(pe.nombre,pe.apellidos,pe.DNI,pe.estadoCivil,pe.fechaIncorporacion, pe.seccion, pe.salario);
	}
	
	public PersonalServicio clonar() {
		return new PersonalServicio(this);
	}
	
	public void visualizar() {
		System.out.println("\n=================");
		System.out.println("Personal de servicios");
		System.out.println("=================");
		super.visualizar();
		System.out.println("Seccion: " + this.seccion);
		System.out.println("=================");
	}

	@Override
	public String toString() {
		return "PersonalServicio [seccion=" + seccion + ", fechaIncorporacion=" + fechaIncorporacion + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", estadoCivil=" + estadoCivil + salario + "]";
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

}
