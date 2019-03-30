package Controleur;

import java.util.Stack;

public class GestionnaireCommande {

	private static GestionnaireCommande GestionnaireCommandeSingleton = new GestionnaireCommande();
	
	Stack<Commande> commandesExecutees = new Stack<Commande>();	
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
	 * Refaire une commande qui a ete undo
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
	 * 
	 * @param uneCommande
	 */
	public void executerCommande(Commande uneCommande) {
		uneCommande.execute();
		commandesExecutees.push(uneCommande);
		commandesDefaites.clear();
	}
	
	/**
	 * Getteur de singleton GestionnaireCommande
	 * @return
	 */
	public static GestionnaireCommande getInstance() {
		return GestionnaireCommandeSingleton;
	}
}
