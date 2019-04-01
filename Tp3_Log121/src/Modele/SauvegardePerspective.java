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

package Modele;

import java.io.Serializable;

/**
 * Classe representant un modele de sauvegarde pour les perspectives. Ce modele est serialisable pour
 * pouvoir sauvegarder dans un fichier.
 * @author Kevin Chenier, Laurent Sieu
 *
 */
public class SauvegardePerspective implements Serializable  {

    private byte[] imageBytes = null;
    private Vector2 vectors[] = null;
    private int zooms[] = null;

    public SauvegardePerspective(byte[] bytesImage, Vector2[] vectors, int[] zooms) {
        this.setImageBytes(bytesImage);
        this.setVectors(vectors);
        this.setZoomLevels(zooms);
    }

    /**
     * Getter pour les bytes representant l'image.
     * @return le array de bytes.
     */
	public byte[] getImageBytes() {
		return imageBytes;
	}

	/**
	 * Setter pour les bytes representant une image.
	 * @param imageBytes, le array de bytes.
	 */
	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}

	/**
	 * Getter pour les positions de toutes les perspectives.
	 * @return les positions.
	 */
	public Vector2[] getVectors() {
		return vectors;
	}

	/**
	 * Setter pour les positions de toutes les perspectives.
	 * @param vectors, les positions.
	 */
	public void setVectors(Vector2 vectors[]) {
		this.vectors = vectors;
	}

	/**
	 * Getter pour les zooms de toutes les perspectives.
	 * @return les zoom levels.
	 */
	public int[] getZoomLevels() {
		return this.zooms;
	}

	/**
	 * Setter pour les zooms de toutes les perspectives.
	 * @param zooms, les zoom levels.
	 */
	public void setZoomLevels(int zooms[]) {
		this.zooms = zooms;
	}
}
