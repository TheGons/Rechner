
public class ControllerTaschenrechner {

	private KonsoleTaschenrechner konsole;
	private Rechenoperationen rechner;
	private float zahl1;
	private float zahl2;
	private float ergebnis;
	private String auswahl;
	private char auswahlc;
	private boolean weiter = true;
	
	public void start()
	{
		while(weiter == true)
		{
			konsole = new KonsoleTaschenrechner();
			rechner = new Rechenoperationen();
			auswahlc = konsole.eingabeOperation();
			zahl1 = konsole.eingabeZahl();
			zahl2 = konsole.eingabeZahl();
			auswahl = Character.toString(auswahlc);
			switch(auswahl)
			{
				case "a":
				case "A":
					ergebnis = rechner.Addition(zahl1, zahl2);
					break;
				case "d":
				case "D":
					ergebnis = rechner.Division(zahl1, zahl2);
					break;
				case "m":
				case "M":
					ergebnis = rechner.Multiplikation(zahl1, zahl2);
					break;
				case "s":
				case "S":
					ergebnis = rechner.Subtraktion(zahl1, zahl2);
					break;
			}
			konsole.ausgabe(ergebnis);
			weiter = konsole.nochmal();
		}
	}
}
