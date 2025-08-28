package grafisk.Matador;

public class BenytGrafiskMatador
{
	public static void main(String[] arg)
	{
		
		GrafiskMatador panel = new GrafiskMatador();        // opret panelet
		
		panel.spil.spillere.add(new Spiller("Søren", 50000)); // opret spiller Søren
		panel.spil.spillere.add(new Spiller("Gitte", 50000)); // opret spiller Gitte

		System.out.println(panel.spil.felter.toString());
		int xx = 1;
		// løb gennem x runder
		for (panel.spil.spillersTur = 0; panel.spil.spillersTur < panel.spil.spillere.size() * xx; panel.spil.spillersTur++) {
			// tag skiftevis Søren og Gitte (% er forklaret i afsnit Fejl: Henvisningskilde
			// ikke fundet)
			Spiller sp = panel.spil.spillere.get(panel.spil.spillersTur % panel.spil.spillere.size());
			sp.slag();
			System.out.println("***** " + sp.navn + " på felt " + sp.feltnr + " slår " + sp.slag);

			for (int i = 1; i <= sp.slag; i = i + 1) // nu rykkes der
			{
				// gå til næste felt. Hvis vi når over antal felter så tæl fra 0
				sp.feltnr = sp.feltnr + 1;
				if (sp.feltnr == panel.spil.felter.size())
					sp.feltnr = 0;
				Felt felt = panel.spil.felter.get(sp.feltnr);
				panel.repaint();
				try {Thread.sleep(100);} catch (Exception e) {}

				if (i < sp.slag)
					felt.passeret(sp); // kald passeret() på passerede felter
				else
					felt.landet(sp); // kald landet() på sidste felt
				try {
					Thread.sleep(300);
				} catch (Exception e) {
				} // vent 0.3 sek
			}
			panel.repaint();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			} // tur slut, vent 3 sek
		}
		
		

	}
}