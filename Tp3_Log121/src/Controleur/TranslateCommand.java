package Controleur;

public class TranslateCommand implements Commande {

	private int zoomLevel;
	private int imageHauteur;
	private int imageLargeur;

	public void zoomer(int zoomLevel) {
		
	}
	
	public int getZoomLevel() {
		return zoomLevel;
	}


	public void setZoomLevel(int zoomLevel) {
		this.zoomLevel = zoomLevel;
	}


	public int getImageHauteur() {
		return imageHauteur;
	}


	public void setImageHauteur(int imageHauteur) {
		this.imageHauteur = imageHauteur;
	}


	public int getImageLargeur() {
		return imageLargeur;
	}


	public void setImageLargeur(int imageLargeur) {
		this.imageLargeur = imageLargeur;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
}
