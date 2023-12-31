/******************************************************
Cours:   LOG121
Session: H2019
Groupe:  04
Projet: Laboratoire #3
Étudiant(e)s: Eugene Wiafe, Ian Garcia-Guerrero, Kevin Chenier, Laurent Sieu
              
              
Professeur : Ghizlane El Boussaidi
Nom du fichier: MenuVue.java
Date cree: 2019-03-25
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

/**
 * Cette classe represente le menu deroulant qui permet a l'utilisateur d'ouvrir une image,
 * de sauvegarder des perspectives, de charger des perspectives ou meme de Undo/Redo des
 * commandes.
 * @author Eugene Wiafe, Ian Garcia-Guerrero
 *
 */
public class MenuVue extends JMenuBar {

	// Le chemin par defaut pour ouvrir une image
	private static final String PATH = System.getProperty("user.dir") + File.separator + "images_test";

	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenuItem openImage;
	private JMenuItem saveImage;
	private JMenuItem loadImage;
	private JMenuItem menuUndo;
	private JMenuItem menuRedo;

	private final JFileChooser fileChooser = new JFileChooser();
	private File file;

	private PerspectiveControleur perspectiveControleur;
	private SauvegardeControleur save;
	private final GestionnaireCommande commande;

	public MenuVue(PerspectiveControleur perspectiveControleur) {
		save = new SauvegardeControleur();
		commande = GestionnaireCommande.getInstance();
		this.perspectiveControleur = perspectiveControleur;
		initComponents();
		initEvents();
		this.add(menuFile);
		this.add(menuEdit);
	}

	/**
	 * Initialisation des menus et des items des menus.
	 */
	private void initComponents() {
		menuFile = new JMenu("File");
		menuEdit = new JMenu("Edit");

		openImage = new JMenuItem("Open Image");
		saveImage = new JMenuItem("Save Images");
		loadImage = new JMenuItem("Load Images");
		menuUndo = new JMenuItem("Undo");
		menuRedo = new JMenuItem("Redo");

		menuFile.add(openImage);
		menuFile.add(saveImage);
		menuFile.add(loadImage);
		menuEdit.add(menuUndo);
		menuEdit.add(menuRedo);
	}

	/**
	 * Initialisation de tous les comportements des items.
	 */
	private void initEvents() {

		fileChooser.setCurrentDirectory(new File(PATH));

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
		
		loadImage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					loadImageActionPerformed(evt);
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

	/**
	 * Methode utilisee pour selectionner une image et la mettre dans les perspectives.
	 * @param evt, evenement qui declenche la methode.
	 * @throws IOException
	 */
	private void openImageActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		fileChooser.showOpenDialog(this);
		file = fileChooser.getSelectedFile();
		perspectiveControleur.setImages(file);

		System.out.println(fileChooser.getSelectedFile().getName() + " succesfully loaded!");
	}
	
	/**
	 * Methode utilisee pour sauvegarder les perspectives.
	 * @param evt, evenement qui declenche la methode.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void saveImageActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException, IOException {
		save.sauvegarderFichier(perspectiveControleur.getImages());
	}

	/**
	 * Methode utilisee pour charger des perspectives.
	 * @param evt, evenement qui declenche la methode.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void loadImageActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException, IOException {
		 fileChooser.showOpenDialog(this);
         file = fileChooser.getSelectedFile();
         save.chargerUnFichier(file, perspectiveControleur);
	}

	/**
	 * Methode utilisee pour annuler une commande.
	 * @param evt, evenement qui declenche la methode.
	 */
	private void undoActionPerformed(java.awt.event.ActionEvent evt) {
		commande.undo();
	}
	
	/**
	 * Methode utilisee pour refaire une commande annulee.
	 * @param evt, evenement qui declenche la methode.
	 */
	private void redoActionPerformed(java.awt.event.ActionEvent evt) {
		commande.redo();
	}

}
