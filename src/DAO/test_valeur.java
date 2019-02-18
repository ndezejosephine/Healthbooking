/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author KingDan
 */
public class test_valeur {

    public static boolean testString(String tst) throws Exception {
        boolean test = false;
        if (!tst.isEmpty()) {
            char[] caractere = tst.toCharArray();
            for (int i = 0; i < caractere.length; i++) {
                if (caractere[i] == '/' | caractere[i] == '\\' | caractere[i] == '$' | caractere[i] == '!' | caractere[i] == ',' | caractere[i] == ';' | caractere[i] == '?'
                        | caractere[i] == '#' | caractere[i] == '@' | caractere[i] == '%' | caractere[i] == '^' | caractere[i] == '&' | caractere[i] == '*' | caractere[i] == '('
                        | caractere[i] == ')' | caractere[i] == '_' | caractere[i] == '=' | caractere[i] == '[' | caractere[i] == ']' | caractere[i] == '{' | caractere[i] == '}'
                        | caractere[i] == '"' | caractere[i] == '`' | caractere[i] == '~' | caractere[i] == '<' | caractere[i] == '>') {
                    test = true;
                    break;
                }
            }
            if (test == false) {
                return true;
            } else {
                DAO.Alertes.alerteErreur("Erreur", "Vous avez utilisé des caractères non autorisés");
                throw new Exception("Vous avez utilisé des caractères non autorisés");

            }
        } else {
            DAO.Alertes.alerteErreur("Erreur", "Veuillez completer les champs vides ");

        }
        return false;
    }

    public static boolean testeFloat(String tst) throws Exception {
        if (!tst.isEmpty()) {
            char[] caractere = tst.toCharArray();
            boolean test = false;
            for (int i = 0; i < caractere.length; i++) {
                if (caractere[i] == '/' | caractere[i] == '\\' | caractere[i] == '$' | caractere[i] == '!' | caractere[i] == ',' | caractere[i] == ';' | caractere[i] == '?'
                        | caractere[i] == '#' | caractere[i] == '@' | caractere[i] == '%' | caractere[i] == '^' | caractere[i] == '&' | caractere[i] == '*'
                        | caractere[i] == '_' | caractere[i] == '=' | caractere[i] == '[' | caractere[i] == ']' | caractere[i] == '{' | caractere[i] == '}'
                        | caractere[i] == '"' | caractere[i] == '`' | caractere[i] == '~' | caractere[i] == '<' | caractere[i] == '>') {
                    test = true;
                    break;
                }
            }
            if (test == false) {
                return true;
            } else {
                DAO.Alertes.alerteAvertissement("Avertissement", "Les lettres et caractères spéciaux sont invalides pour la saisie du numero ");
                throw new Exception("Vous avez utiliser un caractere non autorisé");
            }
        }
        return false;
    }

    public static boolean testFormatNumber(String tst) throws Exception {
        if (!tst.isEmpty()) {
            char[] caractere = tst.toCharArray();
            boolean test = false;
            for (int i = 0; i < caractere.length; i++) {
                if (caractere[i] == '/' | caractere[i] == '\\' | caractere[i] == '$' | caractere[i] == '!' | caractere[i] == ',' | caractere[i] == ';' | caractere[i] == '?'
                        | caractere[i] == '#' | caractere[i] == '@' | caractere[i] == '%' | caractere[i] == '^' | caractere[i] == '&' | caractere[i] == '*'
                        | caractere[i] == '_' | caractere[i] == '=' | caractere[i] == '[' | caractere[i] == ']' | caractere[i] == '{' | caractere[i] == '}'
                        | caractere[i] == '"' | caractere[i] == '`' | caractere[i] == '~' | caractere[i] == '<' | caractere[i] == '>' | caractere[i] == 'a') {
                    {
                        test = true;
                        break;
                    }
                }
            }
            if (test == false) {
                return true;
            } else {
                DAO.Alertes.alerteErreur("Erreur", "Les lettres et caractères spéciaux sont invalides pour la saisie du numero ");
                throw new Exception("Vous avez utiliser un caractere non autorisé");
            }
        } else {
            DAO.Alertes.alerteErreur("Erreur", "Veuillez completer le numero svp");
        }
        return false;
    }

}
