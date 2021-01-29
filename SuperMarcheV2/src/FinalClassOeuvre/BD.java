package FinalClassOeuvre;

import ClassAbstract.Oeuvre;

public class BD extends Oeuvre {
	
	protected int nbImage;

	/**
	 * Ajoute les valeurs de chaque variable
	 * @author Hugo Soubeyrat
	 */
	public void iniValue(int ISBN, String titre, String description, int nbPages, double prix, int nbImage) {
		super.iniValu(ISBN, titre, description, nbPages, prix);
		this.setNbImage(nbImage);
	}
	
	public int getNbImage() {
		return nbImage;
	}

	public void setNbImage(int nbImage) {
		this.nbImage = nbImage;
	}
}
