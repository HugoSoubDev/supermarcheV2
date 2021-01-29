package Librairie;

import java.util.ArrayList;
import java.util.Date;

import FinalClassOeuvre.BD;
import FinalClassOeuvre.Livre;
import FinalClassOeuvre.Magasine;
import Interface.MagasinLivre;

public class Librairie implements MagasinLivre {
	
	ArrayList<BD> listBD = new ArrayList<BD>();
	ArrayList<Magasine> listMagasine = new ArrayList<Magasine>();
	ArrayList<Livre> listLivre = new ArrayList<Livre>(); 
	
	
	
	@Override
	public void Acheter(BD bd) {
		listBD.add(bd);
	}
	@Override
	public void Acheter(Livre livre) {
		listLivre.add(livre);
	}
	@Override
	public void Acheter(Magasine magasine) {
		listMagasine.add(magasine);
	}
	
	public void Vendre(int ISBN, String nomListe) {
		
		if(nomListe == "BD") {
			for(int i = 0; i< listBD.size(); i++) {
				if(ISBN == listBD.get(i).getISBN()){
					listBD.remove(i);
					break;
				}
			}
			
		}else if (nomListe == "Livre"){
			for(int i = 0; i< listLivre.size(); i++) {
				if(ISBN == listLivre.get(i).getISBN()){
					listLivre.remove(i);
					break;
				}
			}
			
		}else{
			for(int i = 0; i< listMagasine.size(); i++) {
				if(ISBN == listMagasine.get(i).getISBN()){
					listMagasine.remove(i);
					break;
				}
			}
		}
	}
	
	public ArrayList<Livre> getListLivre() {
		return listLivre;
	}
	public void setListLivre(ArrayList<Livre> listLivre) {
		this.listLivre = listLivre;
	}
	public ArrayList<BD> getListBD() {
		return listBD;
	}
	public void setListBD(ArrayList<BD> listBD) {
		this.listBD = listBD;
	}
	public ArrayList<Magasine> getListMagasine() {
		return listMagasine;
	}
	public void setListMagasine(ArrayList<Magasine> listMagasine) {
		this.listMagasine = listMagasine;
	}

	




	
	
}
