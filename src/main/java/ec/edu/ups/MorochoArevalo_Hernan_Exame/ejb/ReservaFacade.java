package ec.edu.ups.MorochoArevalo_Hernan_Exame.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.MorochoArevalo_Hernan_Exame.models.Reserva;

public class ReservaFacade extends AbstractFacade<Reserva> {

	public ReservaFacade(Class<Reserva> entityClass) {
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
