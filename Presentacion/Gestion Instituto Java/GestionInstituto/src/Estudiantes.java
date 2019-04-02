/**
 * @author: Carlos Robles
 * @version: W219
*/
public class Estudiantes extends Persona{
	
	private String curso;
	
	public Estudiantes() {
		super();
		this.curso = "";
	}
	
	public Estudiantes(String nombre, String apellidos, String DNI, String estadoCivil, String curso) {
		super(nombre,apellidos,DNI,estadoCivil);
		this.curso = curso;
	}
	
	public void matricularEstudianeteCurso(String curso) {
		this.curso = curso;
	}
	
	public Estudiantes(Estudiantes es) {
		this(es.nombre,es.apellidos,es.DNI,es.estadoCivil,es.curso);
	}
	
	public Estudiantes clonar() {
		return new Estudiantes(this);
	}
	
	public void visualizar() {
		System.out.println("\n=================");
		System.out.println("Estudiante");
		System.out.println("=================");
		super.visualizar();
		System.out.println("Curso de matriculacion: " + this.curso);
		System.out.println("=================");
	}

	@Override
	public String toString() {
		return "Estudiantes [curso=" + curso + ", nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI
				+ ", estadoCivil=" + estadoCivil + "]";
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
