/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threeguys.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mint
 */
@Entity
@Table(name = "cars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c"),
    @NamedQuery(name = "Cars.findByCarID", query = "SELECT c FROM Cars c WHERE c.carID = :carID"),
    @NamedQuery(name = "Cars.findByType", query = "SELECT c FROM Cars c WHERE c.type = :type"),
    @NamedQuery(name = "Cars.findByBrand", query = "SELECT c FROM Cars c WHERE c.brand = :brand"),
    @NamedQuery(name = "Cars.findByModel", query = "SELECT c FROM Cars c WHERE c.model = :model"),
    @NamedQuery(name = "Cars.findByYear", query = "SELECT c FROM Cars c WHERE c.year = :year"),
    @NamedQuery(name = "Cars.findByTransmission", query = "SELECT c FROM Cars c WHERE c.transmission = :transmission"),
    @NamedQuery(name = "Cars.findByEngine", query = "SELECT c FROM Cars c WHERE c.engine = :engine"),
    @NamedQuery(name = "Cars.findByDisplacement", query = "SELECT c FROM Cars c WHERE c.displacement = :displacement"),
    @NamedQuery(name = "Cars.findByMaxRPM", query = "SELECT c FROM Cars c WHERE c.maxRPM = :maxRPM")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "carID")
    private Integer carID;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 45)
    @Column(name = "brand")
    private String brand;
    @Size(max = 45)
    @Column(name = "model")
    private String model;
    @Size(max = 45)
    @Column(name = "year")
    private String year;
    @Size(max = 45)
    @Column(name = "transmission")
    private String transmission;
    @Size(max = 45)
    @Column(name = "engine")
    private String engine;
    @Column(name = "displacement")
    private Integer displacement;
    @Size(max = 45)
    @Column(name = "maxRPM")
    private String maxRPM;

    public Cars() {
    }

    public Cars(Integer carID) {
        this.carID = carID;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    public String getMaxRPM() {
        return maxRPM;
    }

    public void setMaxRPM(String maxRPM) {
        this.maxRPM = maxRPM;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carID != null ? carID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.carID == null && other.carID != null) || (this.carID != null && !this.carID.equals(other.carID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.threeguyswebservice.Cars[ carID=" + carID + " ]";
    }
    
}
