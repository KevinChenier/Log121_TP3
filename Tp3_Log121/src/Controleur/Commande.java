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

/**
 * Interface utilisee pour faire le patron Commande.
 * @author Laurent Sieu 
 * 
 */
public interface Commande {
	/**
	 * Execute une commande
	 */
	public void execute();
	
	/**
	 * Retire les effets de la derniere commande
	 */
	public void undo();
	
}
