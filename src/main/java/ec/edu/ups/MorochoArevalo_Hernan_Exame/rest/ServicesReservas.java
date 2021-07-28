package ec.edu.ups.MorochoArevalo_Hernan_Exame.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb.ClienteFacade;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb.ReservaFacade;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb.RestaurantFacade;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.modelJSON.ReservaJSON;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.modelJSON.RespuestaJSON;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Reserva;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Restaurante;

@Path("reserva/")
public class ServicesReservas {

	@EJB
	private ReservaFacade ejbReserva;
	@EJB
	private RestaurantFacade ejbRestaurante;
	@EJB
	private ClienteFacade ejbCliente;
	
	@POST	
	@Path("/registrar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postReserva (@FormParam("cedulaCliente") String cedulaCliente, 
								 @FormParam("nombreRestaurant") String nombreRes,
								 @FormParam("asistentes") int asistentes,
								 @FormParam("fecha") String fecha,
								 @FormParam("hora")String hora ) throws ParseException 
	{
		Reserva reserv = new Reserva();
		
		reserv.setCliente(ejbCliente.buscarPorCedula(cedulaCliente));
		reserv.setRestaurante(ejbRestaurante.buscarPorNombre(nombreRes));
		reserv.setAsistentes(asistentes);
		
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(fecha);  
		
		reserv.setFecha(date1);
		reserv.setHora(hora);
		
		ejbReserva.create(reserv);		
		
		RespuestaJSON res = new RespuestaJSON();
		res.setValor("ok");
		res.setRespuesta("Reserva Registrada: ");
		Jsonb json = JsonbBuilder.create();
		return Response.ok(json.toJson(res)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();	
	}
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaReservas() {

		List<Reserva> lista = ejbReserva.listarReservas();
		List<ReservaJSON> lista2 = new ArrayList<ReservaJSON>();
		
		
		
		for (int i = 0; i < lista.size(); i++) {
			ReservaJSON resJson = new ReservaJSON();
			resJson.setId(lista.get(i).getId());
			resJson.setAsistentes(lista.get(i).getAsistentes());
			resJson.setCliente(lista.get(i).getCliente().getNombre());
			resJson.setRestaurante(lista.get(i).getRestaurante().getNombre());
			resJson.setFecha(lista.get(i).getFecha().toString());
			resJson.setHora(lista.get(i).getHora() );
			lista2.add(resJson);
			System.out.println("numero "+i);
		}
		
		Jsonb jsonb = JsonbBuilder.create();

		return Response.ok(jsonb.toJson(lista2)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}
	
	@GET
	@Path("/list/{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaReservasCedula( @PathParam("cedula") String cedula ) {

		List<Reserva> lista = ejbReserva.listarReservasPorCedula(cedula);
		List<ReservaJSON> lista2 = new ArrayList<ReservaJSON>();
		
		
		
		for (int i = 0; i < lista.size(); i++) {
			ReservaJSON resJson = new ReservaJSON();
			resJson.setId(lista.get(i).getId());
			resJson.setAsistentes(lista.get(i).getAsistentes());
			resJson.setCliente(lista.get(i).getCliente().getNombre());
			resJson.setRestaurante(lista.get(i).getRestaurante().getNombre());
			resJson.setFecha(lista.get(i).getFecha().toString());
			resJson.setHora(lista.get(i).getHora() );
			lista2.add(resJson);
			System.out.println("numero "+i);
		}
		
		Jsonb jsonb = JsonbBuilder.create();

		return Response.ok(jsonb.toJson(lista2)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}
	
	
	
	
}
