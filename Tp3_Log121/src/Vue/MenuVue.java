/******************************************************
Cours:   LOG121
Session: H2019
Groupe:  04
Projet: Laboratoire #3
Étudiant(e)s: Eugene Wiafe, Ian Garcia-Guerrero, Kevin Chénier, Laurent Sieu
              
              
Professeur : Ghizlane El Boussaidi
Nom du fichier: MenuVue.java
Date créé: 2019-03-25
Date dern. modif. 2019-03-25
*******************************************************
Historique des modifications
*******************************************************

*******************************************************/
package Vue;

import java.io.File;
import java.io.IOException;

import javax.swing.*;

import Controleur.GestionnaireCommande;
import Controleur.PerspectiveControleur;
import Controleur.SauvegardeControleur;

public class MenuVue extends JMenuBar {

	/**
	 * Le chemin par défaut pour ouvrir une image
	 */
	private static final String PATH = System.getProperty("user.dir") + File.separator + "images_test";

	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenuItem openImage;
	private JMenuItem saveImage;
	private JMenuItem menuUndo;
	private JMenuItem menuRedo;

	private final JFileChooser choicedFile = new JFileChooser();
	private File file;

	private PerspectiveControleur perspectiveControleur;
	private SauvegardeControleur save;
	private final GestionnaireCommande commande;

	/*
	 * Constructeur de la classe MenuVue
	 */
	public MenuVue(PerspectiveControleur perspectiveControleur) {

		save = new SauvegardeControleur();
		commande = GestionnaireCommande.getInstance();
		this.perspectiveControleur = perspectiveControleur;

		initComponents();
		initEvents();
		this.add(menuFile);
		this.add(menuEdit);
	}

	/*
	 * Initialisation des menus et des items des menus
	 */
	private void initComponents() {

		menuFile = new JMenu("File");
		menuEdit = new JMenu("Edit");

		openImage = new JMenuItem("Open Image");
		saveImage = new JMenuItem("Save Images");
		menuUndo = new JMenuItem("Undo");
		menuRedo = new JMenuItem("Redo");

		menuFile.add(openImage);
		menuFile.add(saveImage);

		menuEdit.add(menuUndo);
		menuEdit.add(menuRedo);
	}

	/*
	 * Initialisation de tout les comportements des items
	 */
	private void initEvents() {

		choicedFile.setCurrentDirectory(new File(PATH));

		openImage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					openImageActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});

		saveImage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					saveImageActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		menuUndo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				undoActionPerformed(evt);
			}
		});

		menuRedo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				redoActionPerformed(evt);
			}
		});

	}

	private void openImageActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		choicedFile.showOpenDialog(this);
		file = choicedFile.getSelectedFile();
		perspectiveControleur.setImages(file);

		System.out.println(choicedFile.getSelectedFile().getName() + " succesfully loaded!");
	}

	private void saveImageActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException, IOException {
		 choicedFile.showOpenDialog(this);
         file = choicedFile.getSelectedFile();
         save.chargerUnFichier(file, perspectiveControleur);

	}

	private void undoActionPerformed(java.awt.event.ActionEvent evt) {
		commande.undo();
	}
	
	private void redoActionPerformed(java.awt.event.ActionEvent evt) {
		commande.redo();
	}

}
