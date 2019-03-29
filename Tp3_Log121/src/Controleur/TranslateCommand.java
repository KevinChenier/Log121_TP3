package Controleur;

import Modele.Image;
import Modele.Vector2;

public class TranslateCommand implements Commande {

	private Image image;
	private Vector2 position;
	private Vector2 previousPosition;
	
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
	
	public Vector2 getPreviousPosition() {
		return previousPosition;
	}

	public void setPreviousPosition(Vector2 previousPosition) {
		this.previousPosition = previousPosition;
	}
	
	@Override
	public void execute() {
		this.getImage().setPosition(this.position);
	}

	@Override
	public void undo() {
		this.getImage().setPosition(this.previousPosition);		
	}
	
}
