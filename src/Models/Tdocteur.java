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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tdocteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tdocteur.findAll", query = "SELECT t FROM Tdocteur t")
    , @NamedQuery(name = "Tdocteur.findByCode", query = "SELECT t FROM Tdocteur t WHERE t.code = :code")
    , @NamedQuery(name = "Tdocteur.findByNoms", query = "SELECT t FROM Tdocteur t WHERE t.noms = :noms")
    , @NamedQuery(name = "Tdocteur.findByContact", query = "SELECT t FROM Tdocteur t WHERE t.contact = :contact")
    , @NamedQuery(name = "Tdocteur.findByAge", query = "SELECT t FROM Tdocteur t WHERE t.age = :age")
    , @NamedQuery(name = "Tdocteur.findBySexe", query = "SELECT t FROM Tdocteur t WHERE t.sexe = :sexe")})
public class Tdocteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private Integer code;
    @Column(name = "Noms")
    private String noms;
    @Column(name = "Contact")
    private String contact;
    @Column(name = "Age")
    private String age;
    @Column(name = "Sexe")
    private String sexe;
    @JoinColumn(name = "CodeSpecialisation", referencedColumnName = "Code")
    @ManyToOne
    private Ttypedocteur codeSpecialisation;
    @OneToMany(mappedBy = "codeDocteur")
    private Collection<Thoraire> thoraireCollection;

    public Tdocteur() {
    }

    private static String designationType;

    public static String getDesignationType() {
        return designationType;
    }

    public static void setDesignationType(String designationType) {
        Tdocteur.designationType = designationType;
    }

    public Tdocteur(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) throws Exception {
        if (DAO.test_valeur.testString(noms)) {

        }
        this.noms = noms;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) throws Exception {
        if (DAO.TestNumbers.ValateNumber(contact)) {

        }
        this.contact = contact;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) throws Exception {
        if (DAO.test_valeur.testString(age)) {

        }
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) throws Exception {
        if (DAO.test_valeur.testString(sexe)) {
            
        }
        this.sexe = sexe;
    }

    public Ttypedocteur getCodeSpecialisation() {
        return codeSpecialisation;
    }

    public void setCodeSpecialisation(Ttypedocteur codeSpecialisation) {
        this.codeSpecialisation = codeSpecialisation;
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
        if (!(object instanceof Tdocteur)) {
            return false;
        }
        Tdocteur other = (Tdocteur) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Tdocteur[ code=" + code + " ]";
    }

}
