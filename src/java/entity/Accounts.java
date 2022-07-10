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
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByIDAccount", query = "SELECT a FROM Accounts a WHERE a.iDAccount = :iDAccount"),
    @NamedQuery(name = "Accounts.findByEmail", query = "SELECT a FROM Accounts a WHERE a.email = :email"),
    @NamedQuery(name = "Accounts.findByUserName", query = "SELECT a FROM Accounts a WHERE a.userName = :userName"),
    @NamedQuery(name = "Accounts.findByPassWord1", query = "SELECT a FROM Accounts a WHERE a.passWord1 = :passWord1"),
    @NamedQuery(name = "Accounts.findByQuyen", query = "SELECT a FROM Accounts a WHERE a.quyen = :quyen")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Account")
    private String iDAccount;
    @Column(name = "Email")
    private String email;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "PassWord1")
    private String passWord1;
    @Column(name = "Quyen")
    private String quyen;

    public Accounts() {
    }

    public Accounts(String iDAccount) {
        this.iDAccount = iDAccount;
    }

    public String getIDAccount() {
        return iDAccount;
    }

    public void setIDAccount(String iDAccount) {
        this.iDAccount = iDAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord1() {
        return passWord1;
    }

    public void setPassWord1(String passWord1) {
        this.passWord1 = passWord1;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAccount != null ? iDAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.iDAccount == null && other.iDAccount != null) || (this.iDAccount != null && !this.iDAccount.equals(other.iDAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Accounts[ iDAccount=" + iDAccount + " ]";
    }
    
}
