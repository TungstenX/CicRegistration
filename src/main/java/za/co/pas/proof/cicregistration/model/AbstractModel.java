package za.co.pas.proof.cicregistration.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.jboss.logging.Logger;

/**
 * Generic model functionality for persistence layer
 *
 * @author Andre Labuschange
 */
public abstract class AbstractModel<T> {

    private static final Logger LOG = Logger.getLogger(AbstractModel.class.getName());

    private final Class<T> entityClass;

    public AbstractModel(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * To be implemented by my children, mwhahaha!
     * <p>
     * It also allows my children to use different entity manages, and thus
     * different databases.
     *
     * @return an entity manager
     */
    public abstract EntityManager getEntityManager();

    /**
     * Insert newly create entity, it does check for constraint violations
     *
     * @param entity the entity to be inserted
     */
    public void create(T entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            StringBuilder sbLog = new StringBuilder("Error while inserting into database: \n");
            while (iterator.hasNext()) {
                ConstraintViolation<T> cv = iterator.next();
                sbLog.append("\t")
                        .append(cv.getRootBeanClass().getName())
                        .append(".")
                        .append(cv.getPropertyPath())
                        .append(" ")
                        .append(cv.getMessage()).
                        append("\n");
            }
            LOG.error(sbLog.toString());
            throw new ConstraintViolationException(sbLog.toString(), new HashSet<ConstraintViolation<?>>(constraintViolations));
        } else {
            getEntityManager().persist(entity);
            getEntityManager().flush();
        }
    }

    /**
     * Update an entity
     *
     * @param entity the entity
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * Removes an entity
     *
     * @param entity the entity
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Get the entity using its id field
     *
     * @param id the id to use
     * @return the entity
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Find all the entities for this table
     *
     * @return a list of entities
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Get a list of entities using a field and a value. It uses LIKE, this is
     * an issue when the value is not string
     *
     * @param fieldname the table field name, entity member
     * @param value the value to get
     * @return a list of entities
     */
    public List<T> findFieldWithValue(String fieldname, String value) {
        String sql = new StringBuilder("SELECT c FROM ")
                .append(entityClass.getSimpleName())
                .append(" c WHERE c.")
                .append(fieldname)
                .append(" LIKE :")
                .append(fieldname).toString();
        LOG.info(sql);
        return getEntityManager().createQuery(
                sql)
                .setParameter(fieldname, value)
                .getResultList();
    }
}
