package grafisk.Matador.Interface;

//et bryggeri der kan købes og lejen afhænger af spillerens slag
public class Bryggeri2 extends Grund2 {

	public Bryggeri2(String navn, double pris, double leje) {
		super(navn, pris, leje); // kald Grund2's konstruktør
	}

	public double beregnLeje(Spiller sp) // tilsidesæt Grund2's beregnLeje()
	{
		return grundleje * sp.slag;
	}

	public void landet(Spiller sp) {
		if (sp != ejer || ejer != null) { // hvis en anden spiller ejer Bryggeriet
			double leje = beregnLeje(sp); // udregn lejen
			sp.besked("Leje: " + leje);
			sp.betal(ejer, leje); // spiller betaler til ejeren
		} else {
			super.landet(sp); // brug gamle landet()
		}
	}
}