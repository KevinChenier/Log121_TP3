package Modele;

import java.io.Serializable;

public class SauvegardePerspective implements Serializable  {

    private byte[] imageBytes = null;
    private Vector2 vectors[] = null;
    private int zooms[] = null;

    public SauvegardePerspective(byte[] bytesImage, Vector2[] vectors, int[] zooms) {
        this.setImageBytes(bytesImage);
        this.setTabVector(vectors);
        this.setTabZoomLevel(zooms);
    }

	public byte[] getImageBytes() {
		return imageBytes;
	}

	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}

	public Vector2[] getVectors() {
		return vectors;
	}

	public void setTabVector(Vector2 vectors[]) {
		this.vectors = vectors;
	}

	public int[] getZooms() {
		return this.zooms;
	}

	public void setTabZoomLevel(int zooms[]) {
		this.zooms = zooms;
	}
}
