/**
 * @author: Carlos Robles
 * @version: W219
*/
import java.util.ArrayList;

public class CentroDocente {
	
	private static ArrayList<Persona> personas;
	
	public CentroDocente() {
		personas = new ArrayList <Persona>();
	}
	
	public CentroDocente(ArrayList<Persona> personas) {
		for (Persona persona : personas) {
			personas.add(persona.clonar());
		}
	}

	public CentroDocente(CentroDocente ce) {
		this(ce.personas);
	}
	
	public CentroDocente clonar() {
		return new CentroDocente(this);
	}

	public void darAltaPersona(Persona pe) throws excepcionesPersonalizadas{
		boolean dniEncontrado = false;
		
		for (Persona per : personas) {
			if (per.getDNI().equals(pe.getDNI())) {
				dniEncontrado = true;
				throw new excepcionesPersonalizadas(1);
			}
		} 
		
		if (!dniEncontrado) {
			personas.add(pe);
		}	
	}
	
	public boolean cambioDeSeccion(String dni, String seccion) {
		boolean resultado = false;
		
		for(int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getDNI().equals(dni) && personas.get(i) instanceof PersonalServicio) {
				((PersonalServicio)personas.get(i)).setSeccion(seccion);
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public boolean cambioDepartamento(String dni, String departamento) {
		boolean resultado = false;
		
		for(int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getDNI().equals(dni) && personas.get(i) instanceof Profesores) {
				((Profesores)personas.get(i)).setDepartamento(departamento);
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public boolean matriculacionAlumno(String dni, String curso) {
		boolean resultado = false;
		
		for(int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getDNI().equals(dni) && personas.get(i) instanceof Estudiantes) {
				((Estudiantes)personas.get(i)).setCurso(curso);
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public boolean cambioEstadoCivil(String dni, String estadoCivil) {
		boolean resultado = false;
		
		for(int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getDNI().equals(dni)) {
				this.personas.get(i).setEstadoCivil(estadoCivil);
				resultado = true;
			}
		}
		return resultado;
	}
	
	public boolean darBajaPersona(String dni) {
		boolean resultado = false; 
		
		for(int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getDNI().equals(dni)) {
				personas.remove(personas.get(i));
				resultado = true;
			}
		}	
		return resultado;
	}

	public void salarioEmpleados() {
		for (Persona per : personas) {
			if(per instanceof Profesores) {
				System.out.println("\n=================");
				System.out.println("Profesor");
				System.out.println("=================");
				System.out.println("Nombre: " + ((Profesores)per).getNombre());
				System.out.println("Apellidos: " + ((Profesores)per).getApellidos());
				System.out.println("Salario: " + ((Profesores)per).salario + "€");
				System.out.println("=================");
			}
			if(per instanceof PersonalServicio) {
				System.out.println("\n=================");
				System.out.println("Persona de servicios");
				System.out.println("=================");
				System.out.println("Nombre: " + ((PersonalServicio)per).getNombre());
				System.out.println("Apellidos: " + ((PersonalServicio)per).getApellidos());
				System.out.println("Salario: " + ((PersonalServicio)per).salario + "€");
				System.out.println("=================");
			}
		}
	}
	
	public void consultarExistenciaDNI(String dni) throws excepcionesPersonalizadas {
		int contador = 0;
		for (Persona per : personas) {
			if (per.getDNI().equals(dni)) {
				contador++;
			}
		} 
		if (contador > 1) {
			throw new excepcionesPersonalizadas(2);
		}
    }
	
	public void visualizar() {
		for (Persona per : personas) {
			per.visualizar();
		}
	}

	@Override
	public String toString() {
		return "CentroDocente [personas=" + personas.toString() + "]";
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

}
