package Controleur;

import Modele.PerspectiveImage;

public class ZoomCommand implements Commande {

	private PerspectiveImage image;
	private int zoomLevel;
	private int previousZoomLevel;
	
	public ZoomCommand(PerspectiveImage image, int zoomLevel) {
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
