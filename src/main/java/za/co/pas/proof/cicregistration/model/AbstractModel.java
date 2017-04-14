/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.pas.proof.cicregistration.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Generic functionality
 *
 * @author andre
 */
public abstract class AbstractModel<T> {

    private static final Logger LOG = Logger.getLogger(AbstractModel.class.getName());

    private final Class<T> entityClass;

    public AbstractModel(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract EntityManager getEntityManager();

    public void create(T entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            StringBuilder sbLog = new StringBuilder("Error while inserting into database: \n");
            while (iterator.hasNext()) {
                ConstraintViolation<T> cv = iterator.next();
                sbLog.append("\t").append(cv.getRootBeanClass().getName()).append(".").append(cv.getPropertyPath()).append(" ").append(cv.getMessage()).append("\n");

            }
            LOG.log(Level.SEVERE, sbLog.toString());
            throw new ConstraintViolationException(sbLog.toString(), new HashSet<ConstraintViolation<?>>(constraintViolations));
        } else {
            getEntityManager().persist(entity);
            getEntityManager().flush();
        }
    }

    /**
     * 
     * @param entity 
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * 
     * @param entity 
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * 
     * @param id
     * @return 
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * 
     * @return 
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * 
     * @param range
     * @return 
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * 
     * @return 
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     *
     * @param fieldname
     * @param value
     * @return
     */
    public List<T> findFieldWithValue(String fieldname, String value) {
        return getEntityManager().createQuery(
                "SELECT c FROM " + entityClass.getSimpleName() + " c WHERE c." + fieldname.toLowerCase() + " LIKE :" + fieldname.toLowerCase())
                .setParameter(fieldname.toLowerCase(), value)
                .getResultList();
    }

}
