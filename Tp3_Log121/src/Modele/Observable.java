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

import java.util.ArrayList;

/**
 * Classe qui reprensente ce qui est observable (le sujet dans le patron Observateur).
 * @author Kevin
 *
 */
public class Observable {
	
	private ArrayList<Observer> observers;
	
	public Observable() {
		this.observers = new ArrayList<Observer>();
	}
	
	/**
	 * Notifie les observateurs.
	 */
    void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
    
    /**
     * Attache un observateur au sujet.
     * @param observer, un observateur du sujet.
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Enleve un observateur du sujet.
     * @param observer, un observateur a enlever.
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

}
