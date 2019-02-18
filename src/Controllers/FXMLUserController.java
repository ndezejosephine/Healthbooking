
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Tusers;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author NDEZE
 */
public class FXMLUserController implements Initializable {

    @FXML
    private JFXButton Parcourir;
    @FXML
    private Circle Cercle;
    Image image = null;
    private FileChooser file = new FileChooser();
    public static File fl = null;
    ObservableList liste = FXCollections.observableArrayList("*.jpg", "*.png");
    Image img = null;
    @FXML
    private JFXCheckBox RadioAdmin;
    @FXML
    private JFXTextField NomsUser;
    @FXML
    private JFXPasswordField Pass;
    @FXML
    private JFXTextField Contacts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    Tusers user = new Tusers();

    @FXML
    private void Choose_Picture(ActionEvent event) {

        file.setInitialDirectory(new File("C:\\Users\\NDEZE\\Pictures"));
        file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image", liste));
        fl = file.showOpenDialog(null);

        if (fl != null) {
            img = new Image(fl.toURI().toString(), 100, 150, true, true);
            Cercle.setFill(new ImagePattern(img));
        } else {
            DAO.Alertes.alerteErreur("Erreur", "Veuillez ajouter une photo svp");

        }
    }

    @FXML
    private void Add_User(ActionEvent event) {

        try {

            user.setCode(DAO.File_Chargement.AutoIncremente("Tusers"));
            user.setNomsUtilisateur(NomsUser.getText());
            user.setContacts(Contacts.getText());
            user.setMotDePasse(Pass.getText());
            if (RadioAdmin.isSelected()) {
                user.setTypeUser("Admin");
            } else {
                user.setTypeUser("Simple");
            }

            if (DAO.Update_All_Models.Enregister(user)) {
                DAO.Alertes.alerteInformation("Enregistrer", "Enregistrement reussi avec succès");

            }

        } catch (Exception e) {
        }
        String paths = "" + fl;

    }

}
