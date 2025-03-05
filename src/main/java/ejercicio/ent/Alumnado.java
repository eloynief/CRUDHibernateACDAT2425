package ejercicio.ent;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name = "Alumnos")
public class Alumnado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumnado")
    private int idAlumnado;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    public Alumnado() {}

    public Alumnado(String nombre, String apellidos, String fechaNacimiento) {
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
        
    }
    
    public Alumnado(int idAlumnado, String nombre, String apellidos, String fechaNacimiento) {
		this.idAlumnado = idAlumnado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		setFechaNacimiento(fechaNacimiento);
		
		/**
		SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
    	Date date;
    	
		try {
			
	    	// convert string to date
			date = dateFormater.parse(fechaNacimiento);


	    	if(date==null) {
	    		date=dateFormater.parse("01/01/2000");
	    	}
	    	
			
			
	    	this.fechaNacimiento = date;
	    	
		} catch (ParseException e) {
			e.getMessage();
		}   
		
		*/
	}
    

	public int getIdAlumnado() { return idAlumnado; }
    public void setIdAlumnado(int idAlumnado) { this.idAlumnado = idAlumnado; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    
    public String getFechaNacimiento() { 
    	
    	return fechaNacimiento.toString(); 
    	
    }
    
    public void setFechaNacimiento(String fechaNacimiento) throws NullPointerException { 
        SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        
        try {
            date = dateFormater.parse(fechaNacimiento);
        } catch (ParseException| NullPointerException e) {
            e.getMessage(); // Muestra el error en la consola
            try {
                date = dateFormater.parse("01/01/2000"); // Valor por defecto
            } catch (ParseException ex) {
                throw new RuntimeException("Error al introducir la fecha por defecto"); // No debería ocurrir
            }
        }   
        this.fechaNacimiento = date;
    }


	@Override
	public String toString() {
		
		String texto="-----Alumno-----\n";
		texto+="ID: "+idAlumnado+"\n";
		texto+="Nombre: "+nombre+"\n";
		texto+="Apellidos: "+apellidos+"\n";
		texto+="Fecha de Nacimiento: "+fechaNacimiento+"\n";
		
		return texto;
	}
    
}