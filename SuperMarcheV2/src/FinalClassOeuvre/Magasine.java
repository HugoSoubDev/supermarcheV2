package FinalClassOeuvre;

import java.util.Date;

import ClassAbstract.Oeuvre;

public class Magasine extends Oeuvre {

	protected int numero;
	protected Date dateParution;
	
	/**
	 * Ajoute les valeurs de chaque variable
	 * @author Paul Annes et Hugo Soubeyrat
	 */
	public void iniValue (int ISBN, String titre, String description, int nbPages, double prix, int numero, Date dateParution) {
		super.iniValu(ISBN, titre, description, nbPages, prix);
		this.setNumero(numero);
		this.setDateParution(dateParution);
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDateParution() {
		return dateParution;
	}
	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}
	
}
