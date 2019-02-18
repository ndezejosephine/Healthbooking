/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NDEZE
 */
@Entity
@Table(name = "tjour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tjour.findAll", query = "SELECT t FROM Tjour t")
    , @NamedQuery(name = "Tjour.findByCode", query = "SELECT t FROM Tjour t WHERE t.code = :code")
    , @NamedQuery(name = "Tjour.findByJour", query = "SELECT t FROM Tjour t WHERE t.jour = :jour")})
public class Tjour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private Integer code;
    @Column(name = "Jour")
    private String jour;
    @OneToMany(mappedBy = "codeJour")
    private Collection<Thoraire> thoraireCollection;

    public Tjour() {
    }

    public Tjour(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    @XmlTransient
    public Collection<Thoraire> getThoraireCollection() {
        return thoraireCollection;
    }

    public void setThoraireCollection(Collection<Thoraire> thoraireCollection) {
        this.thoraireCollection = thoraireCollection;
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
        if (!(object instanceof Tjour)) {
            return false;
        }
        Tjour other = (Tjour) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Tjour[ code=" + code + " ]";
    }
    
}
