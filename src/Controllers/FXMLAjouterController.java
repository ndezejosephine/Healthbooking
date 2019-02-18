/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.IsFieldEmpty;
import Models.Tdocteur;
import Models.Tpatient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author NDEZE
 */
public class FXMLAjouterController implements Initializable {

    Tpatient pat = new Tpatient();
    Tdocteur doc = new Tdocteur();

    @FXML
    private ToggleGroup Perssonne;
    @FXML
    private TextField Noms;
    @FXML
    private TextField Contacts;
    @FXML
    private TextField Age;
    @FXML
    private ComboBox<String> Sexe;
    @FXML
    private JFXButton BtnAjouter;
    @FXML
    private AnchorPane AnchorpaneAjouter;
    @FXML
    private JFXPopup popup;
    @FXML
    private JFXToggleButton Active_Docteur;
    @FXML
    private JFXToggleButton Active_Patient;
    @FXML
    private ComboBox<String> ComboSpecialisation;
    @FXML
    private VBox VboxTypeDocteur;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            final Tooltip tooltipPassword = new Tooltip();
            tooltipPassword.setText("Ajouter une spécialisation");
            BtnAjouter.setTooltip(tooltipPassword);

            Sexe.getItems().addAll("F", "M");
            DAO.File_Chargement.chargerCombox(ComboSpecialisation, "Select Specialisation from Ttypedocteur");

        } catch (Exception e) {
        }
        // TODO
    }

    @FXML
    private void Enregistrer_Nouveau(ActionEvent event) {
        try {

            if (Active_Patient.isSelected()) {

                pat.setCode(DAO.File_Chargement.AutoIncremente("Tpatient"));
                pat.setNoms(Noms.getText());
                pat.setContacts(Contacts.getText());
                pat.setAge(Age.getText());
                pat.setSexe((String) Sexe.getValue());

                if (DAO.Update_All_Models.Enregister(pat)) {
                    DAO.Alertes.alerteInformation("Enregistrer", "Enregistrement reussi avec succès");
                    Noms.setText("");
                    Contacts.setText("");
                    Age.setText("");
                    Sexe.setValue("Sexe");
                }
            } else if (Active_Docteur.isSelected()) {

                doc.setCode(DAO.File_Chargement.AutoIncremente("TDocteur"));
                doc.setNoms(Noms.getText());
                doc.setContact(Contacts.getText());
                doc.setAge(Age.getText());
                doc.setSexe((String) Sexe.getValue());
                doc.setDesignationType(ComboSpecialisation.getValue().toString());

                if (DAO.Update_All_Models.Enregister(doc)) {
                    DAO.Alertes.alerteInformation("Enregistrer", "Enregistrement reussi avec succès");
                    Noms.setText("");
                    Contacts.setText("");
                    Age.setText("");
                    Sexe.setValue("Sexe");
                    ComboSpecialisation.setValue("Entrer votre spécialisation");

                }

            } else {
                DAO.Alertes.alerteAvertissement("Selectionner", "Veuillez selectionner la personne à enregistrer svp");
            }

        } catch (Exception e) {
            DAO.Alertes.alerteAvertissement("Avertissement", "Echec d'enregistrement");
            e.printStackTrace();
        }

    }

    @FXML
    private void Add_Specialisation(ActionEvent event) throws IOException {
        AnchorPane anc = FXMLLoader.load(getClass().getResource("/GUI/FXMLSpecialisation.fxml"));
        popup.setContent(anc);
        popup.setSource(AnchorpaneAjouter);
        popup.show(JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT);
    }

    void Selection() {

        if (Active_Docteur.isSelected()) {
            VboxTypeDocteur.setVisible(true);
            BtnAjouter.setVisible(true);
        } else {

            VboxTypeDocteur.setVisible(false);
            BtnAjouter.setVisible(false);
        }
    }

    @FXML
    private void Docteur_Selected(ActionEvent event) {
        Selection();
    }

    @FXML
    private void Patient_Selected(ActionEvent event) {
        Selection();
    }

}
