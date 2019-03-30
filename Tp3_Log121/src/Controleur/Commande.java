package Controleur;
/**
 * 
 * @author laurent sieu 
 * @see GestionnaireCommande
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
