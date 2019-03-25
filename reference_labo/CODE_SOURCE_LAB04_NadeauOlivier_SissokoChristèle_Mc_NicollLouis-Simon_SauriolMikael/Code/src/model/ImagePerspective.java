/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe:  01
 Projet: Laboratoire #4
 Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko

 Nom du fichier: ImagePerspective.java
 Date créé: 2017-03-25
 Date dern. modif. 2017-xx-0xx
 *******************************************************
 Historique des modifications
 *******************************************************
 2017-03-25 Version Initiale -

 *******************************************************/

package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Cette classe permet de gérer tout ce qui a rapport èa la perspective et l'image
 */
public class ImagePerspective extends ModelObservable implements Serializable {

    /**
     * Le niveau de zoom par défaut
     */
    private static final double DEFAULT_ZOOM_LEVEL = 1;
    /**
     * L'image
     */
    private BufferedImage bufferedImage;
    /**
     * Le déplacement de l'image
     */
    private Vector2D vector2D;
    /**
     * Le niveau de zoom de l'image
     */
    private double zoomLevel;

    /**
     * Constructeur de la classe ImagePerspective
     */
    public ImagePerspective() {
        vector2D = Vector2D.NULL_VECTOR;
        zoomLevel = DEFAULT_ZOOM_LEVEL;
    }

    /**
     * La méthode getBufferedImage retourne l'objet bufferedImage
     *
     * @return l'image
     */
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    /**
     * La méthode getVector2D retourne l'objet vector2d
     *
     * @return Le vecteur de déplacement de l'image
     */
    public Vector2D getVector2D() {
        return vector2D;
    }

    /**
     * Cette méthode permet de définir le bufferedImage et notifie les 
     * observateurs.
     *
     * @param bufferedImage La nouvelle image
     */
    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        notifyObservers();
    }

    /**
     * Cette méthode permet d'obtenir la valeur du niveau du zoom
     *
     * @return Le niveau de zoom
     */
    public double getZoomLevel() {
        return zoomLevel;
    }

    /**
     * Cette méthode permet de définir le vector2D et notifie les observateurs.
     *
     * @param vector2D Le nouveau déplacement de l'image
     */
    public void setVector2D(Vector2D vector2D) {
        this.vector2D = vector2D;
        notifyObservers();
    }

    /**
     * Cette méthode permet de définir la valeur du zoom et notifie les
     * observateurs.
     *
     * @param zoomLevel Le nouveau niveau de zoom
     */
   public  void setZoomLevel(double zoomLevel) {
        this.zoomLevel = zoomLevel;
        notifyObservers();
    }
}
