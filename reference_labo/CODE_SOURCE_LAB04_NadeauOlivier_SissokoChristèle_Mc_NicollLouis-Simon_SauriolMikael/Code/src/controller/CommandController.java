/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe:  01
 Projet: Laboratoire #4
 Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko

 Nom du fichier: CommandController.java
 Date créé: 2017-03-25
 Date dern. modif. 2017-xx-0xx
 *******************************************************
 Historique des modifications
 *******************************************************
 2017-03-25 Version Initiale -

 *******************************************************/

package controller;

import java.io.Serializable;
import java.util.Stack;
import model.Command;

/**
 * Cette classe gère toute les commandes de l'appliccation.
 */
public class CommandController implements Serializable {

    /**
     * Initialisation d'un seul CommandController
     */
    private static final CommandController ourInstance = new CommandController();

    /**
     * Méthode qui permet de retourner l'instance CommandController
     *
     * @return L'instance unique de CommandController
     */
    public static CommandController getInstance() {
        return ourInstance;
    }

    /**
     * La pile des commandes exécutées.
     */
    private Stack<Command> executedCommands = new Stack<>();
    /**
     * La pile des commandes annulées.
     */
    private Stack<Command> undoneCommands = new Stack<>();

    /**
     * Constructeur privé de la classe CommandController
     */
    private CommandController() {
    }

    /**
     * Méthode qui reçoit une commande, l'exécute et l'enregistre.
     *
     * @param command La commande à exécuter
     */
    void executeCommand(Command command) {
        command.execute();
        executedCommands.push(command);
        undoneCommands.clear();
    }

    /**
     * Méthode qui permet d'anuler la dernière commande.
     */
    public void undoLastCommand() {
        if (!executedCommands.empty()) {
            Command lastCommand = executedCommands.pop();
            lastCommand.undo();
            undoneCommands.push(lastCommand);
        }
    }

    /**
     * Méthode qui permet de réexécuter une commande annulée.
     */
    public void redoLastUndo() {
        if (!undoneCommands.empty()) {
            Command lastUndoneCommand = undoneCommands.pop();
            lastUndoneCommand.execute();
            executedCommands.push(lastUndoneCommand);
        }
    }
}
