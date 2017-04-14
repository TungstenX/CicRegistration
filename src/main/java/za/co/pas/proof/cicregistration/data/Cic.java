/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.pas.proof.cicregistration.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "cic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cic.findAll", query = "SELECT c FROM Cic c")
    , @NamedQuery(name = "Cic.findByCicid", query = "SELECT c FROM Cic c WHERE c.cicid = :cicid")
    , @NamedQuery(name = "Cic.findByCicType", query = "SELECT c FROM Cic c WHERE c.cicType = :cicType")
    , @NamedQuery(name = "Cic.findBySubject", query = "SELECT c FROM Cic c WHERE c.subject = :subject")
    , @NamedQuery(name = "Cic.findBySourceSystem", query = "SELECT c FROM Cic c WHERE c.sourceSystem = :sourceSystem")
    , @NamedQuery(name = "Cic.findByCicTimestamp", query = "SELECT c FROM Cic c WHERE c.cicTimestamp = :cicTimestamp")})
public class Cic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cicid")
    private Integer cicid;
    @Size(max = 45)
    @Column(name = "cicType")
    private String cicType;
    @Size(max = 45)
    @Column(name = "subject")
    private String subject;
    @Lob
    @Size(max = 65535)
    @Column(name = "body")
    private String body;
    @Size(max = 45)
    @Column(name = "sourceSystem")
    private String sourceSystem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cicTimestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cicTimestamp;
    @JoinTable(name = "cic_entity", joinColumns = {
        @JoinColumn(name = "cicid", referencedColumnName = "cicid")}, inverseJoinColumns = {
        @JoinColumn(name = "entityid", referencedColumnName = "entityId")})
    @ManyToMany
    private Collection<za.co.pas.proof.cicregistration.data.Entity> entityCollection;

    public Cic() {
    }

    public Cic(Integer cicid) {
        this.cicid = cicid;
    }

    public Cic(Integer cicid, Date cicTimestamp) {
        this.cicid = cicid;
        this.cicTimestamp = cicTimestamp;
    }

    public Integer getCicid() {
        return cicid;
    }

    public void setCicid(Integer cicid) {
        this.cicid = cicid;
    }

    public String getCicType() {
        return cicType;
    }

    public void setCicType(String cicType) {
        this.cicType = cicType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public Date getCicTimestamp() {
        return cicTimestamp;
    }

    public void setCicTimestamp(Date cicTimestamp) {
        this.cicTimestamp = cicTimestamp;
    }

    @XmlTransient
    public Collection<za.co.pas.proof.cicregistration.data.Entity> getEntityCollection() {
        return entityCollection;
    }

    public void setEntityCollection(Collection<za.co.pas.proof.cicregistration.data.Entity> entityCollection) {
        this.entityCollection = entityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cicid != null ? cicid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cic)) {
            return false;
        }
        Cic other = (Cic) object;
        if ((this.cicid == null && other.cicid != null) || (this.cicid != null && !this.cicid.equals(other.cicid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.pas.proof.cicregistration.data.Cic[ cicid=" + cicid + " ]";
    }
    
}
