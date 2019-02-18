/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Dan Baruka
 */
public class TestNumbers {

    public static String myFullNumber = null;

    public static boolean ValateNumber(String valeur) throws Exception {
        if (!valeur.equals("")) {
            char[] myValue = valeur.toCharArray();
            if (myValue.length > 9) {
                DAO.Alertes.alerteErreur("Erreur", "Veuillez saisir un bon numéro svp");
//                throw new Exception("Ce numero est invalide! :" + valeur);

            } else if (myValue.length == 9) {
                for (int i = 0; i < myValue.length; i++) {
                    if (myValue[i] == '/' | myValue[i] == '\\' | myValue[i] == '<' | myValue[i] == '>' | myValue[i] == '(' | myValue[i] == ')' | myValue[i] == ')'
                            | myValue[i] == '%' | myValue[i] == '$' | myValue[i] == '@' | myValue[i] == '#' | myValue[i] == '*' | myValue[i] == '=' | myValue[i] == '+'
                            | myValue[i] == '!' | myValue[i] == '`' | myValue[i] == '~' | myValue[i] == '[' | myValue[i] == ']' | myValue[i] == '{' | myValue[i] == '}'
                            | myValue[i] == '&' | myValue[i] == '^' | myValue[i] == '\'' | myValue[i] == ',' | myValue[i] == '_' | myValue[i] == 'A' | myValue[i] == 'a'
                            | myValue[i] == 'B' | myValue[i] == 'b' | myValue[i] == 'C' | myValue[i] == 'c' | myValue[i] == 'E' | myValue[i] == 'e' | myValue[i] == 'F'
                            | myValue[i] == 'f' | myValue[i] == 'G' | myValue[i] == 'g' | myValue[i] == 'H' | myValue[i] == 'h' | myValue[i] == 'I' | myValue[i] == 'i'
                            | myValue[i] == 'J' | myValue[i] == 'j' | myValue[i] == 'K' | myValue[i] == 'k' | myValue[i] == 'L' | myValue[i] == 'l' | myValue[i] == 'M'
                            | myValue[i] == 'm' | myValue[i] == 'N' | myValue[i] == 'n' | myValue[i] == 'O' | myValue[i] == 'o' | myValue[i] == 'P' | myValue[i] == 'p'
                            | myValue[i] == 'Q' | myValue[i] == 'q' | myValue[i] == 'S' | myValue[i] == 's' | myValue[i] == 'T' | myValue[i] == 't' | myValue[i] == 'U'
                            | myValue[i] == 'u' | myValue[i] == 'V' | myValue[i] == 'v' | myValue[i] == 'W' | myValue[i] == 'w' | myValue[i] == 'X' | myValue[i] == 'x'
                            | myValue[i] == 'Y' | myValue[i] == 'y' | myValue[i] == 'Z' | myValue[i] == 'z') {

                        DAO.Alertes.alerteErreur("Erreur", "Les lettres et caractères spéciaux sont invalides pour la saisie du numero ");
//                        throw new Exception("Les lettres et caractères spéciaux sont invalides pour la saisie du numero ");
                    }
                }
                return true;
            } else {
                DAO.Alertes.alerteErreur("Erreur", "Ce numero est invalide!");
//                throw new Exception("Ce numero est invalide! :" + valeur);
            }
        } else {

            DAO.Alertes.alerteErreur("Erreur", "Veuillez saisir le numero svp");

        }
        return false;

    }

}
