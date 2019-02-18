/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Parametres.ReadKeys;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NDEZE
 */
public class BDConnect {

    private static Connection MyConnection = null;

    public static Connection Connect() throws Exception {
        try {
            ReadKeys read = new ReadKeys();
            Class.forName("com.mysql.jdbc.Driver");
            MyConnection = DriverManager.getConnection("jdbc:mysql://" + read.getServer() + ":3306/" + read.getDatabase(), read.getUser(), read.getPassword());
            System.out.print("------Connxion OK------");
            return MyConnection;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception("Erreur liée à l'instance de MS SQL Server" + ex.getMessage());
        }
    }

    public static boolean Disconnect() throws Exception {

        try {
            if (!MyConnection.isClosed()) {
                MyConnection.close();
            }
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
        return false;

    }
}
