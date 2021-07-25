package ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Cliente;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente>{

	public ClienteFacade(Class<Cliente> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "ERP")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	
	
}
