package za.co.pas.proof.cicregistration.data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Auto gen entity; here is how I cheated:
 * <p>
 * <ul>
 * <li>Create tables in MySql according to specified UML</li>
 * <li>Use Netbeans to create entities using database tables</li>
 * <li>Hack persistence.xml to create tables in H2</li>
 * <li>Ta-da!</li>
 * </ul>
 *
 * @author Andre Labuschagne
 */
@javax.persistence.Entity
@Table(name = "entity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entity.findAll", query = "SELECT e FROM Entity e")
    , @NamedQuery(name = "Entity.findByEntityId", query = "SELECT e FROM Entity e WHERE e.entityId = :entityId")
    , @NamedQuery(name = "Entity.findByEntityName", query = "SELECT e FROM Entity e WHERE e.entityName = :entityName")
    , @NamedQuery(name = "Entity.findByEmailAddress", query = "SELECT e FROM Entity e WHERE e.emailAddress = :emailAddress")})
public class Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entityId")
    private Integer entityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "entityName")
    private String entityName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "emailAddress")
    private String emailAddress;
    //Maybe this should be One to Many...
    @ManyToMany(mappedBy = "entityCollection")
    private Collection<Cic> cicCollection;

    public Entity() {
    }

    public Entity(Integer entityId) {
        this.entityId = entityId;
    }

    public Entity(Integer entityId, String entityName, String emailAddress) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.emailAddress = emailAddress;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @XmlTransient
    public Collection<Cic> getCicCollection() {
        return cicCollection;
    }

    public void setCicCollection(Collection<Cic> cicCollection) {
        this.cicCollection = cicCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entityId != null ? entityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entity)) {
            return false;
        }
        Entity other = (Entity) object;
        if ((this.entityId == null && other.entityId != null) || (this.entityId != null && !this.entityId.equals(other.entityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.pas.proof.cicregistration.data.Entity[ entityId=" + entityId + " ]";
    }

}
