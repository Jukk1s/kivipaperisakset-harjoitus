package kivipaperisakset;

/**
 * Main-luokka, jossa luodaan Peli- ja Pelaaja -objektit.
 * 
 * @author Jukka Hallikainen
 */

public class Main {

	public static void main(String[] args) {
		Pelaaja pelaaja1 = new Pelaaja();
	    Pelaaja pelaaja2 = new Pelaaja();
		Peli kiviPaperiSakset = new Peli(pelaaja1, pelaaja2);
		kiviPaperiSakset.aloitaPeli();
	}
}
