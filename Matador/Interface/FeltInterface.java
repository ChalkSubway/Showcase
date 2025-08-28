package grafisk.Matador.Interface;

import java.awt.Graphics;

public interface FeltInterface {
	/** kaldes når en spiller passerer dette felt */
	public void passeret(Spiller sp);

	/** kaldes når en spiller lander på dette felt */
	public void landet(Spiller sp);

	// bruges til at tegne feltet
	public void tegn(Graphics g, int x, int y);

	// returnerer navnet på feltet
	public String getNavn();

	// returnerer ejer af feltet
	public Spiller getEjer();

	// sætter ejeren af feltet
	public void setEjer(Spiller ejer);

}
