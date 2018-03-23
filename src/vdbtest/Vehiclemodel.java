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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vehiclemodel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiclemodel.findAll", query = "SELECT v FROM Vehiclemodel v"),
    @NamedQuery(name = "Vehiclemodel.findByModelId", query = "SELECT v FROM Vehiclemodel v WHERE v.modelId = :modelId"),
    @NamedQuery(name = "Vehiclemodel.findByVName", query = "SELECT v FROM Vehiclemodel v WHERE v.vName = :vName"),
    @NamedQuery(name = "Vehiclemodel.findByDescription", query = "SELECT v FROM Vehiclemodel v WHERE v.description = :description"),
    @NamedQuery(name = "Vehiclemodel.findByBodyType", query = "SELECT v FROM Vehiclemodel v WHERE v.bodyType = :bodyType")})
public class Vehiclemodel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "modelId")
    private Integer modelId;
    @Basic(optional = false)
    @Column(name = "vName")
    private String vName;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "bodyType")
    private String bodyType;
    @JoinColumn(name = "mfgId", referencedColumnName = "mfgId")
    @ManyToOne(optional = false)
    private Vehiclemfg mfgId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelId")
    private Collection<Vehiclemaster> vehiclemasterCollection;

    public Vehiclemodel() {
    }

    public Vehiclemodel(Integer modelId) {
        this.modelId = modelId;
    }

    public Vehiclemodel(Integer modelId, String vName, String description, String bodyType) {
        this.modelId = modelId;
        this.vName = vName;
        this.description = description;
        this.bodyType = bodyType;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Vehiclemfg getMfgId() {
        return mfgId;
    }

    public void setMfgId(Vehiclemfg mfgId) {
        this.mfgId = mfgId;
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
        hash += (modelId != null ? modelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiclemodel)) {
            return false;
        }
        Vehiclemodel other = (Vehiclemodel) object;
        if ((this.modelId == null && other.modelId != null) || (this.modelId != null && !this.modelId.equals(other.modelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vdbtest.Vehiclemodel[ modelId=" + modelId + " ]";
    }
    
}
