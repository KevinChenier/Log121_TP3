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
import Modele.Vector2;

/**
 * La commande qui permet de faire une translation sur une image.
 * @author Kevin Chenier
 *
 */
public class TranslateCommand implements Commande {

	private PerspectiveImage image;
	private Vector2 newPosition;
	
	public TranslateCommand(PerspectiveImage image, Vector2 newPosition) {
		this.image = image;
		this.newPosition = newPosition;
	}
	
	@Override
	public void execute() {
		Vector2 currentImagePosition = this.image.getPosition();
		Vector2 addedPosition = currentImagePosition.addVector(this.newPosition);
		this.image.setPosition(addedPosition);
	}

	@Override
	public void undo() {
		Vector2 currentImagePosition = this.image.getPosition();
		Vector2 revertImagePosition = currentImagePosition.addVector(this.newPosition.oppositeVector());
		this.image.setPosition(revertImagePosition);	
	}
}
