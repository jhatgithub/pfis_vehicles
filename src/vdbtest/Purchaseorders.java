/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vdbtest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhughes
 */
@Entity
@Table(name = "purchaseorders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchaseorders.findAll", query = "SELECT p FROM Purchaseorders p"),
    @NamedQuery(name = "Purchaseorders.findByPoNumberId", query = "SELECT p FROM Purchaseorders p WHERE p.poNumberId = :poNumberId"),
    @NamedQuery(name = "Purchaseorders.findByPoNumber", query = "SELECT p FROM Purchaseorders p WHERE p.poNumber = :poNumber"),
    @NamedQuery(name = "Purchaseorders.findByPoDescription", query = "SELECT p FROM Purchaseorders p WHERE p.poDescription = :poDescription")})
public class Purchaseorders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "poNumberId")
    private Integer poNumberId;
    @Basic(optional = false)
    @Column(name = "poNumber")
    private String poNumber;
    @Column(name = "poDescription")
    private String poDescription;
    @Lob
    @Column(name = "poLongDescription")
    private String poLongDescription;
    @ManyToMany(mappedBy = "purchaseordersCollection")
    private Collection<Vehiclemaster> vehiclemasterCollection;

    public Purchaseorders() {
    }

    public Purchaseorders(Integer poNumberId) {
        this.poNumberId = poNumberId;
    }

    public Purchaseorders(Integer poNumberId, String poNumber) {
        this.poNumberId = poNumberId;
        this.poNumber = poNumber;
    }

    public Integer getPoNumberId() {
        return poNumberId;
    }

    public void setPoNumberId(Integer poNumberId) {
        this.poNumberId = poNumberId;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getPoDescription() {
        return poDescription;
    }

    public void setPoDescription(String poDescription) {
        this.poDescription = poDescription;
    }

    public String getPoLongDescription() {
        return poLongDescription;
    }

    public void setPoLongDescription(String poLongDescription) {
        this.poLongDescription = poLongDescription;
    }

    @XmlTransient
    public Collection<Vehiclemaster> getVehiclemasterCollection() {
        return vehiclemasterCollection;
    }

    public void setVehiclemasterCollection(Collection<Vehiclemaster> vehiclemasterCollection) {
        this.vehiclemasterCollection = vehiclemasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poNumberId != null ? poNumberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchaseorders)) {
            return false;
        }
        Purchaseorders other = (Purchaseorders) object;
        if ((this.poNumberId == null && other.poNumberId != null) || (this.poNumberId != null && !this.poNumberId.equals(other.poNumberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vdbtest.Purchaseorders[ poNumberId=" + poNumberId + " ]";
    }
    
}
