package ejercicio.crud;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import ejercicio.ent.Alumnado;
import ejercicio.ent.Matricula;
import ejercicio.ent.Profesor;

public class CRUD {

    // ALUMNOS

    public static List<Alumnado> leerAlumnos() {
        List<Alumnado> alumnos = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            alumnos = session.createNativeQuery("SELECT * FROM Alumnos", Alumnado.class).list();
            transaction.commit();
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al leer alumnos: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return alumnos;
    }
    
    
    public static Alumnado leerAlumnoPorID(int id) {
        Alumnado alumno = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            // Usamos get() en lugar de createNativeQuery para obtener por ID
            alumno = session.get(Alumnado.class, id);
            transaction.commit();
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al leer alumno por ID: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return alumno;
    }

    

    

    public static boolean insertaAlumno(Alumnado a) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;
        
        try {
            if (a == null || a.getFechaNacimiento() == null) {
                throw new IllegalArgumentException("El alumno o su fecha de nacimiento no pueden ser nulos");
            }
            
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            session.save(a);
            transaction.commit();
            success = true;
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al insertar alumno: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Datos invalidos: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return success;
    }

    public static boolean actualizarAlumno(int id, Alumnado alumnoNuevo) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;
        
        try {
            if (alumnoNuevo == null) {
                throw new IllegalArgumentException("El alumno nuevo no puede ser nulo");
            }
            
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            Alumnado alumno = session.get(Alumnado.class, id);
            if (alumno != null) {

                if(alumnoNuevo.getNombre()!=null||!alumnoNuevo.getNombre().equals("")) {
                alumno.setNombre(alumnoNuevo.getNombre());
                }
                
                if(alumnoNuevo.getApellidos()!=null||!alumnoNuevo.getApellidos().equals("")) {
                alumno.setApellidos(alumnoNuevo.getApellidos());
                }
                
                if(alumnoNuevo.getFechaNacimiento()!=null) {
                alumno.setFechaNacimiento(alumnoNuevo.getFechaNacimiento());
                }
                
                session.update(alumno);
                transaction.commit();
                success = true;
            }
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al actualizar alumno: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Datos invalidos: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return success;
    }

    public static boolean borrarAlumno(int idAlumno) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;
        
        try {
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            Alumnado alumno = session.get(Alumnado.class, idAlumno);
            if (alumno != null) {
                session.delete(alumno);
                transaction.commit();
                success = true;
            }
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al borrar alumno: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return success;
    }

    // MATRICULAS

    public static List<Matricula> leerMatriculas() {
        List<Matricula> matriculas = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            matriculas = session.createNativeQuery("SELECT * FROM Matriculas", Matricula.class).list();
            transaction.commit();
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al leer matrículas: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return matriculas;
    }
    
    
    public static Matricula leerMatriculaPorID(int id) {
        Matricula matricula = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            matricula = session.get(Matricula.class, id);
            transaction.commit();
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al leer matrícula por ID: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return matricula;
    }
    
    

    public static boolean insertarMatricula(Matricula m) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;
        
        try {
            if (m == null || m.getCurso() == null) {
                throw new IllegalArgumentException("La matrícula o su curso no pueden ser nulos");
            }
            
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            Profesor profesor = session.get(Profesor.class, m.getIdProfesorado());
            Alumnado alumno = session.get(Alumnado.class, m.getIdAlumnado());
            
            if (profesor == null || alumno == null) {
                throw new IllegalStateException("El profesor o alumno referenciado no existe");
            }
            
            session.save(m);
            transaction.commit();
            success = true;
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al insertar matrícula: " + e.getMessage());
        } catch (IllegalArgumentException | IllegalStateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Datos inválidos: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return success;
    }

    public static boolean actualizarMatricula(int id, Matricula matriculaNueva) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;
        
        try {
            if (matriculaNueva == null) {
                throw new IllegalArgumentException("La matrícula nueva no puede ser nula");
            }
            
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            Matricula matricula = session.get(Matricula.class, id);
            if (matricula != null) {
                Profesor profesor = session.get(Profesor.class, matriculaNueva.getIdProfesorado());
                Alumnado alumno = session.get(Alumnado.class, matriculaNueva.getIdAlumnado());
                
                if (profesor == null || alumno == null) {
                    throw new IllegalStateException("El profesor o alumno referenciado no existe");
                }
                
                matricula.setIdProfesorado(matriculaNueva.getIdProfesorado());
                matricula.setIdAlumnado(matriculaNueva.getIdAlumnado());
                matricula.setAsignatura(matriculaNueva.getAsignatura());
                matricula.setCurso(matriculaNueva.getCurso());
                session.update(matricula);
                transaction.commit();
                success = true;
            }
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al actualizar matrícula: " + e.getMessage());
        } catch (IllegalArgumentException | IllegalStateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Datos inválidos: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return success;
    }

    public static boolean borrarMatricula(int idMatricula) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;
        
        try {
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            Matricula matricula = session.get(Matricula.class, idMatricula);
            if (matricula != null) {
                session.delete(matricula);
                transaction.commit();
                success = true;
            }
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al borrar matrícula: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return success;
    }

    // PROFESOR

    public static List<Profesor> leerProfesores() {
        List<Profesor> profesores = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            profesores = session.createNativeQuery("SELECT * FROM Profesores", Profesor.class).list();
            transaction.commit();
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al leer profesores: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return profesores;
    }
    
    

    public static Profesor leerProfesorPorID(int id) {
        Profesor profesor = null;
        Session session = null;
        Transaction transaction = null;
        
        try {
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            profesor = session.get(Profesor.class, id);
            transaction.commit();
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al leer profesor por ID: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return profesor;
    }
    
    

    public static boolean insertarProfesor(Profesor p) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;
        
        try {
            if (p == null || p.getFechaNacimiento() == null) {
                throw new IllegalArgumentException("El profesor o su fecha de nacimiento no pueden ser nulos");
            }
            
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            session.save(p);
            transaction.commit();
            success = true;
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al insertar profesor: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Datos inválidos: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return success;
    }

    public static boolean actualizarProfesor(int id, Profesor profesorNuevo) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;
        
        try {
            if (profesorNuevo == null) {
                throw new IllegalArgumentException("El profesor nuevo no puede ser nulo");
            }
            
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            Profesor profesor = session.get(Profesor.class, id);
            if (profesor != null) {
                profesor.setNombre(profesorNuevo.getNombre());
                profesor.setApellidos(profesorNuevo.getApellidos());
                profesor.setFechaNacimiento(profesorNuevo.getFechaNacimiento());
                profesor.setAntiguedad(profesorNuevo.getAntiguedad());
                session.update(profesor);
                transaction.commit();
                success = true;
            }
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al actualizar profesor: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Datos inválidos: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return success;
    }

    public static boolean borrarProfesor(int idProfesor) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;
        
        try {
            Conexion.compruebaConexion();
            session = Conexion.miSeccion.openSession();
            transaction = session.beginTransaction();
            
            Profesor profesor = session.get(Profesor.class, idProfesor);
            if (profesor != null) {
                session.delete(profesor);
                transaction.commit();
                success = true;
            }
            
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al borrar profesor: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return success;
    }
}