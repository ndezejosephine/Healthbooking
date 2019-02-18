/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NDEZE
 */
public class FXMLAccueilVraiController implements Initializable {

    @FXML
    private JFXPopup popup;
    public static JFXPopup menuPopup;

    @FXML
    private JFXButton BtnDeconnexion;
    @FXML
    private HBox GrandContenaire;
    @FXML
    private AnchorPane Contenaire;

    double x, y;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menuPopup = popup;

    }

    @FXML
    private void Load_Deconnexion(ActionEvent event) throws IOException {
        AnchorPane anc = FXMLLoader.load(getClass().getResource("/GUI/FXMLDeconnexion.fxml"));
        popup.setContent(anc);
        popup.setSource(Contenaire);
        popup.show(JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT);

    }

    @FXML
    private void Ajouter_Nouveau(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/GUI/FXMLAjouter.fxml"));
            Contenaire.getChildren().removeAll();
            Contenaire.getChildren().setAll(fxml);
        } catch (IOException e) {
        }
    }

    @FXML
    private void Load_Visualiser(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/GUI/FXMLVisualiser.fxml"));
            Contenaire.getChildren().removeAll();
            Contenaire.getChildren().addAll(fxml);
        } catch (IOException e) {
        }
    }

    @FXML
    private void Load_Serveur(MouseEvent event) {

        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/GUI/FXMLServeur.fxml"));
            Contenaire.getChildren().removeAll();
            Contenaire.getChildren().setAll(fxml);
            FXMLServeurController.boutton1.setVisible(false);
            FXMLServeurController.boutton2.setVisible(false);

        } catch (IOException e) {
        }
    }

    @FXML
    private void Load_Users(MouseEvent event) {

        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/GUI/FXMLUser.fxml"));
            Contenaire.getChildren().removeAll();
            Contenaire.getChildren().setAll(fxml);

        } catch (IOException e) {
        }
    }

    @FXML
    private void Dragged(MouseEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void Pressed(MouseEvent event) {

        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void Load_Horaire(MouseEvent event) {

        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/GUI/FXMLhoraire.fxml"));
            Contenaire.getChildren().removeAll();
            Contenaire.getChildren().setAll(fxml);
        } catch (Exception e) {
        }
    }

}
