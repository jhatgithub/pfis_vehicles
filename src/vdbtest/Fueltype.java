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
@Table(name = "fueltype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fueltype.findAll", query = "SELECT f FROM Fueltype f"),
    @NamedQuery(name = "Fueltype.findByFuelTypeId", query = "SELECT f FROM Fueltype f WHERE f.fuelTypeId = :fuelTypeId"),
    @NamedQuery(name = "Fueltype.findByFuelTypeDesc", query = "SELECT f FROM Fueltype f WHERE f.fuelTypeDesc = :fuelTypeDesc")})
public class Fueltype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fuelTypeId")
    private Integer fuelTypeId;
    @Basic(optional = false)
    @Column(name = "fuelTypeDesc")
    private String fuelTypeDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuelTypeId")
    private Collection<Vehiclemaster> vehiclemasterCollection;

    public Fueltype() {
    }

    public Fueltype(Integer fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public Fueltype(Integer fuelTypeId, String fuelTypeDesc) {
        this.fuelTypeId = fuelTypeId;
        this.fuelTypeDesc = fuelTypeDesc;
    }

    public Integer getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Integer fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelTypeDesc() {
        return fuelTypeDesc;
    }

    public void setFuelTypeDesc(String fuelTypeDesc) {
        this.fuelTypeDesc = fuelTypeDesc;
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
        hash += (fuelTypeId != null ? fuelTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fueltype)) {
            return false;
        }
        Fueltype other = (Fueltype) object;
        if ((this.fuelTypeId == null && other.fuelTypeId != null) || (this.fuelTypeId != null && !this.fuelTypeId.equals(other.fuelTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vdbtest.Fueltype[ fuelTypeId=" + fuelTypeId + " ]";
    }
    
}
