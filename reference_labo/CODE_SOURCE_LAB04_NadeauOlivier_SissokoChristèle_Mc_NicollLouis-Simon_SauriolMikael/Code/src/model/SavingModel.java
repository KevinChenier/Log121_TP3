/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe:  01
 Projet: Laboratoire #4
 Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko

 Nom du fichier: SavingModel.java
 Date créé: 2017-03-25
 Date dern. modif. 2017-xx-0xx
 *******************************************************
 Historique des modifications
 *******************************************************
 2017-03-25 Version Initiale -
 *******************************************************/
package model;

import java.io.Serializable;

/**
 * Classe contenant les éléments à sauvegarder des ImagePerspective mais dans
 * un format sérializable.
 */
public class SavingModel implements Serializable {
    /**
     * L'image sous format d'octets.
     */
    byte[] imageBytes = null;
    /**
     * Le tableau des déplacements des perspectives
     */
    Vector2D tabVector[] = null;
    /**
     * Le tableau de niveaux de zoom des perspectives
     */
    double tabZoomLevel[] = null;

    public SavingModel(byte[] imageBytes, Vector2D[] tabVector, double[] tabZoomLevel) {
        this.imageBytes = imageBytes;
        this.tabVector = tabVector;
        this.tabZoomLevel = tabZoomLevel;
    }
}
