/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author NDEZE
 */
public class FXMLLoginVraiController implements Initializable {

    @FXML
    private JFXButton BtnConnexion;
    @FXML
    private AnchorPane AnchorpaneLogin;
    @FXML
    private StackPane Stack;
    @FXML
    private JFXSpinner loading;

    double x, y;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loading.setVisible(false);
    }

    private void load(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXMLAccueilVrai.fxml"));
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.initStyle(StageStyle.UNDECORATED);
            st.getIcons().add(new javafx.scene.image.Image("/Images/JosephineLogo3.1.jpg"));
            st.setTitle("Healthbooking Accueil");
            st.setScene(scene);
            ((Stage) AnchorpaneLogin.getScene().getWindow()).close();
            st.show();
        } catch (Exception e) {
        }

    }

    @FXML
    private void Load_Accueil(ActionEvent event) {
        loading.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished((ev) -> {
            load(event);
        });

        pt.play();
    }

    @FXML
    private void Close_Login(MouseEvent event) {

    }

    @FXML
    private void Close(ActionEvent event) {
        JFXButton btn1 = new JFXButton("OUI");
        JFXButton btn2 = new JFXButton("ANNULER");
        JFXDialogLayout dl = new JFXDialogLayout();
        dl.setBody(new Text("Voulez-vous vraiment quitter?"));

        JFXDialog dialog = new JFXDialog(Stack, dl, JFXDialog.DialogTransition.CENTER);
        dialog.setOnDialogClosed((e) -> {
            Stack.setEffect(null);
            AnchorpaneLogin.setEffect(null);
        });
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            System.exit(0);
        });

        btn2.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            dialog.close();

        });
        dl.setActions(btn1, btn2);

        dialog.show();
        AnchorpaneLogin.setEffect(new BoxBlur(3, 3, 3));
    }

    @FXML
    private void Config_Load(ActionEvent event) {

        JFXPasswordField myTextField = new JFXPasswordField();
        myTextField.setMaxWidth(250);
        myTextField.setPromptText("Mot de passe de confirmation s'il vous plait");
        JFXButton btn1 = new JFXButton("Valider");
        JFXButton btn2 = new JFXButton("Changer Mot de passe");
        JFXButton btn3 = new JFXButton("Annuler");
        JFXDialogLayout dl = new JFXDialogLayout();
        dl.setBody(myTextField);

        JFXDialog dialog = new JFXDialog(Stack, dl, JFXDialog.DialogTransition.CENTER);
        dialog.setOnDialogClosed((e) -> {
            AnchorpaneLogin.setEffect(null);
        });
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            if (myTextField.getText().equals("admin".toUpperCase())) {
                try {
                    Parent rt;
                    AnchorpaneLogin.getScene().getWindow().hide();
                    //   loginAnchorPane.getScene().getWindow().hide();
                    Stage stage = new Stage();
                    stage = new Stage(StageStyle.UNDECORATED);
                    rt = FXMLLoader.load(getClass().getResource("/GUI/FXMLServeur.fxml"));
                    Scene scene = new Scene(rt);
                    stage.getIcons().add(new javafx.scene.image.Image("/Images/JosephineLogo3.1.jpg"));
                    stage.setTitle("Configuration du serveur");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLLoginVraiController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                DAO.Alertes.alerteErreur("Erreur", "Mot de passe incorrect");
            }
        }
        );
        btn2.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (e) -> {

                }
        );
        btn3.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (e) -> {
                    dialog.close();
                }
        );
        dl.setActions(btn1, btn2, btn3);

        dialog.show();

        AnchorpaneLogin.setEffect(
                new BoxBlur(5, 5, 5));

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
}
