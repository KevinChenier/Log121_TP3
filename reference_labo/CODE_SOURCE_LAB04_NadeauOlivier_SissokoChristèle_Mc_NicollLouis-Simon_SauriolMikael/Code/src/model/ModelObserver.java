/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe:  01
 Projet: Laboratoire #4
 Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko

 Nom du fichier: ModelObserver.java
 Date créé: 2017-03-25
 Date dern. modif. 2017-xx-0xx
 *******************************************************
 Historique des modifications
 *******************************************************
 2017-03-25 Version Initiale -

 *******************************************************/

package model;

/**
 * Cette interface permet d'observer des ModelObservable
 */
public interface ModelObserver {
    /**
     * Méthode qui est lancée quand l'état de l'observé change
     *
     * @param modelObservable L'observé qui a lancé l'évènement
     */
    void update(ModelObservable modelObservable);
}
