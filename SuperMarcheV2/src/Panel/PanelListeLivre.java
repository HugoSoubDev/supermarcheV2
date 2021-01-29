package Panel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import Librairie.Librairie;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PanelListeLivre extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JList list = new JList();
	
	DefaultListModel<String> livreString;
	
	private JTextField textFieldISBN;
	private JTextField textFieldTitre;
	private JTextField textFieldDesc;
	private JTextField textFieldPrix;
	private JTextField textFieldNbPage;
	private JTextField textFieldType;

	/**
	 * Permet de créer la liste dans le panel liste des livres
	 * 
	 * @param librairie : Pour pouvoir appeller la method refresh afin d'initiliser la liste avec des valeurs.
	 * @author Hugo Soubeyrat
	 */
	public PanelListeLivre(Librairie librairie) {

		setSize(721, 338);
		setLayout(null);
		
		this.refresh(librairie);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Stock le livre selectionné dans la liste
				int select = list.getSelectedIndex();
				
				// Remplit les différents textField avec les bonnes valeurs par rapport à l'ISBN select dans la liste
				librairie.getListLivre().get(select);
				
				textFieldISBN.setText(String.valueOf(librairie.getListLivre().get(select).getISBN()));
				textFieldTitre.setText(librairie.getListLivre().get(select).getTitre());
				textFieldDesc.setText(librairie.getListLivre().get(select).getDescription());
				textFieldNbPage.setText(String.valueOf(librairie.getListLivre().get(select).getNbPages()));
				textFieldPrix.setText(String.valueOf(librairie.getListLivre().get(select).getPrix()));
				textFieldType.setText(String.valueOf(librairie.getListLivre().get(select).getType()));
				
				
			}
		});

		list.setBounds(10, 10, 314, 318);
		add(list);
		
		// Bouton supprmier
		JButton btnSuppr = new JButton("Supprmier");
		btnSuppr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Stock le livre selectionné dans la liste
				int select = list.getSelectedIndex();
				
				// Supprime le livre selectionné dans la liste
				delete(librairie, select);
			}
		});
		btnSuppr.setBounds(529, 307, 85, 21);
		add(btnSuppr);
		
		// Initialisation du bouton modif
		JButton btnModif = new JButton("Modifier");
		btnModif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Stock le livre selectionné dans la liste
				int select = list.getSelectedIndex();
				
				// Modif le livre selectionné dans la liste
				modif(librairie, select);
			}
		});
		btnModif.setBounds(434, 307, 85, 21);
		add(btnModif);
		
		// Initialisation du panelChamps qui regroupe les champs commun à livre, magasine, BD
		JPanel panelChamps = new JPanel();
		panelChamps.setBounds(334, 10, 377, 281);
		add(panelChamps);
		panelChamps.setLayout(new GridLayout(0, 1, 0, 0));
		
		// Initialisation panelISBN dans panelChamps
		JPanel panelISBN = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panelISBN.getLayout();
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		panelChamps.add(panelISBN);
		
		// Initialisation de lblISBN dans le panelISBN
		JLabel lblISBN = new JLabel("ISBN :");
		panelISBN.add(lblISBN);
		
		// Initialisation textFieldISBN dans le panelISBN
		textFieldISBN = new JTextField();
		textFieldISBN.setText("");
		panelISBN.add(textFieldISBN);
		textFieldISBN.setColumns(10);
		
		// Initialisation du panelTitre dans le panelChamps
		JPanel panelTitre = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panelTitre.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		panelChamps.add(panelTitre);
		
		// Initialisation du lblTitre dans le lblTitre
		JLabel lblTitre = new JLabel("Titre :");
		panelTitre.add(lblTitre);
		
		// Initialisation du textFieldTitre dans le lblTitre
		textFieldTitre = new JTextField();
		textFieldTitre.setText("");
		textFieldTitre.setColumns(10);
		panelTitre.add(textFieldTitre);
		
		// Initialisation du panelDesc dans le panelChamps
		JPanel panelDesc = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelDesc.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panelChamps.add(panelDesc);
		
		// Initialisation du lblDesc dans le panelDesc
		JLabel lblDesc = new JLabel("Description :");
		panelDesc.add(lblDesc);
		
		// Initialisation du textFieldDesc dans le panelDesc
		textFieldDesc = new JTextField();
		textFieldDesc.setText("");
		textFieldDesc.setColumns(10);
		panelDesc.add(textFieldDesc);
		
		// Initialisation du panelPrix dans le panelChamps
		JPanel panelPrix = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelPrix.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panelChamps.add(panelPrix);
		
		// Initialisation du lblPrix dans le panelPrix
		JLabel lblPrix = new JLabel("Prix :");
		panelPrix.add(lblPrix);
		
		// Initialisation du textFieldPrix dans le panelPrix
		textFieldPrix = new JTextField();
		textFieldPrix.setText("");
		textFieldPrix.setColumns(10);
		panelPrix.add(textFieldPrix);

		// Initialisation du panelType dans le panelChamps
		JPanel panelType = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelType.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelChamps.add(panelType);
		
		// Initialisation du lblType dans le panelType
		JLabel lblType = new JLabel("Type :");
		panelType.add(lblType);
		
		// Initialisation du textFieldType dans le panelType
		textFieldType = new JTextField();
		textFieldType.setText("");
		textFieldType.setColumns(10);
		panelType.add(textFieldType);
	}
	
	/**
	 * Permet de refresh la liste lors d'un ajout, d'un modification ou d'une supression
	 * 
	 * @param librairie : Permet de savoir quelle livre est présente dans la collection listLivre pour mettre à jour la liste
	 * @author Hugo Soubeyrat
	 */
	public void refresh(Librairie librairie) {
		
		livreString = new DefaultListModel<>();
		
		// Remplie list avec les valeurs de la collection listLivre avec le titre et l'IBSN pour l'interface graphique
		for(int i=0; i<librairie.getListLivre().size();i++){
			
			livreString.addElement(String.valueOf(librairie.getListLivre().get(i).getISBN()));
		}
		
		// Refresh
		list.setModel(livreString);
	}
	
	/**
	 * Permet la modification d'un livre
	 * 
	 * @param index : Permet de savoir quelle livre modifier des listes
	 * @param librairie : Permet de savoir modifier le livre dans la collection listLivre
	 * @author Hugo Soubeyrat
	 */
	public void modif(Librairie librairie, int index) {
			
			// Modification du livre dans les 2 listes
			livreString.set(index, textFieldISBN.getText());
			
			librairie.getListLivre().get(index).setISBN(Integer.parseInt(textFieldISBN.getText()));
			librairie.getListLivre().get(index).setTitre(textFieldTitre.getText());
			librairie.getListLivre().get(index).setDescription(textFieldDesc.getText());
			librairie.getListLivre().get(index).setType(textFieldType.getText());
			librairie.getListLivre().get(index).setNbPages(Integer.parseInt(textFieldNbPage.getText()));
			librairie.getListLivre().get(index).setPrix(Double.parseDouble(textFieldPrix.getText()));
			
			// Refresh
			list.setModel(livreString);
	}
	
	/**
	 * Permet la supression d'un livre
	 * 
	 * @param index : Permet de savoir quelle livre suprimer des listes
	 * @param librairie : Permet de savoir suprimer le livre dans la collection listLivre
	 * @author Hugo Soubeyrat
	 */
	public void delete(Librairie librairie, int index) {
			
			// Supression du livre dans les 2 listes
			livreString.remove(index);
			librairie.getListLivre().remove(index);
			
			// Refresh
			list.setModel(livreString);
	}
}

