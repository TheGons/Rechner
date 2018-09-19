import java.util.Scanner;
import java.util.regex.*;

public class KonsoleTaschenrechner {
		
		private char letter;
		
		public char eingabeOperation()
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Bitte wählen sie die Rechenart: ");
			System.out.println("(A)ddieren, (S)ubtrahieren, (D)ividieren, (M)ultiplizieren");
			while(input.hasNext())
			{
				letter = input.next().charAt(0);
				if(Character.toString(letter).matches("^[aAdDsSmM]*$"))
				{
					return (letter);
				}
				else
				{
					input.nextLine();
				}
			}
			return(letter);
		}
		
		public float eingabeZahl()
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Bitte geben sie eine Zahl ein: ");
			while(input.hasNextFloat() == false)
			{
				input.nextLine();
			}
			return (input.nextFloat());
		}
		
		public void ausgabe(float x)
		{
			System.out.println("Das Ergebnis lautet: " + x);
		}
		
		public boolean nochmal()
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Wollen sie den Rechner weiter benutzen? ");
			System.out.println("(J)a, (N)ein");
			while(input.hasNext())
			{
				letter = input.next().charAt(0);
				if(Character.toString(letter).matches("^[jJ]*$"))
				{
					return (true);
				}
				else if(Character.toString(letter).matches("^[nN]*$"))
				{
					return(false);
				}
				else
				{
					input.nextLine();
				}
			}
			return false;
		}
}
