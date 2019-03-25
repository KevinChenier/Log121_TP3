/**
 * ****************************************************
 * Cours:   LOG121
 * Session: H2017
 * Groupe:  01
 * Projet: Laboratoire #4
 * Étudiant(e)s: Louis-Simon McNicoll, Olivier Nadeau, Mikaël Sauriol et Christelle Sissoko
 *
 * Nom du fichier: MainWindow.java
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

import controller.PerspectiveController;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import model.ImagePerspective;

/**
 * Gère les différents composants de l'application et leur instantiation.
 */
public class MainWindow extends JFrame {

    /**
     * La taille de l'écran
     */
    private static final Dimension SCREEN_SIZE
            = Toolkit.getDefaultToolkit().getScreenSize();
    private static final double OCCUPATION_RATION_HALF = 0.5;
    private static final double OCCUPATION_RATION_ALL = 1;
    /**
     * Le nombre de perspectives à instantcier.
     */
    private static final int NB_PERSPECTIVES = 3;

    /**
     * La perspective servant de référence
     */
    private PerspectiveView thumbnail;
    /**
     * La perspective de gauche
     */
    private PerspectiveView perspectiveViewLeft;
    /**
     * La perspective de droite
     */
    private PerspectiveView perspectiveViewRight;
    /**
     * Le contrôleur des perspectives
     */
    private final PerspectiveController perspectiveController;

    /**
     * Constructeur de MainWindow
     */
    public MainWindow() {
        this.perspectiveController = new PerspectiveController();

        setupWindow();
        setupViews();
        setupPerspectives();
        this.setJMenuBar(new MainWindowMenu(perspectiveController));
        this.setVisible(true);
    }

    /**
     * Instancie les perspectives, les attache à leurs observateurs et les
     * affecte au contrôleur
     */
    private void setupPerspectives() {
        ArrayList<ImagePerspective> imagePerspectives = new ArrayList<>(NB_PERSPECTIVES);
        ImagePerspective imagePerspective1 = new ImagePerspective();
        ImagePerspective imagePerspective2 = new ImagePerspective();
        ImagePerspective imagePerspective3 = new ImagePerspective();

        imagePerspective1.attach(thumbnail);
        imagePerspective2.attach(perspectiveViewLeft);
        imagePerspective3.attach(perspectiveViewRight);

        imagePerspectives.add(imagePerspective1);
        imagePerspectives.add(imagePerspective2);
        imagePerspectives.add(imagePerspective3);

        perspectiveController.setImagePerspectives(imagePerspectives);
    }

    /**
     * Défini les paramètres de la fenêtre de l'application
     */
    private void setupWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize((int) SCREEN_SIZE.getWidth() / 2, (int) SCREEN_SIZE.getHeight() / 2);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
    }

    /**
     * Instancie les vues et la gestion de la disposition par le LayoutManager
     */
    private void setupViews() {
        thumbnail = new PerspectiveView(0, OCCUPATION_RATION_HALF,
                perspectiveController);
        perspectiveViewLeft = new PerspectiveView(1, OCCUPATION_RATION_ALL,
                perspectiveController);
        perspectiveViewRight = new PerspectiveView(2, OCCUPATION_RATION_ALL,
                perspectiveController);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(thumbnail, constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(perspectiveViewLeft, constraints);
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(perspectiveViewRight, constraints);
    }
}
