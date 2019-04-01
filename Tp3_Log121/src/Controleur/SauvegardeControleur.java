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

import Modele.PerspectiveImage;
import Modele.SauvegardePerspective;
import Modele.Vector2;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Cette classe permet de faire le traitement de sauvegarde sur l'image et la perspective.
 * @author Kevin Chenier
 * 
 */
public class SauvegardeControleur {

	private final static String FILE_EXTENSION = "ps";

    /**
     * Cette methode permet de sauvegarder une perspective en fichier.
     *
     * @param images, la liste de perspectives a serialisee.
     * @throws IOException 
     */
    public void sauvegarderFichier(ArrayList<PerspectiveImage> images) throws IOException {
    	
        Vector2 vectors[] = new Vector2[images.size()];
        int zooms[] = new int[images.size()];
        
        int index = 0;
        
        // On va rechercher toutes les perspectives
        for(PerspectiveImage image : images) {
        	vectors[index] = image.getPosition();
        	zooms[index] = image.getZoomLevel();
        	index++;
        }
        
        try {
	        ByteArrayOutputStream bytesImageOutput = new ByteArrayOutputStream();
	        ImageIO.write(images.get(0).getImage(), "png", bytesImageOutput);
	        
	        SauvegardePerspective perspectiveSauvegardee = new SauvegardePerspective(bytesImageOutput.toByteArray(), vectors, zooms);
	        FileOutputStream fileOutput = new FileOutputStream("perspectiveFile." + FILE_EXTENSION);
	        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
	            
	        objectOutput.writeObject(perspectiveSauvegardee);
	        objectOutput.close();
	        
	        System.out.println("Sauvegarde reussi!");
        } catch (Exception e) {
            System.err.println("Error has occured while saving file: " + e);
        }
    }

    /**
     * Cette methode permet de charger un fichier contenant une image et une perspective.
     *
     * @param file, le fichier que l'on peut charger.
     * @param perspectiveController, le controlleur de la perspective.
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public void chargerUnFichier(File file, PerspectiveControleur perspectiveController) throws IOException, ClassNotFoundException{
    	
    	String filePath = file.getAbsolutePath();
            
        // Si l'extension du fichier est FILE_EXTENSION, alors on peut charger le fichier et le traiter
        if(filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length()).equals(FILE_EXTENSION)) {
            	
        	FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream inputObject = new ObjectInputStream(fileInput);

            SauvegardePerspective perspectiveSauvegardee = (SauvegardePerspective) inputObject.readObject();
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(perspectiveSauvegardee.getImageBytes()));
                
            int[] zooms = perspectiveSauvegardee.getZoomLevels();
            Vector2[] vectors = perspectiveSauvegardee.getVectors();
                
            inputObject.close();
            perspectiveController.setPerspectives(image, vectors, zooms);
        } else {
            System.err.println("Erreur lors l'ouverture du fichier. " + "Extension necessaire: ." + FILE_EXTENSION);
        }
    }
}
