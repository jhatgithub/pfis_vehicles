/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vdbtest;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhughes
 */
@Entity
@Table(name = "vehiclemfg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiclemfg.findAll", query = "SELECT v FROM Vehiclemfg v"),
    @NamedQuery(name = "Vehiclemfg.findByMfgId", query = "SELECT v FROM Vehiclemfg v WHERE v.mfgId = :mfgId"),
    @NamedQuery(name = "Vehiclemfg.findByMfgName", query = "SELECT v FROM Vehiclemfg v WHERE v.mfgName = :mfgName")})
public class Vehiclemfg implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mfgId")
    private Integer mfgId;
    @Basic(optional = false)
    @Column(name = "mfgName")
    private String mfgName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mfgId")
    private Collection<Vehiclemodel> vehiclemodelCollection;

    public Vehiclemfg() {
    }

    public Vehiclemfg(Integer mfgId) {
        this.mfgId = mfgId;
    }

    public Vehiclemfg(Integer mfgId, String mfgName) {
        this.mfgId = mfgId;
        this.mfgName = mfgName;
    }

    public Integer getMfgId() {
        return mfgId;
    }

    public void setMfgId(Integer mfgId) {
        Integer oldMfgId = this.mfgId;
        this.mfgId = mfgId;
        changeSupport.firePropertyChange("mfgId", oldMfgId, mfgId);
    }

    public String getMfgName() {
        return mfgName;
    }

    public void setMfgName(String mfgName) {
        String oldMfgName = this.mfgName;
        this.mfgName = mfgName;
        changeSupport.firePropertyChange("mfgName", oldMfgName, mfgName);
    }

    @XmlTransient
    public Collection<Vehiclemodel> getVehiclemodelCollection() {
        return vehiclemodelCollection;
    }

    public void setVehiclemodelCollection(Collection<Vehiclemodel> vehiclemodelCollection) {
        this.vehiclemodelCollection = vehiclemodelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mfgId != null ? mfgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiclemfg)) {
            return false;
        }
        Vehiclemfg other = (Vehiclemfg) object;
        if ((this.mfgId == null && other.mfgId != null) || (this.mfgId != null && !this.mfgId.equals(other.mfgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vdbtest.Vehiclemfg[ mfgId=" + mfgId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
