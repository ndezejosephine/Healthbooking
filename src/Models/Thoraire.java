/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NDEZE
 */
@Entity
@Table(name = "thoraire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thoraire.findAll", query = "SELECT t FROM Thoraire t")
    , @NamedQuery(name = "Thoraire.findByCode", query = "SELECT t FROM Thoraire t WHERE t.code = :code")
    , @NamedQuery(name = "Thoraire.findByNombrePatient", query = "SELECT t FROM Thoraire t WHERE t.nombrePatient = :nombrePatient")
    , @NamedQuery(name = "Thoraire.findByHeureDebut", query = "SELECT t FROM Thoraire t WHERE t.heureDebut = :heureDebut")
    , @NamedQuery(name = "Thoraire.findByHeureFin", query = "SELECT t FROM Thoraire t WHERE t.heureFin = :heureFin")})
public class Thoraire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private Integer code;
    @Column(name = "NombrePatient")
    private Integer nombrePatient;
    @Column(name = "HeureDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDebut;
    @Column(name = "HeureFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureFin;
    @OneToMany(mappedBy = "codeHoraire")
    private Collection<Trendezvous> trendezvousCollection;
    @JoinColumn(name = "CodeDocteur", referencedColumnName = "Code")
    @ManyToOne
    private Tdocteur codeDocteur;
    @JoinColumn(name = "CodeJour", referencedColumnName = "Code")
    @ManyToOne
    private Tjour codeJour;

    public Thoraire() {
    }

    public Thoraire(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getNombrePatient() {
        return nombrePatient;
    }

    public void setNombrePatient(Integer nombrePatient) {
        this.nombrePatient = nombrePatient;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    @XmlTransient
    public Collection<Trendezvous> getTrendezvousCollection() {
        return trendezvousCollection;
    }

    public void setTrendezvousCollection(Collection<Trendezvous> trendezvousCollection) {
        this.trendezvousCollection = trendezvousCollection;
    }

    public Tdocteur getCodeDocteur() {
        return codeDocteur;
    }

    public void setCodeDocteur(Tdocteur codeDocteur) {
        this.codeDocteur = codeDocteur;
    }

    public Tjour getCodeJour() {
        return codeJour;
    }

    public void setCodeJour(Tjour codeJour) {
        this.codeJour = codeJour;
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
        if (!(object instanceof Thoraire)) {
            return false;
        }
        Thoraire other = (Thoraire) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Thoraire[ code=" + code + " ]";
    }
    
}
