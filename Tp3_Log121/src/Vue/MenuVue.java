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

import javax.swing.*;

public class MenuVue extends JMenuBar {

	private JMenu menuFile;
	private JMenu menuEdit; 
	private JMenuItem openImage;
	private JMenuItem saveImage;
	private JMenuItem menuUndo1;
	private JMenuItem menuUndo2;

	private JFileChooser openFile;
	
	/*
	 * Constructeur de la classe MenuVue
	 */
	public MenuVue() {
		initComponents();

		initEvents();
		this.add(menuEdit);
		this.add(menuFile);
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
		openFile = new JFileChooser();
		openFile.setCurrentDirectory(new File("./images"));

		if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
			String filename = openFile.getSelectedFile().getPath();

			/*
			 * sourceImagePanel.setImage(filename); leftPersceptive.put.setImage(filename);
			 */
			System.out.println(openFile.getSelectedFile().getName() + " succesfully loaded!");
		}
	}

	private void saveImageActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void undo1ActionPerformed(java.awt.event.ActionEvent evt) {
		// gestionnaireCommandes.undo();
	}

}
