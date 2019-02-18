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
@Table(name = "ttypedocteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ttypedocteur.findAll", query = "SELECT t FROM Ttypedocteur t")
    , @NamedQuery(name = "Ttypedocteur.findByCode", query = "SELECT t FROM Ttypedocteur t WHERE t.code = :code")
    , @NamedQuery(name = "Ttypedocteur.findBySpecialisation", query = "SELECT t FROM Ttypedocteur t WHERE t.specialisation = :specialisation")})
public class Ttypedocteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private Integer code;
    @Column(name = "Specialisation")
    private String specialisation;
    @OneToMany(mappedBy = "codeSpecialisation")
    private Collection<Tdocteur> tdocteurCollection;

    public Ttypedocteur() {
    }

    public Ttypedocteur(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) throws Exception {
        if (DAO.test_valeur.testString(specialisation)) {
            
        }
        this.specialisation = specialisation;
    }

    @XmlTransient
    public Collection<Tdocteur> getTdocteurCollection() {
        return tdocteurCollection;
    }

    public void setTdocteurCollection(Collection<Tdocteur> tdocteurCollection) {
        this.tdocteurCollection = tdocteurCollection;
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
        if (!(object instanceof Ttypedocteur)) {
            return false;
        }
        Ttypedocteur other = (Ttypedocteur) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Ttypedocteur[ code=" + code + " ]";
    }
    
}
