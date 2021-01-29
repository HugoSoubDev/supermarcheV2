package ClassAbstract;

abstract public class Oeuvre {
	
	private int ISBN;
	private String titre;
	private String description;
	private int nbPages;
	private double prix;
	
	/**
	 * Ajoute les valeurs de chaque variable qui sont comune au différetes classes abstraites livre, bd, magasine
	 * @author Paul Annes
	 */
	public void iniValu(int ISBN, String titre, String description, int nbPages, double prix) {
		this.setISBN(ISBN);
		this.setTitre(titre);
		this.setDescription(description);
		this.setNbPages(nbPages);
		this.setPrix(prix);
	}
	
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		
		if(nbPages <= 0) {
			System.out.println("Un livre ne peut pas avoir un nombre de page inférieur à 0");
		}
		else {
			this.nbPages = nbPages;
		}
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		
		if(prix <= 0) {
			System.out.println("Un livre ne peut pas couté moins de 0€");
		}
		else {
			this.prix = prix;
		}
	}
}

