package ec.edu.ups.MorochoArevalo_Hernan_Exame.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private Cliente cliente;
	private Restaurante restaurante;
	private Date fecha;
	private int asistentes;
	private String hora;
	
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
	public int getAsistentes() {
		return asistentes;
	}
	public void setAsistentes(int asistentes) {
		this.asistentes = asistentes;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", cliente=" + cliente + ", restaurante=" + restaurante + ", fecha=" + fecha
				+ ", asistentes=" + asistentes + ", hora=" + hora + "]";
	}
	
	
	
}
