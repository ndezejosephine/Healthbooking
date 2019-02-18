/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static DAO.File_Chargement.chargerTable;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author NDEZE
 */
public class FXMLVisualiserController implements Initializable {

    @FXML
    private ToggleGroup GroupePersonne;
    @FXML
    private TableView<String> tabVisualisation;
    @FXML
    private JFXToggleButton patienRadio;
    @FXML
    private JFXToggleButton docteurRadio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActiveAffichagr();
    }

    public void ActiveAffichagr() {
        try {
            if (patienRadio.isSelected()) {
                chargerTable("Select concat('00',code) as NUMERO_PATIENTS,noms as NOMS_ET_POSTNOM,Contacts as CONTACT_DU_PATIENT,age as AGE,sexe as SEXE from tpatient", tabVisualisation, 20);
            } else {
                chargerTable("Select concat('00',code) as NUMERO_DOCTEUR,noms as NOMS_ET_POSTNOM,Contact as CONTACT_DU_DOCTEUR,age as AGE,sexe as SEXE from tdocteur", tabVisualisation, 20);
            }
        } catch (Exception e) {
        }
    }

    @FXML
    private void ActivePatient(ActionEvent event) {
        ActiveAffichagr();
    }

    @FXML
    private void ActiveDocteur(ActionEvent event) {
        ActiveAffichagr();
    }

}
