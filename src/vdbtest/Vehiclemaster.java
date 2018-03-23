/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vdbtest;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhughes
 */
@Entity
@Table(name = "vehiclemaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiclemaster.findAll", query = "SELECT v FROM Vehiclemaster v"),
    @NamedQuery(name = "Vehiclemaster.findByVmid", query = "SELECT v FROM Vehiclemaster v WHERE v.vmid = :vmid"),
    @NamedQuery(name = "Vehiclemaster.findByByuKey", query = "SELECT v FROM Vehiclemaster v WHERE v.byuKey = :byuKey"),
    @NamedQuery(name = "Vehiclemaster.findByVin", query = "SELECT v FROM Vehiclemaster v WHERE v.vin = :vin"),
    @NamedQuery(name = "Vehiclemaster.findByVYear", query = "SELECT v FROM Vehiclemaster v WHERE v.vYear = :vYear"),
    @NamedQuery(name = "Vehiclemaster.findByLicenseNo", query = "SELECT v FROM Vehiclemaster v WHERE v.licenseNo = :licenseNo"),
    @NamedQuery(name = "Vehiclemaster.findByLicenseExp", query = "SELECT v FROM Vehiclemaster v WHERE v.licenseExp = :licenseExp"),
    @NamedQuery(name = "Vehiclemaster.findByByuInventoryNo", query = "SELECT v FROM Vehiclemaster v WHERE v.byuInventoryNo = :byuInventoryNo"),
    @NamedQuery(name = "Vehiclemaster.findByTitleNumber", query = "SELECT v FROM Vehiclemaster v WHERE v.titleNumber = :titleNumber"),
    @NamedQuery(name = "Vehiclemaster.findByKeyCodes", query = "SELECT v FROM Vehiclemaster v WHERE v.keyCodes = :keyCodes"),
    @NamedQuery(name = "Vehiclemaster.findByColor", query = "SELECT v FROM Vehiclemaster v WHERE v.color = :color"),
    @NamedQuery(name = "Vehiclemaster.findByTireSize", query = "SELECT v FROM Vehiclemaster v WHERE v.tireSize = :tireSize"),
    @NamedQuery(name = "Vehiclemaster.findByCylinders", query = "SELECT v FROM Vehiclemaster v WHERE v.cylinders = :cylinders"),
    @NamedQuery(name = "Vehiclemaster.findByVehicleMastercol", query = "SELECT v FROM Vehiclemaster v WHERE v.vehicleMastercol = :vehicleMastercol"),
    @NamedQuery(name = "Vehiclemaster.findByCna", query = "SELECT v FROM Vehiclemaster v WHERE v.cna = :cna"),
    @NamedQuery(name = "Vehiclemaster.findByParkingStall", query = "SELECT v FROM Vehiclemaster v WHERE v.parkingStall = :parkingStall"),
    @NamedQuery(name = "Vehiclemaster.findByLicenseWeight", query = "SELECT v FROM Vehiclemaster v WHERE v.licenseWeight = :licenseWeight"),
    @NamedQuery(name = "Vehiclemaster.findByVehicleWeight", query = "SELECT v FROM Vehiclemaster v WHERE v.vehicleWeight = :vehicleWeight"),
    @NamedQuery(name = "Vehiclemaster.findByGvwr", query = "SELECT v FROM Vehiclemaster v WHERE v.gvwr = :gvwr"),
    @NamedQuery(name = "Vehiclemaster.findByInitialCost", query = "SELECT v FROM Vehiclemaster v WHERE v.initialCost = :initialCost"),
    @NamedQuery(name = "Vehiclemaster.findByDateReceived", query = "SELECT v FROM Vehiclemaster v WHERE v.dateReceived = :dateReceived"),
    @NamedQuery(name = "Vehiclemaster.findByDateInUse", query = "SELECT v FROM Vehiclemaster v WHERE v.dateInUse = :dateInUse"),
    @NamedQuery(name = "Vehiclemaster.findByInitialOdom", query = "SELECT v FROM Vehiclemaster v WHERE v.initialOdom = :initialOdom"),
    @NamedQuery(name = "Vehiclemaster.findByNameAssigned", query = "SELECT v FROM Vehiclemaster v WHERE v.nameAssigned = :nameAssigned"),
    @NamedQuery(name = "Vehiclemaster.findByAreaAssigned", query = "SELECT v FROM Vehiclemaster v WHERE v.areaAssigned = :areaAssigned"),
    @NamedQuery(name = "Vehiclemaster.findByContactPerson", query = "SELECT v FROM Vehiclemaster v WHERE v.contactPerson = :contactPerson"),
    @NamedQuery(name = "Vehiclemaster.findByPhone", query = "SELECT v FROM Vehiclemaster v WHERE v.phone = :phone"),
    @NamedQuery(name = "Vehiclemaster.findByRadio", query = "SELECT v FROM Vehiclemaster v WHERE v.radio = :radio"),
    @NamedQuery(name = "Vehiclemaster.findByRentalRate", query = "SELECT v FROM Vehiclemaster v WHERE v.rentalRate = :rentalRate")})
