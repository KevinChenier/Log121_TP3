/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe:  01
 Projet: Laboratoire #4
 Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko

 Nom du fichier: ModelObservable.java
 Date créé: 2017-03-25
 Date dern. modif. 2017-xx-0xx
 *******************************************************
 Historique des modifications
 *******************************************************
 2017-03-25 Version Initiale -

 *******************************************************/
package model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe permettant à un objet l'héritant d'être observé.
 */
public abstract class ModelObservable implements Serializable {

    /**
     * La liste des observateurs
     */
    private final List<ModelObserver> observers;

    ModelObservable() {
        this.observers = new LinkedList<>();
    }

    /**
     * Cette méthode notify tous les observateurs
     */
    void notifyObservers() {
        for (ModelObserver observer : observers) {
            observer.update(this);
        }
    }

    /**
     * Cette méthode ajoute un observateur au modelObserver.
     *
     * @param modelObserver Le nouvel observateur
     */
    public void attach(ModelObserver modelObserver) {
        observers.add(modelObserver);
    }

    /**
     * Cette méthode enlève un observateur au modelObserver
     *
     * @param modelObserver L'observateur à retirer
     */
    public void detach(ModelObserver modelObserver) {
        observers.remove(modelObserver);
    }
}
