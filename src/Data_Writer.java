/*
 * Klassenname.: Data_Writer.java
 * Autor.......: Phillip-Morton Paape <phillip_morton@yahoo.com>
 * Datum.......: 2018/09/24
 * Version.....: 1.0
 * 
 * Beschreibung: Eine Klasse die das Speichern von Rechnungen erlaubt
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Data_Writer 
{
	
	public void Write_file(float wert1, float wert2, float ergebnis, char operator)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");	//Festlegung des Datumformats
		String timestamp = sdf.format(System.currentTimeMillis());		//Holen der Systemzeit und Speichern als Formatiertes Datum im String timestamp 
		String filename = "Rechnungen/Rechnung-" + timestamp + ".txt";	//Erstellen des Dateinamens Rechnung + timestamp
		String content = String.valueOf(wert1) + " " +  operator + " " + String.valueOf(wert2) + " = " + String.valueOf(ergebnis);	//Erstellen des Dateiinhaltes
		File file = new File("Rechnungen");	//fuer Ordnerueberpruefung
		if(!file.exists())					//Pruefen ob Verzeichnis Rechnungen da ist
		{
			new File("Rechnungen").mkdir();	//Falls Verzeichnis nicht vorhanden dann erstellen
		}
		try 
		{
			//Schreiben der Datei
			FileWriter fileWriter = new FileWriter(filename);
			fileWriter.write(content);
			fileWriter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
