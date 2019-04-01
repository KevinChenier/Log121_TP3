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

/**
 * La commande qui permet de faire un zoomp sur une image.
 * @author Laurent Sieu
 *
 */
public class ZoomCommand implements Commande {

	private PerspectiveImage image;
	private int zoomLevel;
	private int previousZoomLevel;
	
	public ZoomCommand(PerspectiveImage image, int zoomLevel) {
		this.image = image;
		this.previousZoomLevel = image.getZoomLevel();
		this.zoomLevel = zoomLevel;
	}

	@Override
	public void execute() {
		this.image.setZoomLevel(this.zoomLevel);
	}

	@Override
	public void undo() {
		this.image.setZoomLevel(previousZoomLevel);
	}
}
