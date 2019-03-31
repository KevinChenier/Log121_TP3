package Modele;

import java.io.Serializable;

public class Vector2 implements Serializable{
	
	private int x;
	private int y;
	
	public static final Vector2 zero = new Vector2(0,0);
	
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Vector2 addVector(Vector2 vector) {
		return new Vector2(this.x + vector.getX(), this.y + vector.getY());
	}
	
	public Vector2 oppositeVector() {
		return new Vector2(-(this.x), -(this.y));
	}

}
