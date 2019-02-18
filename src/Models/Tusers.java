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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NDEZE
 */
@Entity
@Table(name = "tusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tusers.findAll", query = "SELECT t FROM Tusers t")
    , @NamedQuery(name = "Tusers.findByCode", query = "SELECT t FROM Tusers t WHERE t.code = :code")
    , @NamedQuery(name = "Tusers.findByTypeUser", query = "SELECT t FROM Tusers t WHERE t.typeUser = :typeUser")
    , @NamedQuery(name = "Tusers.findByNomsUtilisateur", query = "SELECT t FROM Tusers t WHERE t.nomsUtilisateur = :nomsUtilisateur")
    , @NamedQuery(name = "Tusers.findByMotDePasse", query = "SELECT t FROM Tusers t WHERE t.motDePasse = :motDePasse")
    , @NamedQuery(name = "Tusers.findByContacts", query = "SELECT t FROM Tusers t WHERE t.contacts = :contacts")})
public class Tusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    private Integer code;
    @Column(name = "TypeUser")
    private String typeUser;
    @Column(name = "NomsUtilisateur")
    private String nomsUtilisateur;
    @Column(name = "MotDePasse")
    private String motDePasse;
    @Lob
    @Column(name = "Photo")
    private byte[] photo;
    @Column(name = "Contacts")
    private String contacts;

    public Tusers() {
    }

    public Tusers(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) throws Exception {
        if (DAO.test_valeur.testString(typeUser)) {

        }
        this.typeUser = typeUser;
    }

    public String getNomsUtilisateur() {

        return nomsUtilisateur;
    }

    public void setNomsUtilisateur(String nomsUtilisateur) throws Exception {
        if (DAO.test_valeur.testString(nomsUtilisateur)) {

        }
        this.nomsUtilisateur = nomsUtilisateur;
    }

    public String getMotDePasse() {

        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public byte[] getPhoto() {

        return photo;
    }

    public void setPhoto(byte[] photo) {

        this.photo = photo;
    }

    public String getContacts() {

        return contacts;
    }

    public void setContacts(String contacts) throws Exception {
        if (DAO.test_valeur.testFormatNumber(contacts)) {

        }
        this.contacts = contacts;
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
        if (!(object instanceof Tusers)) {
            return false;
        }
        Tusers other = (Tusers) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Tusers[ code=" + code + " ]";
    }

}
