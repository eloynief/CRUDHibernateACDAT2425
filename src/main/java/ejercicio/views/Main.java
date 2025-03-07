package ejercicio.views;

import java.text.ParseException;
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
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        List<Alumnado> alumnos = new ArrayList<>();
        List<Matricula> matriculas = new ArrayList<>();
        List<Profesor> profesores = new ArrayList<>();
        
        int opcion = 0;
        int id = 0;
        String texto = "";

        try {
            Conexion.setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(Ansi.colorize(" ඞ EJERCICIO CRUD ඞ ", Attribute.BACK_COLOR(200, 0, 0), Attribute.TEXT_COLOR(200, 200, 20)));

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
                        Alumnado alumno = insertarAlumno();
                        if (CRUD.insertaAlumno(alumno)) {
                            System.out.println("Alumno insertado correctamente");
                        } else {
                            System.out.println("No se pudo insertar el alumno");
                        }
                        break;
                    }
                    case 2: {
                        Matricula matricula = insertaMatricula();
                        if (CRUD.insertarMatricula(matricula)) {
                            System.out.println("Matrícula insertada correctamente");
                        } else {
                            System.out.println("No se pudo insertar la matrícula");
                        }
                        break;
                    }
                    case 3: {
                        Profesor profesor = insertaProfesor();
                        if (CRUD.insertarProfesor(profesor)) {
                            System.out.println("Profesor insertado correctamente");
                        } else {
                            System.out.println("No se pudo insertar el profesor");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opción inválida. Elige otra opción");
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
                        Alumnado alumno = insertarAlumno();
                        alumno.setIdAlumnado(id);
                        if (CRUD.actualizarAlumno(id, alumno)) {
                            System.out.println("El alumno se actualizó correctamente");
                        } else {
                            System.out.println("El alumno no se ha podido actualizar");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Introduce el id de la matrícula:");
                        id = introducirInt();
                        Matricula matricula = insertaMatricula();
                        matricula.setIdMatricula(id);
                        if (CRUD.actualizarMatricula(id, matricula)) {
                            System.out.println("La matrícula se actualizó correctamente");
                        } else {
                            System.out.println("La matrícula no se ha podido actualizar");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Introduce el id del profesor:");
                        id = introducirInt();
                        Profesor profesor = insertaProfesor();
                        profesor.setIdProfesor(id);
                        if (CRUD.actualizarProfesor(id, profesor)) {
                            System.out.println("El profesor se actualizó correctamente");
                        } else {
                            System.out.println("El profesor no se ha podido actualizar");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opción inválida. Elige otra opción");
                        break;
                    }
                    }
                } while (opcion <= 0 || opcion > 3);
                break;
            }
            case 3: {
                System.out.println("Elige una opcion: 1: Alumnado, 2: Matricula, 3: Profesor");
                int subOpcion = introducirInt();
                System.out.println("¿Borrar por: 1: ID, 2: Nombre/Asignatura?");
                int criterio = introducirInt();
                
                switch (subOpcion) {
                case 1: { // Alumnado
                    if (criterio == 1) {
                        System.out.println("Introduce el id del alumno:");
                        id = introducirInt();
                        if (CRUD.borrarAlumno(id)) {
                            System.out.println("El alumno se ha borrado");
                        } else {
                            System.out.println("El alumno no se ha podido borrar");
                        }
                    } else if (criterio == 2) {
                        sc.nextLine(); // Limpiar buffer
                        System.out.println("Introduce el nombre del alumno:");
                        String nombre = sc.nextLine();
                        if (CRUD.borrarAlumnoPorNombre(nombre)) {
                            System.out.println("Alumnos borrados correctamente");
                        } else {
                            System.out.println("No se pudieron borrar los alumnos con ese nombre");
                        }
                    } else {
                        System.out.println("Criterio inválido");
                    }
                    break;
                }
                case 2: { // Matricula
                    if (criterio == 1) {
                        System.out.println("Introduce el id de la matrícula:");
                        id = introducirInt();
                        if (CRUD.borrarMatricula(id)) {
                            System.out.println("La matrícula se ha borrado");
                        } else {
                            System.out.println("La matrícula no se ha podido borrar");
                        }
                    } else if (criterio == 2) {
                        sc.nextLine(); // Limpiar buffer
                        System.out.println("Introduce la asignatura de la matrícula:");
                        String asignatura = sc.nextLine();
                        if (CRUD.borrarMatriculaPorAsignatura(asignatura)) {
                            System.out.println("Matrículas borradas correctamente");
                        } else {
                            System.out.println("No se pudieron borrar las matrículas con esa asignatura");
                        }
                    } else {
                        System.out.println("Criterio inválido");
                    }
                    break;
                }
                case 3: { // Profesor
                    if (criterio == 1) {
                        System.out.println("Introduce el id del profesor:");
                        id = introducirInt();
                        if (CRUD.borrarProfesor(id)) {
                            System.out.println("El profesor se ha borrado");
                        } else {
                            System.out.println("El profesor no se ha podido borrar");
                        }
                    } else if (criterio == 2) {
                        sc.nextLine(); // Limpiar buffer
                        System.out.println("Introduce el nombre del profesor:");
                        String nombre = sc.nextLine();
                        if (CRUD.borrarProfesorPorNombre(nombre)) {
                            System.out.println("Profesores borrados correctamente");
                        } else {
                            System.out.println("No se pudieron borrar los profesores con ese nombre");
                        }
                    } else {
                        System.out.println("Criterio inválido");
                    }
                    break;
                }
                default: {
                    System.out.println("Opción inválida. Elige otra opción");
                    break;
                }
                }
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
                        System.out.println("Opción inválida. Elige otra opción");
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
                    sc.nextLine(); // Limpiar buffer
                    
                    switch (opcion) {
                    case 1: {
                        System.out.println("Elige la opcion a filtrar: 1: Nombre, 2: Apellido, 3: Fecha de nacimiento");
                        int filtroOpcion = introducirInt();
                        sc.nextLine();
                        System.out.println("Introduce el valor de la opcion que vas a usar como filtro:");
                        texto = sc.nextLine();
                        alumnos = CRUD.leerAlumnos();
                        List<Alumnado> als = CRUD.filtrarAlumnos(alumnos, filtroOpcion, texto);
                        if (!als.isEmpty()) {
                            for (Alumnado a : als) {
                                System.out.println(a);
                            }
                        } else {
                            System.out.println("No se encontraron alumnos con ese criterio");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Elige la opcion a filtrar: 1: ID Alumno, 2: ID Profesor, 3: Asignatura, 4: Curso");
                        int filtroOpcion = introducirInt();
                        sc.nextLine();
                        System.out.println("Introduce el valor de la opcion que vas a usar como filtro:");
                        texto = sc.nextLine();
                        matriculas = CRUD.leerMatriculas();
                        List<Matricula> mats = CRUD.filtrarMatriculas(matriculas, filtroOpcion, texto);
                        if (!mats.isEmpty()) {
                            for (Matricula m : mats) {
                                System.out.println(m);
                            }
                        } else {
                            System.out.println("No se encontraron matrículas con ese criterio");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Elige la opcion a filtrar: 1: Nombre, 2: Apellido, 3: Fecha de nacimiento, 4: Antigüedad");
                        int filtroOpcion = introducirInt();
                        sc.nextLine();
                        System.out.println("Introduce el valor de la opcion que vas a usar como filtro:");
                        texto = sc.nextLine();
                        profesores = CRUD.leerProfesores();
                        List<Profesor> profs = CRUD.filtrarProfesores(profesores, filtroOpcion, texto);
                        if (!profs.isEmpty()) {
                            for (Profesor p : profs) {
                                System.out.println(p);
                            }
                        } else {
                            System.out.println("No se encontraron profesores con ese criterio");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opción inválida. Elige otra opción");
                        break;
                    }
                    }
                } while (opcion <= 0 || opcion > 3);
                break;
            }
            
            case 6: {
                System.out.println("Elige una opción: 1: Borrar todos los alumnos, 2: Borrar todas las matrículas, 3: Borrar todos los profesores");
                int subOpcion = introducirInt();
                switch (subOpcion) {
                case 1:
                    if (CRUD.dropTablaAlumnos()) {
                        System.out.println("Todos los alumnos han sido borrados.");
                    } else {
                        System.out.println("No se pudieron borrar los alumnos.");
                    }
                    break;
                case 2:
                    if (CRUD.dropTablaMatriculas()) {
                        System.out.println("Todas las matrículas han sido borradas.");
                    } else {
                        System.out.println("No se pudieron borrar las matrículas.");
                    }
                    break;
                case 3:
                    if (CRUD.dropTablaProfesores()) {
                        System.out.println("Todos los profesores han sido borrados.");
                    } else {
                        System.out.println("No se pudieron borrar los profesores.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
                }
                break;
            }
            
            case 0: {
                System.out.println("Saliendo del CRUD...");
                break;
            }
            default: {
                System.out.println("Opción no válida");
                break;
            }
            }
        } while (opcion != 0);
        
        sc.close();
    }

    private static int introducirInt() {
        boolean entradaValida = false;
        int dato = 0;
        do {
            try {
                dato = sc.nextInt();
                entradaValida = true;
            } catch (InputMismatchException i) {
                System.out.println(Ansi.colorize("Tipo de dato no válido", Attribute.BACK_COLOR(200, 50, 50), Attribute.BLACK_TEXT()));
                sc.nextLine();
            }
        } while (!entradaValida);
        return dato;
    }
    
    private static void menu() {
        System.out.println(Ansi.colorize("=========CRUD=========", Attribute.TEXT_COLOR(20, 200, 20)));
        System.out.println("Inserta opción:");
        System.out.println(Ansi.colorize("1 Inserta", Attribute.TEXT_COLOR(20, 200, 20)));
        System.out.println("2 Actualizar");
        System.out.println(Ansi.colorize("3 Borrar", Attribute.TEXT_COLOR(20, 200, 20)));
        System.out.println("4 Obtener datos");
        System.out.println(Ansi.colorize("5 Filtrar", Attribute.TEXT_COLOR(20, 200, 20)));
        System.out.println(Ansi.colorize("6 BORRAR TABLAS", Attribute.TEXT_COLOR(200, 20, 20)));
        System.out.println("0 Salir");
        System.out.println(Ansi.colorize("======================", Attribute.TEXT_COLOR(20, 200, 20)));
        System.out.println("");
    }
    
    private static Alumnado insertarAlumno() {
        sc.nextLine(); 
        System.out.println("Introduce el nombre");
        String nombre = sc.nextLine();
        
        System.out.println("Introduce el apellido");
        String apellido = sc.nextLine();
        
        Alumnado alumno = null;
        boolean fechaValida = false;
        do {
            System.out.println("Introduce la fecha de nacimiento (dd/MM/yyyy, ejemplo: 15/05/2000)");
            String fechaNacimiento = sc.nextLine();
            try {
                alumno = new Alumnado(nombre, apellido, fechaNacimiento);
                fechaValida = true;
            } catch (ParseException e) {
                System.out.println(Ansi.colorize("Fecha inválida: " + e.getMessage() + ". Use dd/MM/yyyy (ejemplo: 15/05/2000), y que tenga el mes, dia y año correctos", Attribute.TEXT_COLOR(255, 0, 0)));
            } catch (IllegalArgumentException e) {
                System.out.println(Ansi.colorize("Error: " + e.getMessage(), Attribute.TEXT_COLOR(255, 0, 0)));
            }
        } while (!fechaValida);
        
        return alumno;
    }
    
    private static Profesor insertaProfesor() {
        sc.nextLine(); 
        System.out.println("Introduce el nombre");
        String nombre = sc.nextLine();
        
        System.out.println("Introduce el apellido");
        String apellido = sc.nextLine();
        
        Profesor profesor = null;
        boolean fechaValida = false;
        do {
            System.out.println("Introduce la fecha de nacimiento (dd/MM/yyyy, ejemplo: 15/05/2000)");
            String fechaNacimiento = sc.nextLine();
            try {
                profesor = new Profesor(nombre, apellido, fechaNacimiento, 0); // Antigüedad temporal
                fechaValida = true;
            } catch (ParseException e) {
                System.out.println(Ansi.colorize("Fecha inválida: " + e.getMessage() + ". Use dd/MM/yyyy (ejemplo: 15/05/2000), y que tenga el mes, dia y año correctos", Attribute.TEXT_COLOR(255, 0, 0)));
            } catch (IllegalArgumentException e) {
                System.out.println(Ansi.colorize("Error: " + e.getMessage(), Attribute.TEXT_COLOR(255, 0, 0)));
            }
        } while (!fechaValida);
        
        System.out.println("Introduce la antigüedad");
        int antiguedad = introducirInt();
        profesor.setAntiguedad(antiguedad);
        
        return profesor;
    }
    
    private static Matricula insertaMatricula() {
        System.out.println("Introduce el ID del alumno");
        int idAlumno = introducirInt(); 
        
        System.out.println("Introduce el ID del profesor");
        int idProfesor = introducirInt(); 
        
        sc.nextLine(); 
        System.out.println("Introduce la asignatura");
        String asignatura = sc.nextLine();
        
        System.out.println("Introduce el curso");
        String curso = sc.nextLine();
        
        return new Matricula(idProfesor, idAlumno, asignatura, curso);
    }
}