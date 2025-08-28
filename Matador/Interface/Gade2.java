package grafisk.Matador.Interface;

import java.awt.Graphics;

/** En gade, der købes af en spiller og bebygges */
public class Gade2 extends Grund2 {
	int antalHuse; // antal huse og pris
	double huspris;

	public Gade2(String navn, double pris, double leje, double huspris) {
		super(navn, pris, leje); // kald Grund2's konstruktør
		this.huspris = huspris;
		antalHuse = 0;
	}

	public double beregnLeje() // tilsidesæt Grund2's beregnLeje()
	{
		return grundleje + antalHuse * huspris;
	}

	public void landet(Spiller sp) {
		if (sp == ejer) { // eget felt; byg hus?
			if (antalHuse < 5 && sp.konto > huspris && sp.spørgsmål("købe hus for " + pris)) { // byg et hus
				ejer.transaktion(-huspris);
				antalHuse = antalHuse + 1;
				sp.besked("Du bygger hus på " + navn + " for " + huspris);
			}
		} else {
			super.landet(sp); // brug gamle landet()
		}
	}

	@Override
	public void tegn(Graphics g, int x, int y) { // skriver feltets navn, ejer og hvor mange huse der er
		super.tegn(g, x, y);
		if (antalHuse > 0) {
			g.drawString("" + this.antalHuse, x, 30 + y);

		}
	}

	public void setHus(int a) {
		this.antalHuse = a;
	}

	public int getHus() {
		return antalHuse;
	}
}