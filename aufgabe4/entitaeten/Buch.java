// Datei: Buch.java

package aufgabe4.entitaeten;

import java.util.Scanner;

public class Buch extends Medium
{
   private static int bestand = 0;

   public Buch (Scanner eingabe)
   {
      super (eingabe);
      System.out.print ("Bitte geben Sie die ISBN ein: ");
      mediumNummer = eingabe.nextLine();
      bestand++;
   }

   // Konstruktor mit Untertitel.
   public Buch (String titel, String unterTitel, String isbn, 
                int anzahlExemplare)
   {
      super (titel, unterTitel, isbn, anzahlExemplare);
      // Bei jeder Objekterzeugung wird die Klassenvariable
      // bestand um eins erhöht.
      bestand++;
   }

   // Konstruktor mit 3 Übergabeparametern.
   public Buch (String titel, String isbn, int anzahlExemplare)
   {
      this (titel, "", isbn, anzahlExemplare);
   }

   public String toString()
   {
      return "[Buch]: " + super.toString();
   }

   public static int getBestand()
   {
      return bestand;
   }
}
