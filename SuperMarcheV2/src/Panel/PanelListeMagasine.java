package Panel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Librairie.Librairie;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;

public class PanelListeMagasine extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JList list = new JList();
	
	DefaultListModel<String> magasineString;
	
	private JTextField textFieldISBN;
	private JTextField textFieldTitre;
	private JTextField textFieldDesc;
	private JTextField textFieldPrix;
	private JTextField textFieldNbPage;
	private JTextField textFieldNbImage;
	private JTextField textFieldNum;
	private JDateChooser dateChooser;

	/**
	 * Permet de créer la liste dans le panel liste des magasine
	 * 
	 * @param librairie : Pour pouvoir appeller la method refresh afin d'initiliser la liste avec des valeurs.
	 * @author Hugo Soubeyrat
	 */
	public PanelListeMagasine(Librairie librairie) {

		setSize(721, 338);
		setLayout(null);
		
		this.refresh(librairie);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Stock le magasine selectionné dans la liste
				int select = list.getSelectedIndex();
				
				// Remplit les différents textField avec les bonnes valeurs par rapport à l'ISBN select dans la liste
				librairie.getListMagasine().get(select);
				
				textFieldISBN.setText(String.valueOf(librairie.getListMagasine().get(select).getISBN()));
				textFieldTitre.setText(librairie.getListMagasine().get(select).getTitre());
				textFieldDesc.setText(librairie.getListMagasine().get(select).getDescription());
				textFieldNbPage.setText(String.valueOf(librairie.getListMagasine().get(select).getNbPages()));
				textFieldPrix.setText(String.valueOf(librairie.getListMagasine().get(select).getPrix()));
				textFieldNum.setText(String.valueOf(librairie.getListMagasine().get(select).getNumero()));
			}
		});

		list.setBounds(10, 10, 314, 318);
		add(list);
		
		// Bouton supprmier
		JButton btnSuppr = new JButton("Supprmier");
		btnSuppr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Stock le magasine selectionné dans la liste
				int select = list.getSelectedIndex();
				
				// Supprime le magasine selectionné dans la liste
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
				
				// Stock le  selectionné dans la liste
				int select = list.getSelectedIndex();
				
				// Modif le  selectionné dans la liste
				modif(librairie, select);
			}
		});
		btnModif.setBounds(434, 307, 85, 21);
		add(btnModif);
		
		// Initialisation du panelChamps qui regroupe les champs commun à livre, magasine, Magasine
		JPanel panelChamps = new JPanel();
		panelChamps.setBounds(334, 10, 377, 287);
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
		
		// Initialisation du panelNbPage dans le panelChamps
		JPanel panelNbPage = new JPanel();
		panelChamps.add(panelNbPage);
		panelNbPage.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		// Initialisation du lblNbPage dans le panelNbPage
		JLabel lblNbPage = new JLabel("Nombre de pages :");
		panelNbPage.add(lblNbPage);
		
		// Initialisation du textFieldNbPage dans le panelNbPage
		textFieldNbPage = new JTextField();
		textFieldNbPage.setText("");
		textFieldNbPage.setColumns(10);
		panelNbPage.add(textFieldNbPage);
		
		// Initialisation du panelMagasine dans le panelChamps
		JPanel panelMagDate = new JPanel();
		FlowLayout fl_panelMagDate = (FlowLayout) panelMagDate.getLayout();
		fl_panelMagDate.setAlignment(FlowLayout.RIGHT);
		panelChamps.add(panelMagDate);
		
		// Incrémentation de lblDate dans panelMagasine
		JLabel lblDate = new JLabel("Date d'apparition :");
		panelMagDate.add(lblDate);
		
		// Incrémentation de dateChooser dans panelMagasine
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		panelMagDate.add(dateChooser);
		
		// Incrémentation de panelMagNum dans panelChamps
		JPanel panelMagNum = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelMagNum.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelChamps.add(panelMagNum);
		
		// Incrémentation de lblNum dans panelMagNum
		JLabel lblNum = new JLabel("Num\u00E9ro :");
		panelMagNum.add(lblNum);
		
		// Incrémentation de textFieldNum dans panelMagNum
		textFieldNum = new JTextField();
		panelMagNum.add(textFieldNum);
		textFieldNum.setColumns(10);
	}
	
	/**
	 * Permet de refresh la liste lors d'un ajout, d'un modification ou d'une supression
	 * 
	 * @param librairie : Permet de savoir quelle magasine est présente dans la collection list pour mettre à jour la liste
	 * @author Hugo Soubeyrat
	 */
	public void refresh(Librairie librairie) {
		
		magasineString = new DefaultListModel<>();
		
		// Remplie list avec les valeurs de la collection list avec le titre et l'IBSN pour l'interface graphique
		for(int i=0; i<librairie.getListMagasine().size();i++){
			
			magasineString.addElement(String.valueOf(librairie.getListMagasine().get(i).getISBN()));
		}
		
		// Refresh
		list.setModel(magasineString);
	}
	
	/**
	 * Permet la modification d'un magasine
	 * 
	 * @param index : Permet de savoir quelle magasine modifier des listes
	 * @param librairie : Permet de savoir modifier le magasine dans la collection listMagasine
	 * @author Hugo Soubeyrat et Paul Annes
	 */
	public void modif(Librairie librairie, int index) {
			
			// Modification magasine dans les 2 listes
			magasineString.set(index, textFieldISBN.getText());
			
			librairie.getListMagasine().get(index).setISBN(Integer.parseInt(textFieldISBN.getText()));
			librairie.getListMagasine().get(index).setTitre(textFieldTitre.getText());
			librairie.getListMagasine().get(index).setDescription(textFieldDesc.getText());
			librairie.getListMagasine().get(index).setNbPages(Integer.parseInt(textFieldNbPage.getText()));
			librairie.getListMagasine().get(index).setPrix(Double.parseDouble(textFieldPrix.getText()));
			librairie.getListMagasine().get(index).setNumero(Integer.parseInt(textFieldNum.getText()));
			librairie.getListMagasine().get(index).setDateParution(dateChooser.getDate());
			
			// Refresh
			list.setModel(magasineString);
	}
	
	/**
	 * Permet la supression d'un Magasine
	 * 
	 * @param index : Permet de savoir quelle Magasine suprimer des listes
	 * @param librairie : Permet de savoir suprimer le Magasine dans la collection listMagasine
	 * @author Hugo Soubeyrat
	 */
	public void delete(Librairie librairie, int index) {
			
			// Supression du Magasine dans les 2 listes
			magasineString.remove(index);
			librairie.getListMagasine().remove(index);
			
			// Refresh
			list.setModel(magasineString);
	}
}

