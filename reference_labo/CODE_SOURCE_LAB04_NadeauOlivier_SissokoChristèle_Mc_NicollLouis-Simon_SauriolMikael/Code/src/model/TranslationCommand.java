/**
 * ****************************************************
 * Cours:   LOG121
 * Session: H2017
 * Groupe:  01
 * Projet: Laboratoire #4
 * Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko
 *
 * Nom du fichier: TranslationCommand.java
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
 * Cette classe permet d'appliquer une translation à une perspective et
 * éventuellement de l'annuler
 */
public class TranslationCommand extends Command {

    /**
     * La direction et l'ampleur de la translation sous forme de vecteur
     */
    private final Vector2D vector2D;

    /**
     * Constructeur de TranslationCommand
     *
     * @param imagePerspective La perspective à laquelle appliquer la
     * transformation
     * @param vector2D La direction et l'ampleur de la translation
     */
    public TranslationCommand(ImagePerspective imagePerspective, Vector2D vector2D) {
        super(imagePerspective);
        this.vector2D = vector2D;
    }

    /**
     * L'exécution de la translation
     */
    @Override
    public void execute() {
        getImagePerspective().setVector2D(getImagePerspective().getVector2D()
                .addVector(vector2D));
    }

    /**
     * L'annulation de la translation
     */
    @Override
    public void undo() {
        getImagePerspective().setVector2D(getImagePerspective().getVector2D()
                .addVector(vector2D.getOpposite()));
    }
}
