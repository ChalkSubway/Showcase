package grafisk.Matador;
import java.awt.Graphics;
/** Definition af en spiller */
public class Spiller
{
  String navn;       // spillerens navn, f.eks. "Søren"
  double konto;      // antal kroner på spillerens konto
  int feltnr;        // hvad nummer felt spilleren står på. ”Start” er nummer 0
  int slag;			 //slagget der bruges i spillet 

  public Spiller(String navn, double konto)
  {
    this.navn = navn;
    this.konto = konto;
    feltnr = 0;
  }
  
  public int slag() {
	  slag = (int)(Math.random()*6)+1;     // og slå et terningkast (1-6)
	  return slag;
  }

  /** En besked til spilleren */
  public void besked(String besked)
  {
    System.out.println(navn+": "+besked);
  }

  /** Et ja/nej-spørgsmål. Svarer brugeren ja returneres true, ellers false */
  public boolean spørgsmål(String spørgsmål)
  {
    String spm = navn+": Vil du "+spørgsmål+"?";
    //problem med String svar = javax.swing.JOptionPane.showInputDialog(spm, "ja");
    String svar = javax.swing.JOptionPane.showInputDialog(spm, "ja");
    System.out.println(spm+" "+svar);
    if (svar!=null && svar.equals("ja")) return true;
    else return false;
  }

  public void transaktion(double kr)
  {
    konto = konto + kr;
    System.out.println(navn+"s konto lyder nu på "+konto+" kr.");
  }

  public void betal(Spiller modtager, double kr)
  {
    System.out.println(navn+" betaler "+modtager.navn+": "+kr+" kr.");
    modtager.transaktion(kr);
    transaktion(-kr);
  }
  
  public String toString() {
	  return navn;
  }
  
  public void tegn(Graphics g, int x, int y) {
	  g.fillRect(x-11, y-25, 10, 10);
	  g.drawString(this.navn+1, x, y-15); // tegner spillerens navn oven over feltet
	  
  }
  
  public int getFelt() {
	  return feltnr;
  }
}