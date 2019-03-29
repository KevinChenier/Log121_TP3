package Controleur;

import Modele.Image;
import Modele.Vector2;

public class TranslateCommand implements Commande {

	private Image image;
	private Vector2 position;
	
	public TranslateCommand(Image image, Vector2 position) {
		this.image = image;
		this.position = position;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	@Override
	public void execute() {
		this.getImage().setPosition(this.position);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
	
}
