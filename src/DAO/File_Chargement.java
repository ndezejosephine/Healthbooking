/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author NDEZE
 */
public class File_Chargement {

    public static PreparedStatement pst;
    public static ResultSet rs;

    public static int AutoIncremente(String Table) throws Exception {
        try {

            pst = BDConnect.Connect().prepareStatement("select coalesce(MAX(code), 0)+1 from " + Table + "");
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("OKKKKKKKKKK   " + rs.getInt(1));
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("erreur d'incrementation" + e);
        }
        return 0;
    }

    public static void chargerCombox(ComboBox combo, String Querry) throws Exception {
        try {
            pst = BDConnect.Connect().prepareStatement(Querry);
            rs = pst.executeQuery();
            combo.getItems().clear();
            while (rs.next()) {
                combo.getItems().add(rs.getString(1));
            }
            BDConnect.Disconnect();
            pst.close();
            rs.close();
        } catch (SQLException e) {

        }

    }

    public static void chargerTable(String SQL, TableView v, int taille) throws Exception {

        ObservableList<ObservableList> oblist = FXCollections.observableArrayList();
        v.getColumns().clear();

        rs = DAO.BDConnect.Connect().createStatement().executeQuery(SQL);

        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {

            final int j = i;
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1).toUpperCase());
            col.setPrefWidth((v.getPrefWidth() / rs.getMetaData().getColumnCount()) + taille);
            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, Object>, ObservableValue<Object>>() {
                @Override
                public ObservableValue<Object> call(TableColumn.CellDataFeatures<ObservableList, Object> param) {
                    return new SimpleObjectProperty(param.getValue().get(j)); //To change body of generated methods, choose Tools | Templates.
                }
            });

            v.getColumns().addAll(col);
        }
        while (rs.next()) {

            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

                row.add(rs.getString(i));
            }
            oblist.add(row);
        }
        v.setItems(oblist);
    }

    public static ObservableList onTableClick(TableView maTable) {
        ObservableList o = (ObservableList) maTable.getItems().get(maTable.getSelectionModel().getSelectedIndex());

        return o;

    }
}
