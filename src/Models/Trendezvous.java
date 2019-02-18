/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NDEZE
 */
@Entity
@Table(name = "trendezvous")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trendezvous.findAll", query = "SELECT t FROM Trendezvous t")
    , @NamedQuery(name = "Trendezvous.findByCode", query = "SELECT t FROM Trendezvous t WHERE t.code = :code")
    , @NamedQuery(name = "Trendezvous.findByDateRendeVous", query = "SELECT t FROM Trendezvous t WHERE t.dateRendeVous = :dateRendeVous")})
public class Trendezvous implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private Integer code;
    @Column(name = "DateRendeVous")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRendeVous;
    @JoinColumn(name = "CodeHoraire", referencedColumnName = "Code")
    @ManyToOne
    private Thoraire codeHoraire;

    public Trendezvous() {
    }

    public Trendezvous(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getDateRendeVous() {
        return dateRendeVous;
    }

    public void setDateRendeVous(Date dateRendeVous) {
        this.dateRendeVous = dateRendeVous;
    }

    public Thoraire getCodeHoraire() {
        return codeHoraire;
    }

    public void setCodeHoraire(Thoraire codeHoraire) {
        this.codeHoraire = codeHoraire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trendezvous)) {
            return false;
        }
        Trendezvous other = (Trendezvous) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Trendezvous[ code=" + code + " ]";
    }
    
}
