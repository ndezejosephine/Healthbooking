/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.IsFieldEmpty;
import Parametres.ConfigServeurMessagerie;
import Parametres.ConfigurationServeur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author NDEZE
 */
public class FXMLServeurController implements Initializable {

    @FXML
    private AnchorPane AnchorServer;
    ConfigurationServeur donnee = new ConfigurationServeur();
    @FXML
    private JFXTextField txtInstance;
    @FXML
    private JFXTextField txtBD;
    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXTextField txtPass;
    @FXML
    private JFXTextField txtConfirmPass;
    @FXML
    private JFXButton BtnRetour1;
    @FXML
    private JFXButton BtnRetour2;

    public static JFXButton boutton1;
    public static JFXButton boutton2;
    @FXML
    private JFXTextField port;
    @FXML
    private JFXTextField modem;
    @FXML
    private JFXTextField bittem;
    @FXML
    private JFXTextField centre;
    @FXML
    private JFXTextField pin;
    ConfigServeurMessagerie donneeMessagerie = new ConfigServeurMessagerie();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        boutton2 = BtnRetour2;
        boutton1 = BtnRetour1;

    }

    @FXML
    private void BackButtonConfig(ActionEvent event) {
        FadeTransition ft = new FadeTransition(Duration.seconds(1));
        ft.setNode(AnchorServer);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(ev -> {
            AnchorServer.getScene().getWindow().hide();
            try {
                Parent root;
                //  loginAnchorPane.getScene().getWindow().hide();
                Stage main = new Stage();
                main = new Stage(StageStyle.UNDECORATED);
                root = FXMLLoader.load(getClass().getResource("/GUI/FXMLLoginVrai.fxml"));
                Scene scene = new Scene(root);
                //main.getIcons().add(new Image("/Images/iconAppli.jpg"));
                main.setTitle("Healthbooking");
                main.setScene(scene);
                main.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLServeurController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        ft.play();
    }

    @FXML
    private void Enregister_BD(ActionEvent event) {

        try {
            if (!IsFieldEmpty.isFieldsempty(txtBD, txtConfirmPass, txtInstance, txtPass, txtUser)) {
                if (donnee.getServerPassword() == null ? donnee.getConfirPassword() != null : !donnee.getServerPassword().equals(donnee.getConfirPassword())) {
                    DAO.Alertes.alerteErreur("Erreur", "les deux mots de passe ne sont pas identiques");
                } else {
                    donnee.setServerName(txtInstance.getText());
                    donnee.setServerUser(txtUser.getText());
                    donnee.setServerPassword(txtPass.getText());
                    donnee.setConfirPassword(txtConfirmPass.getText());
                    donnee.setDatabaseName(txtBD.getText());
                    if (donnee.Configuration()) {
                        DAO.Alertes.alerteInformation("Configuration", "Enregistré");
                        txtBD.setText("");
                        txtUser.setText("");
                        txtInstance.setText("");
                        txtPass.setText("");
                        txtConfirmPass.setText("");
                    }
                }
            } else {
                DAO.Alertes.alerteAvertissement("Avertissement", "Veuillez Compléter les champs vides svp");
            }
        } catch (Exception e) {
            DAO.Alertes.alerteAvertissement("Avertissement", "Echec d'enregistrement de la base de donnee");
            e.printStackTrace();
        }

    }

    @FXML
    private void Enregistrer_Messagerie(ActionEvent event
    ) {
        try {
            if (!IsFieldEmpty.isFieldsempty(port, bittem, modem, centre, pin)) {
                donneeMessagerie.setPortCom(port.getText());
                donneeMessagerie.setBitTemporisation(Integer.valueOf(bittem.getText()));
                donneeMessagerie.setNomModem(modem.getText());
                donneeMessagerie.setCentreMessagerie(centre.getText());
                donneeMessagerie.setPinSIM(pin.getText());
                if (donneeMessagerie.Configuration()) {
                    DAO.Alertes.alerteInformation("Enregistrer", "Enregistrement reussi avec succès");
                    port.setText("");
                    modem.setText("");
                    bittem.setText("");
                    centre.setText("");
                    pin.setText("");
                }
            } else {
                DAO.Alertes.alerteAvertissement("Avertissement", "Veuillez Compléter les champs vides svp");
            }
        } catch (Exception e) {
            DAO.Alertes.alerteAvertissement("Avertissement", "Echec d'enregistrement de la configuration du serveur");
            e.printStackTrace();
        }
    }
}
