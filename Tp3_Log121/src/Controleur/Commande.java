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
