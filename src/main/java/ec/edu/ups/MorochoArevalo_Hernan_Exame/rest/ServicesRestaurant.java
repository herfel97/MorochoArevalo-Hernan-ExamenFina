package ec.edu.ups.MorochoArevalo_Hernan_Exame.rest;

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

import ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb.RestaurantFacade;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.modelJSON.RespuestaJSON;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Cliente;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Restaurante;

@Path("/restaurant")
public class ServicesRestaurant {

	@EJB
	private RestaurantFacade ejbRestaurant;

	@POST
	@Path("/registrar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postRestaurant(@FormParam("nombre") String nombre, 
								 @FormParam("direccion") String direccion,
								 @FormParam("telefono") String telefono, 
								 @FormParam("aforo") int aforo) 
	{
		Restaurante x = new Restaurante();
		x.setNombre(nombre);
		x.setDireccion(direccion);
		x.setTelefono(telefono);
		x.setAforo(aforo);
		RespuestaJSON res = new RespuestaJSON();
		res.setValor("ok");
		res.setRespuesta("Restaurante registrado" +x.toString());
		Jsonb json = JsonbBuilder.create();
		
		ejbRestaurant.create(x);
		return Response.ok(json.toJson(res)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();	
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaRestaurantes() {

		List<Restaurante> lista = ejbRestaurant.listarRestaurantes();
		Jsonb jsonb = JsonbBuilder.create();

		return Response.ok(jsonb.toJson(lista)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}
	
	@GET
	@Path("/buscar/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarRestaurantes(@PathParam("nombre") String nombre) {

		Restaurante res = ejbRestaurant.buscarPorNombre(nombre);
		Jsonb jsonb = JsonbBuilder.create();

		return Response.ok(jsonb.toJson(res)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}
	
	
	

}
