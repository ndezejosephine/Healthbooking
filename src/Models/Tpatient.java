/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

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
 * @author NDEZE
 */
@Entity
@Table(name = "tpatient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpatient.findAll", query = "SELECT t FROM Tpatient t")
    , @NamedQuery(name = "Tpatient.findByCode", query = "SELECT t FROM Tpatient t WHERE t.code = :code")
    , @NamedQuery(name = "Tpatient.findByNoms", query = "SELECT t FROM Tpatient t WHERE t.noms = :noms")
    , @NamedQuery(name = "Tpatient.findByContacts", query = "SELECT t FROM Tpatient t WHERE t.contacts = :contacts")
    , @NamedQuery(name = "Tpatient.findByAge", query = "SELECT t FROM Tpatient t WHERE t.age = :age")
    , @NamedQuery(name = "Tpatient.findBySexe", query = "SELECT t FROM Tpatient t WHERE t.sexe = :sexe")})
public class Tpatient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private Integer code;
    @Column(name = "Noms")
    private String noms;
    @Column(name = "Contacts")
    private String contacts;
    @Column(name = "Age")
    private String age;
    @Column(name = "Sexe")
    private String sexe;

    public Tpatient() {
    }

    public Tpatient(Integer code) {
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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) throws Exception {
        if (DAO.test_valeur.testFormatNumber(contacts)) {
            this.contacts = contacts;
        }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpatient)) {
            return false;
        }
        Tpatient other = (Tpatient) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Tpatient[ code=" + code + " ]";
    }

}
