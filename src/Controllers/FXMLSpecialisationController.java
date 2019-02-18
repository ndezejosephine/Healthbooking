/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.IsFieldEmpty;

import Models.Ttypedocteur;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author NDEZE
 */
public class FXMLSpecialisationController implements Initializable {

    Ttypedocteur ty = new Ttypedocteur();
    @FXML
    private JFXTextField Specialisation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Add_Specialisation(ActionEvent event) {

        try {
            if (IsFieldEmpty.isFieldsempty(Specialisation)) {
                DAO.Alertes.alerteAvertissement("Avertissement", "Veuillez Compléter les champs vides svp");
            } else {

                ty.setCode(DAO.File_Chargement.AutoIncremente("Ttypedocteur"));
                ty.setSpecialisation(Specialisation.getText());
                if (DAO.Update_All_Models.Enregister(ty)) {
                    DAO.Alertes.alerteInformation("Enregistrer", "Enregistrement reussi avec succès");
                    Specialisation.setText("");

                }
            }
        } catch (Exception e) {

            DAO.Alertes.alerteAvertissement("Avertissement", "Echec d'enregistrement");
            e.printStackTrace();
        }

    }

}
