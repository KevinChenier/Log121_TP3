package Controleur;

import java.util.ArrayList;
import java.util.Stack;

public class GestionnaireCommande {
	//SINGLETON
	private static GestionnaireCommande GestionnaireCommandeSingleton = new GestionnaireCommande();
	
	//ATTRIBUTS 
	Stack<Commande> pileDeCommandes = new Stack<Commande>();	
	Stack<Commande> pileDeCommandeDesuete = new Stack<Commande>();	
	
	private GestionnaireCommande() { }
	
	//METHODES
	/**
	 * Il est important de noter que nous ne faisons que reexcuter une commande. Cela ne retourne pas exactement l'etat rechercher.
	 * A voir comment resoudre cela
	 * @see Commande#execute()
	 * @param uneCommnade
	 */
	public void undo(Commande uneCommande) {
		
		if(!pileDeCommandes.empty()) {
			Commande vieilleCommande = pileDeCommandes.pop();
			vieilleCommande.undo();
			pileDeCommandeDesuete.add(vieilleCommande);
		}
	}
	
	/**
	 * 
	 * @param unecommande
	 */
	public void UndoDernierUndo(Commande unecommande) {
		
		if(!pileDeCommandeDesuete.empty()) {
			Commande dernierUndo = pileDeCommandeDesuete.pop();
			dernierUndo.execute();
		}
	}
	
	/**
	 * 
	 * @param uneCommande
	 */
	public void executerCommande(Commande uneCommande) {
		uneCommande.execute();
		pileDeCommandes.push(uneCommande);
	}
	
	//GETTER / SETTER
	/**
	 * Getteur de singleton GestionnaireCommande
	 * @return
	 */
	public static GestionnaireCommande getInstance() {
		return GestionnaireCommandeSingleton;
	}
}
