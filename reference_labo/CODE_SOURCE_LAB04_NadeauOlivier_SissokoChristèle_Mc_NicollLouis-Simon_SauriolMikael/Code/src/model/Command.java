/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe:  01
 Projet: Laboratoire #4
 Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko

 Nom du fichier: Command.java
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
 * Abstraction d'une commande
 */
public abstract class Command implements Serializable {

    /**
     * La perspective sur laquelle la commande est appliquée
     */
    private final ImagePerspective imagePerspective;

    /**
     * Constructeur de la classe Command
     *
     * @param imagePerspective La perspective sur laquelle la commande est appliquée
     */
    Command(ImagePerspective imagePerspective) {
        this.imagePerspective = imagePerspective;
    }

    /**
     * Cette méthode retourne un objet imagePerspective
     *
     * @return La perspective sur laquelle la commande est appliquée
     */
    ImagePerspective getImagePerspective() {
        return imagePerspective;
    }

    /**
     * Définit le comportement de la commande lorsqu'elle est exécutée
     */
    public abstract void execute();

    /**
     * Définit le comportement de la commande lorsqu'elle est annulée
     */
    public abstract void undo();
}
