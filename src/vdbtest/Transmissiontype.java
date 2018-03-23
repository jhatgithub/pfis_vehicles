/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vdbtest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhughes
 */
@Entity
@Table(name = "transmissiontype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transmissiontype.findAll", query = "SELECT t FROM Transmissiontype t"),
    @NamedQuery(name = "Transmissiontype.findByTransmissionTypeId", query = "SELECT t FROM Transmissiontype t WHERE t.transmissionTypeId = :transmissionTypeId"),
    @NamedQuery(name = "Transmissiontype.findByDescription", query = "SELECT t FROM Transmissiontype t WHERE t.description = :description")})
public class Transmissiontype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transmissionTypeId")
    private Integer transmissionTypeId;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transmissionTypeId")
    private Collection<Vehiclemaster> vehiclemasterCollection;

    public Transmissiontype() {
    }

    public Transmissiontype(Integer transmissionTypeId) {
        this.transmissionTypeId = transmissionTypeId;
    }

    public Transmissiontype(Integer transmissionTypeId, String description) {
        this.transmissionTypeId = transmissionTypeId;
        this.description = description;
    }

    public Integer getTransmissionTypeId() {
        return transmissionTypeId;
    }

    public void setTransmissionTypeId(Integer transmissionTypeId) {
        this.transmissionTypeId = transmissionTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (transmissionTypeId != null ? transmissionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transmissiontype)) {
            return false;
        }
        Transmissiontype other = (Transmissiontype) object;
        if ((this.transmissionTypeId == null && other.transmissionTypeId != null) || (this.transmissionTypeId != null && !this.transmissionTypeId.equals(other.transmissionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vdbtest.Transmissiontype[ transmissionTypeId=" + transmissionTypeId + " ]";
    }
    
}
