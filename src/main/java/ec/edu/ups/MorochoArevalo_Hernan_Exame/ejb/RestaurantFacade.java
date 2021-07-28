package ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Cliente;
import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Restaurante;

@Stateless
public class RestaurantFacade extends AbstractFacade<Restaurante>{

	public RestaurantFacade() {
		super(Restaurante.class);
	}

	@PersistenceContext(unitName = "ERP")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Restaurante> listarRestaurantes(){
		String jpql = "SELECT r FROM Restaurante r";
		return (List<Restaurante>) em.createQuery(jpql).getResultList();
	}

	public Restaurante buscarPorNombre(String nombre) {
		try {
			String jpql = "FROM Restaurante r WHERE r.nombre = ?1";
			Query query = em.createQuery(jpql);
			query.setParameter(1, nombre);
			return (Restaurante) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			return null;
		}
		
	}

	
}
