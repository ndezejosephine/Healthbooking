
package Parametres;

import Parametres.*;
import com.sun.jna.platform.win32.Advapi32Util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER;

/**
 *
 * @author Moses TAGBA
 */
public class ConfigServeurMessagerie 
{
    private String portCom, nomModem, centreMessagerie, pinSIM;
    private int bitTemporisation;
    private final String Cle_Cryptage = "futhsftersopiu78";
    private static Cipher Crypt;
    SecretKey myKey = new SecretKeySpec(Cle_Cryptage.getBytes(), "AES");

    public String getPinSIM() {
        return pinSIM;
    }

    public void setPinSIM(String pinSIM) throws Exception {
        if(ToValide_String(pinSIM))    
            this.pinSIM = pinSIM;
    }

    public String getPortCom() {
        return portCom;
    }

    public String getNomModem() {
        return nomModem;
    }

    public String getCentreMessagerie() {
        return centreMessagerie;
    }

    public int getBitTemporisation() {
        return bitTemporisation;
    }

    public void setPortCom(String portCom) throws Exception {
        if(ToValide_String(portCom))
            this.portCom = portCom;
    }

    public void setNomModem(String nomModem) throws Exception {
        if(ToValide_String(nomModem))
            this.nomModem = nomModem;
    }

    public void setCentreMessagerie(String centreMessagerie) throws Exception {
        if(ToValide_String(centreMessagerie))
            this.centreMessagerie = centreMessagerie;
    }

    public void setBitTemporisation(int bitTemporisation) {
        this.bitTemporisation = bitTemporisation;
    }
    
    public boolean ToValide_String(String input) throws Exception 
    {
        if (!input.equals("")) 
        {
            char[] monText = input.toCharArray();
            for (int i = 0; i < monText.length; i++) 
            {
                if (monText[i]=='/' | monText[i]=='\\' | monText[i]=='<' | monText[i]=='>' | monText[i]=='(' | monText[i]==')'
                        | monText[i]=='%' | monText[i]=='$' | monText[i]=='@' | monText[i]=='#' | monText[i]=='*' | monText[i]=='-' | monText[i]=='='
                        | monText[i]=='!' | monText[i]=='`' | monText[i]=='~' | monText[i]=='[' | monText[i]==']' | monText[i]=='{' | monText[i]=='}'
                        | monText[i]=='&' | monText[i]=='^') 
                {                      
                    throw new Exception("Erreur un caractère non valide trouvé");
                }
            }
        }
        return true;        
    }
    
    public boolean CreateFolder() throws Exception
    {
        try 
        {
            if(!Advapi32Util.registryKeyExists(HKEY_CURRENT_USER, "Software\\Health"))
            {
                Advapi32Util.registryCreateKey(HKEY_CURRENT_USER, "Software\\Health");
                Advapi32Util.registryCreateKey(HKEY_CURRENT_USER, "Software\\Health\\Messagerie");
            }
            else
            {
                if(!Advapi32Util.registryKeyExists(HKEY_CURRENT_USER, "Software\\Health\\Messagerie"))
                    Advapi32Util.registryCreateKey(HKEY_CURRENT_USER, "Software\\Health\\Messagerie");
            }
            return true;
        } 
        catch (Exception e) 
        {
            throw new Exception("Erreur lors de la création des dossiers");
        }   
    }
    
    private boolean Config() throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, Exception
    {
        String port, modem, cMnumber, bit, pinSim;
        try 
        {
            Crypt = Cipher.getInstance("AES");
            Crypt.init(Cipher.ENCRYPT_MODE, myKey);            
            // Cryptage de valeurs
            byte[] portname = getPortCom().getBytes("UTF-8");
            byte[] com = Crypt.doFinal(portname);
            port = new sun.misc.BASE64Encoder().encode(com);
            
            byte[] modemname = getNomModem().getBytes("UTF-8");
            byte[] mode = Crypt.doFinal(modemname);
            modem = new sun.misc.BASE64Encoder().encode(mode);
            
            byte[] centreM = getCentreMessagerie().getBytes("UTF-8");
            byte[] ctr = Crypt.doFinal(centreM);
            cMnumber = new sun.misc.BASE64Encoder().encode(ctr);            
            
            byte[] bitTempo = Integer.toString(getBitTemporisation()).getBytes("UTF-8");
            byte[] temp = Crypt.doFinal(bitTempo);
            bit = new sun.misc.BASE64Encoder().encode(temp);
            
            byte[] pin = getPinSIM().getBytes("UTF-8");
            byte[] codePin = Crypt.doFinal(pin);
            pinSim = new sun.misc.BASE64Encoder().encode(codePin);
            
            Advapi32Util.registrySetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Messagerie", "com", port);
            Advapi32Util.registrySetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Messagerie", "device", modem);
            Advapi32Util.registrySetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Messagerie", "messagerie", cMnumber);
            Advapi32Util.registrySetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Messagerie", "bit", bit);
            Advapi32Util.registrySetStringValue(HKEY_CURRENT_USER, "Software\\Health\\Messagerie", "pinSIM", pinSim);            
            return true;
        } 
        catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) 
        {
            throw new Exception("Erreur de chiffrement AES");
        }
    }
    
    public boolean Configuration() throws Exception
    {
        try 
        {
            if(CreateFolder())
            {
                if(Config())
                {
                    return true;
                }
            }
        } 
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        return false;
    }
}