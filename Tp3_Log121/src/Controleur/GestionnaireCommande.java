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

import java.util.Stack;

/**
 * Classe qui permet de gerer les commandes.
 * @author Laurent Sieu, Kevin Chenier
 *
 */
public class GestionnaireCommande {

	private static GestionnaireCommande GestionnaireCommandeSingleton = new GestionnaireCommande();
	
	// Tous les commandes qui ont ete executees depuis le debut
	Stack<Commande> commandesExecutees = new Stack<Commande>();	
	// Les commande qui ont ete "undone", utilisee pour le redo
	Stack<Commande> commandesDefaites = new Stack<Commande>();	
	
	private GestionnaireCommande() { }
	
	/**
	 * Annuler la derniere commande.
	 */
	public void undo() {
		
		if(!commandesExecutees.empty()) {
			Commande vieilleCommande = commandesExecutees.pop();
			vieilleCommande.undo();
			commandesDefaites.push(vieilleCommande);
		}
	}
	
	/**
	 * Refaire une commande qui a ete undo.
	 * @param unecommande
	 */
	public void redo() {
		
		if(!commandesDefaites.empty()) {
			Commande dernierUndo = commandesDefaites.pop();
			dernierUndo.execute();
			commandesExecutees.push(dernierUndo);
		}
	}
	
	/**
	 * Executer une commande.
	 * @param uneCommande
	 */
	public void executeCommande(Commande uneCommande) {
		uneCommande.execute();
		commandesExecutees.push(uneCommande);
		commandesDefaites.clear();
	}
	
	/**
	 * Getteur de singleton de GestionnaireCommande.
	 * @return l'instance unique.
	 */
	public static GestionnaireCommande getInstance() {
		return GestionnaireCommandeSingleton;
	}
}
