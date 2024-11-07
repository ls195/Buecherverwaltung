// Datei: Medium.java

package aufgabe4.entitaeten;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Medium implements Comparable<Medium>
{
   protected String titel;
   protected String unterTitel;
   protected String mediumNummer;
   protected int anzahlExemplare;

   // Konstruktor für die Klasse zur Initialisierung der
   // Datenfelder.
   public Medium (String titel, String unterTitel, 
                  String mediumNummer, int anzahlExemplare)
   {
      this.titel = titel;
      this.unterTitel = unterTitel;
      this.mediumNummer = mediumNummer;
      this.anzahlExemplare = anzahlExemplare;
   }

   public Medium (Scanner eingabe)
   {
      System.out.print ("\nBitte geben Sie den Titel ein: ");
      titel = eingabe.nextLine();
      System.out.print ("Bitte geben Sie den Untertitel ein: ");
      unterTitel = eingabe.nextLine();

      while (true)
      {
         try
         {
            System.out.print("Bitte geben Sie die Exemplare ein: ");
            anzahlExemplare = eingabe.nextInt();
            break;
         }
         catch (InputMismatchException ex)
         {
            System.out.println ("Falsche Eingabe!");
            System.out.println ("Bitte eine ganze Zahl eingeben!");
         }
         finally
         {
            eingabe.nextLine(); // Zeilenumbruch einlesen
         }
      }
   }

   public String toString()
   {
      return titel + " : " + unterTitel + 
             " : " + mediumNummer + " : " + anzahlExemplare;
   }

   public int compareTo (Medium medium)
   {
      // Die Methode compareToIgnoreCase() ist in der Klasse
      // String implementiert und liefert als Vergleichsergebnis
      // -1, 0 oder 1.
      return titel.compareToIgnoreCase (medium.titel);
   }

   public String getTitel()
   {
      return titel;
   }

   public String getUnterTitel()
   {
      return unterTitel;
   }

   public String getMediumNummer()
   {
      return mediumNummer;
   }

   public int getAnzahlExemplare()
   {
      return anzahlExemplare;
   }
}
