import javafx.scene.control.TreeTableRow;

/**
 * @author: Carlos Robles
 * @version: W219
*/
public abstract class Empleados extends Persona{
	
	public final float kSalarioFijo = 1500F;
	public final int fechaDefault = 2000;
	
	protected int fechaIncorporacion;
	protected float salario;
	
	public Empleados() {
		super();
		this.salario = kSalarioFijo;
		this.fechaIncorporacion = fechaDefault;
	}
	
	public Empleados(String nombre, String apellidos, String DNI, String estadoCivil, int fechaIncorporacion, float salario) {
		super(nombre,apellidos,DNI,estadoCivil);
		this.fechaIncorporacion = fechaIncorporacion;
		this.salario = salario;
	}
	
	public Empleados(Empleados em) {
		this(em.nombre,em.apellidos,em.DNI,em.estadoCivil,em.fechaIncorporacion, em.salario);
	}
	
	public abstract void calcularSalario();
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Año de incorporacion: " + this.fechaIncorporacion);
	}

	@Override
	public String toString() {
		return "Empleados [fechaIncorporacion=" + fechaIncorporacion + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", DNI=" + DNI + ", estadoCivil=" + estadoCivil + "]";
	}

	public int getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(int fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public float getSalarioExtra() {
		return salario;
	}

	public void setSalarioExtra(float salarioExtra) throws excepcionesPersonalizadas{
		if (salario<0) {
			throw new excepcionesPersonalizadas(3);
		}else {
			this.salario = salarioExtra;
		}
	}
	
}
