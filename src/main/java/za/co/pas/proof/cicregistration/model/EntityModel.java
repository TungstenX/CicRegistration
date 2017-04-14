package za.co.pas.proof.cicregistration.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.pas.proof.cicregistration.data.Entity;

/**
 * The (Email) Entity model to deal with (email) entity entities
 *
 * @author Andre Labuschagne
 */
@Stateless
public class EntityModel extends AbstractModel<Entity> {

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
    public EntityModel() {
        super(Entity.class);
    }

}
