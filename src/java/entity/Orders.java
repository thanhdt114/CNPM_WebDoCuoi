/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thanh
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByIDOrder", query = "SELECT o FROM Orders o WHERE o.iDOrder = :iDOrder"),
    @NamedQuery(name = "Orders.findByEmail", query = "SELECT o FROM Orders o WHERE o.email = :email"),
    @NamedQuery(name = "Orders.findByTenNguoiNhan", query = "SELECT o FROM Orders o WHERE o.tenNguoiNhan = :tenNguoiNhan"),
    @NamedQuery(name = "Orders.findByDiaChi", query = "SELECT o FROM Orders o WHERE o.diaChi = :diaChi"),
    @NamedQuery(name = "Orders.findBySoDienThoai", query = "SELECT o FROM Orders o WHERE o.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "Orders.findByNgayDatHang", query = "SELECT o FROM Orders o WHERE o.ngayDatHang = :ngayDatHang"),
    @NamedQuery(name = "Orders.findByThanhTien", query = "SELECT o FROM Orders o WHERE o.thanhTien = :thanhTien"),
    @NamedQuery(name = "Orders.findByTinhtrang", query = "SELECT o FROM Orders o WHERE o.tinhtrang = :tinhtrang")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Order")
    private String iDOrder;
    @Column(name = "Email")
    private String email;
    @Column(name = "Ten_Nguoi_Nhan")
    private String tenNguoiNhan;
    @Column(name = "Dia_Chi")
    private String diaChi;
    @Column(name = "So_Dien_Thoai")
    private String soDienThoai;
    @Column(name = "Ngay_Dat_Hang")
    @Temporal(TemporalType.DATE)
    private Date ngayDatHang;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Thanh_Tien")
    private Double thanhTien;
    @Column(name = "Tinh_trang")
    private String tinhtrang;

    public Orders() {
    }

    public Orders(String iDOrder) {
        this.iDOrder = iDOrder;
    }

    public String getIDOrder() {
        return iDOrder;
    }

    public void setIDOrder(String iDOrder) {
        this.iDOrder = iDOrder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOrder != null ? iDOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.iDOrder == null && other.iDOrder != null) || (this.iDOrder != null && !this.iDOrder.equals(other.iDOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orders[ iDOrder=" + iDOrder + " ]";
    }
    
}
