/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe:  01
 Projet: Laboratoire #4
 Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko

 Nom du fichier: SaveController.java
 Date créé: 2017-03-25
 Date dern. modif. 2017-xx-0xx
 *******************************************************
 Historique des modifications
 *******************************************************
 2013-03-25 Version Initiale -

 *******************************************************/
package controller;

import model.ImagePerspective;
import model.Serializer;


import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Cette classe permet de faire le traitement de sauvegarde sur l'image et la perspective
 */
public class SaveController {
    /**
     * Cette méthode permet d'enregistrer une liste d'imagePerspectives
     *
     * @param images Liste des perspectives
     */
    public void save(ArrayList<ImagePerspective> images) {
        ArrayList<ImagePerspective> receivedImages = images;
        Boolean saved = Serializer.saveToFile(images);

        if(saved) {
            JOptionPane.showMessageDialog(null,"Sauvegardé !",
                    "Sauvegarde",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,"Erreur lors de la " +
                    "sauvegarde !","Sauvegarde",JOptionPane.ERROR_MESSAGE);
        }

    }

        /**
         * Cette méthode permet de charger un fichier
         *
         * @param file Fichier a charger
         */
        public void load(File file, PerspectiveController perspectiveController) {
            Serializer.loadFromFile(file, perspectiveController);
        }
}
