package ejercicio.ent;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Matriculas")
public class Matricula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMatricula")
    private int idMatricula;
    
    @Column(name = "idProfesorado")
    //@ManyToOne
    //@JoinColumn(name="idProfesorado")
    private int idProfesorado;
    
    @Column(name = "idAlumnado")
    //@ManyToOne
    //@JoinColumn(name="idAlumnado")
    private int idAlumnado;
    
    @Column(name = "asignatura")
    private String asignatura;
    
    @Column(name = "curso")
    private String curso;

    public Matricula() {}
    
    
    public Matricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Matricula(int idProfesorado, int idAlumnado, String asignatura, String curso) {
        this.idProfesorado = idProfesorado;
        this.idAlumnado = idAlumnado;
        this.asignatura = asignatura;
        this.curso = curso;
    }

    public int getIdMatricula() { return idMatricula; }
    public void setIdMatricula(int idMatricula) { this.idMatricula = idMatricula; }
    public int getIdProfesorado() { return idProfesorado; }
    public void setIdProfesorado(int idProfesorado) { this.idProfesorado = idProfesorado; }
    public int getIdAlumnado() { return idAlumnado; }
    public void setIdAlumnado(int idAlumnado) { this.idAlumnado = idAlumnado; }
    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    

	@Override
	public String toString() {
		
		String texto="-----Matricula-----\n";
		texto+="ID de la Matricula: "+idMatricula+"\n";
		texto+="ID del Profesorado: "+idProfesorado+"\n";
		texto+="Id del Alumno: "+idAlumnado+"\n";
		texto+="Asignatura: "+asignatura+"\n";
		texto+="Curso: "+curso+"\n";
		
		return texto;
	}
    
}

