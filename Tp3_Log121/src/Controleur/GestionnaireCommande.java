package Controleur;

import java.util.ArrayList;
import java.util.Stack;

public class GestionnaireCommande {
	//SINGLETON
	private static GestionnaireCommande GestionnaireCommandeSingleton = new GestionnaireCommande();
	//ATTRIBUTS 
	Stack<Commande> pileDeCommande = new Stack<Commande>();	
	Stack<Commande> pileDeCommandeDesuete = new Stack<Commande>();	
	
	
	
	
	
	//METHODES
	/**
	 * Il est important de noter que nous ne faisons que reexcuter une commande. Cela ne retourne pas exactement l'etat rechercher.
	 * A voir comment resoudre cela
	 * @see Commande#execute()
	 * @param uneCommnade
	 */
	public void undo(Commande uneCommande) {
		Commande vieilleCommande = pileDeCommande.pop();
		vieilleCommande.execute();
		pileDeCommandeDesuete.add(vieilleCommande);
		
	}
	/**
	 * 
	 * @param unecommande
	 */
	public void UndoDernierUndo(Commande unecommande) {
		
	}
	/**
	 * 
	 * @param uneCommande
	 */
	
	public void executerCommande(Commande uneCommande) {
		uneCommande.execute();
		pileDeCommande.add(uneCommande);
	}
	
	
	//CONSTRUCTEURS
	private GestionnaireCommande() {
	}
	//GETTER / SETTER
	/**
	 * Getteur de singleton GestionnaireCommande
	 * @return
	 */
	public static GestionnaireCommande getSingletonGestComm() {
		return GestionnaireCommandeSingleton;
	}
}
