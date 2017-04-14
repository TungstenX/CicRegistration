package za.co.pas.proof.cicregistration.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.jboss.logging.Logger;
import za.co.pas.proof.cicregistration.data.Cic;
import za.co.pas.proof.cicregistration.data.Entity;
import za.co.pas.proof.cicregistration.model.CicModel;
import za.co.pas.proof.cicregistration.model.EntityModel;

/**
 * The service layer for the only implemented interface method; registerCic
 *
 * @author Andre Labuschagne
 */
@Stateless
@LocalBean
public class CicService implements CicServiceinterface {

    private static final Logger LOG = Logger.getLogger(CicService.class.getName());

    @EJB
    private EntityModel entityModel;

    @EJB
    private CicModel cicModel;

    /**
     * This will register a Cic
     *
     * @param cicType the Cic type
     * @param subject the Cic's subject
     * @param body the Cic's body/message
     * @param sourceSystem the source system
     * @param name the entity's name
     * @param email the entity's email address
     * @return true if successful else, umh, false if not
     */
    @Override
    public boolean registerCic(String cicType, String subject, String body,
            String sourceSystem, String name, String email) {
        try {
            List<Entity> entities = entityModel.findFieldWithValue(EMAIL_ADDRESS, email);
            Entity entity;
            if (entities.isEmpty()) {
                //then we don't have this entity yet
                LOG.debug("Email Entity doesn't exist yet, creating");
                entity = new Entity();
                entity.setEmailAddress(email);
                entity.setEntityName(name);
                entityModel.create(entity);
            } else if (entities.size() == 1) {
                LOG.debug("Email Entity exist");
                entity = entities.get(0);
            } else {
                LOG.warn("Email Entity exist: more than one, use first one, this may be an issue but this condition was not specified");
                entity = entities.get(0);
            }
            LOG.debug("Creating new Cic");
            Cic cic = new Cic();
            cic.setBody(body);
            cic.setCicTimestamp(new Date());
            cic.setCicType(cicType);
            cic.setSourceSystem(sourceSystem);
            cic.setSubject(subject);
            cic.setEntityCollection(new LinkedList<Entity>());
            cic.getEntityCollection().add(entity);
            cicModel.create(cic);
            if (entity.getCicCollection() == null) {
                entity.setCicCollection(new LinkedList<Cic>());
            }
            entity.getCicCollection().add(cic);
            LOG.info("Updating email entity");
            entityModel.edit(entity);
            //Whoot whoot! It worked!
            return true;
        } catch (Exception e) {
            //Pokemon exception handling!
            LOG.error("Error while registering Cic:", e);
            return false;
        }
    }
}
