package ec.edu.ups.MorochoArevalo_Hernan_Exame.modelJSON;

public class ReservaJSON {
	
	private int id;
	private int asistentes;
	private String fecha;
	private String hora;
	private String cliente;
	private String restaurante;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAsistentes() {
		return asistentes;
	}
	public void setAsistentes(int asistentes) {
		this.asistentes = asistentes;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}
}
