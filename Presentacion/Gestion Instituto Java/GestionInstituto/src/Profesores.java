/**
 * @author: Carlos Robles
 * @version: W219
*/
public class Profesores extends Empleados{
	
	private String departamento;
	
	public Profesores() {
		super();
		this.departamento = "";
		calcularSalario();
	}
	
	public Profesores(String nombre, String apellidos, String DNI, String estadoCivil, int fechaIncorporacion, String departamento, float salario) {
		super(nombre,apellidos,DNI,estadoCivil, fechaIncorporacion, salario);
		this.departamento = departamento;
		calcularSalario();
	}
	
	public void cambaiarDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public void calcularSalario() {
		if(this.estadoCivil.equals("casado") || this.estadoCivil.equals("Casado")) {
			this.salario*=0.8;
		}
	}
	
	public Profesores(Profesores pr) {
		this(pr.nombre,pr.apellidos,pr.DNI,pr.estadoCivil,pr.fechaIncorporacion, pr.departamento, pr.salario);
	}
	
	public Profesores clonar() {
		return new Profesores(this);
	}
	
	public void visualizar() {
		System.out.println("\n=================");
		System.out.println("Profesor(a)");
		System.out.println("=================");
		super.visualizar();
		System.out.println("Departamento: " + this.departamento);
		System.out.println("=================");
	}

	@Override
	public String toString() {
		return "Profesores [departamento=" + departamento + ", fechaIncorporacion=" + fechaIncorporacion + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", estadoCivil=" + estadoCivil + salario + "]";
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}
