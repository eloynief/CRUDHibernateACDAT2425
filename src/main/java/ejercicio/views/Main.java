package ejercicio.views;

import java.sql.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ejercicio.crud.CRUD;
import ejercicio.crud.Conexion;
import ejercicio.ent.Alumnado;
import ejercicio.ent.Matricula;
import ejercicio.ent.Profesor;

import com.diogonunes.jcolor.*;


public class Main {
    
    /**
     * Scanner estatico para poder usarlo en otras funciones diferentes del main
     * (Privado)
     */
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {

        List<Alumnado> alumnos = new ArrayList<Alumnado>();
        List<Matricula> matriculas = new ArrayList<Matricula>();
        List<Profesor> profesores = new ArrayList<Profesor>();
        
        Alumnado alumno = new Alumnado();
        Matricula matricula = new Matricula();
        Profesor profesor = new Profesor();
        
        int opcion = 0;
        int id = 0;

        try {
            Conexion.setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(Ansi.colorize(" ඞ EJERCICIO CRUD ඞ ",Attribute.BACK_COLOR(200, 0, 0),Attribute.TEXT_COLOR(200,200,20)));

        do {
            menu();
            
            opcion = introducirInt();
            
            switch (opcion) {
            
            case 1: {
                do {
                    System.out.println("Elige una opcion: 1: Alumnado, 2: Matricula, 3: Profesor");
                    opcion = introducirInt();
                    
                    switch (opcion) {
                    case 1: {
                        alumno = insertarAlumno();
                        CRUD.insertaAlumno(alumno);
                        break;
                    }
                    case 2: {
                        matricula = insertaMatricula();
                        CRUD.insertarMatricula(matricula);
                        break;
                    }
                    case 3: {
                        profesor = insertaProfesor();
                        CRUD.insertarProfesor(profesor);
                        break;
                    }
                    default: {
                        System.out.println("Opcion invalida. Elige otra opcion");
                        break;
                    }
                    }
                } while (opcion <= 0 || opcion > 3);
                break;
            }
                
            case 2: {
                do {
                    System.out.println("Elige una opcion: 1: Alumnado, 2: Matricula, 3: Profesor");
                    opcion = introducirInt();
                    
                    switch (opcion) {
                    case 1: {
                        System.out.println("Introduce el id del alumno:");
                        id = introducirInt();

                        alumno = insertarAlumno();
                        alumno.setIdAlumnado(id);
                        if (CRUD.actualizarAlumno(id, alumno)) {
                            System.out.println("El alumno se actualizo correctamente");
                        } else {
                            System.out.println("El alumno no se ha podido actualizar");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Introduce el id de la matricula:");
                        id = introducirInt();

                        matricula = insertaMatricula();
                        matricula.setIdMatricula(id);
                        if (CRUD.actualizarMatricula(id, matricula)) {
                            System.out.println("La matricula se actualizo correctamente");
                        } else {
                            System.out.println("La matricula no se ha podido actualizar");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Introduce el id del profesor:");
                        id = introducirInt();

                        profesor = insertaProfesor();
                        profesor.setIdProfesor(id);
                        if (CRUD.actualizarProfesor(id, profesor)) {
                            System.out.println("El profesor se actualizo correctamente");
                        } else {
                            System.out.println("El profesor no se ha podido actualizar");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opcion invalida. Elige otra opcion");
                        break;
                    }
                    }
                } while (opcion <= 0 || opcion > 3);
                break;
            }

            case 3: {
                do {
                    System.out.println("Elige una opcion: 1: Alumnado, 2: Matricula, 3: Profesor");
                    opcion = introducirInt();
                    
                    switch (opcion) {
                    case 1: {
                        System.out.println("Introduce el id del alumno:");
                        id = introducirInt();
                        
                        if (CRUD.borrarAlumno(id)) {
                            System.out.println("El alumno se ha borrado");
                        } else {
                            System.out.println("El alumno no se ha podido borrar");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Introduce el id de la matricula:");
                        id = introducirInt();
                        
                        if (CRUD.borrarMatricula(id)) {
                            System.out.println("La matricula se ha borrado");
                        } else {
                            System.out.println("La matricula no se ha podido borrar");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Introduce el id del profesor:");
                        id = introducirInt();
                        if (CRUD.borrarProfesor(id)) {
                            System.out.println("El profesor se ha borrado");
                        } else {
                            System.out.println("El profesor no se ha podido borrar");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opcion invalida. Elige otra opcion");
                        break;
                    }
                    }
                } while (opcion <= 0 || opcion > 3);
                break;
            }

            case 4: {
                do {
                    System.out.println("Elige una opcion: 1: Alumnado, 2: Matricula, 3: Profesor");
                    opcion = introducirInt();
                    
                    switch (opcion) {
                    case 1: {
                        alumnos = CRUD.leerAlumnos();
                        for (Alumnado a : alumnos) {
                            System.out.println(a);
                        }
                        break;
                    }
                    case 2: {
                        matriculas = CRUD.leerMatriculas();
                        for (Matricula m : matriculas) {
                            System.out.println(m);
                        }
                        break;
                    }
                    case 3: {
                        profesores = CRUD.leerProfesores();
                        for (Profesor p : profesores) {
                            System.out.println(p);
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opcion invalida. Elige otra opcion");
                        break;
                    }
                    }
                } while (opcion <= 0 || opcion > 3);
                break;
            }
            
            case 5: {
                do {
                    System.out.println("Elige una opcion: 1: Alumnado, 2: Matricula, 3: Profesor");
                    opcion = introducirInt();
                    
                    switch (opcion) {
                    case 1: {
                    	System.out.println("Introduce el ID");
                        id = introducirInt();
                        alumno = CRUD.leerAlumnoPorID(id);
                        if (alumno != null) {
                            System.out.println(alumno);
                        } else {
                            System.out.println("No se encontro alumno con ID: " + id);
                        }
                        break;
                    }
                    case 2: {
                    	System.out.println("Introduce el ID");
                        id = introducirInt(); 
                        matricula = CRUD.leerMatriculaPorID(id);
                        if (matricula != null) {
                            System.out.println(matricula);
                        } else {
                            System.out.println("No se encontro matricula con ID: " + id);
                        }
                        break;
                    }
                    case 3: {
                    	System.out.println("Introduce el ID");
                        id = introducirInt(); 
                        profesor = CRUD.leerProfesorPorID(id);
                        if (profesor != null) {
                            System.out.println(profesor);
                        } else {
                            System.out.println("No se encontro profesor con ID: " + id);
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opcion invalida. Elige otra opcion");
                        break;
                    }
                    }
                } while (opcion <= 0 || opcion > 3);
                break;
            }
            
            case 10: {
                System.out.println("ENTRANDO MODO DE PRUEBAS...");
                System.out.println("Que deseas imprimir?: 1: Alumno, 2: Profesor");
                
                do {
                    opcion = introducirInt();
                    
                    switch (opcion) {
                    case 1: {
                        System.out.println("Introduce el alumno");
                        alumno = insertarAlumno();
                        System.out.println(alumno);
                        break;
                    }
                    case 2: {
                        System.out.println("Introduce el profesor");
                        alumno = insertarAlumno();
                        System.out.println(alumno);
                        break;
                    }
                    
                    }
                } while (opcion <= 0 || opcion >= 3); // Corregido: debería ser > 2
                break;
            }
            
            case 0: {
                System.out.println("Saliendo del CRUD...");
                break;
            }
            }
        } while (opcion != 0);
        
        sc.close(); // Cerrar el Scanner al finalizar
    }

    private static int introducirInt() {
        boolean entradaValida = false;
        int dato = 0;
        do {
            try {
                dato = sc.nextInt();
                entradaValida = true;
            } catch (InputMismatchException i) {
                System.err.println("Tipo de dato no valido");
                sc.nextLine();
            }
        } while (!entradaValida);
        return dato;
    }
    
    private static void menu() {
    	System.out.println("    /\\_____/\\");
    	System.out.println("   /  o   o  \\");
    	System.out.println("  ( ==  ^  == )");
    	System.out.println("   )         (");
    	System.out.println("  (           )");
    	System.out.println(" ( (  )   (  ) )");
    	System.out.println("(__(__)___(__)__)");
    	
        System.out.println(Ansi.colorize("=========CRUD=========",Attribute.TEXT_COLOR(20,200,20)));
        System.out.println("Inserta opcion:");
        System.out.println(Ansi.colorize("1 Inserta",Attribute.TEXT_COLOR(20,200,20)));
        System.out.println("2 Actualizar");
        System.out.println(Ansi.colorize("3 Borrar",Attribute.TEXT_COLOR(20,200,20)));
        System.out.println("4 Obtener datos");
        System.out.println(Ansi.colorize("5 Obtener por ID",Attribute.TEXT_COLOR(20,200,20))); // Corregido: debía ser 5, no 4
        System.out.println("0 Salir");
        System.out.println(Ansi.colorize("======================",Attribute.TEXT_COLOR(20,200,20)));
        System.out.println("");
    }
    
    private static Alumnado insertarAlumno() {
        Alumnado alumno = new Alumnado();
        sc.nextLine(); 

        System.out.println("Introduce el nombre");
        String nombre = sc.nextLine();
        
        System.out.println("Introduce el apellido");
        String apellido = sc.nextLine();
        
        System.out.println("Introduce la fecha de nacimiento");
        String fechaNacimiento = sc.nextLine();
        
        alumno = new Alumnado(nombre, apellido, fechaNacimiento);
        return alumno;
    }
    
    private static Profesor insertaProfesor() {
        Profesor profesor = new Profesor();
        
        sc.nextLine(); 
        
        System.out.println("Introduce el nombre");
        String nombre = sc.nextLine();
        
        System.out.println("Introduce el apellido");
        String apellido = sc.nextLine();
        
        System.out.println("Introduce la fecha de nacimiento");
        String fechaNacimiento = sc.nextLine();
        
        System.out.println("Introduce la antiguedad");
        int antiguedad = introducirInt();

        profesor = new Profesor(nombre, apellido, fechaNacimiento, antiguedad);
        return profesor;
    }
    
    private static Matricula insertaMatricula() {
        Matricula matricula = new Matricula();
        
        System.out.println("Introduce el ID del alumno");
        int idAlumno = introducirInt(); 
        
        System.out.println("Introduce el ID del profesor");
        int idProfesor = introducirInt(); 
        
        sc.nextLine(); 
        
        System.out.println("Introduce la asignatura");
        String asignatura = sc.nextLine();
        
        System.out.println("Introduce el curso");
        String curso = sc.nextLine();
        
        matricula = new Matricula(idProfesor, idAlumno, asignatura, curso);
        return matricula;
    }
}