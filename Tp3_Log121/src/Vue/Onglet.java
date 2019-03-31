/******************************************************
Cours:   LOG121
Session: H2019
Groupe:  04
Projet: Laboratoire #3
Ã‰tudiant(e)s: Eugene Wiafe, Ian Garcia-Guerrero, Kevin Chenier, Laurent Sieu
              
              
Professeur : Ghizlane El Boussaidi
Nom du fichier: Onglet.java
Date cree: 2019-03-25
Date dern. modif. 2019-03-25
*******************************************************
Historique des modifications
*******************************************************

*******************************************************/
package Vue;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

import Modele.PerspectiveImage;
import Modele.Vector2;
import Modele.Observable;
import Modele.Observer;
import Controleur.PerspectiveControleur;

/**
 * Classe representant les espaces ou les images vont etre affichees.
 * @author Eugene Wiafe, Ian Garcia-Guerrero
 *
 */
public class Onglet extends JPanel implements Observer {

	private static final int MINIMUM_HEIGHT_AND_WIDTH = 1;

	// Label qui contient l'image qui est affichee
	private final JLabel imageView = new JLabel();

	public Onglet(int IDOnglet, PerspectiveControleur perspectiveController) {

		this.setLayout(null);
		this.add(imageView);
		
		this.addMouseWheelListener(e -> {
			perspectiveController.zoomer(IDOnglet, -e.getWheelRotation());
		});

		this.addMouseListener(new MouseAdapter() {
 
			/**
			 * Le point inital lors d'un "click and drag"
			 */
			private Vector2 initialPoint;

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				initialPoint = new Vector2(e.getPoint().x, e.getPoint().y);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				Vector2 finalPoint = new Vector2(e.getPoint().x, e.getPoint().y);
				perspectiveController.translate(IDOnglet, initialPoint.addVector(finalPoint.oppositeVector()).oppositeVector());
			}
		});
		this.setVisible(true);
	}

	/**
	 * Appelee lorsque l'etat du model associe a  cette vue change
	 * 
	 * @param modelObservable
	 *            Le model dont l'etat a change
	 */
	@Override
	public void update(Observable observable) {
		setZoom(observable);
	}

	/**
	 * Methode appelee lorsque une image est modifie par translation ou par zoom.
	 * @param imageModifiee, image qui doit etre modifiee.
	 * @param largeur, la largeur de une image modifiee.
	 * @param hauteur, la hauteur de une image modifiee.
	 * @param x, la position en x.
	 * @param y, la position en y.
	 * @return une nouvelle image modifiee.
	 */
	private Icon modifieImage(BufferedImage imageModifiee, int largeur, int hauteur, int x, int y) {
		BufferedImage resizedImg = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(imageModifiee, x, y, largeur, hauteur, null);
		g2.dispose();

		return new ImageIcon(resizedImg);
	}

	/**
	 * Applique le niveau de zoom a une image.
	 *
	 * @param Observable, le modele observe ayant besoin d'etre redessinne.
	 */
	private void setZoom(Observable observable) {
		PerspectiveImage imagePerspective = (PerspectiveImage) observable;

		double zoomLevel = imagePerspective.getZoomLevel();
		BufferedImage image = imagePerspective.getImage();
		Vector2 finalTranslation = imagePerspective.getPosition();

		// Si le zoom est plus petit que 0, on applique une reduction de la perspective
		if (zoomLevel < 0) {
			zoomLevel = 1 / Math.abs(zoomLevel);
		} else if (zoomLevel == 0) {
			zoomLevel = 1;
		}
		int imageWidth = Math.max((int) (this.getWidth() * zoomLevel), MINIMUM_HEIGHT_AND_WIDTH);
		int imageHeight = Math.max((int) (this.getHeight() * zoomLevel), MINIMUM_HEIGHT_AND_WIDTH);
		imageView.setIcon(modifieImage(image, imageWidth, imageHeight, finalTranslation.getX(), finalTranslation.getY()));
		imageView.setSize(imageWidth, imageHeight);
		imageView.setLocation(this.getWidth() / 2 - imageWidth / 2, this.getHeight() / 2 - imageHeight / 2);
		imageView.invalidate();
		this.repaint();
	}
}
