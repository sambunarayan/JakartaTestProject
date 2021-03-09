/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author soyou
 */
@Entity
@Table(name = "JBATCH_TEST")
@NamedQueries({
    @NamedQuery(name = "JbatchTest.findAll", query = "SELECT j FROM JbatchTest j"),
    @NamedQuery(name = "JbatchTest.findById", query = "SELECT j FROM JbatchTest j WHERE j.id = :id"),
    @NamedQuery(name = "JbatchTest.findByName", query = "SELECT j FROM JbatchTest j WHERE j.name = :name")})
public class JbatchTest implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;

    public JbatchTest() {
    }

    public JbatchTest(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public JbatchTest(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof JbatchTest)) {
            return false;
        }
        JbatchTest other = (JbatchTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.jeu.jbatch.entity.JbatchTest[ id=" + id + " ]";
    }

}
