package ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Restaurante;

public class RestaurantFacade extends AbstractFacade<Restaurante>{

	public RestaurantFacade(Class<Restaurante> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "ERP")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
