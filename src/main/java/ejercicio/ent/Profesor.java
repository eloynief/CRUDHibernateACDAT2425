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

    
    
    
    
    
    
    
    public Profesor(String nombre, String apellidos, String fechaNacimiento, int antiguedad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		setFechaNacimiento(fechaNacimiento);
		/**
		SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
    	Date date;
    	
		try {
			
	    	// convert string to date
			date = dateFormater.parse(fechaNacimiento);
	    	
	    	this.fechaNacimiento = date;
	    	
		} catch (ParseException e) {
			e.getMessage();
		}  
        */
		
		
		
		this.antiguedad = antiguedad;
	}








	public Profesor(int idProfesor, String nombre, String apellidos, String fechaNacimiento, int antiguedad) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
		setFechaNacimiento(fechaNacimiento);
		/**
		SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
    	Date date;
    	
		try {
			
	    	// convert string to date
			date = dateFormater.parse(fechaNacimiento);
	    	
	    	this.fechaNacimiento = date;
	    	
		} catch (ParseException e) {
			e.getMessage();
		}  
        */
        
        this.antiguedad = antiguedad;
    }

    public int getIdProfesor() { return idProfesor; }
    public void setIdProfesor(int idProfesor) { this.idProfesor = idProfesor; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    

    public String getFechaNacimiento() { 
    	
    	return fechaNacimiento.toString(); 
    	
    }
    
    public void setFechaNacimiento(String fechaNacimiento) { 
        SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        
        try {
            date = dateFormater.parse(fechaNacimiento);
        } catch (ParseException | NullPointerException e) {
            e.printStackTrace(); // Muestra el error en la consola
            try {
                date = dateFormater.parse("01/01/2000"); // Valor por defecto
            } catch (ParseException | NullPointerException ex) {
                throw new RuntimeException("Error al parsear la fecha por defecto"); // No debería ocurrir
            }
        }   
        this.fechaNacimiento = date;
    }

    
    
    public int getAntiguedad() { return antiguedad; }
    public void setAntiguedad(int antiguedad) { this.antiguedad = antiguedad; }
    
    

	@Override
	public String toString() {
		
		String texto="-----Profesor-----\n";
		texto+="ID de la Matricula: "+idProfesor+"\n";
		texto+="Nombre: "+nombre+"\n";
		texto+="Apellidos: "+apellidos+"\n";
		texto+="Fecha de Nacimiento: "+fechaNacimiento+"\n";
		texto+="Antiguedad: "+antiguedad+"\n";
		
		return texto;
	}
    
}
