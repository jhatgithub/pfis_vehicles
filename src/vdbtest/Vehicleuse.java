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
@Table(name = "vehicleuse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicleuse.findAll", query = "SELECT v FROM Vehicleuse v"),
    @NamedQuery(name = "Vehicleuse.findByVUseId", query = "SELECT v FROM Vehicleuse v WHERE v.vUseId = :vUseId"),
    @NamedQuery(name = "Vehicleuse.findByUseDescription", query = "SELECT v FROM Vehicleuse v WHERE v.useDescription = :useDescription")})
public class Vehicleuse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vUseId")
    private Integer vUseId;
    @Basic(optional = false)
    @Column(name = "useDescription")
    private String useDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vUseId")
    private Collection<Vehiclemaster> vehiclemasterCollection;

    public Vehicleuse() {
    }

    public Vehicleuse(Integer vUseId) {
        this.vUseId = vUseId;
    }

    public Vehicleuse(Integer vUseId, String useDescription) {
        this.vUseId = vUseId;
        this.useDescription = useDescription;
    }

    public Integer getVUseId() {
        return vUseId;
    }

    public void setVUseId(Integer vUseId) {
        this.vUseId = vUseId;
    }

    public String getUseDescription() {
        return useDescription;
    }

    public void setUseDescription(String useDescription) {
        this.useDescription = useDescription;
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
        hash += (vUseId != null ? vUseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicleuse)) {
            return false;
        }
        Vehicleuse other = (Vehicleuse) object;
        if ((this.vUseId == null && other.vUseId != null) || (this.vUseId != null && !this.vUseId.equals(other.vUseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vdbtest.Vehicleuse[ vUseId=" + vUseId + " ]";
    }
    
}
