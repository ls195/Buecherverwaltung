package aufgabe4;
// Datei: Buecherverwaltung.java

import javax.swing.JButton;
import javax.swing.JFrame;

import aufgabe4.entitaeten.MediumVerwaltung;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Buecherverwaltung extends JFrame
{
   private static final long serialVersionUID = 1L;

   public Buecherverwaltung()
   {
      super ("Bücherverwaltung");

      setLayout (new GridLayout (5, 1));

      dialogAufbauen();

      addWindowListener (new WindowAdapter()
      {
         public void windowClosing (WindowEvent e)
         {
            MediumVerwaltung buecher = MediumVerwaltung.getRefToInstance();
            buecher.bestandSpeichern();
         }
      });

      setSize (new Dimension (250, 250));
      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      setVisible (true);
   }

   private void dialogAufbauen()
   {
      ButtonController controller = new ButtonController();

      JButton buchAufnehmen = new JButton ("Buch aufnehmen");
      buchAufnehmen.setActionCommand ("Buch aufnehmen");
      buchAufnehmen.addActionListener(controller);

      JButton ausleiherAufnehmen = new JButton ("Ausleiher aufnehmen");

      JButton bestandAnzeigen = new JButton ("Bestand anzeigen");
      bestandAnzeigen.setActionCommand ("Bestand anzeigen");
      bestandAnzeigen.addActionListener(controller);

      JButton ausleihe = new JButton ("Buchausleihe erfassen");
      JButton rueckgabe = new JButton ("Buchrückgabe erfassen");

      add (buchAufnehmen);
      add (ausleiherAufnehmen);
      add (bestandAnzeigen);
      add (ausleihe);
      add (rueckgabe);
   }

   public static void main (String args[])
   {
      Buecherverwaltung fenster = new Buecherverwaltung();
   }

   // Controller als Elementklasse.
   class ButtonController implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         if (e.getActionCommand() == "Buch aufnehmen")
         {
            BuchAufnehmenGUI b = new BuchAufnehmenGUI (Buecherverwaltung.this);
         }
         else if (e.getActionCommand() == "Bestand anzeigen")
         {
            BestandAnzeigenGUI b = new BestandAnzeigenGUI (Buecherverwaltung.this);
         }
      }
   }
}



