/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe:  01
 Projet: Laboratoire #4
 Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko

 Nom du fichier: Vector2D.java
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
 * Classe contenant une valeur X et une valeur Y représentant un vecteur en deux
 * dimensions.
 */
public class Vector2D implements Serializable {
    /**
     * Le vecteur nul.
     */
    public static final Vector2D NULL_VECTOR = new Vector2D(0, 0);
    /**
     * La valeur en X
     */
    private final int x;
    /**
     * La valeur en Y
     */
    private final int y;

    /**
     * Constructeur de la classe Vector2D avec une valeur en X et Y
     * @param x La valeur en X
     * @param y La valeur en Y
     */
    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Cette méthode retourne la valeur en X
     *
     * @return La valeur en x
     */
    public int getX() {
        return x;
    }

    /**
     * Cette méthode retourne la valeur en Y
     *
     * @return La valeur en Y
     */
    public int getY() {
        return y;
    }

    /**
     * Créer un nouveau vecteur qui est l'addition du vecteur courant et de 
     * celui reçu en paramètre.
     *
     * @param vector2D Le vecteur à ajouter au vecteur courant
     * @return un nouvel objet de type Vector2D
     */
    public Vector2D addVector(Vector2D vector2D) {
        return new Vector2D(this.x + vector2D.x, this.y + vector2D.y);
    }

    /**
     * Créer un nouveau vecteur qui est l'inverse du vecteur courant.
     *
     * @return L'inverse du vecteur courant
     */
    public Vector2D getOpposite() {
        return new Vector2D(-x, -y);
    }

}
