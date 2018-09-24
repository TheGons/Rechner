/*
 * Klassenname.: GUI_View.java
 * Autor.......: Phillip-Morton Paape
 * Datum.......: 2018/09/24
 * Version.....: 1.0
 * 
 * Beschreibung: Grafische Oberflaeche fuer das Taschenrechnerprogramm
 */

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.ComponentOrientation;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class GUI_View 
{

	private JFrame frmRechner;
	private JTextField wert1Field;
	private JTextField wert2Field;

	/**
	 * Launch the application.
	 */
	public void Start_Gui() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI_View window = new GUI_View();
					window.frmRechner.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_View() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmRechner = new JFrame();
		frmRechner.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_View.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		frmRechner.setTitle("Rechner");
		frmRechner.setResizable(false);
		frmRechner.setBounds(100, 100, 292, 184);
		frmRechner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmRechner.getContentPane().setLayout(springLayout);
		
		wert1Field = new JTextField();
		frmRechner.getContentPane().add(wert1Field);
		wert1Field.setColumns(10);
		
		JLabel lblWert = new JLabel("Wert 1:");
		springLayout.putConstraint(SpringLayout.NORTH, wert1Field, -3, SpringLayout.NORTH, lblWert);
		springLayout.putConstraint(SpringLayout.WEST, wert1Field, 6, SpringLayout.EAST, lblWert);
		springLayout.putConstraint(SpringLayout.EAST, wert1Field, 232, SpringLayout.EAST, lblWert);
		springLayout.putConstraint(SpringLayout.NORTH, lblWert, 58, SpringLayout.NORTH, frmRechner.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblWert, 10, SpringLayout.WEST, frmRechner.getContentPane());
		frmRechner.getContentPane().add(lblWert);
		
		JLabel lblWert_1 = new JLabel("Wert 2:");
		springLayout.putConstraint(SpringLayout.NORTH, lblWert_1, 12, SpringLayout.SOUTH, lblWert);
		springLayout.putConstraint(SpringLayout.WEST, lblWert_1, 0, SpringLayout.WEST, lblWert);
		frmRechner.getContentPane().add(lblWert_1);
		
		wert2Field = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, wert2Field, 6, SpringLayout.SOUTH, wert1Field);
		springLayout.putConstraint(SpringLayout.WEST, wert2Field, 0, SpringLayout.WEST, wert1Field);
		springLayout.putConstraint(SpringLayout.EAST, wert2Field, 0, SpringLayout.EAST, wert1Field);
		wert2Field.setColumns(10);
		frmRechner.getContentPane().add(wert2Field);
		
		JLabel ergebnisText = new JLabel("ergebnis", SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, ergebnisText, 10, SpringLayout.NORTH, frmRechner.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, ergebnisText, 10, SpringLayout.WEST, frmRechner.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, ergebnisText, -4, SpringLayout.NORTH, wert1Field);
		springLayout.putConstraint(SpringLayout.EAST, ergebnisText, 0, SpringLayout.EAST, wert1Field);
		ergebnisText.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ergebnisText.setFont(new Font("Tahoma", Font.BOLD, 16));
		frmRechner.getContentPane().add(ergebnisText);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, wert1Field);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Addition", "Subtraktion", "Multiplikation", "Division"}));
		comboBox.setSelectedIndex(0);
		comboBox.setToolTipText("");
		frmRechner.getContentPane().add(comboBox);
		
		JButton btnBerechnen = new JButton("Berechnen");
		springLayout.putConstraint(SpringLayout.NORTH, btnBerechnen, 15, SpringLayout.SOUTH, wert2Field);
		springLayout.putConstraint(SpringLayout.WEST, btnBerechnen, 6, SpringLayout.EAST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, btnBerechnen, -7, SpringLayout.EAST, frmRechner.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 1, SpringLayout.NORTH, btnBerechnen);
		btnBerechnen.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				float zahl1 = Float.parseFloat(wert1Field.getText());
				float zahl2 = Float.parseFloat(wert2Field.getText());
				float ergebnis = 0;
				Rechenoperationen rechen = new Rechenoperationen();
				switch(comboBox.getSelectedIndex())
				{
					case 0:
						ergebnis = rechen.Addition(zahl1, zahl2);
						break;
					case 1:
						ergebnis = rechen.Subtraktion(zahl1, zahl2);
						break;
					case 2:
						ergebnis = rechen.Multiplikation(zahl1, zahl2);
						break;
					case 3:
						ergebnis = rechen.Division(zahl1, zahl2);
						break;
				}
				ergebnisText.setText(String.valueOf(ergebnis));
			}
		});
		frmRechner.getContentPane().add(btnBerechnen);
		
		JButton btnNewButton = new JButton("New button");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, lblWert_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, frmRechner.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, lblWert);
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(ergebnisText.getText() != "ergebnis")
				{
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					String kopieren = ergebnisText.getText();
					StringSelection stringSelection = new StringSelection(kopieren);
					clipboard.setContents(stringSelection, null);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblWert);
		frmRechner.getContentPane().add(btnNewButton);
	}
}
