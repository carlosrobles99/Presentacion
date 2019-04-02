/**
 * @author: Carlos Robles
 * @version: W219
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	
	static Scanner teclado = new Scanner(System.in);
	static CentroDocente batoi = new CentroDocente();

	public static void main(String[] args) {
		
		Principal programa = new Principal();
		programa.inicio();

	}
	
	public void salir() {
		System.out.print("\nSaliendo del programa...");
		teclado.close();
	}
	
	public static void consultarAnoNegativo(int ano) throws excepcionesPersonalizadas {	
		if(ano < 1900 || ano > 2019) {
			throw new excepcionesPersonalizadas(4);
		}
    }
	
	public void inicio() {
		int opcion;
		do {
			System.out.print("\n-----------Bienvenido-----------");
			System.out.println("\n------Listado de opciones----------- ");
			System.out.println("1. Dar de alta una persona");
			System.out.println("2. Dar de baja una persona");
			System.out.println("3. Listado de personas vinculadas con el centro");
			System.out.println("4. Listado de nominas de los empleados");
			System.out.println("5. Cambiar estado civil de una persona");
			System.out.println("6. Matriculacion de un estudiante en un nuevo curso");
			System.out.println("7. Cambiar profesor de departamento");
			System.out.println("8. Cambio seccion empleado de servicios de mantenimiento");
			System.out.println("9. Salir");
			System.out.print("\nIntroduce una opcion: ");
				while(!teclado.hasNextInt()) {
					System.out.print("\nIntroduce una opcion valida: ");
					teclado.next();
				}
			opcion = teclado.nextInt();
		}while(opcion < 1 || opcion > 9);
		
		switch (opcion) {
		case 1: darAlta();
			break;
		case 2: darBaja();
			break;
		case 3: listadoPersonas();
			break;
		case 4: salarioEmpleados();
			break;
		case 5: cambiarEstadoCivil();
			break;
		case 6: matriculacion();
			break;
		case 7: cambiarDepartamento();
			break;
		case 8: cambiarDeSeccion();
			break;
		case 9: salir();
			break;
		}
		
	}
	
	public void cambiarDeSeccion() {
		String dni;
		String seccion;
		
		teclado.nextLine();
		System.out.println("\n-----------Cambiar de seccion una persona de servicios-----------");
		System.out.print("Introduce el dni de la persona: ");
		dni = teclado.nextLine();
		System.out.print("Introduce la nueva seccion: ");
		seccion = teclado.nextLine();
		
		if(batoi.cambioDeSeccion(dni, seccion)) {
			System.out.println("\nOperacion realizada con exito");
		}else {
			System.out.println("\nOperacion fallida");
		}
		inicio();
	}
	
	public void cambiarDepartamento() {
		String dni;
		String departamento;
		
		teclado.nextLine();
		System.out.println("\n-----------Cambiar de departamento un profesor(a)-----------");
		System.out.print("Introduce el dni de la persona: ");
		dni = teclado.nextLine();
		System.out.print("Introduce el nuevo departamento: ");
		departamento = teclado.nextLine();
		
		if(batoi.cambioDepartamento(dni, departamento)) {
			System.out.println("\nOperacion realizada con exito");
		}else {
			System.out.println("\nOperacion fallida");
		}
		inicio();
	}
	
	public void matriculacion() {
		String dni;
		String curso;
		
		teclado.nextLine();
		System.out.println("\n-----------Matricular alumno(a) en un nuevo curso-----------");
		System.out.print("Introduce el dni de la persona: ");
		dni = teclado.nextLine();
		System.out.print("Introduce el curso de matriculacion: ");
		curso = teclado.nextLine();
		
		if(batoi.matriculacionAlumno(dni, curso)) {
			System.out.println("\nOperacion realizada con exito");
		}else {
			System.out.println("\nOperacion fallida");
		}
		inicio();
	}
	
	public void cambiarEstadoCivil() {
		String dni;
		String estadoCivil;
		
		teclado.nextLine();
		System.out.println("\n-----------Cambiar el estado civil de una persona-----------");
		System.out.print("Introduce el dni de la persona: ");
		dni = teclado.nextLine();
		System.out.print("Introduce el nuevo estado civil de la persona: ");
		estadoCivil = teclado.nextLine();
		
		if(batoi.cambioEstadoCivil(dni, estadoCivil)) {
			System.out.println("\nOperacion realizada con exito");
		}else {
			System.out.println("\nOperacion fallida");
		}
		inicio();
	}
	
	public void salarioEmpleados() {
		batoi.salarioEmpleados();
		inicio();
	}
	
	public void listadoPersonas() {
		batoi.visualizar();
		inicio();
	}
	
	public void darBaja() {
		String dni;
		
		teclado.nextLine();
		System.out.println("\n-----------Dar de baja una persona-----------");
		System.out.print("Introduce el dni de la persona a dar de baja: ");
		dni = teclado.nextLine();
		if(batoi.darBajaPersona(dni)) {
			System.out.println("\nPersona dada de baja");
		}else {
			System.out.println("\nNo se ha encontrado ninguna persona asignada a este DNI");
		}
		inicio();
	}
	
	public void darAlta() {
		int opcion = 0;
			System.out.println("\n-----------Dar de alta una persona-----------");
			System.out.println("1. Dar de alta una estudiante");
			System.out.println("2. Dar de alta una profesor");
			System.out.println("3. Dar de alta una persona de servicios");
			System.out.println("4. Volver a inicio");
			System.out.print("\nIntroduce una opcion: ");
			try {
				opcion = teclado.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("No has introducido un numero entero");
				darAlta();
			}
			
			switch (opcion) {
			case 1: darAltaEstudiante();
				break;
			case 2: darAltaProfesor();
				break;
			case 3: darAltaPersonaServicios();
				break;
			case 4: inicio();
				break;

			}
	}

	public void darAltaEstudiante() {
		String nombre;
		String apellidos;
		String dni;
		String estadoCivil;
		String curso;
		Persona pe;

	    teclado.nextLine();
		System.out.print("-----------Introduccion de datos-----------");
		System.out.print("\nIntroduce el nombre: " );
		nombre = teclado.nextLine();
		System.out.print("Introduce los apellidos: " );
		apellidos = teclado.nextLine();
		System.out.print("Introduce el DNI: ");
		dni = teclado.nextLine();	 
		System.out.print("Introduce el estado civil: ");
		estadoCivil = teclado.nextLine();
		System.out.print("Introduce el curso academico: ");
		curso = teclado.nextLine(); 
		
		pe = new Estudiantes(nombre,apellidos,dni,estadoCivil,curso);
		//batoi.darAltaPersona(pe);
		
		darAlta();
	}
	
	public void darAltaProfesor() {
		String nombre;
		String apellidos;
		String dni;
		String estadoCivil;
		int fechaIncorporacion;
		String departamento;
		float salario;
		Persona pe;
		
		teclado.nextLine();
		System.out.print("-----------Introduccion de datos-----------");
		System.out.print("\nIntroduce el nombre: " );
		nombre = teclado.nextLine();
		System.out.print("Introduce los apellidos: " );
		apellidos = teclado.nextLine();
		System.out.print("Introduce el DNI: ");
		dni = teclado.nextLine();
		try {
			batoi.consultarExistenciaDNI(dni);
		}catch(excepcionesPersonalizadas e) {
			darAltaProfesor();
			e.toString();
		}
		System.out.print("Introduce el estado civil: ");
		estadoCivil = teclado.nextLine();
		System.out.print("Introduce el departamento: ");
		departamento = teclado.nextLine();
		System.out.print("Introduce el año de incorporacion: ");
		while(!teclado.hasNextInt()) {
			System.out.println("\nIntroduce un año valido: ");
			teclado.next();
		}
		fechaIncorporacion = teclado.nextInt();
		try {
			consultarAnoNegativo(fechaIncorporacion);
		}catch(excepcionesPersonalizadas e) {
			darAltaProfesor();
			e.toString();
		}
		
		System.out.print("Introduce el salario: ");
		while(!teclado.hasNextInt()) {
			System.out.println("\nIntroduce una cantidad valida: ");
			teclado.next();
		}
		
		salario = teclado.nextFloat();
		pe = new Profesores(nombre,apellidos,dni,estadoCivil,fechaIncorporacion, departamento, salario);
		
		try {
			batoi.darAltaPersona(pe);
		}catch (excepcionesPersonalizadas e) {
			System.out.println(e.toString());
		}
		
		try {
			((Empleados) pe).setSalarioExtra(salario);
		}catch (excepcionesPersonalizadas e) {
			System.out.println(e.toString());
		}
		
		darAlta();
	}
	
	public void darAltaPersonaServicios() {
		String nombre;
		String apellidos;
		String dni;
		String estadoCivil;
		int fechaIncorporacion;
		String seccion;
		float salario;
		Persona pe;
		
		teclado.nextLine();
		System.out.print("-----------Introduccion de datos-----------");
		System.out.print("\nIntroduce el nombre: " );
		nombre = teclado.nextLine();
		System.out.print("Introduce los apellidos: " );
		apellidos = teclado.nextLine();
		System.out.print("Introduce el DNI: ");
		dni = teclado.nextLine();
		System.out.print("Introduce el estado civil: ");
		estadoCivil = teclado.nextLine();
		System.out.print("Introduce la seccion: ");
		seccion = teclado.nextLine();
		System.out.print("Introduce el año de incorporacion: ");
		while(!teclado.hasNextInt()) {
			System.out.println("\nIntroduce un año valido: ");
			teclado.next();
		}
		fechaIncorporacion = teclado.nextInt();
		
		System.out.print("Introduce el salario: ");
		while(!teclado.hasNextInt()) {
			System.out.println("\nIntroduce una cantidad valida: ");
			teclado.next();
		}
		salario = teclado.nextFloat();
		
		pe = new PersonalServicio(nombre, apellidos, dni, estadoCivil, fechaIncorporacion, seccion,salario);
		//batoi.darAltaPersona(pe);
		
		darAlta();
	}

}
