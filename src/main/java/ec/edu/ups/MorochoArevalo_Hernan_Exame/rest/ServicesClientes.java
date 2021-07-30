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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb.ClienteFacade;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.modelJSON.RespuestaJSON;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Cliente;

@Path("/clientes")
public class ServicesClientes {
	
	@EJB
	private ClienteFacade ejbcliente;
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarClientes() {

		List<Cliente> lista = ejbcliente.listarClientes();
		
		Jsonb jsonb = JsonbBuilder.create();
		return Response.ok(jsonb.toJson(lista)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}
	
	@POST
	@Path("/registrar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postCliente(@FormParam("nombre") String nombre, 
								 @FormParam("cedula") String cedula,
								 @FormParam("correo") String correo,
								 @FormParam("telefono") String telefono) 
	{
		Cliente x = new Cliente();
		x.setNombre(nombre);
		x.setCedula(cedula);
		x.setCorreo(correo);
		x.setTelefono(telefono);
		
		RespuestaJSON res = new RespuestaJSON();
		res.setValor("ok");
		res.setRespuesta("Cliente registrado con Exito" +x.getNombre());
		Jsonb json = JsonbBuilder.create();
		ejbcliente.create(x);
		return Response.ok(json.toJson(res)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();	
	}
	
	@GET
	@Path("/buscar/{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarCliente(@PathParam("cedula") String cedula) {
		
		Cliente x = ejbcliente.buscarPorCedula(cedula);
		Jsonb json = JsonbBuilder.create();
		
		if(x==null) {
			return Response.status(404).build(); 
		}	
		return Response.ok(json.toJson(x)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();	
	}	

}
