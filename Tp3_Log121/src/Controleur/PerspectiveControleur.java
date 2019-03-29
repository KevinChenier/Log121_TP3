package Controleur;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import Modele.Image;
import Modele.Vector2;

/**
 * Cette classe gère les images et leurs perspectives
 */
public class PerspectiveControleur {

    private final GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

    private ArrayList<Image> perspectivesImages;

    /**
     * Methode qui permet de setter les perspectives des images.
     * @param image, L'image
     * @param vectors, Les vecteurs positions des images
     * @param zooms, Les zooms des perspectives
     */
    public void setPerspectives(BufferedImage bufferedImage, Vector2[] vectors, int[] zooms) {
        
    	int index = 0;
    	
    	for(Image image : perspectivesImages) {
        	image.setImage(bufferedImage);
        	image.setZoomLevel(zooms[index]);
        	image.setPosition(vectors[index]);
        	index++;
        }
    }
    
    /**
     * Methode qui permet de charger une image sur les trois perspectives.
     * @param file, le fichier image
     * @throws IOException 
     */
    public void setImages(File file) throws IOException {
    	
    	//Si le fichier est valide.
        if (file != null) {
        	BufferedImage bufferedImage = ImageIO.read(file);

        	//On set les 3 images selon le fichiers.
            for(Image image : this.perspectivesImages) {
                image.setImage(bufferedImage);
            }
        }
    }
    
    /**
     * Methode qui permet d'appliquer un zoom sur une image.
     *
     * @param ID, L'identifiant de la perspective.
     * @param cursorValue, La valeur du mouvement de la roulette de la souris.
     */
    public void zoomer(int ID, int cursorValue) {
        if (ID > 0) {
            gestionnaireCommande.executerCommande(
            		new ZoomCommand(this.perspectivesImages.get(ID), this.perspectivesImages.get(ID).getZoomLevel() + cursorValue));
        }
    }

    /**
     * Methode qui permet d'appliquer la translation sur une image.
     *
     * @param ID, L'identifiant de la perspective.
     * @param vector, Le vecteur de translation.
     */
    public void translate(int ID, Vector2 vector) {
        if (ID > 0) {
        	gestionnaireCommande.executerCommande(
                    new TranslateCommand(this.perspectivesImages.get(ID), vector));
        }
    }
    
    /**
     * Methode qui modifie la liste de perspectives.
     *
     * @param imagePerspectives La nouvelle liste de perspectives
     */
    public void setImages(ArrayList<Image> imagePerspectives) {
        this.perspectivesImages = imagePerspectives;
    }

    /**
     * Methode qui retourne la liste de perspectives.
     *
     * @return imagePerspective La liste d'images perspectives
     */
    public ArrayList<Image> getImages() {
        return this.perspectivesImages;
    }
}
