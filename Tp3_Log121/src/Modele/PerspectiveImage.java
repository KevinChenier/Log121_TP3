package Modele;

import java.awt.image.BufferedImage;

/**
 * Classe utilisee pour representer une image situee dans un onglet avec sa perspective courante.
 * Cette classe implemente Observable, car elle est "regardee" par les onglets.
 * @author Kevin Chenier
 *
 */
public class PerspectiveImage extends Observable{

	private static final int DEFAULT_ZOOM = 1;
	
	private BufferedImage image;
	private int zoomLevel;
	private Vector2 position;
	
	public PerspectiveImage() {
		this.zoomLevel = DEFAULT_ZOOM;
		this.position = Vector2.zero;
	}

	/**
	 * Getter pour l'image de l'onglet.
	 * @return l'image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * Setter pour l'image de l'onglet.
	 * @param image, l'image en particulier.
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
		notifyObservers(); 
	} 

	/**
	 * Getter pour le zoom level de la perspective.
	 * @return le zoom level.
	 */
	public int getZoomLevel() {
		return zoomLevel;
	}

	/**
	 * Setter pour le zoom level de la perspective.
	 * @param zoomLevel, le zoom level a utilise.
	 */
	public void setZoomLevel(int zoomLevel) {
		this.zoomLevel = zoomLevel;
		notifyObservers();
	}

	/**
	 * Getter de la position de l'image.
	 * @return position de l'image.
	 */
	public Vector2 getPosition() {
		return position;
	}

	/**
	 * Setter de la position de l'image.
	 * @param position, la position a utilisee.
	 */
	public void setPosition(Vector2 position) {
		this.position = position;
		notifyObservers();
	}
	
	
	
}
