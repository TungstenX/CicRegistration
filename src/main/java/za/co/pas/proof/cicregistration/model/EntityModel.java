/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.pas.proof.cicregistration.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.pas.proof.cicregistration.data.Entity;

/**
 *
 * @author andre
 */
@Stateless
public class EntityModel extends AbstractModel<Entity>{

    @PersistenceContext(unitName = "za.co.pas.proof_CicRegistration_ejb_0.0.0PU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public EntityModel() {
        super(Entity.class);
    }
    
}
