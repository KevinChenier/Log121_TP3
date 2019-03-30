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
	private JMenuItem menuUndo1;
	private JMenuItem menuUndo2;

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
		menuUndo1 = new JMenuItem("Undo1");
		menuUndo2 = new JMenuItem("Undo2");

		menuFile.add(openImage);
		menuFile.add(saveImage);

		menuEdit.add(menuUndo1);
		menuEdit.add(menuUndo2);
	}

	/*
	 * Initialisation de tout les comportements des items
	 */
	private void initEvents() {

		choicedFile.setCurrentDirectory(new File(PATH));

		openImage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openImageActionPerformed(evt);
			}
		});

		saveImage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveImageActionPerformed(evt);
			}
		});

		menuUndo1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				undo1ActionPerformed(evt);
			}
		});

		menuUndo2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				undo1ActionPerformed(evt);
			}
		});

	}

	private void openImageActionPerformed(java.awt.event.ActionEvent evt) {

		choicedFile.showOpenDialog(this);
		file = choicedFile.getSelectedFile();

		try {
			perspectiveControleur.setImages(file);
		} catch (IOException e) {
 
			e.printStackTrace();
		}

		System.out.println(choicedFile.getSelectedFile().getName() + " succesfully loaded!");

	}

	private void saveImageActionPerformed(java.awt.event.ActionEvent evt) {
		 choicedFile.showOpenDialog(this);
         file = choicedFile.getSelectedFile();
         try {
			save.chargerUnFichier(file, perspectiveControleur);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void undo1ActionPerformed(java.awt.event.ActionEvent evt) {
		//commande.undo();
	}

}
