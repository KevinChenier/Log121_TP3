package Controleur;

public class GestionnaireCommande {
	private static GestionnaireCommande GestionnaireCommandeSingleton = new GestionnaireCommande();
	//Constructeur
	private GestionnaireCommande() {
		
	}
	
	/**
	 * Getteur de singleton GestionnaireCommande
	 * @return
	 */
	public static GestionnaireCommande getSingletonGestComm() {
		return GestionnaireCommandeSingleton;
	}
}
