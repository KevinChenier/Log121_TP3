package Modele;

import java.io.Serializable;

/**
 * Classe qui represente une position dans l'application. Objet pouvant etre
 * serialise pour sauvergarder dans un fichier.
 * @author Kevin Chenier
 *
 */
public class Vector2 implements Serializable{
	
	// Vecteur representant la position en x=0 et y=0
	public static final Vector2 zero = new Vector2(0,0);
	
	private int x;
	private int y;
	
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Getter de la position en x.
	 * @return la position x.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Setter de la position en x.
	 * @param x, la position en x.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Getter de la position en y.
	 * @return la position en y.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Setter de la position en y.
	 * @param y, la position en y.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Methode permettant d'additionner deux vecteurs ensemble.
	 * @param vector, le vecteur utilise pour additionner.
	 * @return le vecteur additionne.
	 */
	public Vector2 addVector(Vector2 vector) {
		return new Vector2(this.x + vector.getX(), this.y + vector.getY());
	}
	
	/**
	 * Methode retournant le vecteur oppose a celui-ci.
	 * @return le vecteur oppose. 
	 */
	public Vector2 oppositeVector() {
		return new Vector2(-(this.x), -(this.y));
	}

}
