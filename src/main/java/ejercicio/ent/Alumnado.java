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

    public Alumnado(String nombre, String apellidos, String fechaNacimiento) throws ParseException {
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
    
    public Alumnado(int idAlumnado, String nombre, String apellidos, String fechaNacimiento) throws ParseException {
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