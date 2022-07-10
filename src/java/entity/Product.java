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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByIDProd", query = "SELECT p FROM Product p WHERE p.iDProd = :iDProd"),
    @NamedQuery(name = "Product.findByTenSanPham", query = "SELECT p FROM Product p WHERE p.tenSanPham = :tenSanPham"),
    @NamedQuery(name = "Product.findByHinhAnh", query = "SELECT p FROM Product p WHERE p.hinhAnh = :hinhAnh"),
    @NamedQuery(name = "Product.findByGiaBan", query = "SELECT p FROM Product p WHERE p.giaBan = :giaBan"),
    @NamedQuery(name = "Product.findByGiaThue", query = "SELECT p FROM Product p WHERE p.giaThue = :giaThue"),
    @NamedQuery(name = "Product.findByIDCat", query = "SELECT p FROM Product p WHERE p.iDCat = :iDCat"),
    @NamedQuery(name = "Product.findByThuoctinh", query = "SELECT p FROM Product p WHERE p.thuoctinh = :thuoctinh"),
    @NamedQuery(name = "Product.findByMau", query = "SELECT p FROM Product p WHERE p.mau = :mau"),
    @NamedQuery(name = "Product.findByTinhTrang", query = "SELECT p FROM Product p WHERE p.tinhTrang = :tinhTrang")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Prod")
    private String iDProd;
    @Basic(optional = false)
    @Column(name = "Ten_San_Pham")
    private String tenSanPham;
    @Column(name = "Hinh_Anh")
    private String hinhAnh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia_Ban")
    private Double giaBan;
    @Column(name = "Gia_Thue")
    private Double giaThue;
    @Column(name = "ID_Cat")
    private String iDCat;
    @Column(name = "Thuoc_tinh")
    private String thuoctinh;
    @Basic(optional = false)
    @Column(name = "Mau")
    private String mau;
    @Basic(optional = false)
    @Column(name = "Tinh_Trang")
    private String tinhTrang;

    public Product() {
    }

    public Product(String iDProd) {
        this.iDProd = iDProd;
    }

    public Product(String iDProd, String tenSanPham, String mau, String tinhTrang) {
        this.iDProd = iDProd;
        this.tenSanPham = tenSanPham;
        this.mau = mau;
        this.tinhTrang = tinhTrang;
    }

    public String getIDProd() {
        return iDProd;
    }

    public void setIDProd(String iDProd) {
        this.iDProd = iDProd;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Double getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(Double giaThue) {
        this.giaThue = giaThue;
    }

    public String getIDCat() {
        return iDCat;
    }

    public void setIDCat(String iDCat) {
        this.iDCat = iDCat;
    }

    public String getThuoctinh() {
        return thuoctinh;
    }

    public void setThuoctinh(String thuoctinh) {
        this.thuoctinh = thuoctinh;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProd != null ? iDProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.iDProd == null && other.iDProd != null) || (this.iDProd != null && !this.iDProd.equals(other.iDProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ iDProd=" + iDProd + " ]";
    }
    
}
