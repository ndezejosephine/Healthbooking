/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author NDEZE
 */
public class Alertes {

    public static void alerteInformation(String titre, String message) {

        Notifications notificationBuilder = Notifications.create()
                .title(titre)
                .text("\n                               " + message)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BASELINE_RIGHT)
                .onAction((ActionEvent event) -> {
                });

        notificationBuilder.showInformation();

    }

    public static void alerteAvertissement(String titre, String message) {

        Notifications notificationAvertissement;
        notificationAvertissement = Notifications.create()
                .title(titre)
                .text("\n                                 " + message)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BASELINE_RIGHT)
                .onAction((ActionEvent event) -> {
                });
        notificationAvertissement.showWarning();
    }

    public static void alerteErreur(String titre, String message) {

        Notifications notificationsErreur = Notifications.create()
                .title(titre)
                .text("\n                                 " + message)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BASELINE_RIGHT)
                .onAction((ActionEvent event) -> {
                });

        notificationsErreur.showError();

    }

    public static void alerteConfirmation(String titre, String message) {

        Notifications notificationsErreur = Notifications.create()
                .title(titre)
                .text("\n                                 " + message)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BASELINE_RIGHT)
                .onAction((ActionEvent event) -> {
                });

        notificationsErreur.showConfirm();
    }
}
