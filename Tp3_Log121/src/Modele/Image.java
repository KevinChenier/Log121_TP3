package Modele;

import java.awt.image.BufferedImage;

public class Image extends Observable{

	private static final int DEFAULT_ZOOM = 1;
	
	private BufferedImage image;
	
	private int zoomLevel;
	
	private Vector2 position;
	
	public Image() {
		this.zoomLevel = DEFAULT_ZOOM;
		this.position = Vector2.zero;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getZoomLevel() {
		return zoomLevel;
	}

	public void setZoomLevel(int zoomLevel) {
		this.zoomLevel = zoomLevel;
		notifyObservers();
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
		notifyObservers();
	}
	
	
	
}
