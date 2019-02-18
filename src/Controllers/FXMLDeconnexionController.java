/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author NDEZE
 */
public class FXMLDeconnexionController implements Initializable {

    @FXML
    private JFXButton BtnDeconnexion;
    @FXML
    private AnchorPane AnchorpaneDeconnexion;

    private static StackPane st = null;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Load_Login(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXMLLoginVrai.fxml"));
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.initStyle(StageStyle.UNDECORATED);
            st.setScene(scene);
            ((Stage) AnchorpaneDeconnexion.getScene().getWindow()).close();
            st.show();

        } catch (IOException e) {
        }

    }

    @FXML
    private void Hide_Deconnexion(ActionEvent event) {
        FXMLAccueilVraiController.menuPopup.close();
    }

}
