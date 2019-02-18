/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author NDEZE
 */
public class IsFieldEmpty {
    
    public static boolean isFieldsempty(Node... field) {
        int i = 0;
        while (i < field.length) {
            if (field[i] instanceof TextField) {
                TextField text = (TextField) field[i];
                if (text.getText().trim().isEmpty()) {
                    break;
                }
                i++;
            } else if (field[i] instanceof PasswordField) {
                PasswordField pass = (PasswordField) field[i];
                if (pass.getText().trim().isEmpty()) {
                    break;
                }
                i++;
            } else if (field[i] instanceof ComboBox) {
                ComboBox comboBox = (ComboBox) field[i];
                if (comboBox.getValue() == null) {
                    break;
                }
                i++;
            } else if (field[i] instanceof DatePicker) {
                DatePicker date = (DatePicker) field[i];
                if (date.getValue() == null) {
                    break;
                }
                i++;
            } else if (field[i] instanceof TextArea) {
                TextArea area = (TextArea) field[i];
                if (area.getText().trim().isEmpty()) {
                    break;
                }
                i++;
            } else if (field[i] instanceof Label) {
                Label txt = (Label) field[i];
                if (txt.getText().trim().isEmpty()) {
                    break;
                }
                i++;
            } else if (field[i] instanceof Text) {
                Text txt = (Text) field[i];
                if (txt.getText().trim().isEmpty()) {
                    break;
                }
                i++;
            }
        }
        return i != field.length;
    }
    
}
