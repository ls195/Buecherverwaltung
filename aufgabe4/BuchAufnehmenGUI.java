package aufgabe4;
// Datei: BuchAufnehmenGUI.java

import javax.swing.JButton;
import javax.swing.JTextField;

import aufgabe4.entitaeten.Buch;
import aufgabe4.entitaeten.MediumVerwaltung;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuchAufnehmenGUI extends JDialog
{
   private JButton aufnehmen = new JButton("Aufnehmen");
   private JButton abbrechen = new JButton("Abrechen");
   private JTextField titel = new JTextField (30);
   private JTextField unterTitel = new JTextField (30);
   private JTextField isbn = new JTextField (30);
   private JTextField anzahl = new JTextField (10);

   private static final long serialVersionUID = 1L;

   private MediumVerwaltung buecher;

   public BuchAufnehmenGUI(JFrame parent)
   {
      super (parent, "Buch aufnehmen", true);

      buecher = MediumVerwaltung.getRefToInstance();

      setLayout (new GridLayout (5, 1));

      dialogAufbauen();
      controllerHinzufuegen();

      pack();
      setVisible (true);
   }

   private void dialogAufbauen()
   {
      JPanel pane1 = new JPanel();
      pane1.setLayout (new FlowLayout(FlowLayout.LEFT));
      pane1.add (new JLabel ("Titel:         "));
      pane1.add (titel);
      add (pane1);

      JPanel pane2 = new JPanel();
      pane2.setLayout (new FlowLayout(FlowLayout.LEFT));
      pane2.add (new JLabel ("Untertitel:"));
      pane2.add (unterTitel);
      add (pane2);

      JPanel pane3 = new JPanel();
      pane3.setLayout (new FlowLayout(FlowLayout.LEFT));
      pane3.add (new JLabel ("ISBN:        "));
      pane3.add (isbn);
      add (pane3);

      JPanel pane4 = new JPanel();
      pane4.setLayout (new FlowLayout(FlowLayout.LEFT));
      pane4.add (new JLabel ("Anzahl:    "));
      pane4.add (anzahl);
      add (pane4);

      JPanel pane5 = new JPanel();
      pane5.setLayout (new FlowLayout(FlowLayout.LEFT));
      pane5.add (aufnehmen);
      pane5.add (abbrechen);
      add (pane5);
   }

   private void controllerHinzufuegen()
   {
      aufnehmen.addActionListener(new ActionListener()
      {
         public void actionPerformed (ActionEvent e)
         {
            buecher.buchAufnehmen (new Buch(titel.getText(),
                              unterTitel.getText(),
                              isbn.getText(),
                              Integer.parseInt(anzahl.getText())));
            setVisible (false);
            dispose();
         }
      });

      abbrechen.addActionListener(new ActionListener()
      {
         public void actionPerformed (ActionEvent e)
         {
            setVisible (false);
            dispose();
         }
      });
   }
}
