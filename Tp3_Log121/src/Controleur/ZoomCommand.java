package Controleur;

import Modele.Image;

public class ZoomCommand implements Commande {

	private Image image;
	private int zoomLevel;
	private int previousZoomLevel;
	
	public ZoomCommand(Image image, int zoomLevel) {
		this.image = image;
		this.zoomLevel = zoomLevel;
	}

	@Override
	public void execute() {
		this.image.setZoomLevel(this.zoomLevel);
	}

	@Override
	public void undo() {
		this.image.setZoomLevel(previousZoomLevel);
	}
}
