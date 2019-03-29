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
	
	@Override
	public void execute() {
		this.image.setPosition(this.position);
	}

	@Override
	public void undo() {
		this.image.setPosition(this.previousPosition);		
	}
	
}
