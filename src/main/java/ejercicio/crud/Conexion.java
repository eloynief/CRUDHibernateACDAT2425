package ejercicio.crud;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Conexion {

	//session factory del CRUD
	protected static SessionFactory miSeccion;
	
	/**
	 * funcion para abrir el registro de sesion
	 * @throws Exception
	 */
	public static void setUp() throws Exception {
		//si la sesion esta cerrada o es null
	    if (miSeccion == null || miSeccion.isClosed()) {
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure() // por defecto: hibernate.cfg.xml
					.build();
			try {
				miSeccion = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			}
			catch (Exception e) {
				StandardServiceRegistryBuilder.destroy( registry );
			}
	    }
	}
	
	
	

	public static void compruebaConexion() {
		if(Conexion.miSeccion==null) {
			try {
				Conexion.setUp();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
	
}
