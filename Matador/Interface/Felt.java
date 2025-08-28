package grafisk.Matador.Interface;

import java.awt.Graphics;

/** Superklassen for alle matadorspillets felter */
public class Felt {
	String navn; // feltets navn, f.eks. "Hvidovrevej"
	Spiller ejer; // ejeren af feltet

	/** kaldes når en spiller passerer dette felt */
	public void passeret(Spiller sp) {
		sp.besked("Du passerer " + navn);
	}

	/** kaldes når en spiller lander på dette felt */
	public void landet(Spiller sp) {
	}

	public void tegn(Graphics g, int x, int y) {
		g.drawString(this.navn, x, y); // skriver feltets navn
		if (this.ejer != null) { // hvis der er en ejer så skriv det under
			g.drawString(this.ejer.toString(), x, 15 + y);

		}
	}

	public String getNavn() {
		return navn;
	}

	public Spiller getEjer() {
		return ejer;
	}

	public void setEjer(Spiller ejer) {
		this.ejer = ejer;
	}

}