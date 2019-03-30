/******************************************************
Cours:   LOG121
Session: H2019
Groupe:  04
Projet: Laboratoire #3
Ã‰tudiant(e)s: Eugene Wiafe, Ian Garcia-Guerrero, Kevin ChÃ©nier, Laurent Sieu
              
              
Professeur : Ghizlane El Boussaidi
Nom du fichier: Onglet.java
Date crÃ©Ã©: 2019-03-25
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

public class Onglet extends JPanel implements Observer {

	private static final int MINIMUM_HEIGHT_AND_WIDTH = 1;

	// Label qui contient l'image qui est affichee
	private final JLabel imageView = new JLabel();

	public Onglet(int IDOnglet, PerspectiveControleur perspectiveController) {

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
	 * Cette methode permet d'appliquer les changements suite a  une tranlation
	 *
	 * @param srcImg
	 *            L'image a  afficher
	 * @param w
	 *            La largeur de l'image
	 * @param h
	 *            La hauteur de l'image
	 * @param translatedX
	 *            La translation en X
	 * @param translatedY
	 *            La translation en Y
	 * @return L'image modifiee sous forme d'Icon
	 */
	private Icon modifieImage(BufferedImage srcImg, int w, int h, int translatedX, int translatedY) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, translatedX, translatedY, w, h, null);
		g2.dispose();

		return new ImageIcon(resizedImg);
	}

	/**
	 * Applique le niveau de zoom a l'image.
	 *
	 * @param Observable
	 *            Le model observe ayant besoin d'etre redessinne
	 */
	private void setZoom(Observable observable) {
		PerspectiveImage imagePerspective = (PerspectiveImage) observable;

		double zoomLevel = imagePerspective.getZoomLevel();
		BufferedImage image = imagePerspective.getImage();
		Vector2 finalTranslation = imagePerspective.getPosition();

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
