package ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Reserva;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Restaurante;

@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> {

	public ReservaFacade() {
		super(Reserva.class);
	}

	@PersistenceContext(unitName = "ERP")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Reserva> listarReservas(){
		String jpql = "SELECT r FROM Reserva r";
		return (List<Reserva>) em.createQuery(jpql).getResultList();
	}
	
	public List<Reserva> listarReservasPorCedula(String cedula){
		String jpql = "SELECT r FROM Reserva r WHERE r.cliente.cedula = "+cedula;
		return (List<Reserva>) em.createQuery(jpql).getResultList();
	}
	
	public List<Reserva> listarReservasPorRestaurante(String nombreRestaurant){
		try {
			String jpql = "FROM Reserva r WHERE r.restaurante.nombre = ?1";
			Query query = em.createQuery(jpql);
			query.setParameter(1, nombreRestaurant);
			return (List<Reserva>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			return null;
		}
	
	}
	
	

}
