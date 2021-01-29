package Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import FinalClassOeuvre.BD;
import FinalClassOeuvre.Livre;
import FinalClassOeuvre.Magasine;
import Librairie.Librairie;

import javax.swing.JButton;
import java.awt.FlowLayout;

public class PanelAjout extends JPanel {
	
	private JTextField textFieldISBN;
	private JTextField textFieldTitre;
	private JTextField textFieldDesc;
	private JTextField textFieldNbPage;
	private JTextField textFieldPrix;
	private JTextField textFieldNbImage;
	private JTextField textFieldType;
	private JTextField textFieldNum;

	/**
	 * @param librairie : permet CRUD sur les listArray (Livre, BD, Magasine)
	 * @author Paul Annes
	 */
	public PanelAjout(Librairie librairie) {
		
	    String[] typeLivre = {"Livre", "BD", "Magasine"};
	    
		setSize(721, 338);
		setLayout(null);
		
        // Incrémentation de panelOeuvre
		JPanel panelOeuvre = new JPanel();
		panelOeuvre.setBounds(10, 77, 701, 82);
		add(panelOeuvre);
		
		// Incrémentation de panelISBN dans panelOeuvre
		JPanel panelISBN = new JPanel();
		
		// Incrémentation de lblISB dans panelISBN
		JLabel lblISB = new JLabel("ISBN :");
		panelISBN.add(lblISB);
		
		// Incrémentation de textFieldISBN dans panelISBN
		textFieldISBN = new JTextField();
		panelISBN.add(textFieldISBN);
		textFieldISBN.setColumns(10);
		
		// Incrémentation de panelTitre dans panelOeuvre
		JPanel panelTitre = new JPanel();
		
		// Incrémentation de lblTitre dans panelTitre
		JLabel lblTitre = new JLabel("Titre :");
		panelTitre.add(lblTitre);
		
		// Incrémentation de textFieldTitre dans panelTitre
		textFieldTitre = new JTextField();
		textFieldTitre.setColumns(10);
		panelTitre.add(textFieldTitre);
		
		// Incrémentation de panelDesc dans panelOeuvre
		JPanel panelDesc = new JPanel();
		
		// Incrémentation de lblDesc dans panelDesc
		JLabel lblDesc = new JLabel("Description :");
		panelDesc.add(lblDesc);
		
		// Incrémentation de textFieldDesc dans panelDesc
		textFieldDesc = new JTextField();
		textFieldDesc.setColumns(10);
		panelDesc.add(textFieldDesc);
		
		// Incrémentation de panelNbPage dans panelOeuvre
		JPanel panelNbPage = new JPanel();
		
		// Incrémentation de lblNbPages dans panelNbPage
		JLabel lblNbPages = new JLabel("Nombres pages :");
		panelNbPage.add(lblNbPages);
		
		// Incrémentation de textFieldNbPage dans panelNbPage
		textFieldNbPage = new JTextField();
		textFieldNbPage.setColumns(10);
		panelNbPage.add(textFieldNbPage);
		
		// Incrémentation de panelPrix dans panelOeuvre
		JPanel panelPrix = new JPanel();
		
		// Incrémentation de lblPrix dans panelPrix
		JLabel lblPrix = new JLabel("Prix :");
		panelPrix.add(lblPrix);
		
		// Incrémentation de textFieldPrix dans panelPrix
		textFieldPrix = new JTextField();
		textFieldPrix.setColumns(10);
		panelPrix.add(textFieldPrix);
		
		// Ajout de tout les panels présents dans PanelOeuvre
		panelOeuvre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelOeuvre.add(panelISBN);
		panelOeuvre.add(panelTitre);
		panelOeuvre.add(panelDesc);
		panelOeuvre.add(panelNbPage);
		panelOeuvre.add(panelPrix);
		
		// Incrémentation de panelType
		JPanel panelType = new JPanel();
		panelType.setBounds(10, 170, 701, 90);
		add(panelType);
		
		// Incrémentation de panelBD dans panelType
		JPanel panelBD = new JPanel();
		panelBD.setVisible(false);
		panelType.add(panelBD);
		
		// Incrémentation de lblNbImage dans panelBD
		JLabel lblNbImage = new JLabel("Nombre d'images :");
		panelBD.add(lblNbImage);
		
		// Incrémentation de textFieldNbImage dans panelBD
		textFieldNbImage = new JTextField();
		textFieldNbImage.setColumns(10);
		panelBD.add(textFieldNbImage);
		
		// Incrémentation de panelLivre dans panelBD
		JPanel panelLivre = new JPanel();
		panelType.add(panelLivre);
		
		// Incrémentation de lblType dans panelBD
		JLabel lblType = new JLabel("Genre du livre :");
		panelLivre.add(lblType);
		
		// Incrémentation de textFieldType dans panelBD
		textFieldType = new JTextField();
		textFieldType.setColumns(10);
		panelLivre.add(textFieldType);
		
		// Incrémentation de panelMagasine dans panelType
		JPanel panelMagasine = new JPanel();
		panelMagasine.setVisible(false);
		panelType.add(panelMagasine);
		
		// Incrémentation de lblDate dans panelMagasine
		JLabel lblDate = new JLabel("Date d'apparistion :");
		panelMagasine.add(lblDate);
		
		// Incrémentation de dateChooser dans panelMagasine
		JDateChooser dateChooser = new JDateChooser();
		panelMagasine.add(dateChooser);
		
		// Incrémentation de lblNum dans panelMagasine
		JLabel lblNum = new JLabel("Num\u00E9ro :");
		panelMagasine.add(lblNum);
		
		// Incrémentation de textFieldNum dans panelMagasine
		textFieldNum = new JTextField();
		textFieldNum.setColumns(10);
		panelMagasine.add(textFieldNum);
		
		// lookup des types de livres
		JComboBox comboBoxTypeOeuvre = new JComboBox(typeLivre);
		comboBoxTypeOeuvre.setBounds(319, 36, 99, 20);
		
		comboBoxTypeOeuvre.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		
        		String selectedBook = (String) comboBoxTypeOeuvre.getSelectedItem();
        		
        		panelLivre.setVisible(false);
        		panelBD.setVisible(false); 
        		panelMagasine.setVisible(false);  
                
                if(selectedBook == "Livre") {
                	panelLivre.setVisible(true);
                }
                else if(selectedBook == "BD") {
                	panelBD.setVisible(true);                	
                }
                else {
                	panelMagasine.setVisible(true);              	
                }
			}
        });
		
		add(comboBoxTypeOeuvre);
		
		// Incrémentation de textFieldNum dans PanelAjout pour enregistrer des livres
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(319, 304, 99, 23);
		btnAjouter.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
	        	boolean reussie = true;
	        	
        		// Selectionne le type de livre choisie dans le comboBox
	        	String selectedBook = (String) comboBoxTypeOeuvre.getSelectedItem();
	        	
	        	if (selectedBook == "Livre"){
	        		
	        		// Permet de detecter les erreurs de saisie, si tout est bon on enrgistre la nouvelle livre
	        		try {
	        			
	        			Livre livre = new Livre();
	            		livre.iniValue(Integer.parseInt(textFieldISBN.getText()), textFieldTitre.getText(), textFieldDesc.getText(), Integer.parseInt(textFieldNbPage.getText()), Double.parseDouble(textFieldPrix.getText()), textFieldType.getText());
	            		librairie.getListLivre().add(livre);
	        		}
	        		catch(Exception e1){
	
	        			reussie = false;
	        			
	        			JOptionPane.showMessageDialog(null, "Un/des champs n'est ou ne sont pas correcte(s)");
	        		}
	        		
	        		// Reset les champs si l'objet a été crée
	        		if(reussie) {
	        			
	        			restTextField();
	        		}	
	        	}
	        	
        		// Permet de detecter les erreurs de saisie, si tout est bon on enrgistre la nouvelle bd
	        	if (selectedBook == "BD"){
	        		
	        		try {
	            		
	        			BD bd = new BD();
	            		bd.iniValue(Integer.parseInt(textFieldISBN.getText()), textFieldTitre.getText(), textFieldDesc.getText(), Integer.parseInt(textFieldNbPage.getText()), Double.parseDouble(textFieldPrix.getText()), Integer.parseInt(textFieldNbImage.getText()) );
	            		librairie.getListBD().add(bd);
	        		}
	        		catch(Exception e1){
	        			
	        			reussie = false;
	        			
	        			JOptionPane.showMessageDialog(null, "Un/des champs n'est ou ne sont pas correcte(s)");
	        		}
	        		
	        		// Reset les champs si l'objet a été crée
	        		if(reussie) {
	        			
	        			restTextField();
	        		}
	        	}
	        	
        		// Permet de detecter les erreurs de saisie, si tout est bon on enrgistre la nouvelle magasine
	        	if (selectedBook == "Magasine"){
	        		try {
	        			
	            		Magasine magasine = new Magasine();
	            		magasine.iniValue(Integer.parseInt(textFieldISBN.getText()), textFieldTitre.getText(), textFieldDesc.getText(), Integer.parseInt(textFieldNbPage.getText()), Double.parseDouble(textFieldPrix.getText()), Integer.parseInt(textFieldNum.getText()), dateChooser.getDate());
	            		librairie.getListMagasine().add(magasine);
	            		
	            		System.out.print(dateChooser.getDate());
	        		}
	        		catch(Exception e1){
	        			
	        			reussie = false;
	        			
	        			JOptionPane.showMessageDialog(null, "Un/des champs n'est ou ne sont pas correcte(s)");
	        		}
	        		
	        		// Reset les champs si l'objet a été crée
	        		if(reussie) {
	        			
	        			restTextField();
	        		}
	        	}
	        }
        	/**
        	 * Permet de reste les text des textField
        	 * @author Paul Annes
        	 */
        	public void restTextField() {
        		
        		textFieldISBN.setText("");
    			textFieldTitre.setText("");
    			textFieldDesc.setText("");
    			textFieldPrix.setText("");
    			textFieldNbPage.setText("");
    			textFieldNbImage.setText("");
    			textFieldType.setText("");
    			textFieldNum.setText("");
    			dateChooser.setDate(null);
        	}
        });
		add(btnAjouter);
	}
}

