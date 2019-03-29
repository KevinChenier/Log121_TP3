package Controleur;

import Modele.Image;

public class ZoomCommand implements Commande {

	private Image image;
	private int zoomLevel;
	
	public ZoomCommand(Image image, int zoomLevel, int imageHauteur, int imageLargeur) {
		this.setImage(image);
		this.zoomLevel = zoomLevel;
	}
	
	public int getZoomLevel() {
		return zoomLevel;
	}

	public void setZoomLevel(int zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public void execute() {
		this.getImage().setZoomLevel(this.zoomLevel);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
