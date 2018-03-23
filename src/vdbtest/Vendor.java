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
import javax.persistence.Lob;
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
@Table(name = "vendor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v"),
    @NamedQuery(name = "Vendor.findByVendorId", query = "SELECT v FROM Vendor v WHERE v.vendorId = :vendorId"),
    @NamedQuery(name = "Vendor.findByName", query = "SELECT v FROM Vendor v WHERE v.name = :name"),
    @NamedQuery(name = "Vendor.findByAddress1", query = "SELECT v FROM Vendor v WHERE v.address1 = :address1"),
    @NamedQuery(name = "Vendor.findByAddress2", query = "SELECT v FROM Vendor v WHERE v.address2 = :address2"),
    @NamedQuery(name = "Vendor.findByZip", query = "SELECT v FROM Vendor v WHERE v.zip = :zip"),
    @NamedQuery(name = "Vendor.findByContact", query = "SELECT v FROM Vendor v WHERE v.contact = :contact"),
    @NamedQuery(name = "Vendor.findByPhone", query = "SELECT v FROM Vendor v WHERE v.phone = :phone"),
    @NamedQuery(name = "Vendor.findByFax", query = "SELECT v FROM Vendor v WHERE v.fax = :fax")})
public class Vendor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vendorId")
    private Integer vendorId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "zip")
    private String zip;
    @Column(name = "contact")
    private String contact;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendorId")
    private Collection<Vehiclemaster> vehiclemasterCollection;

    public Vendor() {
    }

    public Vendor(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Vendor(Integer vendorId, String name) {
        this.vendorId = vendorId;
        this.name = name;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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
        hash += (vendorId != null ? vendorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) object;
        if ((this.vendorId == null && other.vendorId != null) || (this.vendorId != null && !this.vendorId.equals(other.vendorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vdbtest.Vendor[ vendorId=" + vendorId + " ]";
    }
    
}
