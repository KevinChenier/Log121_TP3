/**
 * ****************************************************
 * Cours:   LOG121
 * Session: H2017
 * Groupe:  01
 * Projet: Laboratoire #4
 * Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko
 *
 * Nom du fichier: ZoomCommand.java
 * Date créé: 2017-03-25
 * Date dern. modif. 2017-xx-0xx
 *******************************************************
 * Historique des modifications
 *******************************************************
 * 2017-03-25 Version Initiale -
 *
 ******************************************************
 */
package model;

/**
 * Perment de changer le niveau de zoom d'une perspective et de potentiellement
 * retourner à l'ancien niveau de zoom.
 */
public class ZoomCommand extends Command {

    /**
     * Le nouveau niveau de zoom 
     */
    private double zoomLevel;
    /**
     * L'ancien niveau de zoom. Utilisé avec d'annuler le changement
     */
    private double previousZoomLevel;

    /**
     * Constructeur de la classe ZoomCommand
     *
     * @param imagePerspective La perspective dont il faut changer le niveau de
     * zoom
     * @param zoomTotal Entier représentant le nouveau zoom total
     */
    public ZoomCommand(ImagePerspective imagePerspective, int zoomLevel) {
        super(imagePerspective);

        this.previousZoomLevel = imagePerspective.getZoomLevel();
        this.zoomLevel = zoomLevel;
    }

    /**
     * Change le niveau de zoom pour le nouveau.
     */
    @Override
    public void execute() {
        getImagePerspective().setZoomLevel(zoomLevel);
    }

    /**
     * Refait le dernier niveau de zoom.
     */
    @Override
    public void undo() {
        getImagePerspective().setZoomLevel(this.previousZoomLevel);
    }

}
