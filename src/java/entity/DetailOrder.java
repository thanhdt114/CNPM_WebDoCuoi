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
@Table(name = "detail_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailOrder.findAll", query = "SELECT d FROM DetailOrder d"),
    @NamedQuery(name = "DetailOrder.findByIDDetailOrder", query = "SELECT d FROM DetailOrder d WHERE d.iDDetailOrder = :iDDetailOrder"),
    @NamedQuery(name = "DetailOrder.findByIDOrder", query = "SELECT d FROM DetailOrder d WHERE d.iDOrder = :iDOrder"),
    @NamedQuery(name = "DetailOrder.findByIDProd", query = "SELECT d FROM DetailOrder d WHERE d.iDProd = :iDProd"),
    @NamedQuery(name = "DetailOrder.findBySoLuong", query = "SELECT d FROM DetailOrder d WHERE d.soLuong = :soLuong"),
    @NamedQuery(name = "DetailOrder.findByDonGia", query = "SELECT d FROM DetailOrder d WHERE d.donGia = :donGia")})
public class DetailOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DetailOrder")
    private String iDDetailOrder;
    @Column(name = "ID_Order")
    private String iDOrder;
    @Column(name = "ID_Prod")
    private String iDProd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "So_Luong")
    private Double soLuong;
    @Column(name = "Don_Gia")
    private Double donGia;

    public DetailOrder() {
    }

    public DetailOrder(String iDDetailOrder) {
        this.iDDetailOrder = iDDetailOrder;
    }

    public String getIDDetailOrder() {
        return iDDetailOrder;
    }

    public void setIDDetailOrder(String iDDetailOrder) {
        this.iDDetailOrder = iDDetailOrder;
    }

    public String getIDOrder() {
        return iDOrder;
    }

    public void setIDOrder(String iDOrder) {
        this.iDOrder = iDOrder;
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
        hash += (iDDetailOrder != null ? iDDetailOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailOrder)) {
            return false;
        }
        DetailOrder other = (DetailOrder) object;
        if ((this.iDDetailOrder == null && other.iDDetailOrder != null) || (this.iDDetailOrder != null && !this.iDDetailOrder.equals(other.iDDetailOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetailOrder[ iDDetailOrder=" + iDDetailOrder + " ]";
    }
    
}
