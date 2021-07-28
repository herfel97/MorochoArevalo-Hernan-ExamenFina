package ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Cliente;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente>{

	public ClienteFacade() {
		super(Cliente.class);
	}

	@PersistenceContext(unitName = "ERP")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Cliente> listarClientes(){
		String jpql = "SELECT c FROM Cliente c";
		return (List<Cliente>) em.createQuery(jpql).getResultList();
	}
	
	
	public Cliente buscarPorCedula(String cedula) {
		try {
			String jpql = "FROM Cliente c WHERE c.cedula = ?1";
			Query query = em.createQuery(jpql);
			query.setParameter(1, cedula);
			return (Cliente) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			return null;
		}
		
	}
		
}
