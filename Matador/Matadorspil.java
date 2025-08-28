package grafisk.Matador;

import java.util.ArrayList;

public class Matadorspil
{
  ArrayList<Felt> felter = new ArrayList<Felt>(); // indeholder alle felter

  ArrayList<Spiller> spillere = new ArrayList<Spiller>();  // alle spillere

  int spillersTur = 0;

  public Matadorspil() 
  {
    felter.add(new Start(5000));
    felter.add(new Gade2("gade1", 10000, 500, 1000));
    felter.add(new Gade2("gade2", 15000, 1000, 1500));
    felter.add(new Helle(15000));
    felter.add(new Gade2("gade 3", 25000,1500,2500));
    felter.add(new Rederi2("Rederi", 17000, 4200));
    
  }
}