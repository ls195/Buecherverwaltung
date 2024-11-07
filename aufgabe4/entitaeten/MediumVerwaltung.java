// Datei: MediumVerwaltung.java
package aufgabe4.entitaeten;

import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;
import java.io.*;

public class MediumVerwaltung
{
   private Vector<Buch> arr = new Vector<Buch>();
   private String dateiName = "daten.txt";
   private static MediumVerwaltung refToSingleInstance;

   private MediumVerwaltung()
   {
      try
      {
         File file = new File (dateiName);
         if (file.exists())
         {
            FileInputStream fis = new FileInputStream (dateiName);
            Scanner scan = new Scanner (fis);
            // Als Trenner soll das Zeichen : verwendet werden.
            scan.useDelimiter ("\\s*:\\s*");

            while (scan.hasNext())
            {
               scan.next(); // [Buch] einlesen und verwerfen
               arr.add (new Buch (scan.next(),scan.next(),
                               scan.next(),scan.nextInt()));
            }
            fis.close();
         }
      }
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }
   }

   public static MediumVerwaltung getRefToInstance()
   {
      if (refToSingleInstance == null)
         refToSingleInstance = new MediumVerwaltung();
      return refToSingleInstance;
   }

   public void bestandSpeichern()
   {
      try
      {
         PrintStream out = 
             new PrintStream (new FileOutputStream (dateiName));
         for (Buch element : arr)
            out.println (element + " :");
         out.close();
      }
      catch (Exception e)
      {
         System.out.println (e.getMessage());
      }
   }

   public void buchAufnehmen (Buch ref)
   {
      arr.add (ref);
   }

   public int getSize()
   {
      return arr.size();
   }

   public Buch getBuch (int index)
   {
      return arr.elementAt(index);
   }
}
