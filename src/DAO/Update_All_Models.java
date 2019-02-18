/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controllers.FXMLUserController;
import static Controllers.FXMLUserController.fl;
import Models.Tdocteur;
import Models.Tpatient;
import Models.Ttypedocteur;
import Models.Tusers;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;

/**
 *
 * @author NDEZE
 */
public class Update_All_Models {

    private static PreparedStatement pst = null;

    public static boolean Enregister(Object ob) {

        try {

            if (ob instanceof Tpatient) {

                Tpatient pa = (Tpatient) ob;
                pst = BDConnect.Connect().prepareCall("call SP_INSERE_TPatient (?,?,?,?,?)");
                pst.setInt(1, pa.getCode());
                pst.setString(2, pa.getNoms());
                pst.setString(3, pa.getContacts());
                pst.setString(4, pa.getAge());
                pst.setString(5, pa.getSexe());
                pst.executeQuery();
                BDConnect.Disconnect();
                return true;
            } else if (ob instanceof Tdocteur) {
                Tdocteur doc = (Tdocteur) ob;
                pst = BDConnect.Connect().prepareCall("call SP_INSERE_TDocteur (?,?,?,?,?,?)");
                pst.setInt(1, doc.getCode());
                pst.setString(2, doc.getNoms());
                pst.setString(3, doc.getContact());
                pst.setString(4, doc.getAge());
                pst.setString(5, doc.getSexe());
                pst.setString(6, doc.getDesignationType());
                pst.executeQuery();
                BDConnect.Disconnect();
                return true;
            } else if (ob instanceof Ttypedocteur) {

                Ttypedocteur ty = (Ttypedocteur) ob;
                pst = BDConnect.Connect().prepareCall("call SP_INSERE_TTypeDocteur (?,?)");
                pst.setInt(1, ty.getCode());
                pst.setString(2, ty.getSpecialisation());
                pst.executeQuery();
                BDConnect.Disconnect();
                return true;
            } else if (ob instanceof Tusers) {

                Tusers us = (Tusers) ob;
                pst = BDConnect.Connect().prepareCall("CALL SP_INSERE_TUsers (?,?,?,?,?,?)");

                pst.setInt(1, us.getCode());
                pst.setString(2, us.getTypeUser());
                pst.setString(3, us.getNomsUtilisateur());
                pst.setString(4, us.getMotDePasse());

                FileInputStream input = new FileInputStream(FXMLUserController.fl);

                pst.setBinaryStream(5, (InputStream) input, (int) fl.length());

                pst.setString(6, us.getContacts());

                pst.executeQuery();
                BDConnect.Disconnect();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

}
