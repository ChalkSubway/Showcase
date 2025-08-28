package grafisk.Matador;

import java.awt.*;
import javax.swing.*;

public class GrafiskMatador extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
Matadorspil spil;
	GrafiskMatador(){
		spil = new Matadorspil();
		/*spil.spillere.add(new Spiller("Søren", 50000)); // opret spiller Søren
		spil.spillere.add(new Spiller("Gitte", 50000)); // opret spiller Gitte

		System.out.println(spil.felter.toString());
		int xx = 1;
		// løb gennem x runder
		for (spil.spillersTur = 0; spil.spillersTur < spil.spillere.size() * xx; spil.spillersTur++) {
			// tag skiftevis Søren og Gitte (% er forklaret i afsnit Fejl: Henvisningskilde
			// ikke fundet)
			Spiller sp = spil.spillere.get(spil.spillersTur % spil.spillere.size());
			sp.slag();
			System.out.println("***** " + sp.navn + " på felt " + sp.feltnr + " slår " + sp.slag);

			for (int i = 1; i <= sp.slag; i = i + 1) // nu rykkes der
			{
				// gå til næste felt. Hvis vi når over antal felter så tæl fra 0
				sp.feltnr = sp.feltnr + 1;
				if (sp.feltnr == spil.felter.size())
					sp.feltnr = 0;
				Felt felt = spil.felter.get(sp.feltnr);

				if (i < sp.slag)
					felt.passeret(sp); // kald passeret() på passerede felter
				else
					felt.landet(sp); // kald landet() på sidste felt
				try {
					Thread.sleep(300);
				} catch (Exception e) {
				} // vent 0.3 sek
			}
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			} // tur slut, vent 3 sek
		}*/
		JFrame vindue = new JFrame("GrafiskMatador");
		vindue.add(this);
		vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		vindue.setSize(800, 800);
		vindue.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		// Herunder referer g til et Graphics-objekt man kan tegne med
		super.paintComponent(g); // tegn først baggrunden på panelet

		for (int i = 0; i < spil.spillere.size(); i++) {
			Spiller spiller = spil.spillere.get(i);
			double v = Math.PI * 2 * spiller.getFelt() / spil.felter.size(); // størelsen af forskydningen i radianer
			int x = 400 + (int) (200 * Math.cos(v)); // x cordinat
			int y = 400 + (int) (200 * Math.sin(v)); // y cordinat
			if (spiller.getFelt()!=spil.spillere.get((i+1)%spil.spillere.size()).getFelt()) {
			spiller.tegn(g, x, y);}
			else { g.drawString("2 spillere", x, y-15);}
		}
		
		for (int i = 0; i < spil.felter.size(); i++) {
			Felt felt = spil.felter.get(i);

			double v = Math.PI * 2 * i / spil.felter.size(); // størelsen af forskydningen i radianer
			int x = 400 + (int) (200 * Math.cos(v)); // x cordinat
			int y = 400 + (int) (200 * Math.sin(v)); // y cordinat

			g.setColor(Color.black); // sætter farven
			felt.tegn(g, x, y); // tegner feltet

			/*
			 * g.setColor(Color.black); g.drawString(felt.getNavn(), x, y); //skriver
			 * feltets navn
			 * 
			 * if (felt.getEjer()!=null) { //hvis der er en ejer så skriv det under
			 * g.drawString(felt.getEjer().toString(), x, 15+y);
			 * 
			 * }
			 */
		}

		System.out.println("Der blev tegnet!!");
	}
}