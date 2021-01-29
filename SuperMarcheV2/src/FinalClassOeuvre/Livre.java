package FinalClassOeuvre;

import ClassAbstract.Oeuvre;

public class Livre extends Oeuvre{
	protected String type;

	/**
	 * Ajoute les valeurs de chaque variable
	 * @author Paul Annes
	 */
	public void iniValue (int ISBN, String titre, String description, int nbPages, double prix, String type) {
		super.iniValu(ISBN, titre, description, nbPages, prix);
		this.setType(type);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}


