/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thanh
 */
@Entity
@Table(name = "detail_cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailCart.findAll", query = "SELECT d FROM DetailCart d"),
    @NamedQuery(name = "DetailCart.findByIDDetailCart", query = "SELECT d FROM DetailCart d WHERE d.iDDetailCart = :iDDetailCart"),
    @NamedQuery(name = "DetailCart.findByIDCart", query = "SELECT d FROM DetailCart d WHERE d.iDCart = :iDCart"),
    @NamedQuery(name = "DetailCart.findByIDProd", query = "SELECT d FROM DetailCart d WHERE d.iDProd = :iDProd"),
    @NamedQuery(name = "DetailCart.findBySoLuong", query = "SELECT d FROM DetailCart d WHERE d.soLuong = :soLuong"),
    @NamedQuery(name = "DetailCart.findByDonGia", query = "SELECT d FROM DetailCart d WHERE d.donGia = :donGia")})
public class DetailCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DetailCart")
    private String iDDetailCart;
    @Column(name = "ID_Cart")
    private String iDCart;
    @Column(name = "ID_Prod")
    private String iDProd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "So_Luong")
    private Double soLuong;
    @Column(name = "Don_Gia")
    private Double donGia;

    public DetailCart() {
    }

    public DetailCart(String iDDetailCart) {
        this.iDDetailCart = iDDetailCart;
    }

    public String getIDDetailCart() {
        return iDDetailCart;
    }

    public void setIDDetailCart(String iDDetailCart) {
        this.iDDetailCart = iDDetailCart;
    }

    public String getIDCart() {
        return iDCart;
    }

    public void setIDCart(String iDCart) {
        this.iDCart = iDCart;
    }

    public String getIDProd() {
        return iDProd;
    }

    public void setIDProd(String iDProd) {
        this.iDProd = iDProd;
    }

    public Double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Double soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDetailCart != null ? iDDetailCart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailCart)) {
            return false;
        }
        DetailCart other = (DetailCart) object;
        if ((this.iDDetailCart == null && other.iDDetailCart != null) || (this.iDDetailCart != null && !this.iDDetailCart.equals(other.iDDetailCart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetailCart[ iDDetailCart=" + iDDetailCart + " ]";
    }
    
}
