package ec.edu.ups.MorochoArevalo_Hernan_Exame.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurante {
	@Id
	private int id;
	
	private String nombre;
	private String direccion;
	private String telefono;
	private int aforo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	
}
