package aufgabe4;
// Datei: BestandAnzeigenGUI.java

import javax.swing.JTable;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.lang.reflect.Array;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import aufgabe4.entitaeten.Buch;
import aufgabe4.entitaeten.MediumVerwaltung;

public class BestandAnzeigenGUI extends JDialog
{
   private static final long serialVersionUID = 1L;

   public BestandAnzeigenGUI(JFrame parent)
   {
      super (parent, "Bestand anzeigen", true);

      dialogAufbauen();

      pack();
      setVisible (true);
   }

   private void dialogAufbauen()
   {
      // Model für die Tabelle anlegen. Die Implementierung der Klasse
      // TableModel befindet sich unterhalb der Klasse BestandAnzeigenGUI.
      TableModel model = new TableModel();
      // Tabelle anlegen und Referenz auf Model übergeben.
      JTable table = new JTable (model);

      // Tabelle mit Sortierfunktion ausstatten
      table.setRowSorter(new TableRowSorter<TableModel>(model));

      // Tabelle wird in einen scrollbaren GUI-Container vom
      // Typ JScrollPane gelegt.
      JScrollPane scrollingTable = new JScrollPane (table, 
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      // Die bevorzugte Größe des scrollbaren GUI-Containers wird gesetzt.
      scrollingTable.setPreferredSize (new Dimension (500, 100));
      // Hinzufügen des GUI-Containers zum Dialogfenster.
      add (scrollingTable);
   }
}


// Eigenes Model für die GUI-Komponente JTable. Ein Model für eine GUI-
// Komponten JTable muss von der abstrakten Klasse AbstractTableModel
// ableiten.
class TableModel extends AbstractTableModel
{
   // AbstractTableModel setzt eindeutige serialVersionUID voraus.
   private static final long serialVersionUID = 1L;

   // Spaltennamen für die Tabelle festlegen.
   private String[] columnNames = { "Titel", "Untertitel", "ISBN", "Anzahl"}; 

   private MediumVerwaltung buecher = MediumVerwaltung.getRefToInstance();

   // Überschriebene Methode zur Rückgabe des Spaltennamens.
   public String getColumnName (int col) 
   {
      return columnNames [col];
   }

   // Überschriebene Methode zur Rückgabe der Spaltenanzahl.
   public int getColumnCount() 
   {
      return Array.getLength (columnNames);
   }

   // Überschriebene Methode zur Rückgabe der Zeilenanzahl.
   public int getRowCount() 
   {
      return buecher.getSize();
   }

   // Überschriebene Methode zur Rückgabe des Wertes einer Zelle.
   public Object getValueAt (int row, int column) 
   {
      Buch ref = buecher.getBuch (row);
      if (column == 0)
         return ref.getTitel();
      else if (column == 1)
         return ref.getUnterTitel();
      else if (column == 2)
         return ref.getMediumNummer();
      else
         return ref.getAnzahlExemplare();
   }
}
