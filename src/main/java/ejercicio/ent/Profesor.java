package ejercicio.ent;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Profesores")
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesor")
    private int idProfesor;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Column(name = "antiguedad")
    private int antiguedad;

    public Profesor() {}

    public Profesor(String nombre, String apellidos, String fechaNacimiento, int antiguedad) throws ParseException {
        this.nombre = nombre;
        this.apellidos = apellidos;
        setFechaNacimiento(fechaNacimiento); // Lanzará ParseException si la fecha es inválida
        this.antiguedad = antiguedad;
    }

    public Profesor(int idProfesor, String nombre, String apellidos, String fechaNacimiento, int antiguedad) throws ParseException {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        setFechaNacimiento(fechaNacimiento); // Lanzará ParseException si la fecha es inválida
        this.antiguedad = antiguedad;
    }

    public int getIdProfesor() { return idProfesor; }
    public void setIdProfesor(int idProfesor) { this.idProfesor = idProfesor; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    
    public String getFechaNacimiento() { 
        return fechaNacimiento != null ? fechaNacimiento.toString() : null; 
    }
    
    public void setFechaNacimiento(String fechaNacimiento) throws ParseException {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatter.setLenient(false); // Para ser estrictos con el formato
        Date date = dateFormatter.parse(fechaNacimiento); // Lanzará ParseException si es inválida
        this.fechaNacimiento = date;
    }
    
    public int getAntiguedad() { return antiguedad; }
    public void setAntiguedad(int antiguedad) { this.antiguedad = antiguedad; }

    @Override
    public String toString() {
        String texto = "-----Profesor-----\n";
        texto += "ID: " + idProfesor + "\n"; // Corregido: "ID de la Matricula" a "ID"
        texto += "Nombre: " + nombre + "\n";
        texto += "Apellidos: " + apellidos + "\n";
        texto += "Fecha de Nacimiento: " + (fechaNacimiento != null ? fechaNacimiento : "No definida") + "\n";
        texto += "Antiguedad: " + antiguedad + "\n";
        return texto;
    }
}