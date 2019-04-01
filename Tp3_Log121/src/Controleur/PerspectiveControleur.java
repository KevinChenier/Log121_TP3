/******************************************************
Cours:   LOG121
Session: H2019
Groupe:  04
Projet: Laboratoire #3
Étudiant(e)s: Eugene Wiafe, Ian Garcia-Guerrero, Kevin Chenier, Laurent Sieu
              
              
Professeur : Ghizlane El Boussaidi
Nom du fichier: CadrePrincipale.java
Date cree: 2019-03-25
Date dern. modif. 2019-03-25
*******************************************************
Historique des modifications
*******************************************************

*******************************************************/

package Controleur;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import Modele.PerspectiveImage;
import Modele.Vector2;

/**
 * Cette classe sert a gerer les images et les perspectives.
 * @author Kevin Chenier, Laurent Sieu
 * bvvv
 */
public class PerspectiveControleur {

	// Le ID qui represente l'image principal
	public final int ID_MAIN_IMAGE = 0;
    private final GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

    private ArrayList<PerspectiveImage> perspectivesImages;

    /**
     * Methode qui permet de setter les perspectives des images.
     * @param image, L'image
     * @param vectors, Les vecteurs positions des images
     * @param zooms, Les zooms des perspectives
     */
    public void setPerspectives(BufferedImage bufferedImage, Vector2[] vectors, int[] zooms) {
        
    	int index = 0;
    	
    	for(PerspectiveImage image : perspectivesImages) {
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
 
        	//On set les 3 images selon le fichier.
            for(PerspectiveImage image : this.perspectivesImages) {
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
    	// Doit etre plus grand que le ID de l'image principale, car l'image principale ne peut etre zoomee.
        if (ID > ID_MAIN_IMAGE) {
            gestionnaireCommande.executeCommande(
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
    	// Doit etre plus grand que le ID de l'image principale, car l'image principale ne peut etre bougee.
        if (ID > ID_MAIN_IMAGE) {
        	gestionnaireCommande.executeCommande(
                    new TranslateCommand(this.perspectivesImages.get(ID), vector));
        }
    }
    
    /**
     * Methode qui modifie la liste de perspectives.
     *
     * @param imagePerspectives La nouvelle liste de perspectives
     */
    public void setImages(ArrayList<PerspectiveImage> imagePerspectives) {
        this.perspectivesImages = imagePerspectives;
    }

    /**
     * Methode qui retourne la liste de perspectives.
     *
     * @return imagePerspective La liste d'images perspectives
     */
    public ArrayList<PerspectiveImage> getImages() {
        return this.perspectivesImages;
    }
}
