import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import FinalClassOeuvre.BD;
import FinalClassOeuvre.Livre;
import FinalClassOeuvre.Magasine;
import Librairie.Librairie;
import Panel.PanelAjout;
import Panel.PanelListeBD;
import Panel.PanelListeLivre;
import Panel.PanelListeMagasine;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

    private static final long serialVersionUID = -4939544011287453046L;
    
    String[] typeLivre = {"Livre", "BD", "Magasine"};
    
    /**
     * Créer la page principale
     * @param librairie : pour pouvoir faire des CRUD avec les listes livre, bd, magasine
     * @author Hugo Soubeyrat et Paul Annes
    */
    public MainWindow(Librairie librairie) {
    	
    	// Initialisation de page principale
        super("Ma Biblioteque");
        this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        this.setSize(996, 404);
        this.setLocationRelativeTo(null);
        
        // Initialisation de PanelAjout
        PanelAjout panelAjout = new PanelAjout(librairie);
        panelAjout.setLocation(253, 6);
        panelAjout.setVisible(true);
        panelAjout.setLayout(null);
        
        // Incrémentation de PanelAjout dans la page mère
        JPanel panelAjouter = (JPanel) this.getContentPane();
        getContentPane().setLayout(null);
        panelAjouter.add(panelAjout);
        
        // Initialisation du panelListLivre
        PanelListeLivre panelListeLivre = new PanelListeLivre(librairie);
        panelListeLivre.setLocation(253, 6);
        panelListeLivre.setVisible(false);
        panelListeLivre.setLayout(null);
        panelListeLivre.refresh(librairie);
        
        // Incrémentation de panelListLivre dans la page mère
        JPanel panelLivre = (JPanel) this.getContentPane();
        getContentPane().setLayout(null);
        panelAjouter.add(panelListeLivre);
        
        // Initialisation du panelListeMagasine
        PanelListeMagasine panelListeMagasine = new PanelListeMagasine(librairie);
        panelListeMagasine.setLocation(253, 6);
        panelListeMagasine.setVisible(false);
        panelListeMagasine.setLayout(null);
        panelListeMagasine.refresh(librairie);
        
        // Incrémentation de panelListeMagasine dans la page mère
        JPanel panelMagasasine = (JPanel) this.getContentPane();
        getContentPane().setLayout(null);
        panelAjouter.add(panelListeMagasine);
        
        // Initialisation du panelListBD
        PanelListeBD panelListeBd = new PanelListeBD(librairie);
        panelListeBd.setLocation(253, 6);
        panelListeBd.setVisible(false);
        panelListeBd.setLayout(null);
        panelListeBd.refresh(librairie);
        
        // Incrémentation de panelListBD dans la page mère
        JPanel panelBd = (JPanel) this.getContentPane();
        getContentPane().setLayout(null);
        panelAjouter.add(panelListeBd);
        
        // Incrémentation de panelBouton dans la page mère
        JPanel panelBouton = new JPanel();
        panelBouton.setBounds(6, 6, 231, 353);
        getContentPane().add(panelBouton);
        panelBouton.setLayout(null);
        
        // Incrémentation de btnListeLivres dans le panel panelBouton
        JButton btnListeLivres = new JButton("Liste des Livres");
        btnListeLivres.setBounds(0, 27, 231, 28);
        btnListeLivres.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent arg0) {
        		
        		// Afficher juste le panel : panelListLivre
        		panelAjout.setVisible(false);
        		panelListeBd.setVisible(false);
        		panelListeMagasine.setVisible(false);
        		
        		panelListeLivre.setVisible(true);
        		
        		// Initialise les donnée de base pour la liste livre
        		panelListeLivre.refresh(librairie);
        	}
        });
        panelBouton.add(btnListeLivres);
        
        // Incrémentation de btnListeBD dans le panel panelBouton
        JButton btnListeBD = new JButton("Liste des BD");
        btnListeBD.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		// Afficher juste le panel : panelListBd
        		panelAjout.setVisible(false);
        		panelListeLivre.setVisible(false);
        		panelListeMagasine.setVisible(false);
        		
        		panelListeBd.setVisible(true);
        		
        		// Initialise les donnée de base pour la liste livre
        		panelListeBd.refresh(librairie);
        	}
        });
        btnListeBD.setBounds(0, 67, 231, 28);
        panelBouton.add(btnListeBD);
        
        // Incrémentation de btnListeMagasines dans le panel panelBouton
        JButton btnListeMagasines = new JButton("Liste des Magasines");
        btnListeMagasines.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		// Afficher juste le panel : panelListMagasine
        		panelAjout.setVisible(false);
        		panelListeLivre.setVisible(false);
        		panelListeBd.setVisible(false);
        		
        		panelListeMagasine.setVisible(true);
        		
        		// Initialise les donnée de base pour la liste livre
        		panelListeMagasine.refresh(librairie);
        	}
        });
        btnListeMagasines.setBounds(0, 107, 231, 28);
        panelBouton.add(btnListeMagasines);
        
        // Incrémentation de btnAjouter dans le panel panelBouton
        JButton btnAjouter = new JButton("Ajouter une Oeuvre");
        btnAjouter.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent arg0) {
        		
        		// Afficher juste le panel : panelAjout
        		panelListeLivre.setVisible(false);
        		panelListeBd.setVisible(false);
        		
        		panelAjout.setVisible(true);
        	}
        });
        btnAjouter.setBounds(0, 290, 231, 41);
        panelBouton.add(btnAjouter);
        
    }
    
    /**
     * Method main qui se lance à l'ouverture de l'application
     * @param args
     * @author Hugo Soubeyrat et Paul Annes
    */
    public static void main(String[] args) throws Exception {

    	Librairie librairie = new Librairie();
    	Livre livre = new Livre();
    	BD bd = new BD();
    	Magasine magasine = new Magasine(); 
    	
    	// création d'un jeu de donnée
    	livre.iniValue(1888, "Colonel Moutarde", "Roman de police", 200, 10, "Roman");
    	librairie.Acheter(livre);
    	
    	bd.iniValue(4578, "Cedric", "BD pour enfant", 200, 15.99, 700);
    	librairie.Acheter(bd);
    	
    	// Améliore le design des pages
    	UIManager.setLookAndFeel(new NimbusLookAndFeel());
        
        // Lance la page principale
        MainWindow mainWindow = new MainWindow(librairie);
        mainWindow.setVisible(true);
    }
}








