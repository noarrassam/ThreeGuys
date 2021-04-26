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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author noorr
 */
@Entity
@Table(name = "Cars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c"),
    @NamedQuery(name = "Cars.findById", query = "SELECT c FROM Cars c WHERE c.id = :id"),
    @NamedQuery(name = "Cars.findByModel", query = "SELECT c FROM Cars c WHERE c.model = :model"),
    @NamedQuery(name = "Cars.findByYear", query = "SELECT c FROM Cars c WHERE c.year = :year"),
    @NamedQuery(name = "Cars.findByPrice", query = "SELECT c FROM Cars c WHERE c.price = :price"),
    @NamedQuery(name = "Cars.findByFeedId", query = "SELECT c FROM Cars c WHERE c.feedId = :feedId"),
    @NamedQuery(name = "Cars.findByType", query = "SELECT c FROM Cars c WHERE c.type = :type"),
    @NamedQuery(name = "Cars.findByBrand", query = "SELECT c FROM Cars c WHERE c.brand = :brand"),
    @NamedQuery(name = "Cars.findByTransmission", query = "SELECT c FROM Cars c WHERE c.transmission = :transmission"),
    @NamedQuery(name = "Cars.findByEngine", query = "SELECT c FROM Cars c WHERE c.engine = :engine"),
    @NamedQuery(name = "Cars.findByDisplacement", query = "SELECT c FROM Cars c WHERE c.displacement = :displacement"),
    @NamedQuery(name = "Cars.findByMaxRPM", query = "SELECT c FROM Cars c WHERE c.maxRPM = :maxRPM")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "id")
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Size(max = 45)
    @Column(name = "model")
    private String model;
    @Column(name = "filename")
    private String Filename;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Column(name = "year")
    private Integer year;
    @Column(name = "price")
    private Integer price;
    @Column(name = "feedId")
    private Integer feedId;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @Size(max = 50)
    @Column(name = "brand")
    private String brand;
    @Size(max = 60)
    @Column(name = "transmission")
    private String transmission;
    @Size(max = 50)
    @Column(name = "engine")
    private String engine;
    @Size(max = 50)
    @Column(name = "displacement")
    private String displacement;
    @Size(max = 50)
    @Column(name = "maxRPM")
    private String maxRPM;

    public Cars() {
    }

    public Cars(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String Filename) {
        this.Filename = Filename;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFeedId() {
        return feedId;
    }

    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
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

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.threeguys.entites.Cars[ id=" + id + " ]";
    }
    
}
