package Interface;

import FinalClassOeuvre.BD;
import FinalClassOeuvre.Livre;
import FinalClassOeuvre.Magasine;

public interface MagasinLivre {
	public void Acheter(BD bd);
	public void Acheter(Livre livre);
	public void Acheter(Magasine magasine);
	public void Vendre(int ISBN, String nomListe);

}
