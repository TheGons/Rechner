
public class ControllerTaschenrechner {

	private KonsoleTaschenrechner konsole;
	private Rechenoperationen rechner;
	private float zahl1;
	private float zahl2;
	private float ergebnis;
	private char operator;
	private String auswahl;
	private char auswahlc;
	private boolean weiter = true;
	
	public void start()
	{
		while(weiter == true)
		{
			konsole = new KonsoleTaschenrechner();
			rechner = new Rechenoperationen();
			Data_Writer data_Writer = new Data_Writer();
			GUI_View gui = new GUI_View();
			gui.Start_Gui();
			auswahlc = konsole.eingabeOperation();
			zahl1 = konsole.eingabeZahl();
			zahl2 = konsole.eingabeZahl();
			auswahl = Character.toString(auswahlc);
			switch(auswahl)
			{
				case "a":
				case "A":
					operator = '+';
					ergebnis = rechner.Addition(zahl1, zahl2);
					break;
				case "d":
				case "D":
					operator = '/';
					ergebnis = rechner.Division(zahl1, zahl2);
					break;
				case "m":
				case "M":
					operator = '*';
					ergebnis = rechner.Multiplikation(zahl1, zahl2);
					break;
				case "s":
				case "S":
					operator = '-';
					ergebnis = rechner.Subtraktion(zahl1, zahl2);
					break;
			}
			konsole.ausgabe(ergebnis);
			data_Writer.Write_file(zahl1, zahl2, ergebnis, operator);
			weiter = konsole.nochmal();
		}
	}
}
