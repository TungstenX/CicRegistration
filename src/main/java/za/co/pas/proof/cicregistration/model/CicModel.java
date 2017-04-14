package za.co.pas.proof.cicregistration.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.pas.proof.cicregistration.data.Cic;

/**
 * The Cic model to deal with cic entities
 *
 * @author Andre Labuschagne
 */
@Stateless
public class CicModel extends AbstractModel<Cic> {

    /**
     * See, here we can use a different PU than the others, and then we will
     * feel special...
     */
    @PersistenceContext(unitName = "za.co.pas.proof_CicRegistration_ejb_0.0.0PU")
    private EntityManager em;

    /**
     * Get the entity manager, as daddy said
     *
     * @return the entity manager
     */
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    /**
     * Default constructor
     */
    public CicModel() {
        super(Cic.class);
    }

}
