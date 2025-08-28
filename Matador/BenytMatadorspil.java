package grafisk.Matador;

public class BenytMatadorspil
{
  public static void main(String[] arg)
  {
	Matadorspil spil = new Matadorspil();
    spil.spillere.add(new Spiller("Søren",50000));   // opret spiller Søren
    spil.spillere.add(new Spiller("Gitte",50000));   // opret spiller Gitte

    
    System.out.println(spil.felter.toString());
    int x = 5;
    // løb gennem x runder
    for (spil.spillersTur=0; spil.spillersTur<spil.spillere.size()*x; spil.spillersTur++)
    {
      // tag skiftevis Søren og Gitte (% er forklaret i afsnit Fejl: Henvisningskilde ikke fundet)
      Spiller sp = spil.spillere.get(spil.spillersTur % spil.spillere.size());
      sp.slag();
      System.out.println("***** "+sp.navn+" på felt "+sp.feltnr+" slår "+sp.slag);

      for (int i=1; i<=sp.slag; i=i+1)                  // nu rykkes der
      {
        // gå til næste felt. Hvis vi når over antal felter så tæl fra 0
        sp.feltnr = sp.feltnr + 1;
        if (sp.feltnr == spil.felter.size()) sp.feltnr=0;
        Felt felt = spil.felter.get(sp.feltnr);

        if (i<sp.slag) felt.passeret(sp); // kald passeret() på passerede felter
        else felt.landet(sp);          // kald landet() på sidste felt
        try { Thread.sleep(300); } catch (Exception e) {} // vent 0.3 sek
      }
      try { Thread.sleep(3000); } catch (Exception e) {} // tur slut, vent 3 sek
    }
  }
}