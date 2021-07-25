package ec.edu.ups.MorochoArevalo_Hernan_Exame.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reserva {
	
	@Id
	private int id;
	
	private Cliente cliente;
	private Restaurante restaurante;
	private Date fecha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
