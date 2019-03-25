/**
 * ****************************************************
 * Cours:   LOG121
 * Session: H2017
 * Groupe:  01
 * Projet: Laboratoire #4
 * Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko
 *
 * Nom du fichier: MainWindowMenu.java
 * Date créé: 2017-03-25
 * Date dern. modif. 2017-xx-0xx
 *******************************************************
 * Historique des modifications
 *******************************************************
 * 2017-03-25 Version Initiale -
 *
 ******************************************************
 */
package view;

import controller.CommandController;
import controller.PerspectiveController;
import controller.SaveController;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;

class MainWindowMenu extends JMenuBar {

    /**
     * Le chemin par défaut pour ouvrir une image
     */
    private static final String PATH = System.getProperty("user.dir")
            + File.separator + "images";

    /**
     * Lee titre du menu fichier
     */
    private static final String MENU_FILE_TITLE = "File";
    /**
     * Le titre de l'onglet ouvrir du menu fichier
     */
    private static final String MENU_FILE_OPEN = "Open";
    /**
     * Le titre de l'onglet charger du menu fichier
     */
    private static final String MENU_FILE_LOAD = "Load";
    /**
     * Le titre de l'onglet sauvegarder du menu fichier
     */
    private static final String MENU_FILE_SAVE = "Save";
    /**
     * Le titre de l'onglet quitter du menu fichier
     */
    private static final String MENU_FILE_QUIT = "Quit";
    /**
     * Le titre du menu édition
     */
    private static final String MENU_EDIT_TITLE = "Edit";
    /**
     * Le titre de l'onglet annuler du menu édition
     */
    private static final String MENU_EDIT_UNDO = "Undo";
    /**
     * Le titre de l'onglet rétablir du menu édition
     */
    private static final String MENU_EDIT_REDO = "Redo";

    /**
     * Le menu fichier
     */
    private final JMenu menuFile = new JMenu(MENU_FILE_TITLE);
    /**
     * L'item ouvrir du menu fichier
     */
    private final JMenuItem menuFileOpen = new JMenuItem(MENU_FILE_OPEN);
    /**
     * L'item charger du menu fichier
     */
    private final JMenuItem menuFileLoad = new JMenuItem(MENU_FILE_LOAD);
    /**
     * L'item sauvegarder du menu fichier
     */
    private final JMenuItem menuFileSave = new JMenuItem(MENU_FILE_SAVE);
    /**
     * L'item quitter du menu fichier
     */
    private final JMenuItem menuFileQuit = new JMenuItem(MENU_FILE_QUIT);
    /**
     * Le menu édition
     */
    private final JMenu menuEdit = new JMenu(MENU_EDIT_TITLE);
    /**
     * L'item annuler du menu édition
     */
    private final JMenuItem menuEditUndo = new JMenuItem(MENU_EDIT_UNDO);
    /**
     * L'item rétablir du menu édition
     */
    private final JMenuItem menuEditRedo = new JMenuItem(MENU_EDIT_REDO);
    /**
     * Le contrôleur de sauvegarde
     */
    private final SaveController saveController;
    /**
     * Le contrôleur des commandes
     */
    private final CommandController commandController;
    /**
     * Le contrôleur des perspectives
     */
    private final PerspectiveController perspectiveController;
    /**
     * Un sélecteur de fichiers
     */
    private final JFileChooser chooser = new JFileChooser();
    /**
     * Le fichier où effectuer la sauvegarde
     */
    private File file;

    /**
     * Constructeur de la classe MainWindowMenu
     *
     * @param perspectiveController Le contrôleur des perspectives
     */
    MainWindowMenu(PerspectiveController perspectiveController) {
        this.saveController = new SaveController();
        this.commandController = CommandController.getInstance();
        this.perspectiveController = perspectiveController;

        initializeMenuFile();
        initializeMenuEdit();
        initializeEvents();

        this.add(menuFile);
        this.add(menuEdit);
    }

    /**
     * Initialisation du menu fichier
     */
    private void initializeMenuFile() {
        menuFile.add(menuFileOpen);
        menuFile.add(menuFileSave);
        menuFile.add(menuFileLoad);
        menuFile.add(menuFileQuit);
    }

    /**
     * Initialisation du menu édition
     */
    private void initializeMenuEdit() {
        menuEdit.add(menuEditUndo);
        menuEdit.add(menuEditRedo);
    }

    /**
     * Initialise les évènements reliés à chaque item.
     */
    private void initializeEvents() {
        chooser.setCurrentDirectory(new File(PATH));

        menuFileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuFileOpen.addActionListener(actionEvent -> {
            chooser.showOpenDialog(this);
            file = chooser.getSelectedFile();
            perspectiveController.loadImage(file);
        });
        menuFileLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuFileLoad.addActionListener(actionEvent -> {
            chooser.showOpenDialog(this);
            file = chooser.getSelectedFile();
            saveController.load(file, perspectiveController);
        });
        menuFileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuFileSave.addActionListener(actionEvent -> {
            saveController.save(perspectiveController.getImagePerspectives());
        });
        menuFileQuit.addActionListener(actionEvent -> {
            System.exit(0);
        });
        menuEditUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuEditUndo.addActionListener(actionEvent -> {
            commandController.undoLastCommand();
        });
        menuEditRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()
                | KeyEvent.SHIFT_DOWN_MASK));
        menuEditRedo.addActionListener(actionEvent -> {
            commandController.redoLastUndo();
        });
    }
}
