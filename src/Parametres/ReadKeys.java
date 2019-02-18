/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parametres;

import com.sun.jna.platform.win32.Advapi32Util;
import static com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author NDEZE
 */
public class ReadKeys {

    private String server, user, password, database, port, modem, numeroCentreMessagerie, numeroCentreFinancier, pinSIM;
    private int bitTemporisation;
    private static final String maCle = "futhsftersopiu78";

    public int getBitTemporisation() {
        return bitTemporisation;
    }

    public void setBitTemporisation(int bitTemporisation) {
        this.bitTemporisation = bitTemporisation;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getModem() {
        return modem;
    }

    public void setModem(String modem) {
        this.modem = modem;
    }

    public String getNumeroCentreMessagerie() {
        return numeroCentreMessagerie;
    }

    public void setNumeroCentreMessagerie(String numeroCentreMessagerie) {
        this.numeroCentreMessagerie = numeroCentreMessagerie;
    }

    public String getNumeroCentreFinancier() {
        return numeroCentreFinancier;
    }

    public void setNumeroCentreFinancier(String numeroCentreFinancier) {
        this.numeroCentreFinancier = numeroCentreFinancier;
    }

    public String getPinSIM() {
        return pinSIM;
    }

    public void setPinSIM(String pinSIM) {
        this.pinSIM = pinSIM;
    }

    public ReadKeys() throws Exception {

        try {
            SecretKey mKey = new SecretKeySpec(maCle.getBytes(), "AES");
            Cipher Decryp = Cipher.getInstance("AES");
            Decryp.init(Cipher.DECRYPT_MODE, mKey);

            if (!"".equals(getServer()) | !"".equals(getUser()) | !"".equals(getPassword()) | !"".equals(getDatabase())
                    | !"".equals(getPort()) | !"".equals(getModem()) | !"".equals(getNumeroCentreMessagerie())
                    | !"".equals(getNumeroCentreFinancier()) | !"".equals(getBitTemporisation()) | !"".equals(getPinSIM())) {
                byte[] s = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Donnees", "server"));
                byte[] serv = Decryp.doFinal(s);
                setServer(new String(serv, "UTF-8"));

                byte[] us = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Donnees", "user"));
                byte[] usr = Decryp.doFinal(us);
                setUser(new String(usr, "UTF-8"));

                byte[] pw = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Donnees", "password"));
                byte[] pd = Decryp.doFinal(pw);
                setPassword(new String(pd, "UTF-8"));

                byte[] bs = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Donnees", "database"));
                byte[] data = Decryp.doFinal(bs);
                setDatabase(new String(data, "UTF-8"));

                byte[] prt = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Messagerie", "com"));
                byte[] pr = Decryp.doFinal(prt);
                setPort(new String(pr, "UTF-8"));

                byte[] mat = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Messagerie", "device"));
                byte[] mtr = Decryp.doFinal(mat);
                setModem(new String(mtr, "UTF-8"));

                byte[] cNM = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Messagerie", "messagerie"));
                byte[] cN = Decryp.doFinal(cNM);
                setNumeroCentreMessagerie(new String(cN, "UTF-8"));

                byte[] bt = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Messagerie", "bit"));
                byte[] temp = Decryp.doFinal(bt);
                setBitTemporisation(Integer.parseInt(new String(temp, "UTF-8")));

                byte[] resa = new sun.misc.BASE64Decoder().decodeBuffer(Advapi32Util.registryGetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Messagerie", "pinSIM"));
                byte[] rse = Decryp.doFinal(resa);
                setPinSIM(new String(rse, "UTF-8"));

            } else {
                throw new Exception("L'un des fichiers de configuration est vide. Soit votre configuration n'est pas finie");
            }
        } catch (Exception e) {
            throw new Exception("Erreur lors de la lecture des fichiers");
        }

    }

}
