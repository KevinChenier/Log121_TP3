/**
 * ****************************************************
 * Cours:   LOG121
 * Session: H2017
 * Groupe:  01
 * Projet: Laboratoire #4
 * Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko
 *
 * Nom du fichier: PerspectiveController.java
 * Date créé: 2017-03-25
 * Date dern. modif. 2017-xx-0xx
 *******************************************************
 * Historique des modifications
 *******************************************************
 * 2017-03-25 Version Initiale -
 *
 ******************************************************
 */
package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import model.ImagePerspective;
import model.TranslationCommand;
import model.Vector2D;
import model.ZoomCommand;

/**
 * Cette classe gère les images et leurs perspectives
 */
public class PerspectiveController implements Serializable {

    /**
     * Une instance de CommandController
     */
    private final CommandController commandController = CommandController.getInstance();
    /**
     * La liste des images et leurs perspectives
     */
    private ArrayList<ImagePerspective> imagePerspectives;

    /**
     * Méthode qui permet de charger une image à partir d'un objet File
     *
     * @param file Le fichier d'où charger l'image
     */
    public void loadImage(File file) {
        if (file != null) {
            try {
                BufferedImage img = ImageIO.read(file);

                imagePerspectives.stream().forEach((imagePerspective) -> {
                    imagePerspective.setBufferedImage(img);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Méthode chargeant les perspectives sauvegardées.
     * @param image L'image
     * @param tabVector Les translations des perspectives
     * @param tabZoom Les zoom des perspectives
     */
    public void loadSavedPerspectives(BufferedImage image, Vector2D[] tabVector,
            double[] tabZoom) {
        for (int i = 0; i < imagePerspectives.size(); i++) {
            imagePerspectives.get(i).setBufferedImage(image);
            imagePerspectives.get(i).setZoomLevel(tabZoom[i]);
            imagePerspectives.get(i).setVector2D(tabVector[i]);
        }
    }

    /**
     * Méthode qui permet d'appliquer un vecteur de mouvement à une perspective.
     *
     * @param idPerspective L'identifiant de la perspective à modifier
     * @param vecteur Le vecteur de mouvement à ajouter
     */
    public void translate(int idPerspective, Vector2D vecteur) {
        if (idPerspective != 0) {
            commandController.executeCommand(
                    new TranslationCommand(imagePerspectives.get(idPerspective),
                            vecteur));
        }
    }

    /**
     * Méthode qui permet d'affecter le zoom de l'image selon les paramètres
     * reçus
     *
     * @param idPerspective L'identifiant de la perspective à modifier
     * @param wheelValue La valeur du mouvement de la molette de la souris
     */
    public void zoom(int idPerspective, int wheelValue) {
        if (idPerspective != 0) {
            ImagePerspective imagePerspective = imagePerspectives.get(idPerspective);
            int zoomLevel = (int) imagePerspective.getZoomLevel() + wheelValue;
            commandController.executeCommand(new ZoomCommand(imagePerspective,
                    zoomLevel));
        }
    }

    /**
     * Méthode qui retourne une liste de ImagePerspective
     *
     * @return imagePerspective La liste d'images perspectives
     */
    public ArrayList<ImagePerspective> getImagePerspectives() {
        return this.imagePerspectives;
    }

    /**
     * Méthode qui permet de modifier la liste imagePerspectives
     *
     * @param imagePerspectives La nouvelle liste de perspectives
     */
    public void setImagePerspectives(ArrayList<ImagePerspective> imagePerspectives) {
        this.imagePerspectives = imagePerspectives;
    }
}
