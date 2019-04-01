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

/**
 * Interface pour le patron Observateur.
 * @author Kevin Chenier
 *
 */
public interface Observer {
	
	public void update(Observable observable);

}
