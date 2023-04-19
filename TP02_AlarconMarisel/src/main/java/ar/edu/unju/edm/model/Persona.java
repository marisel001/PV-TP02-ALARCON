package ar.edu.unju.edm.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component 
public class Persona {
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private Integer edad;
	private String signoZodiaco;
	private String estacion;
		
	//Constructor por defecto
	public Persona() {
		
	}
	
	//Constructor parametrizado
	public Persona(String nombre, String apellido, LocalDate fechaNac) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
	}
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getSignoZodiaco() {
		return signoZodiaco;
	}

	public void setSignoZodiaco(String signoZodiaco) {
		this.signoZodiaco = signoZodiaco;
	}

	public String getEstacion() {
		return estacion;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	
	
}