public class Vehiclemaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vmid")
    private Integer vmid;
    @Basic(optional = false)
    @Column(name = "byuKey")
    private String byuKey;
    @Basic(optional = false)
    @Column(name = "vin")
    private String vin;
    @Basic(optional = false)
    @Column(name = "vYear")
    private int vYear;
    @Column(name = "licenseNo")
    private String licenseNo;
    @Column(name = "licenseExp")
    @Temporal(TemporalType.DATE)
    private Date licenseExp;
    @Column(name = "byuInventoryNo")
    private Integer byuInventoryNo;
    @Column(name = "titleNumber")
    private String titleNumber;
    @Column(name = "keyCodes")
    private Integer keyCodes;
    @Column(name = "color")
    private String color;
    @Column(name = "tireSize")
    private String tireSize;
    @Column(name = "cylinders")
    private Short cylinders;
    @Column(name = "VehicleMastercol")
    private String vehicleMastercol;
    @Column(name = "cna")
    private String cna;
    @Column(name = "parkingStall")
    private String parkingStall;
    @Column(name = "licenseWeight")
    private Integer licenseWeight;
    @Column(name = "vehicleWeight")
    private Integer vehicleWeight;
    @Column(name = "gvwr")
    private Integer gvwr;
    @Column(name = "initialCost")
    private Long initialCost;
    @Column(name = "dateReceived")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    @Column(name = "dateInUse")
    @Temporal(TemporalType.DATE)
    private Date dateInUse;
    @Column(name = "initialOdom")
    private Integer initialOdom;
    @Column(name = "nameAssigned")
    private String nameAssigned;
    @Column(name = "areaAssigned")
    private String areaAssigned;
    @Column(name = "contactPerson")
    private String contactPerson;
    @Column(name = "phone")
    private String phone;
    @Column(name = "radio")
    private String radio;
    @Column(name = "rentalRate")
    private Long rentalRate;
    @JoinTable(name = "xvehiclemasterpurchaseorders", joinColumns = {
        @JoinColumn(name = "VehicleMaster_vmid", referencedColumnName = "vmid")}, inverseJoinColumns = {
        @JoinColumn(name = "PurchaseOrders_poNumberId", referencedColumnName = "poNumberId")})
    @ManyToMany
    private Collection<Purchaseorders> purchaseordersCollection;
    @JoinColumn(name = "vUseId", referencedColumnName = "vUseId")
    @ManyToOne(optional = false)
    private Vehicleuse vUseId;
    @JoinColumn(name = "vendorId", referencedColumnName = "vendorId")
    @ManyToOne(optional = false)
    private Vendor vendorId;
    @JoinColumn(name = "transmissionTypeId", referencedColumnName = "transmissionTypeId")
    @ManyToOne(optional = false)
    private Transmissiontype transmissionTypeId;
    @JoinColumn(name = "fuelTypeId", referencedColumnName = "fuelTypeId")
    @ManyToOne(optional = false)
    private Fueltype fuelTypeId;
    @JoinColumn(name = "classId", referencedColumnName = "classId")
    @ManyToOne(optional = false)
    private Class classId;
    @JoinColumn(name = "modelId", referencedColumnName = "modelId")
    @ManyToOne(optional = false)
    private Vehiclemodel modelId;

    public Vehiclemaster() {
    }

    public Vehiclemaster(Integer vmid) {
        this.vmid = vmid;
    }

    public Vehiclemaster(Integer vmid, String byuKey, String vin, int vYear) {
        this.vmid = vmid;
        this.byuKey = byuKey;
        this.vin = vin;
        this.vYear = vYear;
    }

    public Integer getVmid() {
        return vmid;
    }

    public void setVmid(Integer vmid) {
        this.vmid = vmid;
    }

    public String getByuKey() {
        return byuKey;
    }

    public void setByuKey(String byuKey) {
        this.byuKey = byuKey;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getVYear() {
        return vYear;
    }

    public void setVYear(int vYear) {
        this.vYear = vYear;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public Date getLicenseExp() {
        return licenseExp;
    }

    public void setLicenseExp(Date licenseExp) {
        this.licenseExp = licenseExp;
    }

    public Integer getByuInventoryNo() {
        return byuInventoryNo;
    }

    public void setByuInventoryNo(Integer byuInventoryNo) {
        this.byuInventoryNo = byuInventoryNo;
    }

    public String getTitleNumber() {
        return titleNumber;
    }

    public void setTitleNumber(String titleNumber) {
        this.titleNumber = titleNumber;
    }

    public Integer getKeyCodes() {
        return keyCodes;
    }

    public void setKeyCodes(Integer keyCodes) {
        this.keyCodes = keyCodes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTireSize() {
        return tireSize;
    }

    public void setTireSize(String tireSize) {
        this.tireSize = tireSize;
    }

    public Short getCylinders() {
        return cylinders;
    }

    public void setCylinders(Short cylinders) {
        this.cylinders = cylinders;
    }

    public String getVehicleMastercol() {
        return vehicleMastercol;
    }

    public void setVehicleMastercol(String vehicleMastercol) {
        this.vehicleMastercol = vehicleMastercol;
    }

    public String getCna() {
        return cna;
    }

    public void setCna(String cna) {
        this.cna = cna;
    }

    public String getParkingStall() {
        return parkingStall;
    }

    public void setParkingStall(String parkingStall) {
        this.parkingStall = parkingStall;
    }

    public Integer getLicenseWeight() {
        return licenseWeight;
    }

    public void setLicenseWeight(Integer licenseWeight) {
        this.licenseWeight = licenseWeight;
    }

    public Integer getVehicleWeight() {
        return vehicleWeight;
    }

    public void setVehicleWeight(Integer vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }

    public Integer getGvwr() {
        return gvwr;
    }

    public void setGvwr(Integer gvwr) {
        this.gvwr = gvwr;
    }

    public Long getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(Long initialCost) {
        this.initialCost = initialCost;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getDateInUse() {
        return dateInUse;
    }

    public void setDateInUse(Date dateInUse) {
        this.dateInUse = dateInUse;
    }

    public Integer getInitialOdom() {
        return initialOdom;
    }

    public void setInitialOdom(Integer initialOdom) {
        this.initialOdom = initialOdom;
    }

    public String getNameAssigned() {
        return nameAssigned;
    }

    public void setNameAssigned(String nameAssigned) {
        this.nameAssigned = nameAssigned;
    }

    public String getAreaAssigned() {
        return areaAssigned;
    }

    public void setAreaAssigned(String areaAssigned) {
        this.areaAssigned = areaAssigned;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public Long getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Long rentalRate) {
        this.rentalRate = rentalRate;
    }

    @XmlTransient
    public Collection<Purchaseorders> getPurchaseordersCollection() {
        return purchaseordersCollection;
    }

    public void setPurchaseordersCollection(Collection<Purchaseorders> purchaseordersCollection) {
        this.purchaseordersCollection = purchaseordersCollection;
    }

    public Vehicleuse getVUseId() {
        return vUseId;
    }

    public void setVUseId(Vehicleuse vUseId) {
        this.vUseId = vUseId;
    }

    public Vendor getVendorId() {
        return vendorId;
    }

    public void setVendorId(Vendor vendorId) {
        this.vendorId = vendorId;
    }

    public Transmissiontype getTransmissionTypeId() {
        return transmissionTypeId;
    }

    public void setTransmissionTypeId(Transmissiontype transmissionTypeId) {
        this.transmissionTypeId = transmissionTypeId;
    }

    public Fueltype getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Fueltype fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public Class getClassId() {
        return classId;
    }

    public void setClassId(Class classId) {
        this.classId = classId;
    }

    public Vehiclemodel getModelId() {
        return modelId;
    }

    public void setModelId(Vehiclemodel modelId) {
        this.modelId = modelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vmid != null ? vmid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiclemaster)) {
            return false;
        }
        Vehiclemaster other = (Vehiclemaster) object;
        if ((this.vmid == null && other.vmid != null) || (this.vmid != null && !this.vmid.equals(other.vmid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vdbtest.Vehiclemaster[ vmid=" + vmid + " ]";
    }
    
}
